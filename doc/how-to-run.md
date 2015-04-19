# 如何启动程序

## 运行环境
* Java 7
* Maven 3.2.3

## IDEA中启动

Maven Projects => fantuan => Plugins => spring-boot => spring-boot:run

## 命令行
使用spring-boot插件
```
mvn spring-boot:run
```

或者先打包，后运行

```
mvn clean package
java -jar target/fantuan-1.0-SNAPSHOT.jar
```

## 设置运行环境Profile

```
# profile = test
mvn -Dspring.profiles.active=test spring-boot:run
```
或者
```
# profile = production
java -Dspring.profiles.active=production -jar target/fantuan-1.0-SNAPSHOT.jar
```
可以在 src/main/resources/config/application.properties 中设置默认值。