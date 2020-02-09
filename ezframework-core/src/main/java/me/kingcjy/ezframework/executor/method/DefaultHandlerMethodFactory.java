package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.annotations.Component;
import me.kingcjy.ezframework.beans.factory.BeanFactory;
import me.kingcjy.ezframework.beans.factory.BeanFactoryAware;
import me.kingcjy.ezframework.beans.factory.InitializingBean;
import me.kingcjy.ezframework.executor.method.invoke.InvocableHandlerMethod;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class DefaultHandlerMethodFactory implements BeanFactoryAware, InitializingBean {

    private final HandlerMethodParameterProviderComposite providers = new HandlerMethodParameterProviderComposite();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        this.providers.addResolver(initArgumentResolvers());
    }

    private HandlerMethodParameterProvider[] initArgumentResolvers() {
        Set<HandlerMethodParameterProvider> providers = new HashSet();
        for (Object bean : beanFactory.getBeans()) {
            if(HandlerMethodParameterProvider.class.isAssignableFrom(bean.getClass()) && bean.getClass().isAnnotationPresent(Component.class)) {
                providers.add((HandlerMethodParameterProvider) bean);
            }
        }
        return providers.toArray(new HandlerMethodParameterProvider[]{});
    }

    public InvocableHandlerMethod createInvocableHandlerMethod(Object bean, Method method) {
        InvocableHandlerMethod invocableHandlerMethod = new InvocableHandlerMethod(bean, method);
        invocableHandlerMethod.setMessageMethodArgumentResolvers(providers);
        return invocableHandlerMethod;
    }
}
