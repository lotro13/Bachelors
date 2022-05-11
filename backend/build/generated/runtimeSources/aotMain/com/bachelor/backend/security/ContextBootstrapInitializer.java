package com.bachelor.backend.security;

import com.bachelor.backend.domain.users.UsersService;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.web.accept.ContentNegotiationStrategy;

public final class ContextBootstrapInitializer {
  public static void registerCustomTokenAuthenticationProvider(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("customTokenAuthenticationProvider", CustomTokenAuthenticationProvider.class)
        .instanceSupplier((instanceContext) -> {
          CustomTokenAuthenticationProvider bean = new CustomTokenAuthenticationProvider();
          instanceContext.field("usersService", UsersService.class)
              .invoke(beanFactory, (attributes) -> bean.usersService = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }

          public static void registerSecurityConfiguration(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("securityConfiguration", SecurityConfiguration.class)
                .instanceSupplier((instanceContext) -> {
                  SecurityConfiguration bean = new SecurityConfiguration();
                  instanceContext.method("setApplicationContext", ApplicationContext.class)
                      .invoke(beanFactory, (attributes) -> bean.setApplicationContext(attributes.get(0)));
                  instanceContext.method("setTrustResolver", AuthenticationTrustResolver.class)
                      .resolve(beanFactory, false).ifResolved((attributes) -> bean.setTrustResolver(attributes.get(0)));
                  instanceContext.method("setObjectPostProcessor", ObjectPostProcessor.class)
                      .invoke(beanFactory, (attributes) -> bean.setObjectPostProcessor(attributes.get(0)));
                  instanceContext.method("setAuthenticationConfiguration", AuthenticationConfiguration.class)
                      .invoke(beanFactory, (attributes) -> bean.setAuthenticationConfiguration(attributes.get(0)));
                  instanceContext.method("setContentNegotationStrategy", ContentNegotiationStrategy.class)
                      .resolve(beanFactory, false).ifResolved((attributes) -> bean.setContentNegotationStrategy(attributes.get(0)));
                  instanceContext.field("authenticationProvider", CustomTokenAuthenticationProvider.class)
                      .invoke(beanFactory, (attributes) -> bean.authenticationProvider = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }
                }
