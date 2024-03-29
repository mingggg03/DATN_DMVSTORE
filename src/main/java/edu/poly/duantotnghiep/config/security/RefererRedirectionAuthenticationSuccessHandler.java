package edu.poly.duantotnghiep.config.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import java.io.IOException;

public class RefererRedirectionAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        String targetUrl = getUrlBefore(request);
        if(targetUrl == null){
            targetUrl = "/trang-chu";
        }
        System.out.println(request.getHeader("referer"));
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private String getUrlBefore(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies == null) return null;
        String url = null;
        for (var c : cookies) {
            if (c.getName().equals("url")) {
                url = c.getValue();
            }
        }
        return url;
    }
}