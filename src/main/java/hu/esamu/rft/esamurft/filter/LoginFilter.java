package hu.esamu.rft.esamurft.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static hu.esamu.rft.esamurft.util.Constants.*;

@WebFilter("/login")
public class LoginFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_KEY);
        LOGGER.info("Processing " + username + "'s login (IP: " + req.getRemoteAddr() + ")...");
        chain.doFilter(req, resp);
        LOGGER.info("Login processing ended!");
    }

    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        WebApplicationContext webAppContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        AutowireCapableBeanFactory beanFactory = webAppContext.getAutowireCapableBeanFactory();
        beanFactory.configureBean(this, USER_SERVICE_BEAN_NAME);
    }

    public void destroy() {
    }

}
