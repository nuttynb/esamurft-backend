package hu.esamu.rft.esamurft.servlet;


import com.google.protobuf.InvalidProtocolBufferException;
import hu.esamu.rft.esamurft.protos.EsamuRFTMessages;
import hu.esamu.rft.esamurft.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageServlet extends InitializedServlet {
    @Autowired
    MessageService messageService;
    private static Logger LOG = LoggerFactory.getLogger(MessageServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*if (!MimeTypeUtils.APPLICATION_OCTET_STREAM.equals(resp.getContentType())) {
            resp.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return;
        }*/
        /*
        try {
            EsamuRFTMessages.item message = EsamuRFTMessages.item.parseFrom(req.getInputStream());
            messageService.save(message);
            LOG.info(message.toString());
            InputStream is = new ByteArrayInputStream(message.getImage().toByteArray());
        } catch (InvalidProtocolBufferException e) {
            LOG.error("Invalid message.");
        }
        */
    }
}
