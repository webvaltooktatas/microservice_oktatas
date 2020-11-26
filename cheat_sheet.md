# CHEAT SHEET

## Jenkins

```
docker run -it --name=jenkins -e JENKINS_USER=root --rm -p 8080:8080 -p 50000:50000 \
-v $HOME/.jenkins:/var/ -v /var/run/docker.sock:/var/run/docker.sock \
--name jenkins trion/jenkins-docker-client
```

**Jenkins multiple docker**
```
node {
    checkout scm
    docker.image('mysql:5').withRun('-e "MYSQL_ROOT_PASSWORD=my-secret-pw"') { c ->
        docker.image('mysql:5').inside("--link ${c.id}:db") {
          /* Wait until mysql service is up */
          sh 'while ! mysqladmin ping -hdb --silent; do sleep 1; done'
        }
        docker.image('centos:7').inside("--link ${c.id}:db") {
          /*
           * Run some tests which require MySQL, and assume that it is
           * available on the host name `db`
           */
          sh 'make check'
        }
  }
} 
```

## ActiveMq
```
Docker: docker run -p 61616:61616 -p 8161:8161 rmohr/activemq
Port: 61616
```
**konfig:**
```
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```
## Keycloak
```
Docker: docker run -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin quay.io/keycloak/keycloak:11.0.3
```
```
user=admin
password=admin
port=8080
```
new client
    Valid Redirect URIs: *
    Optional Client Scopes
    Client scopes
new user

## MySql
```
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysql -e MYSQL_DATABASE=demo -d mysql
```

**konfig**
```
#datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/demo
spring.datasource.username=root
spring.datasource.password=mysql
spring.jpa.hibernate.ddl-auto=update

## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect
```

## MongoDB
```
docker run --name mongodb -p 27017:27017 -d mongo:latest
```

**konfig**
```
#Local MongoDB config
spring.data.mongodb.authentication-database=admin
spring.data.mongodb.username=admin
spring.data.mongodb.password=password
spring.data.mongodb.database=mydatabase
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost
```

Liquibase

**Cheat sheet**

```
https://github.com/liquibase/liquibase/blob/master/liquibase-integration-tests/src/test/resources/changelogs/yaml/common.tests.changelog.yaml
```
```
https://github.com/liquibase/liquibase/blob/master/liquibase-core/src/test/resources/liquibase/parser/core/yaml/testCasesChangeLog.yaml
```
