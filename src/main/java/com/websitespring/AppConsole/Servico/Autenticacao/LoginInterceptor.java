package com.websitespring.AppConsole.Servico.Autenticacao;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // Implement your login validation logic here
        // Return true if the request should be processed further (login is valid),
        // or false if it should be stopped (login is invalid).
        String email = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_email")) {
                    email = cookie.getValue();
                    break;
                }
            }
        }

        if (email != null && !email.isEmpty()) {
            // You can set up the user session or authentication here based on the email
            // For example:
            // request.getSession().setAttribute("user_email", email);
            return true;
        } else {
            response.sendRedirect("/login"); // Redirect to the login page if not logged in
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // This method can be used to modify the ModelAndView after the controller is executed.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        // This method is called after the request has been processed by the view.
    }
}
