package me.kingcjy.ezframework.beans.factory;

public interface BeanFactory {

    Object getBean(String name);
    <T> T getBean(String name, Class<?> returnType);

    Object[] getBeans();
}
