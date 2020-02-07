package me.kingcjy.ezframework.executor.registry;

import me.kingcjy.ezframework.annotations.EzCommand;
import me.kingcjy.ezframework.annotations.EzEvent;
import me.kingcjy.ezframework.beans.factory.BeanFactory;
import me.kingcjy.ezframework.beans.factory.BeanFactoryAware;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultEventRegistry implements EventRegistry, BeanFactoryAware {

    private static Logger logger = Bukkit.getLogger();

    private JavaPlugin javaPlugin;
    private BeanFactory beanFactory;

    public DefaultEventRegistry(JavaPlugin javaPlugin, BeanFactory beanFactory) {
        this.javaPlugin = javaPlugin;
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public void registerEvents() {
        Map<Class<?>, Listener> eventClasses = findEventClasses();
        for (Class<?> key : eventClasses.keySet()) {
            Listener listener = eventClasses.get(key);
            javaPlugin.getServer().getPluginManager().registerEvents(listener, javaPlugin);
            logger.log(Level.INFO, "[EzFramework] register event : {0}", new Object[]{listener.getClass().getName()});
        }
    }

    private Map<Class<?>, Listener> findEventClasses() {
        Map<Class<?>, Listener> eventClasses = new HashMap<>();
        for (Object bean : this.beanFactory.getBeans()) {
            if(bean.getClass().isAnnotationPresent(EzEvent.class)) {
                eventClasses.put(bean.getClass(), (Listener) this.beanFactory.getBean(bean.getClass().getName()));
            }
        }
        return eventClasses;
    }
}
