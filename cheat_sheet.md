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

## Client OAuth2RestTemplate-el
port=8091
```
@Bean
    public RestTemplate restTemplate() {
        String url = "http://localhost:8080/auth/realms/test/protocol/openid-connect/token";

        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setGrantType("client_credentials");
        resourceDetails.setAccessTokenUri(url);
        resourceDetails.setClientId("client_one");
        resourceDetails.setClientSecret("93a25c1c-a887-447a-a0cb-b62c7b359310");

        List<String> scopes = new ArrayList<>();
        scopes.add("read");
        scopes.add("write");
        resourceDetails.setScope(scopes);

        RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails);
        return restTemplate;
```

## Client RestTemplate + interceptorral

**konfig**
```
spring:
  thymeleaf:
    cache: false
  security:
    oauth2:
      client:
        registration:
          client_one:
              provider: keycloak
              client-id: client_one
              client-secret: <CLIENT_SECRET>
              authorization-grant-type: client_credentials
              scope: read,write
        provider:
          keycloak:
            authorization-uri: http://localhost:8080/auth/realms/test/protocol/openid-connect/auth
            token-uri: http://localhost:8080/auth/realms/test/protocol/openid-connect/token

resource-server:
  base-uri: http://localhost:8092/
```
**OAuth2AuthorizedClientInterceptor**
```
@Component
public class OAuth2AuthorizedClientInterceptor implements ClientHttpRequestInterceptor {
    OAuth2AuthorizedClientManager manager;

    public OAuth2AuthorizedClientInterceptor(OAuth2AuthorizedClientManager manager) {
        this.manager = manager;
    }

    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
        throws IOException {

        Authentication principal = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthorizeRequest authorizeRequest = OAuth2AuthorizeRequest
             .withClientRegistrationId("client_one")
             .principal(principal)
             .build();
        OAuth2AuthorizedClient authorizedClient =
            this.manager.authorize(authorizeRequest);

        HttpHeaders headers = request.getHeaders();
        headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());

        return execution.execute(request, body);
    }
}
```

**SecurityConfig**
```
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) {
		web
			.ignoring()
				.antMatchers("/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.permitAll()
				.and()
			.oauth2Client();
	}

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("test")
            .password("test")
            .roles("USER")
            .build();
        return  new InMemoryUserDetailsManager(user);
    }
}
```

**RestTemplateConfig**
```
@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate rest(OAuth2AuthorizedClientInterceptor interceptor) {
		RestTemplate rest = new RestTemplate();
		rest.getInterceptors().add(interceptor);
		return rest;
	}

	@Bean
	OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
															OAuth2AuthorizedClientRepository authorizedClientRepository) {
		OAuth2AuthorizedClientProvider authorizedClientProvider =
				OAuth2AuthorizedClientProviderBuilder.builder()
						.clientCredentials()
						.build();
		DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
				clientRegistrationRepository, authorizedClientRepository);
		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

		return authorizedClientManager;
	}
}

```
## OAuth2 Resource server
```
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/**")
                .authorizeRequests()
                .mvcMatchers("/maganember/*/nyilatkozatok", "/ceg/*/nyilatkozatok")
                .access("hasAuthority('SCOPE_read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
    }
}
```
**config**
```
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8080/auth/realms/test/protocol/openid-connect/certs
```