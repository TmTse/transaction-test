# transaction-test
 事务的一些实例，主要用spring,Mybatis,Mysql,atomikos搭建，可用于项目目脚手架或验证一些代码特性。
 
 项目采用maven编译
 +transaction-test（父项目）
       -transaction-test-local-transaction-mybatis（本地事务，事务传播行为）
       -transaction-test-global-transaction-mybatis（全局事务，分布式事务）
  
  每个项目中src/main/resources中都有对应的SQL文件，运行src/test/java中相应的Junit测试方法前需要先执行SQL。
