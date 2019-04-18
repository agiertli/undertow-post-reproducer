# undertow-post-reproducer

- Install vanilla JBoss EAP 7.2 and start it
- Execute 'mvn clean install' which will deploy the application onto JBoss EAP
- Execute `http get localhost:8081/executeGet` . It will return `"I was invoked via GET method"`
- Execute `http post localhost:8081/executePost` . It will return empty response and produce following log:
```
14:09:05,039 WARN  [org.jboss.modules.define] (XNIO-2 task-1) Failed to define class org.xnio.channels.StreamSourceChannel in Module "deployment.undertow-post-reproducer.war" from Service Module Loader: java.lang.LinkageError: Failed to link org/xnio/channels/StreamSourceChannel (Module "deployment.undertow-post-reproducer.war" from Service Module Loader): loader constraint violation: loader (instance of org/jboss/modules/ModuleClassLoader) previously initiated loading for a different type with name "org/xnio/channels/StreamSourceChannel"
  at java.lang.ClassLoader.defineClass1(Native Method)
  at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
  at java.lang.ClassLoader.defineClass(ClassLoader.java:839)
  at org.jboss.modules.ModuleClassLoader.doDefineOrLoadClass(ModuleClassLoader.java:424)
  at org.jboss.modules.ModuleClassLoader.defineClass(ModuleClassLoader.java:519)
  at org.jboss.modules.ModuleClassLoader.loadClassLocal(ModuleClassLoader.java:339)
  at org.jboss.modules.ModuleClassLoader$1.loadClassLocal(ModuleClassLoader.java:126)
  at org.jboss.modules.Module.loadModuleClass(Module.java:731)
  at org.jboss.modules.ModuleClassLoader.findClass(ModuleClassLoader.java:247)
  at org.jboss.modules.ConcurrentClassLoader.performLoadClassUnchecked(ConcurrentClassLoader.java:410)
  at org.jboss.modules.ConcurrentClassLoader.performLoadClass(ConcurrentClassLoader.java:398)
  at org.jboss.modules.ConcurrentClassLoader.loadClass(ConcurrentClassLoader.java:116)
  at org.xnio.channels.BlockingReadableByteChannel.read(BlockingReadableByteChannel.java:134)
  at org.apache.camel.component.undertow.DefaultUndertowHttpBinding.readFromChannel(DefaultUndertowHttpBinding.java:391)
  at org.apache.camel.component.undertow.DefaultUndertowHttpBinding.toCamelMessage(DefaultUndertowHttpBinding.java:128)
  at org.apache.camel.component.undertow.UndertowEndpoint.createExchange(UndertowEndpoint.java:141)
  at org.apache.camel.component.undertow.UndertowConsumer.handleRequest(UndertowConsumer.java:142)
  at io.undertow.server.Connectors.executeRootHandler(Connectors.java:360)
  at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:830)
  at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
  at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1985)
  at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1487)
  at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1378)
  at java.lang.Thread.run(Thread.java:748)

14:09:05,040 ERROR [io.undertow.request] (XNIO-2 task-1) UT005071: Undertow request failed HttpServerExchange{ POST /executePost request {Accept=[*/*], Connection=[keep-alive], Accept-Encoding=[gzip, deflate], Content-Length=[0], User-Agent=[HTTPie/1.0.2], Host=[localhost:8081]} response {}}: java.lang.LinkageError: Failed to link org/xnio/channels/StreamSourceChannel (Module "deployment.undertow-post-reproducer.war" from Service Module Loader): loader constraint violation: loader (instance of org/jboss/modules/ModuleClassLoader) previously initiated loading for a different type with name "org/xnio/channels/StreamSourceChannel"
  at java.lang.ClassLoader.defineClass1(Native Method)
  at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
  at java.lang.ClassLoader.defineClass(ClassLoader.java:839)
  at org.jboss.modules.ModuleClassLoader.doDefineOrLoadClass(ModuleClassLoader.java:424)
  at org.jboss.modules.ModuleClassLoader.defineClass(ModuleClassLoader.java:519)
  at org.jboss.modules.ModuleClassLoader.loadClassLocal(ModuleClassLoader.java:339)
  at org.jboss.modules.ModuleClassLoader$1.loadClassLocal(ModuleClassLoader.java:126)
  at org.jboss.modules.Module.loadModuleClass(Module.java:731)
  at org.jboss.modules.ModuleClassLoader.findClass(ModuleClassLoader.java:247)
  at org.jboss.modules.ConcurrentClassLoader.performLoadClassUnchecked(ConcurrentClassLoader.java:410)
  at org.jboss.modules.ConcurrentClassLoader.performLoadClass(ConcurrentClassLoader.java:398)
  at org.jboss.modules.ConcurrentClassLoader.loadClass(ConcurrentClassLoader.java:116)
  at org.xnio.channels.BlockingReadableByteChannel.read(BlockingReadableByteChannel.java:134)
  at org.apache.camel.component.undertow.DefaultUndertowHttpBinding.readFromChannel(DefaultUndertowHttpBinding.java:391)
  at org.apache.camel.component.undertow.DefaultUndertowHttpBinding.toCamelMessage(DefaultUndertowHttpBinding.java:128)
  at org.apache.camel.component.undertow.UndertowEndpoint.createExchange(UndertowEndpoint.java:141)
  at org.apache.camel.component.undertow.UndertowConsumer.handleRequest(UndertowConsumer.java:142)
  at io.undertow.server.Connectors.executeRootHandler(Connectors.java:360)
  at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:830)
  at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
  at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:1985)
  at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1487)
  at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1378)
  at java.lang.Thread.run(Thread.java:748)
```