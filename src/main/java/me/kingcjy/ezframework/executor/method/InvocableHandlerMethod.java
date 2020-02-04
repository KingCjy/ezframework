package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocableHandlerMethod extends HandlerMethod {

    private static Logger logger = LoggerFactory.getLogger(InvocableHandlerMethod.class);

    private HandlerMethodParameterProviderComposite providers = new HandlerMethodParameterProviderComposite();

    public InvocableHandlerMethod(Object instance, Method method) {
        super(instance, method);
    }

    public void setMessageMethodArgumentResolvers(HandlerMethodParameterProviderComposite parameterProviders) {
        this.providers = parameterProviders;
    }

    public Object invoke(CommandArgs commandArgs, Object... providedArguments) {
        Object[] args = getMethodArgumentValues(commandArgs, providedArguments);
        try {
            return getMethod().invoke(getInstance(), args);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            logger.error(targetException.getMessage(), targetException);
            throw new RuntimeException(targetException);
        }
    }

    private Object[] getMethodArgumentValues(CommandArgs commandArgs, Object...providedArgs) {
        MethodParameter[] parameters = getMethodParameters();
        Object[] args = new Object[parameters.length];

        for(int i = 0; i < parameters.length; i++) {
            MethodParameter parameter = parameters[i];

            args[i] = findProvidedArgument(parameter, providedArgs);

            if(args[i] != null) {
                continue;
            }

            if(this.providers.supportsParameter(parameter)) {
                args[i] = this.providers.resolveParameter(commandArgs, parameter);
            }
        }

        return args;
    }

    private static Object findProvidedArgument(MethodParameter parameter, Object...providedArgs) {
        if(providedArgs == null) {
            return null;
        }

        for (Object providedArg : providedArgs) {
            if(parameter.getParameterType().isInstance(providedArg)) {
                return providedArg;
            }
        }

        return null;
    }
}
