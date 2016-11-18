package hu.esamu.rft.esamurft.servlet;

import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends InitializedServlet {
    @Autowired
    UserService userService;
    private static Logger LOG = LoggerFactory.getLogger(RegisterServlet.class);

    private static final String USERNAME_KEY = "username";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_KEY);
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user = userService.save(user);
        LOG.info(user.toString());
        resp.getWriter().write(user.getId());
    }
}
