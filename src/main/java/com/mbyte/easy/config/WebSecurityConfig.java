package com.mbyte.easy.config;


import com.mbyte.easy.security.auth.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * @Author                   戴书博
 * @Description              Spring Security配置
 * @Date                     2019/11/11
 * @Version                  1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 自定义验证
     **/
	@Autowired
	private MyAuthenticationProvider provider;
	@Autowired
	private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
	@Autowired
	private DataSource dataSource;

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {//.defaultSuccessUrl("/welcome")
		http.authorizeRequests()
                .antMatchers("/kaptcha/getKaptchaImage", "/druid/**", "/rest/**").permitAll()
                .anyRequest().authenticated().and()
				.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/").permitAll()
                .authenticationDetailsSource(authenticationDetailsSource)
				.and().headers().frameOptions().sameOrigin().contentTypeOptions().disable()
                .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400)
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().and().csrf().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
                .antMatchers("/font/**")
                .antMatchers("/images/**")
                .antMatchers("/css/**")
                .antMatchers("/h-ui/**")
                .antMatchers("/h-ui.admin/**")
                .antMatchers("/lib/**")
                .antMatchers("/js/**");
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider);
	}

}
