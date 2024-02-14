package com.example.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.dto.UserDTO;
import com.example.service.UserService;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	System.out.println("AuthProvider.authenticate");
        String email = (String) authentication.getPrincipal(); // 로그인 창에 입력한 email 
        String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password

        // DB에 저장된 사용자 정보 얻기 
        PasswordEncoder passwordEncoder = userService.passwordEncoder();    
        UserDTO userVo = userService.getUserByEmail(email);

        UsernamePasswordAuthenticationToken token;
        
        if (userVo != null && passwordEncoder.matches(password, userVo.getPassword())) { // 일치하는 user 정보가 있는지 확인
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("USER")); // 권한 부여(ROLE_USER)

            token = new UsernamePasswordAuthenticationToken(userVo, null, roles); 
            // token = new UsernamePasswordAuthenticationToken(userVo.getId(), null, roles); 
            
            // 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token
            return token;
        }
        throw new BadCredentialsException("No such user or wrong password."); 
        // Exception을 던지지 않고 다른 값을 반환하면 authenticate() 메서드는 정상적으로 실행된 것이므로 인증되지 않았다면 Exception을 throw 해야 한다.
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}