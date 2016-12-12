package hu.esamu.rft.esamurft.filter;

import hu.esamu.rft.esamurft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static hu.esamu.rft.esamurft.util.Constants.*;

@WebFilter("/register")
public class RegisterFilter implements Filter {

    @Autowired
    private UserService userService;

    private static Logger LOG = LoggerFactory.getLogger(RegisterFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();

        autowireCapableBeanFactory.configureBean(this, USER_SERVICE_BEAN_NAME);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String username = servletRequest.getParameter(USERNAME_KEY);
        LOG.info("Processing " + username + "'s register (IP: " + servletRequest.getRemoteAddr() + ")...");
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Processing ended, new user:");
        LOG.info(userService.findByUsername(username).toString());
    }

    @Override
    public void destroy() {

    }
}
