package th.ac.ku.kinkao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // เป็นการแมทสตริง, / เฉยๆ, สิ่งที่อยู่ในโฟลเดอร์ css และ js ให้เข้าได้โดยไม่ต้องล็อกอิน
                .antMatchers("/", "/css/**", "/js/**").permitAll()
                // รีเควสอื่น ๆ เราต้องการให้เป็น authenticated
                .anyRequest().authenticated()

        .and()
                .oauth2Login()
                .defaultSuccessUrl("/").permitAll()
        .and()
                .logout()
                .logoutSuccessUrl("/").permitAll();
    }
}