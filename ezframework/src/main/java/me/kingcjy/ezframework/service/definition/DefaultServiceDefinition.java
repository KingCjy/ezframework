package me.kingcjy.ezframework.service.definition;

public class DefaultServiceDefinition implements ServiceDefinition {

    private String name;
    private Class<?> serviceClass;

    public DefaultServiceDefinition(Class<?> serviceClass) {
        this(serviceClass, serviceClass.getName());
    }

    public DefaultServiceDefinition(Class<?> serviceClass, String name) {
        this.serviceClass = serviceClass;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Class<?> getServiceClass() {
        return serviceClass;
    }
}
