package com.bachelor.backend.domain.group;

import com.bachelor.backend.domain.challenge.ChallengesRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerGroupsService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("groupsService", GroupsService.class)
        .instanceSupplier((instanceContext) -> {
          GroupsService bean = new GroupsService();
          instanceContext.field("groupRepository", GroupRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field groupRepositoryField = ReflectionUtils.findField(GroupsService.class, "groupRepository", GroupRepository.class);
                ReflectionUtils.makeAccessible(groupRepositoryField);
                ReflectionUtils.setField(groupRepositoryField, bean, attributes.get(0));
              });
                  instanceContext.field("challengesRepository", ChallengesRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field challengesRepositoryField = ReflectionUtils.findField(GroupsService.class, "challengesRepository", ChallengesRepository.class);
                        ReflectionUtils.makeAccessible(challengesRepositoryField);
                        ReflectionUtils.setField(challengesRepositoryField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }
                }
