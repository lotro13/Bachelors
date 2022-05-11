package com.bachelor.backend.domain.feed;

import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerFeedService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("feedService", FeedService.class)
        .instanceSupplier((instanceContext) -> {
          FeedService bean = new FeedService();
          instanceContext.field("groupRepository", GroupRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field groupRepositoryField = ReflectionUtils.findField(FeedService.class, "groupRepository", GroupRepository.class);
                ReflectionUtils.makeAccessible(groupRepositoryField);
                ReflectionUtils.setField(groupRepositoryField, bean, attributes.get(0));
              });
                  instanceContext.field("challengesRepository", ChallengesRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field challengesRepositoryField = ReflectionUtils.findField(FeedService.class, "challengesRepository", ChallengesRepository.class);
                        ReflectionUtils.makeAccessible(challengesRepositoryField);
                        ReflectionUtils.setField(challengesRepositoryField, bean, attributes.get(0));
                      });
                          instanceContext.field("postsRepository", PostsRepository.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field postsRepositoryField = ReflectionUtils.findField(FeedService.class, "postsRepository", PostsRepository.class);
                                ReflectionUtils.makeAccessible(postsRepositoryField);
                                ReflectionUtils.setField(postsRepositoryField, bean, attributes.get(0));
                              });
                                  instanceContext.field("commentsRepository", CommentsRepository.class)
                                      .invoke(beanFactory, (attributes) -> {
                                        Field commentsRepositoryField = ReflectionUtils.findField(FeedService.class, "commentsRepository", CommentsRepository.class);
                                        ReflectionUtils.makeAccessible(commentsRepositoryField);
                                        ReflectionUtils.setField(commentsRepositoryField, bean, attributes.get(0));
                                      });
                                          return bean;
                                        }).register(beanFactory);
                                  }
                                }
