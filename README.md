# 📌 EIP_CBT
- Engineer Information Processing CBT
- 정보시스템 구축 및 관리 프로젝트!

## 체크사항<br>

### project Build Path
- lombok.jar
- ojdbc8.jar
- JUnit 4
### root-context.xml
```java
	<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig">
		<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy"/>
		<property name="jdbcUrl" value="jdbc:log4jdbc:oracle:thin:@diligentp.com:1521:XE"/>
		<property name="username" value="[할당받은 Oracle ID]"/>
		<property name="password" value="[할당받은 Oracle PW]"/>
	</bean>
```

<br>
개발 환경

- IDE : eclipse STS3 , IntelliJ
- JDK : openjdk 11.0.8-internal 2020-07-14
- WAS : Tomcat-9.0.60

<br>
gitIgnore

```
# git ignore IntelliJ
.idea
out

# git ignore eclipse STS3
.settings
.classpath
.project
.springBeans
target
```

## 프로젝트 관리
[레드마인(Redmine) B팀](http://114.70.92.70:3000/redmine/projects/b_team_2022)
