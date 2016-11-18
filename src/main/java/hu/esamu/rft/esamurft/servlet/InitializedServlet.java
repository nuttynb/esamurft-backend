package hu.esamu.rft.esamurft.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitializedServlet extends HttpServlet {
    private static Logger LOG = LoggerFactory.getLogger(InitializedServlet.class);

    public void init(ServletConfig config) {
        try {
            super.init(config);
        } catch (ServletException e) {
            LOG.error(e.getMessage());
        }
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}
