package org.springframework.boot.autoconfigure.session;

import java.lang.String;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.session.IndexResolver;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HttpSessionIdResolver;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionOperations;

public final class ContextBootstrapInitializer {
  public static void registerSessionAutoConfiguration_ServletSessionRepositoryImplementationValidator(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionRepositoryImplementationValidator", SessionAutoConfiguration.ServletSessionRepositoryImplementationValidator.class).withConstructor(ApplicationContext.class, SessionProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new SessionAutoConfiguration.ServletSessionRepositoryImplementationValidator(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerJdbcSessionConfiguration_SpringBootJdbcHttpSessionConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.JdbcSessionConfiguration$SpringBootJdbcHttpSessionConfiguration", JdbcSessionConfiguration.SpringBootJdbcHttpSessionConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          JdbcSessionConfiguration.SpringBootJdbcHttpSessionConfiguration bean = new JdbcSessionConfiguration.SpringBootJdbcHttpSessionConfiguration();
          instanceContext.method("setServletContext", ServletContext.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setServletContext(attributes.get(0)));
          instanceContext.method("setHttpSessionIdResolver", HttpSessionIdResolver.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setHttpSessionIdResolver(attributes.get(0)));
          instanceContext.method("setHttpSessionListeners", List.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setHttpSessionListeners(attributes.get(0)));
          instanceContext.method("setCookieSerializer", CookieSerializer.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setCookieSerializer(attributes.get(0)));
          instanceContext.method("setTransactionManager", PlatformTransactionManager.class)
              .invoke(beanFactory, (attributes) -> bean.setTransactionManager(attributes.get(0)));
          instanceContext.method("setConversionService", ConversionService.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setConversionService(attributes.get(0)));
          instanceContext.method("setLobHandler", LobHandler.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setLobHandler(attributes.get(0)));
          instanceContext.method("setIndexResolver", IndexResolver.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setIndexResolver(attributes.get(0)));
          instanceContext.method("setDataSource", ObjectProvider.class, ObjectProvider.class)
              .invoke(beanFactory, (attributes) -> bean.setDataSource(attributes.get(0), attributes.get(1)));
          instanceContext.method("setSessionRepositoryCustomizer", ObjectProvider.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setSessionRepositoryCustomizer(attributes.get(0)));
          instanceContext.method("setTransactionOperations", TransactionOperations.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setTransactionOperations(attributes.get(0)));
          instanceContext.method("setSpringSessionConversionService", ConversionService.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setSpringSessionConversionService(attributes.get(0)));
          instanceContext.method("customize", SessionProperties.class, JdbcSessionProperties.class, ServerProperties.class)
              .invoke(beanFactory, (attributes) -> bean.customize(attributes.get(0), attributes.get(1), attributes.get(2)));
          return bean;
        }).register(beanFactory);
  }

  public static void registerJdbcSessionConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.JdbcSessionConfiguration", JdbcSessionConfiguration.class)
        .instanceSupplier(JdbcSessionConfiguration::new).register(beanFactory);
  }

  public static void registerJdbcSessionConfiguration_jdbcSessionDataSourceScriptDatabaseInitializer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("jdbcSessionDataSourceScriptDatabaseInitializer", JdbcSessionDataSourceScriptDatabaseInitializer.class).withFactoryMethod(JdbcSessionConfiguration.class, "jdbcSessionDataSourceScriptDatabaseInitializer", ObjectProvider.class, ObjectProvider.class, JdbcSessionProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JdbcSessionConfiguration.class).jdbcSessionDataSourceScriptDatabaseInitializer(attributes.get(0), attributes.get(1), attributes.get(2)))).customize((bd) -> bd.setDependsOn(new String[] { "flywayInitializer" })).register(beanFactory);
  }

  public static void registerServletSessionConfiguration_ServletSessionRepositoryConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionConfiguration$ServletSessionRepositoryConfiguration", SessionAutoConfiguration.ServletSessionConfiguration.ServletSessionRepositoryConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration.ServletSessionConfiguration.ServletSessionRepositoryConfiguration::new).register(beanFactory);
  }

  public static void registerServletSessionConfiguration_RememberMeServicesConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionConfiguration$RememberMeServicesConfiguration", SessionAutoConfiguration.ServletSessionConfiguration.RememberMeServicesConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration.ServletSessionConfiguration.RememberMeServicesConfiguration::new).register(beanFactory);
  }

  public static void registerRememberMeServicesConfiguration_rememberMeServicesCookieSerializerCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("rememberMeServicesCookieSerializerCustomizer", DefaultCookieSerializerCustomizer.class).withFactoryMethod(SessionAutoConfiguration.ServletSessionConfiguration.RememberMeServicesConfiguration.class, "rememberMeServicesCookieSerializerCustomizer")
        .instanceSupplier(() -> beanFactory.getBean(SessionAutoConfiguration.ServletSessionConfiguration.RememberMeServicesConfiguration.class).rememberMeServicesCookieSerializerCustomizer()).register(beanFactory);
  }

  public static void registerSessionAutoConfiguration_ServletSessionRepositoryValidator(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionRepositoryValidator", SessionAutoConfiguration.ServletSessionRepositoryValidator.class).withConstructor(SessionProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new SessionAutoConfiguration.ServletSessionRepositoryValidator(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerSessionRepositoryFilterConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionRepositoryFilterConfiguration", SessionRepositoryFilterConfiguration.class)
        .instanceSupplier(SessionRepositoryFilterConfiguration::new).register(beanFactory);
  }

  public static void registerSessionRepositoryFilterConfiguration_sessionRepositoryFilterRegistration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("sessionRepositoryFilterRegistration", FilterRegistrationBean.class).withFactoryMethod(SessionRepositoryFilterConfiguration.class, "sessionRepositoryFilterRegistration", SessionProperties.class, SessionRepositoryFilter.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SessionRepositoryFilterConfiguration.class).sessionRepositoryFilterRegistration(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerSessionAutoConfiguration_ServletSessionConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionConfiguration", SessionAutoConfiguration.ServletSessionConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration.ServletSessionConfiguration::new).register(beanFactory);
  }

  public static void registerServletSessionConfiguration_cookieSerializer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("cookieSerializer", DefaultCookieSerializer.class).withFactoryMethod(SessionAutoConfiguration.ServletSessionConfiguration.class, "cookieSerializer", ServerProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SessionAutoConfiguration.ServletSessionConfiguration.class).cookieSerializer(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}
