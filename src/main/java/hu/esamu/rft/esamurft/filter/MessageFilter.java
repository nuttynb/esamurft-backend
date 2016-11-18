package hu.esamu.rft.esamurft.filter;

import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;
import hu.esamu.rft.esamurft.service.MessageService;
import hu.esamu.rft.esamurft.servlet.MessageServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

public class MessageFilter implements Filter {
    @Autowired
    MessageService messageService;
    private static Logger LOG = LoggerFactory.getLogger(MessageFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        EsamuRFTMessages.item message = EsamuRFTMessages.item.parseFrom(servletRequest.getInputStream());
        LOG.info("Processing " + message.getId() + "'s message (IP: " + servletRequest.getRemoteAddr() + ")...");
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Processing ended, new message:");
        LOG.info("\n" + message.toString());
    }

    @Override
    public void destroy() {

    }
}
