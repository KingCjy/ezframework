package me.kingcjy.ezframework.beans.definition;

public interface BeanDefinition {
    String getName();
    Class<?> getBeanClass();

    default boolean isAnnotatedDefinition() {
        return false;
    }
}
