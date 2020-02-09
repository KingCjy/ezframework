package me.kingcjy.ezframework.executor.method.invoke;

import me.kingcjy.ezframework.executor.CommandArgs;

/*
찾을수 없는 명령어일시 사용
 */
public class DefaultInvocableHandlerMethod extends InvocableHandlerMethod {
    @Override
    public Object invoke(CommandArgs commandArgs, Object... providedArguments) {
//        nothing to do
        return new Object();
    }
}