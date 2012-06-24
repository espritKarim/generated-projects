/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/interceptor/UserContextInterceptor.p.vm.java
 */
package fr.jaxio.demo.web.interceptor;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

import fr.jaxio.demo.web.flow.FlowsMenuHandler;
import fr.jaxio.demo.web.util.UserContextUtil;

/**
 * Expose the 'userContext' and 'flowsMenuHandler' beans to {@link org.springframework.faces.mvc.JsfView}
 * Note: it does not intercept webflow requests.
 */
@Named
@Singleton
public class UserContextInterceptor implements HandlerInterceptor {

    @Inject
    private UserContextUtil userContext;
    @Inject
    private FlowsMenuHandler flowsMenuHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        request.setAttribute("flowsMenuHandler", flowsMenuHandler);
        request.setAttribute("userContext", userContext);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}