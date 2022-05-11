package com.bachelor.backend.domain.challenge;

import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerChallengesService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("challengesService", ChallengesService.class)
        .instanceSupplier((instanceContext) -> {
          ChallengesService bean = new ChallengesService();
          instanceContext.field("groupRepository", GroupRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field groupRepositoryField = ReflectionUtils.findField(ChallengesService.class, "groupRepository", GroupRepository.class);
                ReflectionUtils.makeAccessible(groupRepositoryField);
                ReflectionUtils.setField(groupRepositoryField, bean, attributes.get(0));
              });
                  instanceContext.field("challengesRepository", ChallengesRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field challengesRepositoryField = ReflectionUtils.findField(ChallengesService.class, "challengesRepository", ChallengesRepository.class);
                        ReflectionUtils.makeAccessible(challengesRepositoryField);
                        ReflectionUtils.setField(challengesRepositoryField, bean, attributes.get(0));
                      });
                          instanceContext.field("postsRepository", PostsRepository.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field postsRepositoryField = ReflectionUtils.findField(ChallengesService.class, "postsRepository", PostsRepository.class);
                                ReflectionUtils.makeAccessible(postsRepositoryField);
                                ReflectionUtils.setField(postsRepositoryField, bean, attributes.get(0));
                              });
                                  return bean;
                                }).register(beanFactory);
                          }
                        }
