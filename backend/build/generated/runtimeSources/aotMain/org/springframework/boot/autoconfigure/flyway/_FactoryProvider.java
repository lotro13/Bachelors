package org.springframework.boot.autoconfigure.flyway;

public abstract class _FactoryProvider {
  public static FlywayMigrationInitializerDatabaseInitializerDetector flywayMigrationInitializerDatabaseInitializerDetector(
      ) {
    return new FlywayMigrationInitializerDatabaseInitializerDetector();
  }

  public static FlywayMigrationScriptMissingFailureAnalyzer flywayMigrationScriptMissingFailureAnalyzer(
      ) {
    return new FlywayMigrationScriptMissingFailureAnalyzer();
  }
}
