package me.kingcjy.ezframework.beans.definition;

public class DefaultBeanDefinition implements BeanDefinition {

    private String name;
    private Class<?> beanClass;

    public DefaultBeanDefinition(Class<?> beanClass) {
        this(beanClass, beanClass.getName());
    }

    public DefaultBeanDefinition(Class<?> beanClass, String name) {
        this.beanClass = beanClass;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }
}
