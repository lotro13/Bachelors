package com.bachelor.backend;

import com.google.gson.Gson;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerJarOfBeans_getGsonBean(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("getGsonBean", Gson.class).withFactoryMethod(JarOfBeans.class, "getGsonBean")
        .instanceSupplier(() -> beanFactory.getBean(JarOfBeans.class).getGsonBean()).register(beanFactory);
  }
}
