package me.kingcjy.ezframework.service;

import me.kingcjy.ezframework.service.definition.ServiceDefinitionRegistry;

public class ClassPathServiceDefinitionScanner {

    private ServiceDefinitionRegistry serviceDefinitionRegistry;

    public void setServiceDefinitionRegistry(ServiceDefinitionRegistry serviceDefinitionRegistry) {
        this.serviceDefinitionRegistry = serviceDefinitionRegistry;
    }

    public void scan(String basePackage) {

    }
}
