package hu.esamu.rft.esamurft.servlet;


import com.google.protobuf.InvalidProtocolBufferException;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;
import hu.esamu.rft.esamurft.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProtobufServlet extends HttpServlet {
    @Autowired
    MessageService messageService;
    private static Logger LOG = LoggerFactory.getLogger(ProtobufServlet.class);

    public void init(ServletConfig config) {
        try {
            super.init(config);
        } catch (ServletException e) {
            LOG.error(e.getMessage());
        }
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*if (!MimeTypeUtils.APPLICATION_OCTET_STREAM.equals(resp.getContentType())) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }*/
        try {
            EsamuRFTMessages.item message = EsamuRFTMessages.item.parseFrom(req.getInputStream());
            messageService.save(message);
            LOG.info(message.toString());
            //InputStream is = new ByteArrayInputStream(message.getImage().toByteArray());
        } catch (InvalidProtocolBufferException e) {
            LOG.error("Invalid message.");
        }
    }
}
