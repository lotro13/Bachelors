package org.springframework.aot;

import com.bachelor.backend.BackendApplication;
import com.bachelor.backend.JarOfBeans;
import com.bachelor.backend.domain.authentication.TokenRepository;
import com.bachelor.backend.domain.challenge.ChallengesRepository;
import com.bachelor.backend.domain.feed.CommentsRepository;
import com.bachelor.backend.domain.feed.PostsRepository;
import com.bachelor.backend.domain.group.GroupRepository;
import com.bachelor.backend.domain.users.UsersRepository;
import com.google.gson.GsonBuilder;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.jooq.Configuration;
import org.jooq.ConnectionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.aot.context.annotation.ImportAwareBeanPostProcessor;
import org.springframework.aot.context.annotation.InitDestroyBeanPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.LazyInitializationExcludeFilter;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleProperties;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcProperties;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqProperties;
import org.springframework.boot.autoconfigure.jooq.SpringTransactionProvider;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.session.JdbcSessionProperties;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.boot.autoconfigure.transaction.TransactionProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateBuilderConfigurer;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.boot.availability.ApplicationAvailabilityBean;
import org.springframework.boot.context.properties.BoundConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.boot.task.TaskSchedulerBuilder;
import org.springframework.boot.validation.beanvalidation.MethodValidationExcludeFilter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ErrorPageRegistrarBeanPostProcessor;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.filter.OrderedFormContentFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.SchedulingConfiguration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration;
import org.springframework.security.config.annotation.web.configuration.AutowiredWebSecurityConfigurersIgnoreParents;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.context.DelegatingApplicationListener;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.jdbc.JdbcIndexedSessionRepository;
import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;
import org.springframework.session.web.http.SessionRepositoryFilter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AbstractTransactionManagementConfiguration;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.event.TransactionalEventListenerFactory;
import org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.PathMatcher;
import org.springframework.validation.Validator;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.method.support.CompositeUriComponentsContributor;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.function.support.HandlerFunctionAdapter;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import org.springframework.web.servlet.mvc.HttpRequestHandlerAdapter;
import org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.web.util.pattern.PathPatternParser;

