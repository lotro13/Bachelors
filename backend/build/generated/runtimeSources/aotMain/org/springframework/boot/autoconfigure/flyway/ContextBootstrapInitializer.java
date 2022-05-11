package org.springframework.boot.autoconfigure.flyway;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerFlywayAutoConfiguration_stringOrNumberMigrationVersionConverter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("stringOrNumberMigrationVersionConverter", FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter.class).withFactoryMethod(FlywayAutoConfiguration.class, "stringOrNumberMigrationVersionConverter")
        .instanceSupplier(() -> beanFactory.getBean(FlywayAutoConfiguration.class).stringOrNumberMigrationVersionConverter()).register(beanFactory);
  }

  public static void registerFlywayAutoConfiguration_flywayDefaultDdlModeProvider(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("flywayDefaultDdlModeProvider", FlywaySchemaManagementProvider.class).withFactoryMethod(FlywayAutoConfiguration.class, "flywayDefaultDdlModeProvider", ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(FlywayAutoConfiguration.class).flywayDefaultDdlModeProvider(attributes.get(0)))).register(beanFactory);
  }
}
