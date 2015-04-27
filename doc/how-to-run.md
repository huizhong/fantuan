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

## 设置包的名字
饭团的默认的包名是 ${project.artifactId}-${project.version}.jar
为了方便控制jar文件的名字，可以打包的时候指定包名

```
mvn -Dapp.build.finalName=fantuan-test package
```

这样得到的包名即为 `fantuan-test.jar`，而不是 `fantuan-1.0-SNAPSHOT.jar`

## 端口号
饭团服务的默认端口号为 8080
可以通过命令行的方式修改端口号
比如把端口号改成9001

```
java -Dserver.port=9001 -jar target/fantuan-1.0-SNAPSHOT.jar
```


