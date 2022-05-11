package com.bachelor.backend.domain.authentication;

import com.bachelor.backend.domain.users.UsersRepository;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerAuthenticationService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("authenticationService", AuthenticationService.class)
        .instanceSupplier((instanceContext) -> {
          AuthenticationService bean = new AuthenticationService();
          instanceContext.field("usersRepository", UsersRepository.class)
              .invoke(beanFactory, (attributes) -> bean.usersRepository = attributes.get(0));
                  instanceContext.field("tokenRepository", TokenRepository.class)
                      .invoke(beanFactory, (attributes) -> bean.tokenRepository = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }
                }
