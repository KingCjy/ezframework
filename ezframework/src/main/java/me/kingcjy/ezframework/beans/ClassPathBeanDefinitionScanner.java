package me.kingcjy.ezframework.beans;

import me.kingcjy.ezframework.annotations.Component;
import me.kingcjy.ezframework.beans.definition.BeanDefinition;
import me.kingcjy.ezframework.beans.definition.BeanDefinitionRegistry;
import me.kingcjy.ezframework.beans.definition.DefaultBeanDefinition;
import me.kingcjy.ezframework.util.EzReflectionUtils;

import java.util.Set;

public class ClassPathBeanDefinitionScanner {

    private BeanDefinitionRegistry beanDefinitionRegistry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void setBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void scan(String basePackage) {
        Set<Class> classes = EzReflectionUtils.findAnnotatedClasses(basePackage, Component.class);

        for (Class targetClass : classes) {
            Component component = (Component) targetClass.getAnnotation(Component.class);

            if(component != null && component.value().isEmpty() == false) {
                beanDefinitionRegistry.registerDefinition(new DefaultBeanDefinition(targetClass, component.value()));
            } else {
                beanDefinitionRegistry.registerDefinition(new DefaultBeanDefinition(targetClass));
            }
        }
    }
}
