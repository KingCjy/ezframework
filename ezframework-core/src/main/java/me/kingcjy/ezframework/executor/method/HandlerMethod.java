package me.kingcjy.ezframework.executor.method;

import java.lang.reflect.Method;

public class HandlerMethod {

    private Method method;
    private Object instance;

    private MethodParameter[] parameters;

    public HandlerMethod() {

    }

    public HandlerMethod(Object instance, Method method) {
        this.instance = instance;
        this.method = method;

        parameters = initMethodParameters();
    }

    private MethodParameter[] initMethodParameters() {
        int count = this.method.getParameterCount();

        MethodParameter[] result = new MethodParameter[count];

        for(int i = 0; i < count; i++) {
            MethodParameter methodParameter = new MethodParameter(this.method, i);
            result[i] = methodParameter;
        }
        return result;
    }

    protected Method getMethod() {
        return this.method;
    }

    protected Object getInstance() {
        return this.instance;
    }

    protected MethodParameter[] getMethodParameters() {
        return parameters;
    }

    public Class<?> getReturnType() {
        return method.getReturnType();
    }
}
