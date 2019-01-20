package com.example.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.security.dto.AuthResult;
import com.example.security.dto.LoginInfoDTO;
import com.example.security.dto.LoginUserDetails;

@Service
public class LoginService {
    @Autowired
    private AuthenticationManager authManager;

    /**
     * 認証処理
     * @param loginInfo
     * @return
     */
    public AuthResult login(LoginInfoDTO loginInfo){
        Authentication authentication = null;
        AuthResult authResult = new AuthResult();
        try {
            //メールアドレスとパスワードによる照合を実施
            Authentication request = new UsernamePasswordAuthenticationToken(loginInfo.getEmail(), loginInfo.getPassword());
            //対象ユーザが存在するかチェックし認証を行う
            authentication = authManager.authenticate(request);
            //認証OKの場合は、認証結果をcontextholderに設定
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //認証済みユーザ情報を格納
            LoginUserDetails principal = (LoginUserDetails)authentication.getPrincipal();
            //クライアントへの返却データを設定
            authResult.setUserName(principal.getUsername());
//            authResult.setPermissions(principal.getPermissions());
//            authResult.setRoles(principal.getAuthorities().stream().map(authority -> authority.getAuthority()).collect(Collectors.toList()));
        }
        //認証失敗の場合
        catch (Exception e) {
        }
        return authResult;
    }
}
