package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

//Spring Security 配置类开启权限控制注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    //配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    // 注入 PasswordEncoder 类到 spring 容器中
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().loginPage("/login.html")
                .loginProcessingUrl("/user/login")
                .successForwardUrl("/success")
                .failureForwardUrl("/unauth")
//                //获取登录用户名  默认为username
                .usernameParameter("userAccount")
//                //获取登录密码  默认为 password
                .passwordParameter("userPwd");
        http.authorizeRequests()
                .antMatchers("/layui/**","/**.html") //表示配置请求路径
                .anonymous()
                .antMatchers("/index","/user/login")

            .permitAll() // 指定 URL 无需保护。
//                .antMatchers("/find").hasAuthority("admin")
//                .antMatchers("/findAll").hasAnyAuthority("role")
            .anyRequest() // 其他请求
            .authenticated(); //需要认证

        //关闭csrf
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/src/main/webapp/WEB-INF/static/**");
        web.ignoring().antMatchers("/static/**");
    }

    //
//    @Override
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
////        manager.createUser(User.builder().username("user").password("password").roles("USER").build());
//        return manager;
//    }
   /* @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER");
//        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().and().authorizeRequests().antMatchers("/login").permitAll()
        http.httpBasic().and().authorizeRequests()
                .anyRequest().authenticated() //任何请求都需要身份认证
                .and().csrf().disable();//禁用CSRF
        http.logout()
                .permitAll()
                .deleteCookies("JSESSIONID");
        http.sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false);
//                .expiredSessionStrategy()
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
*/
}
