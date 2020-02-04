package me.kingcjy.ezframework.executor.method;

import me.kingcjy.ezframework.executor.CommandArgs;
import org.bukkit.Bukkit;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvocableHandlerMethod extends HandlerMethod {

    private static Logger logger = Bukkit.getLogger();

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
            logger.log(Level.SEVERE, "[EzFramework] " + e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            logger.log(Level.SEVERE, "[EzFramework] " + targetException.getMessage(), targetException);
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
