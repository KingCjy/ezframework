package me.kingcjy.ezframework.beans.definition;

import java.util.Set;

public interface BeanDefinitionRegistry {
    void registerDefinition(BeanDefinition beanDefinition);
    Set<BeanDefinition> getBeanDefinitions();
}