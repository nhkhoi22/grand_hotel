[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.ptit:management >-------------------------
[INFO] Building springweb-1 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[WARNING] The artifact org.hibernate:hibernate-validator:jar:6.0.17.Final has been relocated to org.hibernate.validator:hibernate-validator:jar:6.0.17.Final
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ management ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ management ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ management ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory D:\Documents\STS-Workspace\management\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ management ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ management ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.ptit.Springweb1ApplicationTests
20:07:05.292 [main] DEBUG org.springframework.test.context.junit4.SpringJUnit4ClassRunner - SpringJUnit4ClassRunner constructor called with [class com.ptit.Springweb1ApplicationTests]
20:07:05.308 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
20:07:05.339 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
20:07:05.415 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.ptit.Springweb1ApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
20:07:05.476 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.ptit.Springweb1ApplicationTests], using SpringBootContextLoader
20:07:05.490 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.ptit.Springweb1ApplicationTests]: class path resource [com/ptit/Springweb1ApplicationTests-context.xml] does not exist
20:07:05.497 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.ptit.Springweb1ApplicationTests]: class path resource [com/ptit/Springweb1ApplicationTestsContext.groovy] does not exist
20:07:05.497 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.ptit.Springweb1ApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
20:07:05.497 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.ptit.Springweb1ApplicationTests]: Springweb1ApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
20:07:05.682 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.ptit.Springweb1ApplicationTests]
20:07:05.982 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [D:\Documents\STS-Workspace\management\target\classes\com\ptit\WebApplication.class]
20:07:05.989 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.ptit.WebApplication for test class com.ptit.Springweb1ApplicationTests
20:07:06.369 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.ptit.Springweb1ApplicationTests]: using defaults.
20:07:06.371 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener, org.springframework.security.test.context.support.ReactorContextTestExecutionListener]
20:07:06.484 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@2a3b5b47, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@55b699ef, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@35d019a3, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@689604d9, org.springframework.test.context.support.DirtiesContextTestExecutionListener@18078bef, org.springframework.test.context.transaction.TransactionalTestExecutionListener@799f10e1, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@4c371370, org.springframework.security.test.context.support.WithSecurityContextTestExecutionListener@145f66e3, org.springframework.security.test.context.support.ReactorContextTestExecutionListener@3023df74, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@313ac989, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@4562e04d, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@2a65fe7c, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@4135c3b, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@6302bbb1]
20:07:06.488 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.ptit.Springweb1ApplicationTests]
20:07:06.492 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.ptit.Springweb1ApplicationTests]
20:07:06.497 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.ptit.Springweb1ApplicationTests]
20:07:06.498 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.ptit.Springweb1ApplicationTests]
20:07:06.498 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.ptit.Springweb1ApplicationTests]
20:07:06.501 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.ptit.Springweb1ApplicationTests]
20:07:06.520 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@41d477ed testClass = Springweb1ApplicationTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@3590fc5b testClass = Springweb1ApplicationTests, locations = '{}', classes = '{class com.ptit.WebApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@74ad1f1f, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@69b0fd6f, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@43738a82, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@4524411f], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [false] with mode [null].
20:07:06.523 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved @ProfileValueSourceConfiguration [null] for test class [com.ptit.Springweb1ApplicationTests]
20:07:06.523 [main] DEBUG org.springframework.test.annotation.ProfileValueUtils - Retrieved ProfileValueSource type [class org.springframework.test.annotation.SystemProfileValueSource] for class [com.ptit.Springweb1ApplicationTests]
20:07:06.647 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=-1}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.8.RELEASE)

