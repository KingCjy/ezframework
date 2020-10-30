package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.annotations.*;
import me.kingcjy.ezframework.beans.factory.BeanFactory;
import me.kingcjy.ezframework.beans.factory.BeanFactoryAware;
import me.kingcjy.ezframework.executor.method.DefaultHandlerMethodFactory;
import me.kingcjy.ezframework.executor.method.invoke.HelpCommandInvocableHandlerMethod;
import me.kingcjy.ezframework.executor.method.invoke.InvocableHandlerMethod;
import me.kingcjy.ezframework.executor.method.invoke.DefaultInvocableHandlerMethod;
import me.kingcjy.ezframework.resource.ResourceFormat;
import me.kingcjy.ezframework.resource.ResourceLoader;
import org.bukkit.Bukkit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnotationHandlerMapping implements HandlerMapping, BeanFactoryAware {

    private static final Logger logger = Bukkit.getLogger();

    private BeanFactory beanFactory;
    private Map<HandlerKey, InvocableHandlerMethod> handlers = new HashMap<>();
    private Map<String, InvocableHandlerMethod> notfoundHandlers = new HashMap<>();
    private Map<String, InvocableHandlerMethod> tabcompleteHandlers = new HashMap<>();

    private DefaultHandlerMethodFactory handlerMethodFactory;

    public AnnotationHandlerMapping(BeanFactory beanFactory, DefaultHandlerMethodFactory defaultHandlerMethodFactory) {
        this.beanFactory = beanFactory;
        this.handlerMethodFactory = defaultHandlerMethodFactory;

        initialize();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void initialize() {
        Map<Class<?>, Object> controllers = findAnnotatedClasses(EzCommand.class);
        Set<Method> commandTabCompleteMethods = findAllAnnotatedMethods(controllers.keySet(), TabComplete.class);
        Set<Method> commandMethods = findAllAnnotatedMethods(controllers.keySet(), Command.class);
        Set<Method> notFoundMethods = findAllAnnotatedMethods(controllers.keySet(), NotFound.class);

        putMethodsToHandler(controllers, commandMethods);
        putTabCompleteMethodsToHandler(controllers, commandTabCompleteMethods);
        putNotFountMethodsToHandler(controllers, notFoundMethods);
        generateHelpCommands();
    }

    private void generateHelpCommands() {
        Map<Class<?>, Object> controllers = findAnnotatedClasses(GenerateHelpCommand.class);
        for (Class<?> targetClass : controllers.keySet()) {
            String prefix = targetClass.getAnnotation(EzCommand.class).value();
            HelpCommandInvocableHandlerMethod helpCommandInvocableHandlerMethod = generateHelpCommand(targetClass);

            handlers.put(new HandlerKey(prefix + " help"), helpCommandInvocableHandlerMethod);
            logger.log(Level.INFO, "[EzFramework] generate help command : /{0}", new Object[]{prefix + " help"});
        }
    }

    private HelpCommandInvocableHandlerMethod generateHelpCommand(Class<?> targetClass) {
        String prefix = targetClass.getAnnotation(EzCommand.class).value();
        Set<Method> methods = findAnnotatedMethods(targetClass, Description.class);

        List<HelpCommandInvocableHandlerMethod.HelpCommand> helpCommands = new ArrayList<>();

        for (Method method : methods) {
            Command command = method.getAnnotation(Command.class);
            Description description = method.getAnnotation(Description.class);

            helpCommands.add(new HelpCommandInvocableHandlerMethod.HelpCommand(prefix + " " + command.value() , description.value()));
        }

        String content = ResourceLoader.getInstance().read(ResourceLoader.HELP_FORMAT);
        return new HelpCommandInvocableHandlerMethod(new ResourceFormat(content), helpCommands);
    }

    private void putMethodsToHandler(Map<Class<?>, Object> controllers, Set<Method> commandMethods) {
        for (Method method : commandMethods) {
            HandlerKey handlerKey = createHandlerKey(method);

            InvocableHandlerMethod handlerMethod = handlerMethodFactory.createInvocableHandlerMethod(controllers.get(method.getDeclaringClass()), method);
            handlers.put(handlerKey, handlerMethod);
            logger.log(Level.INFO, "[EzFramework] register command : /{0}, method: {1}", new Object[]{handlerKey.getCommand(), method});
        }
    }

    private void putNotFountMethodsToHandler(Map<Class<?>, Object> controllers, Set<Method> notFoundMethods) {
        for (Method method : notFoundMethods) {
            String key = method.getDeclaringClass().getAnnotation(EzCommand.class).value();

            InvocableHandlerMethod handlerMethod = handlerMethodFactory.createInvocableHandlerMethod(controllers.get(method.getDeclaringClass()), method);
            notfoundHandlers.put(key, handlerMethod);
            logger.log(Level.INFO, "[EzFramework] register not found method : /{0}, method: {1}", new Object[]{key, method});
        }
    }
    
    private void putTabCompleteMethodsToHandler(Map<Class<?>, Object> controllers, Set<Method> commandTabCompleteMethods) {
        for (Method method : commandTabCompleteMethods) {
            String key = method.getDeclaringClass().getAnnotation(EzCommand.class).value();

            InvocableHandlerMethod handlerMethod = handlerMethodFactory.createInvocableHandlerMethod(controllers.get(method.getDeclaringClass()), method);
            tabcompleteHandlers.put(key, handlerMethod);
            logger.log(Level.INFO, "[EzFramework] register TabComplete method : /{0}, method: {1}", new Object[]{key, method});
        }
    }

    private HandlerKey createHandlerKey(Method method) {
        String classCommand = findClassCommand(method.getDeclaringClass());
        String methodCommand = findMethodCommand(method);

        if("".equals(classCommand)) {
            return new HandlerKey(methodCommand);
        }
        return new HandlerKey(classCommand + " " + methodCommand);
    }

    private String findClassCommand(Class<?> targetClass) {
        if(targetClass.isAnnotationPresent(EzCommand.class)) {
            EzCommand command = targetClass.getAnnotation(EzCommand.class);
            return command.value();
        }
        return "";
    }

    private String findMethodCommand(Method method) {
        Command command = method.getAnnotation(Command.class);
        return command.value();
    }


    private Map<Class<?>, Object> findAnnotatedClasses(Class<? extends Annotation> annotation) {
        Map<Class<?>, Object> controllers = new HashMap<>();
        for (Object bean : this.beanFactory.getBeans()) {
            if(bean.getClass().isAnnotationPresent(annotation)) {
                controllers.put(bean.getClass(), this.beanFactory.getBean(bean.getClass().getName()));
            }
        }
        return controllers;
    }

    private Set<Method> findAllAnnotatedMethods(Set<Class<?>> controllers, Class<? extends Annotation> annotation) {
        Set<Method> commandMethods = new HashSet<>();
        for (Class<?> controller : controllers) {
            commandMethods.addAll(findAnnotatedMethods(controller, annotation));
        }
        return commandMethods;
    }

    private Set<Method> findAnnotatedMethods(Class<?> controller, Class<? extends Annotation> annotation) {
        Set<Method> commandMethods = new HashSet<>();
        for (Method method : controller.getDeclaredMethods()) {
            if(method.isAnnotationPresent(annotation)) {
                commandMethods.add(method);
            }
        }
        return commandMethods;
    }

    @Override
    public InvocableHandlerMethod getHandler(String command) {
        Optional<HandlerKey> handlerKeyOptional = handlers.keySet().stream()
                .filter(handler -> handler.matches(command))
                .findAny();
        if(handlerKeyOptional.isPresent() == false) {
            return getErrorHandler(command);
        }
        return handlers.get(handlerKeyOptional.get());
    }

    @Override
    public InvocableHandlerMethod getErrorHandler(String command) {
        for (String key : notfoundHandlers.keySet()) {
            if(command.contains(key)) {
                return notfoundHandlers.get(key);
            }
        }
        return new DefaultInvocableHandlerMethod();
    }
    
    /*@Override
    public InvocableHandlerMethod getTabCompleteHandler(String command) {
        for (String key : tabcompleteHandlers.keySet()) {
            if(command.contains(key)) {
                return tabcompleteHandlers.get(key);
            }
        }
        return new DefaultInvocableHandlerMethod();
    }*/

    @Override
    public Set<HandlerKey> getHandlerKeys() {
        return handlers.keySet();
    }
}