public class ContextBootstrapInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
  private ImportAwareBeanPostProcessor createImportAwareBeanPostProcessor() {
    Map<String, String> mappings = new LinkedHashMap<>();
    mappings.put("org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration", "com.bachelor.backend.security.SecurityConfiguration");
    mappings.put("org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration", "org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$JdkDynamicAutoProxyConfiguration");
    return new ImportAwareBeanPostProcessor(mappings);
  }

  private InitDestroyBeanPostProcessor createInitDestroyBeanPostProcessor(
      ConfigurableBeanFactory beanFactory) {
    Map<String, List<String>> initMethods = new LinkedHashMap<>();
    initMethods.put("org.springframework.boot.autoconfigure.session.JdbcSessionConfiguration$SpringBootJdbcHttpSessionConfiguration", List.of("init"));
    Map<String, List<String>> destroyMethods = new LinkedHashMap<>();
    return new InitDestroyBeanPostProcessor(beanFactory, initMethods, destroyMethods);
  }

  @Override
  public void initialize(GenericApplicationContext context) {
    // infrastructure
    DefaultListableBeanFactory beanFactory = context.getDefaultListableBeanFactory();
    beanFactory.setAutowireCandidateResolver(new ContextAnnotationAutowireCandidateResolver());
    beanFactory.addBeanPostProcessor(createImportAwareBeanPostProcessor());
    beanFactory.addBeanPostProcessor(createInitDestroyBeanPostProcessor(beanFactory));

    BeanDefinitionRegistrar.of("com.bachelor.backend.BackendApplication", BackendApplication.class)
        .instanceSupplier(BackendApplication::new).register(beanFactory);
    BeanDefinitionRegistrar.of("jarOfBeans", JarOfBeans.class)
        .instanceSupplier(JarOfBeans::new).register(beanFactory);
    com.bachelor.backend.api.ContextBootstrapInitializer.registerApiController(beanFactory);
    com.bachelor.backend.api.ContextBootstrapInitializer.registerUserController(beanFactory);
    com.bachelor.backend.domain.authentication.ContextBootstrapInitializer.registerAuthenticationService(beanFactory);
    BeanDefinitionRegistrar.of("tokenRepository", TokenRepository.class)
        .instanceSupplier(TokenRepository::new).register(beanFactory);
    BeanDefinitionRegistrar.of("challengesRepository", ChallengesRepository.class)
        .instanceSupplier(ChallengesRepository::new).register(beanFactory);
    com.bachelor.backend.domain.challenge.ContextBootstrapInitializer.registerChallengesService(beanFactory);
    BeanDefinitionRegistrar.of("commentsRepository", CommentsRepository.class)
        .instanceSupplier(CommentsRepository::new).register(beanFactory);
    com.bachelor.backend.domain.feed.ContextBootstrapInitializer.registerFeedService(beanFactory);
    BeanDefinitionRegistrar.of("postsRepository", PostsRepository.class)
        .instanceSupplier(PostsRepository::new).register(beanFactory);
    BeanDefinitionRegistrar.of("groupRepository", GroupRepository.class)
        .instanceSupplier(GroupRepository::new).register(beanFactory);
    com.bachelor.backend.domain.group.ContextBootstrapInitializer.registerGroupsService(beanFactory);
    BeanDefinitionRegistrar.of("usersRepository", UsersRepository.class)
        .instanceSupplier(UsersRepository::new).register(beanFactory);
    com.bachelor.backend.domain.users.ContextBootstrapInitializer.registerUsersService(beanFactory);
    com.bachelor.backend.security.ContextBootstrapInitializer.registerCustomTokenAuthenticationProvider(beanFactory);
    com.bachelor.backend.security.ContextBootstrapInitializer.registerSecurityConfiguration(beanFactory);
    com.bachelor.backend.ContextBootstrapInitializer.registerJarOfBeans_getGsonBean(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration", ObjectPostProcessorConfiguration.class)
        .instanceSupplier(ObjectPostProcessorConfiguration::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("objectPostProcessor", ResolvableType.forClassWithGenerics(ObjectPostProcessor.class, Object.class)).withFactoryMethod(ObjectPostProcessorConfiguration.class, "objectPostProcessor", AutowireCapableBeanFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ObjectPostProcessorConfiguration.class).objectPostProcessor(attributes.get(0)))).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration", AuthenticationConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          AuthenticationConfiguration bean = new AuthenticationConfiguration();
          instanceContext.method("setApplicationContext", ApplicationContext.class)
              .invoke(beanFactory, (attributes) -> bean.setApplicationContext(attributes.get(0)));
          instanceContext.method("setGlobalAuthenticationConfigurers", List.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setGlobalAuthenticationConfigurers(attributes.get(0)));
          instanceContext.method("setObjectPostProcessor", ObjectPostProcessor.class)
              .invoke(beanFactory, (attributes) -> bean.setObjectPostProcessor(attributes.get(0)));
          return bean;
        }).register(beanFactory);
    BeanDefinitionRegistrar.of("authenticationManagerBuilder", AuthenticationManagerBuilder.class).withFactoryMethod(AuthenticationConfiguration.class, "authenticationManagerBuilder", ObjectPostProcessor.class, ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(AuthenticationConfiguration.class).authenticationManagerBuilder(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("enableGlobalAuthenticationAutowiredConfigurer", GlobalAuthenticationConfigurerAdapter.class).withFactoryMethod(AuthenticationConfiguration.class, "enableGlobalAuthenticationAutowiredConfigurer", ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> AuthenticationConfiguration.enableGlobalAuthenticationAutowiredConfigurer(attributes.get(0)))).register(beanFactory);
    org.springframework.security.config.annotation.authentication.configuration.ContextBootstrapInitializer.registerAuthenticationConfiguration_initializeUserDetailsBeanManagerConfigurer(beanFactory);
    org.springframework.security.config.annotation.authentication.configuration.ContextBootstrapInitializer.registerAuthenticationConfiguration_initializeAuthenticationProviderBeanManagerConfigurer(beanFactory);
    org.springframework.security.config.annotation.web.configuration.ContextBootstrapInitializer.registerWebSecurityConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("delegatingApplicationListener", DelegatingApplicationListener.class).withFactoryMethod(WebSecurityConfiguration.class, "delegatingApplicationListener")
        .instanceSupplier(() -> WebSecurityConfiguration.delegatingApplicationListener()).register(beanFactory);
    BeanDefinitionRegistrar.of("webSecurityExpressionHandler", ResolvableType.forClassWithGenerics(SecurityExpressionHandler.class, FilterInvocation.class)).withFactoryMethod(WebSecurityConfiguration.class, "webSecurityExpressionHandler")
        .instanceSupplier(() -> beanFactory.getBean(WebSecurityConfiguration.class).webSecurityExpressionHandler()).customize((bd) -> bd.setDependsOn(new String[] { "springSecurityFilterChain" })).register(beanFactory);
    BeanDefinitionRegistrar.of("springSecurityFilterChain", Filter.class).withFactoryMethod(WebSecurityConfiguration.class, "springSecurityFilterChain")
        .instanceSupplier(() -> beanFactory.getBean(WebSecurityConfiguration.class).springSecurityFilterChain()).register(beanFactory);
    BeanDefinitionRegistrar.of("privilegeEvaluator", WebInvocationPrivilegeEvaluator.class).withFactoryMethod(WebSecurityConfiguration.class, "privilegeEvaluator")
        .instanceSupplier(() -> beanFactory.getBean(WebSecurityConfiguration.class).privilegeEvaluator()).customize((bd) -> bd.setDependsOn(new String[] { "springSecurityFilterChain" })).register(beanFactory);
    BeanDefinitionRegistrar.of("conversionServicePostProcessor", BeanFactoryPostProcessor.class).withFactoryMethod(WebSecurityConfiguration.class, "conversionServicePostProcessor")
        .instanceSupplier(() -> WebSecurityConfiguration.conversionServicePostProcessor()).register(beanFactory);
    BeanDefinitionRegistrar.of("autowiredWebSecurityConfigurersIgnoreParents", AutowiredWebSecurityConfigurersIgnoreParents.class).withFactoryMethod(WebSecurityConfiguration.class, "autowiredWebSecurityConfigurersIgnoreParents", ConfigurableListableBeanFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> WebSecurityConfiguration.autowiredWebSecurityConfigurersIgnoreParents(attributes.get(0)))).register(beanFactory);
    org.springframework.security.config.annotation.web.configuration.ContextBootstrapInitializer.registerWebMvcSecurityConfiguration(beanFactory);
    org.springframework.security.config.annotation.web.configuration.ContextBootstrapInitializer.registerWebMvcSecurityConfiguration_requestDataValueProcessor(beanFactory);
    org.springframework.security.config.annotation.web.configuration.ContextBootstrapInitializer.registerHttpSecurityConfiguration(beanFactory);
    org.springframework.security.config.annotation.web.configuration.ContextBootstrapInitializer.registerHttpSecurityConfiguration_httpSecurity(beanFactory);
    org.springframework.boot.autoconfigure.ContextBootstrapInitializer.registerAutoConfigurationPackages_BasePackages(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration", PropertyPlaceholderAutoConfiguration.class)
        .instanceSupplier(PropertyPlaceholderAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("propertySourcesPlaceholderConfigurer", PropertySourcesPlaceholderConfigurer.class).withFactoryMethod(PropertyPlaceholderAutoConfiguration.class, "propertySourcesPlaceholderConfigurer")
        .instanceSupplier(() -> PropertyPlaceholderAutoConfiguration.propertySourcesPlaceholderConfigurer()).register(beanFactory);
    org.springframework.boot.autoconfigure.websocket.servlet.ContextBootstrapInitializer.registerWebSocketServletAutoConfiguration_TomcatWebSocketConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.websocket.servlet.ContextBootstrapInitializer.registerTomcatWebSocketConfiguration_websocketServletWebServerCustomizer(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration", WebSocketServletAutoConfiguration.class)
        .instanceSupplier(WebSocketServletAutoConfiguration::new).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerServletWebServerFactoryConfiguration_EmbeddedTomcat(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerEmbeddedTomcat_tomcatServletWebServerFactory(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration", ServletWebServerFactoryAutoConfiguration.class)
        .instanceSupplier(ServletWebServerFactoryAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("servletWebServerFactoryCustomizer", ServletWebServerFactoryCustomizer.class).withFactoryMethod(ServletWebServerFactoryAutoConfiguration.class, "servletWebServerFactoryCustomizer", ServerProperties.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ServletWebServerFactoryAutoConfiguration.class).servletWebServerFactoryCustomizer(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("tomcatServletWebServerFactoryCustomizer", TomcatServletWebServerFactoryCustomizer.class).withFactoryMethod(ServletWebServerFactoryAutoConfiguration.class, "tomcatServletWebServerFactoryCustomizer", ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ServletWebServerFactoryAutoConfiguration.class).tomcatServletWebServerFactoryCustomizer(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor", ConfigurationPropertiesBindingPostProcessor.class)
        .instanceSupplier(ConfigurationPropertiesBindingPostProcessor::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    org.springframework.boot.context.properties.ContextBootstrapInitializer.registerConfigurationPropertiesBinder_Factory(beanFactory);
    org.springframework.boot.context.properties.ContextBootstrapInitializer.registerConfigurationPropertiesBinder(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.BoundConfigurationProperties", BoundConfigurationProperties.class)
        .instanceSupplier(BoundConfigurationProperties::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.context.properties.EnableConfigurationPropertiesRegistrar.methodValidationExcludeFilter", MethodValidationExcludeFilter.class)
        .instanceSupplier(() -> MethodValidationExcludeFilter.byAnnotation(ConfigurationProperties.class)).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("server-org.springframework.boot.autoconfigure.web.ServerProperties", ServerProperties.class)
        .instanceSupplier(ServerProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("webServerFactoryCustomizerBeanPostProcessor", WebServerFactoryCustomizerBeanPostProcessor.class)
        .instanceSupplier(WebServerFactoryCustomizerBeanPostProcessor::new).customize((bd) -> bd.setSynthetic(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("errorPageRegistrarBeanPostProcessor", ErrorPageRegistrarBeanPostProcessor.class)
        .instanceSupplier(ErrorPageRegistrarBeanPostProcessor::new).customize((bd) -> bd.setSynthetic(true)).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerDispatcherServletAutoConfiguration_DispatcherServletConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerDispatcherServletConfiguration_dispatcherServlet(beanFactory);
    BeanDefinitionRegistrar.of("spring.mvc-org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties", WebMvcProperties.class)
        .instanceSupplier(WebMvcProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerDispatcherServletAutoConfiguration_DispatcherServletRegistrationConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerDispatcherServletRegistrationConfiguration_dispatcherServletRegistration(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration", DispatcherServletAutoConfiguration.class)
        .instanceSupplier(DispatcherServletAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration", TaskExecutionAutoConfiguration.class)
        .instanceSupplier(TaskExecutionAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("taskExecutorBuilder", TaskExecutorBuilder.class).withFactoryMethod(TaskExecutionAutoConfiguration.class, "taskExecutorBuilder", TaskExecutionProperties.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TaskExecutionAutoConfiguration.class).taskExecutorBuilder(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("applicationTaskExecutor", ThreadPoolTaskExecutor.class).withFactoryMethod(TaskExecutionAutoConfiguration.class, "applicationTaskExecutor", TaskExecutorBuilder.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TaskExecutionAutoConfiguration.class).applicationTaskExecutor(attributes.get(0)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.task.execution-org.springframework.boot.autoconfigure.task.TaskExecutionProperties", TaskExecutionProperties.class)
        .instanceSupplier(TaskExecutionProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerErrorMvcAutoConfiguration_WhitelabelErrorViewConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerWhitelabelErrorViewConfiguration_error(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerWhitelabelErrorViewConfiguration_beanNameViewResolver(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerErrorMvcAutoConfiguration_DefaultErrorViewResolverConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerDefaultErrorViewResolverConfiguration_conventionErrorViewResolver(beanFactory);
    BeanDefinitionRegistrar.of("spring.web-org.springframework.boot.autoconfigure.web.WebProperties", WebProperties.class)
        .instanceSupplier(WebProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration", ErrorMvcAutoConfiguration.class).withConstructor(ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ErrorMvcAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("errorAttributes", DefaultErrorAttributes.class).withFactoryMethod(ErrorMvcAutoConfiguration.class, "errorAttributes")
        .instanceSupplier(() -> beanFactory.getBean(ErrorMvcAutoConfiguration.class).errorAttributes()).register(beanFactory);
    BeanDefinitionRegistrar.of("basicErrorController", BasicErrorController.class).withFactoryMethod(ErrorMvcAutoConfiguration.class, "basicErrorController", ErrorAttributes.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ErrorMvcAutoConfiguration.class).basicErrorController(attributes.get(0), attributes.get(1)))).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerErrorMvcAutoConfiguration_errorPageCustomizer(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.error.ContextBootstrapInitializer.registerErrorMvcAutoConfiguration_preserveErrorControllerTargetClassPostProcessor(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerWebMvcAutoConfiguration_EnableWebMvcConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("requestMappingHandlerAdapter", RequestMappingHandlerAdapter.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "requestMappingHandlerAdapter", ContentNegotiationManager.class, FormattingConversionService.class, Validator.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).requestMappingHandlerAdapter(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("requestMappingHandlerMapping", RequestMappingHandlerMapping.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "requestMappingHandlerMapping", ContentNegotiationManager.class, FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).requestMappingHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2)))).customize((bd) -> bd.setPrimary(true)).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerEnableWebMvcConfiguration_welcomePageHandlerMapping(beanFactory);
    BeanDefinitionRegistrar.of("localeResolver", LocaleResolver.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "localeResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).localeResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("themeResolver", ThemeResolver.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "themeResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).themeResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("flashMapManager", FlashMapManager.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "flashMapManager")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).flashMapManager()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcConversionService", FormattingConversionService.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcConversionService")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcConversionService()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcValidator", Validator.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcValidator")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcValidator()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcContentNegotiationManager", ContentNegotiationManager.class).withFactoryMethod(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class, "mvcContentNegotiationManager")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.EnableWebMvcConfiguration.class).mvcContentNegotiationManager()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcPatternParser", PathPatternParser.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcPatternParser")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcPatternParser()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcUrlPathHelper", UrlPathHelper.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcUrlPathHelper")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcUrlPathHelper()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcPathMatcher", PathMatcher.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcPathMatcher")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcPathMatcher()).register(beanFactory);
    BeanDefinitionRegistrar.of("viewControllerHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "viewControllerHandlerMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).viewControllerHandlerMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("beanNameHandlerMapping", BeanNameUrlHandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "beanNameHandlerMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).beanNameHandlerMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("routerFunctionMapping", RouterFunctionMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "routerFunctionMapping", FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).routerFunctionMapping(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("resourceHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "resourceHandlerMapping", ContentNegotiationManager.class, FormattingConversionService.class, ResourceUrlProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).resourceHandlerMapping(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcResourceUrlProvider", ResourceUrlProvider.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcResourceUrlProvider")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcResourceUrlProvider()).register(beanFactory);
    BeanDefinitionRegistrar.of("defaultServletHandlerMapping", HandlerMapping.class).withFactoryMethod(WebMvcConfigurationSupport.class, "defaultServletHandlerMapping")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).defaultServletHandlerMapping()).register(beanFactory);
    BeanDefinitionRegistrar.of("handlerFunctionAdapter", HandlerFunctionAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "handlerFunctionAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).handlerFunctionAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcUriComponentsContributor", CompositeUriComponentsContributor.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcUriComponentsContributor", FormattingConversionService.class, RequestMappingHandlerAdapter.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcUriComponentsContributor(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("httpRequestHandlerAdapter", HttpRequestHandlerAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "httpRequestHandlerAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).httpRequestHandlerAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("simpleControllerHandlerAdapter", SimpleControllerHandlerAdapter.class).withFactoryMethod(WebMvcConfigurationSupport.class, "simpleControllerHandlerAdapter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).simpleControllerHandlerAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("handlerExceptionResolver", HandlerExceptionResolver.class).withFactoryMethod(WebMvcConfigurationSupport.class, "handlerExceptionResolver", ContentNegotiationManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).handlerExceptionResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcViewResolver", ViewResolver.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcViewResolver", ContentNegotiationManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcViewResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("mvcHandlerMappingIntrospector", HandlerMappingIntrospector.class).withFactoryMethod(WebMvcConfigurationSupport.class, "mvcHandlerMappingIntrospector")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).mvcHandlerMappingIntrospector()).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("viewNameTranslator", RequestToViewNameTranslator.class).withFactoryMethod(WebMvcConfigurationSupport.class, "viewNameTranslator")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcConfigurationSupport.class).viewNameTranslator()).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerWebMvcAutoConfiguration_WebMvcAutoConfigurationAdapter(beanFactory);
    BeanDefinitionRegistrar.of("defaultViewResolver", InternalResourceViewResolver.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "defaultViewResolver")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class).defaultViewResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("viewResolver", ContentNegotiatingViewResolver.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "viewResolver", BeanFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class).viewResolver(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("requestContextFilter", RequestContextFilter.class).withFactoryMethod(WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.class, "requestContextFilter")
        .instanceSupplier(() -> WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.requestContextFilter()).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration", WebMvcAutoConfiguration.class)
        .instanceSupplier(WebMvcAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("formContentFilter", OrderedFormContentFilter.class).withFactoryMethod(WebMvcAutoConfiguration.class, "formContentFilter")
        .instanceSupplier(() -> beanFactory.getBean(WebMvcAutoConfiguration.class).formContentFilter()).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration", AopAutoConfiguration.class)
        .instanceSupplier(AopAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration", ApplicationAvailabilityAutoConfiguration.class)
        .instanceSupplier(ApplicationAvailabilityAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("applicationAvailability", ApplicationAvailabilityBean.class).withFactoryMethod(ApplicationAvailabilityAutoConfiguration.class, "applicationAvailability")
        .instanceSupplier(() -> beanFactory.getBean(ApplicationAvailabilityAutoConfiguration.class).applicationAvailability()).register(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonAutoConfiguration_Jackson2ObjectMapperBuilderCustomizerConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJackson2ObjectMapperBuilderCustomizerConfiguration_standardJacksonObjectMapperBuilderCustomizer(beanFactory);
    BeanDefinitionRegistrar.of("spring.jackson-org.springframework.boot.autoconfigure.jackson.JacksonProperties", JacksonProperties.class)
        .instanceSupplier(JacksonProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonAutoConfiguration_JacksonObjectMapperBuilderConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonObjectMapperBuilderConfiguration_jacksonObjectMapperBuilder(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonAutoConfiguration_ParameterNamesModuleConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerParameterNamesModuleConfiguration_parameterNamesModule(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonAutoConfiguration_JacksonObjectMapperConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jackson.ContextBootstrapInitializer.registerJacksonObjectMapperConfiguration_jacksonObjectMapper(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration", JacksonAutoConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("jsonComponentModule", JsonComponentModule.class).withFactoryMethod(JacksonAutoConfiguration.class, "jsonComponentModule")
        .instanceSupplier(() -> beanFactory.getBean(JacksonAutoConfiguration.class).jsonComponentModule()).register(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerDataSourceConfiguration_Hikari(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerHikari_dataSource(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerDataSourceJmxConfiguration_Hikari(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerDataSourceJmxConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerDataSourceAutoConfiguration_PooledDataSourceConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.metadata.ContextBootstrapInitializer.registerDataSourcePoolMetadataProvidersConfiguration_HikariPoolDataSourceMetadataProviderConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.metadata.ContextBootstrapInitializer.registerHikariPoolDataSourceMetadataProviderConfiguration_hikariPoolDataSourceMetadataProvider(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration", DataSourcePoolMetadataProvidersConfiguration.class)
        .instanceSupplier(DataSourcePoolMetadataProvidersConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration", DataSourceAutoConfiguration.class)
        .instanceSupplier(DataSourceAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.datasource-org.springframework.boot.autoconfigure.jdbc.DataSourceProperties", DataSourceProperties.class)
        .instanceSupplier(DataSourceProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("java.lang.Object", Object.class)
        .instanceSupplier(Object::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration", ConfigurationPropertiesAutoConfiguration.class)
        .instanceSupplier(ConfigurationPropertiesAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration", LifecycleAutoConfiguration.class)
        .instanceSupplier(LifecycleAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("lifecycleProcessor", DefaultLifecycleProcessor.class).withFactoryMethod(LifecycleAutoConfiguration.class, "defaultLifecycleProcessor", LifecycleProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(LifecycleAutoConfiguration.class).defaultLifecycleProcessor(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.lifecycle-org.springframework.boot.autoconfigure.context.LifecycleProperties", LifecycleProperties.class)
        .instanceSupplier(LifecycleProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration", PersistenceExceptionTranslationAutoConfiguration.class)
        .instanceSupplier(PersistenceExceptionTranslationAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("persistenceExceptionTranslationPostProcessor", PersistenceExceptionTranslationPostProcessor.class).withFactoryMethod(PersistenceExceptionTranslationAutoConfiguration.class, "persistenceExceptionTranslationPostProcessor", Environment.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> PersistenceExceptionTranslationAutoConfiguration.persistenceExceptionTranslationPostProcessor(attributes.get(0)))).register(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerJdbcTemplateConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerJdbcTemplateConfiguration_jdbcTemplate(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerNamedParameterJdbcTemplateConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerNamedParameterJdbcTemplateConfiguration_namedParameterJdbcTemplate(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration", JdbcTemplateAutoConfiguration.class)
        .instanceSupplier(JdbcTemplateAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.jdbc-org.springframework.boot.autoconfigure.jdbc.JdbcProperties", JdbcProperties.class)
        .instanceSupplier(JdbcProperties::new).register(beanFactory);
    org.springframework.boot.sql.init.dependency.ContextBootstrapInitializer.registerDatabaseInitializationDependencyConfigurer_DependsOnDatabaseInitializationPostProcessor(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration$FlywayConfiguration", FlywayAutoConfiguration.FlywayConfiguration.class)
        .instanceSupplier(FlywayAutoConfiguration.FlywayConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("flyway", Flyway.class).withFactoryMethod(FlywayAutoConfiguration.FlywayConfiguration.class, "flyway", FlywayProperties.class, ResourceLoader.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(FlywayAutoConfiguration.FlywayConfiguration.class).flyway(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6)))).register(beanFactory);
    BeanDefinitionRegistrar.of("flywayInitializer", FlywayMigrationInitializer.class).withFactoryMethod(FlywayAutoConfiguration.FlywayConfiguration.class, "flywayInitializer", Flyway.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(FlywayAutoConfiguration.FlywayConfiguration.class).flywayInitializer(attributes.get(0), attributes.get(1)))).customize((bd) -> bd.setDependsOn(new String[] { "flyway" })).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.flyway-org.springframework.boot.autoconfigure.flyway.FlywayProperties", FlywayProperties.class)
        .instanceSupplier(FlywayProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration", FlywayAutoConfiguration.class)
        .instanceSupplier(FlywayAutoConfiguration::new).register(beanFactory);
    org.springframework.boot.autoconfigure.flyway.ContextBootstrapInitializer.registerFlywayAutoConfiguration_stringOrNumberMigrationVersionConverter(beanFactory);
    org.springframework.boot.autoconfigure.flyway.ContextBootstrapInitializer.registerFlywayAutoConfiguration_flywayDefaultDdlModeProvider(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration", GsonAutoConfiguration.class)
        .instanceSupplier(GsonAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("gsonBuilder", GsonBuilder.class).withFactoryMethod(GsonAutoConfiguration.class, "gsonBuilder", List.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(GsonAutoConfiguration.class).gsonBuilder(attributes.get(0)))).register(beanFactory);
    org.springframework.boot.autoconfigure.gson.ContextBootstrapInitializer.registerGsonAutoConfiguration_standardGsonBuilderCustomizer(beanFactory);
    BeanDefinitionRegistrar.of("spring.gson-org.springframework.boot.autoconfigure.gson.GsonProperties", GsonProperties.class)
        .instanceSupplier(GsonProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerHttpMessageConvertersAutoConfiguration_StringHttpMessageConverterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerStringHttpMessageConverterConfiguration_stringHttpMessageConverter(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerJacksonHttpMessageConvertersConfiguration_MappingJackson2HttpMessageConverterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerMappingJackson2HttpMessageConverterConfiguration_mappingJackson2HttpMessageConverter(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerJacksonHttpMessageConvertersConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.http.ContextBootstrapInitializer.registerGsonHttpMessageConvertersConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration", HttpMessageConvertersAutoConfiguration.class)
        .instanceSupplier(HttpMessageConvertersAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("messageConverters", HttpMessageConverters.class).withFactoryMethod(HttpMessageConvertersAutoConfiguration.class, "messageConverters", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HttpMessageConvertersAutoConfiguration.class).messageConverters(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration", ProjectInfoAutoConfiguration.class).withConstructor(ProjectInfoProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ProjectInfoAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.info-org.springframework.boot.autoconfigure.info.ProjectInfoProperties", ProjectInfoProperties.class)
        .instanceSupplier(ProjectInfoProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerDataSourceTransactionManagerAutoConfiguration_JdbcTransactionManagerConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.jdbc.ContextBootstrapInitializer.registerJdbcTransactionManagerConfiguration_transactionManager(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration", DataSourceTransactionManagerAutoConfiguration.class)
        .instanceSupplier(DataSourceTransactionManagerAutoConfiguration::new).register(beanFactory);
    org.springframework.transaction.annotation.ContextBootstrapInitializer.registerProxyTransactionManagementConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.transaction.config.internalTransactionAdvisor", BeanFactoryTransactionAttributeSourceAdvisor.class).withFactoryMethod(ProxyTransactionManagementConfiguration.class, "transactionAdvisor", TransactionAttributeSource.class, TransactionInterceptor.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ProxyTransactionManagementConfiguration.class).transactionAdvisor(attributes.get(0), attributes.get(1)))).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("transactionAttributeSource", TransactionAttributeSource.class).withFactoryMethod(ProxyTransactionManagementConfiguration.class, "transactionAttributeSource")
        .instanceSupplier(() -> beanFactory.getBean(ProxyTransactionManagementConfiguration.class).transactionAttributeSource()).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("transactionInterceptor", TransactionInterceptor.class).withFactoryMethod(ProxyTransactionManagementConfiguration.class, "transactionInterceptor", TransactionAttributeSource.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ProxyTransactionManagementConfiguration.class).transactionInterceptor(attributes.get(0)))).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.transaction.config.internalTransactionalEventListenerFactory", TransactionalEventListenerFactory.class).withFactoryMethod(AbstractTransactionManagementConfiguration.class, "transactionalEventListenerFactory")
        .instanceSupplier(() -> AbstractTransactionManagementConfiguration.transactionalEventListenerFactory()).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$JdkDynamicAutoProxyConfiguration", TransactionAutoConfiguration.EnableTransactionManagementConfiguration.JdkDynamicAutoProxyConfiguration.class)
        .instanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration.JdkDynamicAutoProxyConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.aop.config.internalAutoProxyCreator", InfrastructureAdvisorAutoProxyCreator.class)
        .instanceSupplier(InfrastructureAdvisorAutoProxyCreator::new).customize((bd) -> {
      bd.setRole(2);
      bd.getPropertyValues().addPropertyValue("order", -2147483648);
    }).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration", TransactionAutoConfiguration.EnableTransactionManagementConfiguration.class)
        .instanceSupplier(TransactionAutoConfiguration.EnableTransactionManagementConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$TransactionTemplateConfiguration", TransactionAutoConfiguration.TransactionTemplateConfiguration.class)
        .instanceSupplier(TransactionAutoConfiguration.TransactionTemplateConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("transactionTemplate", TransactionTemplate.class).withFactoryMethod(TransactionAutoConfiguration.TransactionTemplateConfiguration.class, "transactionTemplate", PlatformTransactionManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TransactionAutoConfiguration.TransactionTemplateConfiguration.class).transactionTemplate(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration", TransactionAutoConfiguration.class)
        .instanceSupplier(TransactionAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("platformTransactionManagerCustomizers", TransactionManagerCustomizers.class).withFactoryMethod(TransactionAutoConfiguration.class, "platformTransactionManagerCustomizers", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TransactionAutoConfiguration.class).platformTransactionManagerCustomizers(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.transaction-org.springframework.boot.autoconfigure.transaction.TransactionProperties", TransactionProperties.class)
        .instanceSupplier(TransactionProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration$DslContextConfiguration", JooqAutoConfiguration.DslContextConfiguration.class)
        .instanceSupplier(JooqAutoConfiguration.DslContextConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("dslContext", DefaultDSLContext.class).withFactoryMethod(JooqAutoConfiguration.DslContextConfiguration.class, "dslContext", Configuration.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JooqAutoConfiguration.DslContextConfiguration.class).dslContext(attributes.get(0)))).customize((bd) -> bd.setDependsOn(new String[] { "flyway", "flywayInitializer", "dataSourceScriptDatabaseInitializer", "jdbcSessionDataSourceScriptDatabaseInitializer" })).register(beanFactory);
    BeanDefinitionRegistrar.of("jooqConfiguration", DefaultConfiguration.class).withFactoryMethod(JooqAutoConfiguration.DslContextConfiguration.class, "jooqConfiguration", JooqProperties.class, ConnectionProvider.class, DataSource.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JooqAutoConfiguration.DslContextConfiguration.class).jooqConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4)))).register(beanFactory);
    BeanDefinitionRegistrar.of("jooqProvidersDefaultConfigurationCustomizer", DefaultConfigurationCustomizer.class).withFactoryMethod(JooqAutoConfiguration.DslContextConfiguration.class, "jooqProvidersDefaultConfigurationCustomizer", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JooqAutoConfiguration.DslContextConfiguration.class).jooqProvidersDefaultConfigurationCustomizer(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6), attributes.get(7)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.jooq-org.springframework.boot.autoconfigure.jooq.JooqProperties", JooqProperties.class)
        .instanceSupplier(JooqProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration", JooqAutoConfiguration.class)
        .instanceSupplier(JooqAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("dataSourceConnectionProvider", DataSourceConnectionProvider.class).withFactoryMethod(JooqAutoConfiguration.class, "dataSourceConnectionProvider", DataSource.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JooqAutoConfiguration.class).dataSourceConnectionProvider(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("transactionProvider", SpringTransactionProvider.class).withFactoryMethod(JooqAutoConfiguration.class, "transactionProvider", PlatformTransactionManager.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JooqAutoConfiguration.class).transactionProvider(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("jooqExceptionTranslatorExecuteListenerProvider", DefaultExecuteListenerProvider.class).withFactoryMethod(JooqAutoConfiguration.class, "jooqExceptionTranslatorExecuteListenerProvider")
        .instanceSupplier(() -> beanFactory.getBean(JooqAutoConfiguration.class).jooqExceptionTranslatorExecuteListenerProvider()).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration", QuartzAutoConfiguration.class)
        .instanceSupplier(QuartzAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("quartzScheduler", SchedulerFactoryBean.class).withFactoryMethod(QuartzAutoConfiguration.class, "quartzScheduler", QuartzProperties.class, ObjectProvider.class, ObjectProvider.class, Map.class, ObjectProvider.class, ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(QuartzAutoConfiguration.class).quartzScheduler(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5)))).customize((bd) -> bd.setDependsOn(new String[] { "flyway", "flywayInitializer", "dataSourceScriptDatabaseInitializer", "jdbcSessionDataSourceScriptDatabaseInitializer" })).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.quartz-org.springframework.boot.autoconfigure.quartz.QuartzProperties", QuartzProperties.class)
        .instanceSupplier(QuartzProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.security.servlet.ContextBootstrapInitializer.registerErrorPageSecurityFilterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.security.servlet.ContextBootstrapInitializer.registerErrorPageSecurityFilterConfiguration_errorPageSecurityInterceptor(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration", SecurityAutoConfiguration.class)
        .instanceSupplier(SecurityAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("authenticationEventPublisher", DefaultAuthenticationEventPublisher.class).withFactoryMethod(SecurityAutoConfiguration.class, "authenticationEventPublisher", ApplicationEventPublisher.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SecurityAutoConfiguration.class).authenticationEventPublisher(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.security-org.springframework.boot.autoconfigure.security.SecurityProperties", SecurityProperties.class)
        .instanceSupplier(SecurityProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration", SecurityFilterAutoConfiguration.class)
        .instanceSupplier(SecurityFilterAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("securityFilterChainRegistration", DelegatingFilterProxyRegistrationBean.class).withFactoryMethod(SecurityFilterAutoConfiguration.class, "securityFilterChainRegistration", SecurityProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SecurityFilterAutoConfiguration.class).securityFilterChainRegistration(attributes.get(0)))).register(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerSessionAutoConfiguration_ServletSessionRepositoryImplementationValidator(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.scheduling.annotation.SchedulingConfiguration", SchedulingConfiguration.class)
        .instanceSupplier(SchedulingConfiguration::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.context.annotation.internalScheduledAnnotationProcessor", ScheduledAnnotationBeanPostProcessor.class).withFactoryMethod(SchedulingConfiguration.class, "scheduledAnnotationProcessor")
        .instanceSupplier(() -> beanFactory.getBean(SchedulingConfiguration.class).scheduledAnnotationProcessor()).customize((bd) -> bd.setRole(2)).register(beanFactory);
    org.springframework.session.jdbc.config.annotation.web.http.ContextBootstrapInitializer.registerJdbcHttpSessionConfiguration_SessionCleanupConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerJdbcSessionConfiguration_SpringBootJdbcHttpSessionConfiguration(beanFactory);
    BeanDefinitionRegistrar.of("sessionRepository", JdbcIndexedSessionRepository.class).withFactoryMethod(JdbcHttpSessionConfiguration.class, "sessionRepository")
        .instanceSupplier(() -> beanFactory.getBean(JdbcHttpSessionConfiguration.class).sessionRepository()).customize((bd) -> bd.setDependsOn(new String[] { "flyway", "flywayInitializer", "dataSourceScriptDatabaseInitializer", "jdbcSessionDataSourceScriptDatabaseInitializer" })).register(beanFactory);
    BeanDefinitionRegistrar.of("sessionEventHttpSessionListenerAdapter", SessionEventHttpSessionListenerAdapter.class).withFactoryMethod(SpringHttpSessionConfiguration.class, "sessionEventHttpSessionListenerAdapter")
        .instanceSupplier(() -> beanFactory.getBean(SpringHttpSessionConfiguration.class).sessionEventHttpSessionListenerAdapter()).register(beanFactory);
    BeanDefinitionRegistrar.of("springSessionRepositoryFilter", ResolvableType.forClassWithGenerics(SessionRepositoryFilter.class, Session.class)).withFactoryMethod(SpringHttpSessionConfiguration.class, "springSessionRepositoryFilter", SessionRepository.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SpringHttpSessionConfiguration.class).springSessionRepositoryFilter(attributes.get(0)))).register(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerJdbcSessionConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerJdbcSessionConfiguration_jdbcSessionDataSourceScriptDatabaseInitializer(beanFactory);
    BeanDefinitionRegistrar.of("spring.session.jdbc-org.springframework.boot.autoconfigure.session.JdbcSessionProperties", JdbcSessionProperties.class)
        .instanceSupplier(JdbcSessionProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerServletSessionConfiguration_ServletSessionRepositoryConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerServletSessionConfiguration_RememberMeServicesConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerRememberMeServicesConfiguration_rememberMeServicesCookieSerializerCustomizer(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerSessionAutoConfiguration_ServletSessionRepositoryValidator(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerSessionRepositoryFilterConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerSessionRepositoryFilterConfiguration_sessionRepositoryFilterRegistration(beanFactory);
    BeanDefinitionRegistrar.of("spring.session-org.springframework.boot.autoconfigure.session.SessionProperties", SessionProperties.class)
        .instanceSupplier(SessionProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerSessionAutoConfiguration_ServletSessionConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.session.ContextBootstrapInitializer.registerServletSessionConfiguration_cookieSerializer(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration", SessionAutoConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.webflux-org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties", WebFluxProperties.class)
        .instanceSupplier(WebFluxProperties::new).register(beanFactory);
    org.springframework.boot.autoconfigure.sql.init.ContextBootstrapInitializer.registerDataSourceInitializationConfiguration(beanFactory);
    org.springframework.boot.autoconfigure.sql.init.ContextBootstrapInitializer.registerDataSourceInitializationConfiguration_dataSourceScriptDatabaseInitializer(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration", SqlInitializationAutoConfiguration.class)
        .instanceSupplier(SqlInitializationAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.sql.init-org.springframework.boot.autoconfigure.sql.init.SqlInitializationProperties", SqlInitializationProperties.class)
        .instanceSupplier(SqlInitializationProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration", TaskSchedulingAutoConfiguration.class)
        .instanceSupplier(TaskSchedulingAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("scheduledBeanLazyInitializationExcludeFilter", LazyInitializationExcludeFilter.class).withFactoryMethod(TaskSchedulingAutoConfiguration.class, "scheduledBeanLazyInitializationExcludeFilter")
        .instanceSupplier(() -> TaskSchedulingAutoConfiguration.scheduledBeanLazyInitializationExcludeFilter()).register(beanFactory);
    BeanDefinitionRegistrar.of("taskSchedulerBuilder", TaskSchedulerBuilder.class).withFactoryMethod(TaskSchedulingAutoConfiguration.class, "taskSchedulerBuilder", TaskSchedulingProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TaskSchedulingAutoConfiguration.class).taskSchedulerBuilder(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.task.scheduling-org.springframework.boot.autoconfigure.task.TaskSchedulingProperties", TaskSchedulingProperties.class)
        .instanceSupplier(TaskSchedulingProperties::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration", RestTemplateAutoConfiguration.class)
        .instanceSupplier(RestTemplateAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("restTemplateBuilderConfigurer", RestTemplateBuilderConfigurer.class).withFactoryMethod(RestTemplateAutoConfiguration.class, "restTemplateBuilderConfigurer", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestTemplateAutoConfiguration.class).restTemplateBuilderConfigurer(attributes.get(0), attributes.get(1), attributes.get(2)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("restTemplateBuilder", RestTemplateBuilder.class).withFactoryMethod(RestTemplateAutoConfiguration.class, "restTemplateBuilder", RestTemplateBuilderConfigurer.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(RestTemplateAutoConfiguration.class).restTemplateBuilder(attributes.get(0)))).customize((bd) -> bd.setLazyInit(true)).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration$TomcatWebServerFactoryCustomizerConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class)
        .instanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("tomcatWebServerFactoryCustomizer", TomcatWebServerFactoryCustomizer.class).withFactoryMethod(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class, "tomcatWebServerFactoryCustomizer", Environment.class, ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(EmbeddedWebServerFactoryCustomizerAutoConfiguration.TomcatWebServerFactoryCustomizerConfiguration.class).tomcatWebServerFactoryCustomizer(attributes.get(0), attributes.get(1)))).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration", EmbeddedWebServerFactoryCustomizerAutoConfiguration.class)
        .instanceSupplier(EmbeddedWebServerFactoryCustomizerAutoConfiguration::new).register(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration", HttpEncodingAutoConfiguration.class).withConstructor(ServerProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new HttpEncodingAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("characterEncodingFilter", CharacterEncodingFilter.class).withFactoryMethod(HttpEncodingAutoConfiguration.class, "characterEncodingFilter")
        .instanceSupplier(() -> beanFactory.getBean(HttpEncodingAutoConfiguration.class).characterEncodingFilter()).register(beanFactory);
    org.springframework.boot.autoconfigure.web.servlet.ContextBootstrapInitializer.registerHttpEncodingAutoConfiguration_localeCharsetMappingsCustomizer(beanFactory);
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration", MultipartAutoConfiguration.class).withConstructor(MultipartProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new MultipartAutoConfiguration(attributes.get(0)))).register(beanFactory);
    BeanDefinitionRegistrar.of("multipartConfigElement", MultipartConfigElement.class).withFactoryMethod(MultipartAutoConfiguration.class, "multipartConfigElement")
        .instanceSupplier(() -> beanFactory.getBean(MultipartAutoConfiguration.class).multipartConfigElement()).register(beanFactory);
    BeanDefinitionRegistrar.of("multipartResolver", StandardServletMultipartResolver.class).withFactoryMethod(MultipartAutoConfiguration.class, "multipartResolver")
        .instanceSupplier(() -> beanFactory.getBean(MultipartAutoConfiguration.class).multipartResolver()).register(beanFactory);
    BeanDefinitionRegistrar.of("spring.servlet.multipart-org.springframework.boot.autoconfigure.web.servlet.MultipartProperties", MultipartProperties.class)
        .instanceSupplier(MultipartProperties::new).register(beanFactory);
  }
}
