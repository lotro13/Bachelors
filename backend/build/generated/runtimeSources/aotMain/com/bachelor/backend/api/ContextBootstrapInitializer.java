package com.bachelor.backend.api;

import com.bachelor.backend.domain.authentication.AuthenticationService;
import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.challenge.ChallengesService;
import com.bachelor.backend.domain.feed.CommentsRepository;
import com.bachelor.backend.domain.feed.FeedService;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.group.GroupsService;
import com.bachelor.backend.domain.users.UsersRepository;
import com.google.gson.Gson;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class ContextBootstrapInitializer {
  public static void registerApiController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("apiController", ApiController.class)
        .instanceSupplier((instanceContext) -> {
          ApiController bean = new ApiController();
          instanceContext.field("feedService", FeedService.class)
              .invoke(beanFactory, (attributes) -> {
                Field feedServiceField = ReflectionUtils.findField(ApiController.class, "feedService", FeedService.class);
                ReflectionUtils.makeAccessible(feedServiceField);
                ReflectionUtils.setField(feedServiceField, bean, attributes.get(0));
              });
                  instanceContext.field("groupRepository", GroupRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field groupRepositoryField = ReflectionUtils.findField(ApiController.class, "groupRepository", GroupRepository.class);
                        ReflectionUtils.makeAccessible(groupRepositoryField);
                        ReflectionUtils.setField(groupRepositoryField, bean, attributes.get(0));
                      });
                          instanceContext.field("challengesRepository", ChallengesRepository.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field challengesRepositoryField = ReflectionUtils.findField(ApiController.class, "challengesRepository", ChallengesRepository.class);
                                ReflectionUtils.makeAccessible(challengesRepositoryField);
                                ReflectionUtils.setField(challengesRepositoryField, bean, attributes.get(0));
                              });
                                  instanceContext.field("usersRepository", UsersRepository.class)
                                      .invoke(beanFactory, (attributes) -> {
                                        Field usersRepositoryField = ReflectionUtils.findField(ApiController.class, "usersRepository", UsersRepository.class);
                                        ReflectionUtils.makeAccessible(usersRepositoryField);
                                        ReflectionUtils.setField(usersRepositoryField, bean, attributes.get(0));
                                      });
                                          instanceContext.field("postsRepository", PostsRepository.class)
                                              .invoke(beanFactory, (attributes) -> {
                                                Field postsRepositoryField = ReflectionUtils.findField(ApiController.class, "postsRepository", PostsRepository.class);
                                                ReflectionUtils.makeAccessible(postsRepositoryField);
                                                ReflectionUtils.setField(postsRepositoryField, bean, attributes.get(0));
                                              });
                                                  instanceContext.field("commentsRepository", CommentsRepository.class)
                                                      .invoke(beanFactory, (attributes) -> {
                                                        Field commentsRepositoryField = ReflectionUtils.findField(ApiController.class, "commentsRepository", CommentsRepository.class);
                                                        ReflectionUtils.makeAccessible(commentsRepositoryField);
                                                        ReflectionUtils.setField(commentsRepositoryField, bean, attributes.get(0));
                                                      });
                                                          instanceContext.field("tokenRepository", TokenRepository.class)
                                                              .invoke(beanFactory, (attributes) -> {
                                                                Field tokenRepositoryField = ReflectionUtils.findField(ApiController.class, "tokenRepository", TokenRepository.class);
                                                                ReflectionUtils.makeAccessible(tokenRepositoryField);
                                                                ReflectionUtils.setField(tokenRepositoryField, bean, attributes.get(0));
                                                              });
                                                                  instanceContext.field("groupsService", GroupsService.class)
                                                                      .invoke(beanFactory, (attributes) -> {
                                                                        Field groupsServiceField = ReflectionUtils.findField(ApiController.class, "groupsService", GroupsService.class);
                                                                        ReflectionUtils.makeAccessible(groupsServiceField);
                                                                        ReflectionUtils.setField(groupsServiceField, bean, attributes.get(0));
                                                                      });
                                                                          instanceContext.field("challengesService", ChallengesService.class)
                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                Field challengesServiceField = ReflectionUtils.findField(ApiController.class, "challengesService", ChallengesService.class);
                                                                                ReflectionUtils.makeAccessible(challengesServiceField);
                                                                                ReflectionUtils.setField(challengesServiceField, bean, attributes.get(0));
                                                                              });
                                                                                  instanceContext.field("gson", Gson.class)
                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                        Field gsonField = ReflectionUtils.findField(ApiController.class, "gson", Gson.class);
                                                                                        ReflectionUtils.makeAccessible(gsonField);
                                                                                        ReflectionUtils.setField(gsonField, bean, attributes.get(0));
                                                                                      });
                                                                                          return bean;
                                                                                        }).register(beanFactory);
                                                                                  }

                                                                                  public static void registerUserController(
                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                    BeanDefinitionRegistrar.of("userController", UserController.class)
                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                          UserController bean = new UserController();
                                                                                          instanceContext.field("authenticationService", AuthenticationService.class)
                                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                                Field authenticationServiceField = ReflectionUtils.findField(UserController.class, "authenticationService", AuthenticationService.class);
                                                                                                ReflectionUtils.makeAccessible(authenticationServiceField);
                                                                                                ReflectionUtils.setField(authenticationServiceField, bean, attributes.get(0));
                                                                                              });
                                                                                                  instanceContext.field("usersRepository", UsersRepository.class)
                                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                                        Field usersRepositoryField = ReflectionUtils.findField(UserController.class, "usersRepository", UsersRepository.class);
                                                                                                        ReflectionUtils.makeAccessible(usersRepositoryField);
                                                                                                        ReflectionUtils.setField(usersRepositoryField, bean, attributes.get(0));
                                                                                                      });
                                                                                                          return bean;
                                                                                                        }).register(beanFactory);
                                                                                                  }
                                                                                                }
