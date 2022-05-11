package com.bachelor.backend.domain.users;

import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerUsersService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("usersService", UsersService.class)
        .instanceSupplier((instanceContext) -> {
          UsersService bean = new UsersService();
          instanceContext.field("groupRepository", GroupRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field groupRepositoryField = ReflectionUtils.findField(UsersService.class, "groupRepository", GroupRepository.class);
                ReflectionUtils.makeAccessible(groupRepositoryField);
                ReflectionUtils.setField(groupRepositoryField, bean, attributes.get(0));
              });
                  instanceContext.field("challengesRepository", ChallengesRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field challengesRepositoryField = ReflectionUtils.findField(UsersService.class, "challengesRepository", ChallengesRepository.class);
                        ReflectionUtils.makeAccessible(challengesRepositoryField);
                        ReflectionUtils.setField(challengesRepositoryField, bean, attributes.get(0));
                      });
                          instanceContext.field("tokenRepository", TokenRepository.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field tokenRepositoryField = ReflectionUtils.findField(UsersService.class, "tokenRepository", TokenRepository.class);
                                ReflectionUtils.makeAccessible(tokenRepositoryField);
                                ReflectionUtils.setField(tokenRepositoryField, bean, attributes.get(0));
                              });
                                  return bean;
                                }).register(beanFactory);
                          }
                        }
