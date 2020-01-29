package me.kingcjy.ezframework.service.definition;

import java.util.Set;

public interface ServiceDefinitionRegistry {
    void registerDefinition(ServiceDefinition beanDefinition);
    Set<ServiceDefinition> getServiceDefinitions();
}

