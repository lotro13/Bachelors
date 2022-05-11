package org.springframework.session.jdbc.config.annotation.web.http;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;

public final class ContextBootstrapInitializer {
  public static void registerJdbcHttpSessionConfiguration_SessionCleanupConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration$SessionCleanupConfiguration", JdbcHttpSessionConfiguration.SessionCleanupConfiguration.class).withConstructor(JdbcHttpSessionConfiguration.class, JdbcIndexedSessionRepository.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JdbcHttpSessionConfiguration.class).new SessionCleanupConfiguration(attributes.get(1)))).register(beanFactory);
  }
}
