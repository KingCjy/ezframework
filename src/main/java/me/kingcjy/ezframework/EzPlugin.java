package me.kingcjy.ezframework;

import me.kingcjy.ezframework.beans.ClassPathBeanDefinitionScanner;
import me.kingcjy.ezframework.beans.factory.DefaultBeanFactory;
import me.kingcjy.ezframework.executor.AnnotationHandlerMapping;
import me.kingcjy.ezframework.executor.method.DefaultHandlerMethodFactory;
import me.kingcjy.ezframework.executor.registry.DefaultCommandRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class EzPlugin {
    public static void run(JavaPlugin instance) {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan(instance.getClass().getPackage().getName());
        beanFactory.instantiateBeans();

        DefaultHandlerMethodFactory handlerMethodFactory = new DefaultHandlerMethodFactory();
        handlerMethodFactory.setBeanFactory(beanFactory);
        handlerMethodFactory.afterPropertiesSet();

        AnnotationHandlerMapping annotationHandlerMapping = new AnnotationHandlerMapping(beanFactory, handlerMethodFactory);

        DefaultCommandRegistry defaultCommandRegistry = new DefaultCommandRegistry(instance, annotationHandlerMapping);
        defaultCommandRegistry.registerCommands();
    }
}
