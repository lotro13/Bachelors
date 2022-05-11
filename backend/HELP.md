# Read Me First
The following was discovered as part of building this project:

* The following dependencies are not known to work with Spring Native: 'Flyway Migration, JOOQ Access Layer, Quartz Scheduler'. As a result, your application may not work as expected.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/gradle-plugin/reference/html/#build-image)
* [Spring Native Reference Guide](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-security)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#howto-execute-flyway-database-migrations-on-startup)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-sql)
* [JOOQ Access Layer](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-jooq)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-email)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-quartz)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure the Spring AOT Plugin](https://docs.spring.io/spring-native/docs/0.11.4/reference/htmlsingle/#spring-aot-gradle)

## Spring Native

This project has been configured to let you generate either a lightweight container or a native executable.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started with Spring Native.
Docker should be installed and configured on your machine prior to creating the image, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.4/reference/htmlsingle/#getting-started-buildpacks).

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 backend:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM native-image compiler should be installed and configured on your machine, see [the Getting Started section of the reference guide](https://docs.spring.io/spring-native/docs/0.11.4/reference/htmlsingle/#getting-started-native-build-tools).

To create the executable, run the following goal:

```
$ ./gradlew nativeBuild
```

Then, you can run the app as follows:
```
$ build/native-image/backend
```
