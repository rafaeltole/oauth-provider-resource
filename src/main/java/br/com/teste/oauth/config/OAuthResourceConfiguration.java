package br.com.teste.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class OAuthResourceConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("Resource Server").stateless(false);
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()//
                .antMatchers("/oauth/*", "/teste/semToken").permitAll()//
                .and().authorizeRequests().anyRequest().authenticated();

    }

}
