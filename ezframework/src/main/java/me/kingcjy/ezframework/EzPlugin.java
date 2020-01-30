package me.kingcjy.ezframework;

import me.kingcjy.ezframework.beans.ClassPathBeanDefinitionScanner;
import me.kingcjy.ezframework.beans.factory.DefaultBeanFactory;
import me.kingcjy.ezframework.executor.AnnotationHandlerMapping;
import me.kingcjy.ezframework.executor.EzCommandExecutor;
import me.kingcjy.ezframework.executor.method.DefaultHandlerMethodFactory;

public class EzPlugin {


    public static void run(Object instance) {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan(instance.getClass().getPackage().getName());
        beanFactory.instantiateBeans();


        DefaultHandlerMethodFactory handlerMethodFactory = new DefaultHandlerMethodFactory();
        handlerMethodFactory.setBeanFactory(beanFactory);
        handlerMethodFactory.afterPropertiesSet();

        AnnotationHandlerMapping annotationHandlerMapping = new AnnotationHandlerMapping(beanFactory, handlerMethodFactory);

        EzCommandExecutor ezCommandExecutor = new EzCommandExecutor(annotationHandlerMapping);

        ezCommandExecutor.onCommand(null, null, "teleport", new String[]{"from", "to"});

        System.out.println(instance.getClass().getPackage().getName());
    }
}
