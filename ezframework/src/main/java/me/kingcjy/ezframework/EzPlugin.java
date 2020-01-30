package me.kingcjy.ezframework;

import me.kingcjy.ezframework.beans.ClassPathBeanDefinitionScanner;
import me.kingcjy.ezframework.beans.factory.DefaultBeanFactory;
import me.kingcjy.ezframework.executor.AnnotationHandlerMapping;
import me.kingcjy.ezframework.executor.EzCommandExecutor;
import me.kingcjy.ezframework.executor.method.DefaultHandlerMethodFactory;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandMap;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.defaults.BukkitCommand;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.SimplePluginManager;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EzPlugin {

    public static void run(Object instance) {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(beanFactory);
        scanner.scan(instance.getClass().getPackage().getName());
        beanFactory.instantiateBeans();

        DefaultHandlerMethodFactory handlerMethodFactory = new DefaultHandlerMethodFactory();
        handlerMethodFactory.setBeanFactory(beanFactory);
        handlerMethodFactory.afterPropertiesSet();

        AnnotationHandlerMapping annotationHandlerMapping = new AnnotationHandlerMapping(beanFactory, handlerMethodFactory);

        EzCommandExecutor ezCommandExecutor = new EzCommandExecutor(annotationHandlerMapping);

        Server server = Bukkit.getServer();
        PluginManager pluginManager = server.getPluginManager();

        try {
            Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            CommandMap commandMap = (CommandMap) field.get(pluginManager);

            Constructor constructor = PluginCommand.class.getDeclaredConstructor(String.class, Plugin.class);
            constructor.setAccessible(true);
            PluginCommand pluginCommand = (PluginCommand) constructor.newInstance("message", instance);

            pluginCommand.setExecutor(ezCommandExecutor);
            commandMap.register("좇", pluginCommand);
            Method method = Bukkit.getServer().getClass().getDeclaredMethod("syncCommands");
            method.setAccessible(true);

            method.invoke(server);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
