package hu.esamu.rft.esamurft.filter;

import hu.esamu.rft.esamurft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

public class RegisterFilter implements Filter {
    @Autowired
    UserService userService;
    private static Logger LOG = LoggerFactory.getLogger(RegisterFilter.class);
    private static final String USERNAME_KEY = "username";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        String username = servletRequest.getParameter(USERNAME_KEY);
        LOG.info("Processing " + username + "'s register (IP: " + servletRequest.getRemoteAddr() + ")...");
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Processing ended, new user:");
        LOG.info("\n");
    }

    @Override
    public void destroy() {

    }
}
