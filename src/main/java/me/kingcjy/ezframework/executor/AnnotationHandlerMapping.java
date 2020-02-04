package me.kingcjy.ezframework.executor;

import me.kingcjy.ezframework.annotations.Command;
import me.kingcjy.ezframework.annotations.CommandService;
import me.kingcjy.ezframework.beans.factory.BeanFactory;
import me.kingcjy.ezframework.beans.factory.BeanFactoryAware;
import me.kingcjy.ezframework.executor.method.DefaultHandlerMethodFactory;
import me.kingcjy.ezframework.executor.method.InvocableHandlerMethod;
import org.bukkit.Bukkit;

import java.lang.reflect.Method;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnnotationHandlerMapping implements HandlerMapping, BeanFactoryAware {

    private static final Logger logger = Bukkit.getLogger();

    private BeanFactory beanFactory;
    private Map<HandlerKey, InvocableHandlerMethod> handlers = new HashMap<>();

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
        Map<Class<?>, Object> controllers = findAllCommandServices();
        Set<Method> commandMethods = findAllCommandMethods(controllers.keySet());

        putMethodsToHandler(controllers, commandMethods);
    }

    private void putMethodsToHandler(Map<Class<?>, Object> controllers, Set<Method> commandMethods) {
        for (Method method : commandMethods) {
            HandlerKey handlerKey = createHandlerKey(method);

            InvocableHandlerMethod handlerMethod = handlerMethodFactory.createInvocableHandlerMethod(controllers.get(method.getDeclaringClass()), method);
            handlers.put(handlerKey, handlerMethod);
            logger.log(Level.INFO, "[EzFramework] register command : /{0}, method: {1}", new Object[]{handlerKey.getCommand(), method});
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
        if(targetClass.isAnnotationPresent(CommandService.class)) {
            CommandService command = targetClass.getAnnotation(CommandService.class);
            return command.value();
        }
        return "";
    }

    private String findMethodCommand(Method method) {
        Command command = method.getAnnotation(Command.class);
        return command.value();
    }


    private Map<Class<?>, Object> findAllCommandServices() {
        Map<Class<?>, Object> controllers = new HashMap<>();
        for (Object bean : this.beanFactory.getBeans()) {
            if(bean.getClass().isAnnotationPresent(CommandService.class)) {
                controllers.put(bean.getClass(), this.beanFactory.getBean(bean.getClass().getName()));
            }
        }
        return controllers;
    }

    private Set<Method> findAllCommandMethods(Set<Class<?>> controllers) {
        Set<Method> commandMethods = new HashSet<>();
        for (Class<?> controller : controllers) {
            commandMethods.addAll(findCommandMethods(controller));
        }
        return commandMethods;
    }

    private Set<Method> findCommandMethods(Class<?> controller) {
        Set<Method> commandMethods = new HashSet<>();
        for (Method method : controller.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Command.class)) {
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
            return null;
        }
        return handlers.get(handlerKeyOptional.get());
    }

    @Override
    public Set<HandlerKey> getHandlerKeys() {
        return handlers.keySet();
    }
}