2019-10-03 20:07:07.540  INFO 19500 --- [           main] com.ptit.Springweb1ApplicationTests      : Starting Springweb1ApplicationTests on MSI with PID 19500 (started by MSI GF in D:\Documents\STS-Workspace\management)
2019-10-03 20:07:07.541  INFO 19500 --- [           main] com.ptit.Springweb1ApplicationTests      : No active profile set, falling back to default profiles: default
2019-10-03 20:07:09.907  INFO 19500 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2019-10-03 20:07:10.267  INFO 19500 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 330ms. Found 3 repository interfaces.
2019-10-03 20:07:11.814  INFO 19500 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$95ee0218] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-03 20:07:12.559  INFO 19500 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-10-03 20:07:15.107  INFO 19500 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-10-03 20:07:15.471  INFO 19500 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
2019-10-03 20:07:15.718  INFO 19500 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.11.Final}
2019-10-03 20:07:15.718  INFO 19500 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-10-03 20:07:16.327  INFO 19500 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
2019-10-03 20:07:16.947  INFO 19500 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.MySQL5Dialect
2019-10-03 20:07:17.731  WARN 19500 --- [           main] o.s.w.c.s.GenericWebApplicationContext   : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
2019-10-03 20:07:17.736  INFO 19500 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2019-10-03 20:07:17.781  INFO 19500 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
2019-10-03 20:07:17.822  INFO 19500 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2019-10-03 20:07:17.846 ERROR 19500 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1105) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:744) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:391) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:312) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120) [spring-boot-test-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:246) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:227) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:246) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418) [surefire-booter-2.22.2.jar:2.22.2]
Caused by: org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
	at org.hibernate.cfg.ToOneFkSecondPass.doSecondPass(ToOneFkSecondPass.java:97) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processEndOfQueue(InFlightMetadataCollectorImpl.java:1827) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processFkSecondPassesInOrder(InFlightMetadataCollectorImpl.java:1771) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processSecondPasses(InFlightMetadataCollectorImpl.java:1658) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:287) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:904) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:935) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:390) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:377) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1837) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1774) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	... 42 common frames omitted

2019-10-03 20:07:17.856 ERROR 19500 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@2a3b5b47] to prepare test instance [com.ptit.Springweb1ApplicationTests@6cbe68e9]

java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:246) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:227) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:246) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190) [spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:365) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeWithRerun(JUnit4Provider.java:273) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:238) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:159) [surefire-junit4-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.invokeProviderInSameClassLoader(ForkedBooter.java:384) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:345) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.execute(ForkedBooter.java:126) [surefire-booter-2.22.2.jar:2.22.2]
	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:418) [surefire-booter-2.22.2.jar:2.22.2]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1778) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:515) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1105) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:867) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:549) ~[spring-context-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:744) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:391) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:312) ~[spring-boot-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120) ~[spring-boot-test-2.1.8.RELEASE.jar:2.1.8.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117) ~[spring-test-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	... 27 common frames omitted
Caused by: org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
	at org.hibernate.cfg.ToOneFkSecondPass.doSecondPass(ToOneFkSecondPass.java:97) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processEndOfQueue(InFlightMetadataCollectorImpl.java:1827) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processFkSecondPassesInOrder(InFlightMetadataCollectorImpl.java:1771) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processSecondPasses(InFlightMetadataCollectorImpl.java:1658) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:287) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:904) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:935) ~[hibernate-core-5.3.11.Final.jar:5.3.11.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:390) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:377) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) ~[spring-orm-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1837) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1774) ~[spring-beans-5.1.9.RELEASE.jar:5.1.9.RELEASE]
	... 42 common frames omitted

[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 13.919 s <<< FAILURE! - in com.ptit.Springweb1ApplicationTests
[ERROR] contextLoads(com.ptit.Springweb1ApplicationTests)  Time elapsed: 0.003 s  <<< ERROR!
java.lang.IllegalStateException: Failed to load ApplicationContext
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int
Caused by: org.hibernate.AnnotationException: @OneToOne or @ManyToOne on com.ptit.entity.Position.departmentId references an unknown entity: int

[INFO] 
[INFO] Results:
[INFO] 
[ERROR] Errors: 
[ERROR]   Springweb1ApplicationTests.contextLoads » IllegalState Failed to load Applicat...
[INFO] 
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.332 s
[INFO] Finished at: 2019-10-03T20:07:19+07:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.2:test (default-test) on project management: There are test failures.
[ERROR] 
[ERROR] Please refer to D:\Documents\STS-Workspace\management\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
