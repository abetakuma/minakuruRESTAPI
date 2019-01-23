package com.example.security.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.entity.UserLoginInfo;
import com.example.security.repository.UserLoginInfoRepository;
import com.example.security.service.UserLoginInfoService;

@RestController
public class LoginRestController {
	@Autowired
	UserLoginInfoRepository userLoginInfoRepository;

    @Autowired
    private UserLoginInfoService userLoginInfoService;

//    /**
//     * ログイン処理
//     * @param loginInfo
//     * @param request
//     * @param response
//     * @return
//     */
//    @RequestMapping(value="/api/login",method=RequestMethod.POST)
//    public ResponseEntity<AuthResult> login(@RequestBody LoginInfoDTO loginInfo,HttpServletRequest request,HttpServletResponse response){
//        //認証処理を実行
//        AuthResult  authResult = loginService.login(loginInfo);
//        //認証OKの場合はcsrfトークンをクッキーにセット
//        if(authResult.getUserName() != null){
//            CsrfToken csrf = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
//            if(csrf != null){
//                Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
//                String token = csrf.getToken();
//                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//                if((cookie == null || token != null && !token.equals(cookie.getValue())) && (authentication != null && authentication.isAuthenticated())){
//                    cookie = new Cookie("XSRF-TOKEN", token);
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                }
//            }
//            return new ResponseEntity<>(authResult,null,HttpStatus.OK);
//        }
//        //認証失敗時は401エラーを返却
//        else{
//            return new ResponseEntity<>(authResult,null,HttpStatus.UNAUTHORIZED);
//        }
//    }
    @GetMapping(value="/api/login/{id}")
    	public Optional<UserLoginInfo> login(@PathVariable Long id){
        Optional<UserLoginInfo> userLoginInfo = userLoginInfoService.findOne(id);

        return userLoginInfo;
    }

//    @RequestMapping(value="/api/login/save",method=RequestMethod.GET)
//    public void save(HttpServletRequest request,HttpServletResponse response){
//
//
//	    	PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//	    UserLoginInfo user = UserLoginInfo.of("name", encoder.encode("password"), "exec@gmail.com");
//	    userLoginInfoRepository.save(user);
//    }

}