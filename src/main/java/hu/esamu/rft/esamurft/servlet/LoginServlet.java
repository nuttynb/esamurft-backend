package hu.esamu.rft.esamurft.servlet;

import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.exception.AuthenticationException;
import hu.esamu.rft.esamurft.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hu.esamu.rft.esamurft.util.Constants.*;

@WebServlet("/login")
public class LoginServlet extends InitializedServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);

    @Autowired
    private UserService userService;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_KEY);
        String password = req.getParameter(PASSWORD_KEY);

        UserDTO user = null;

        try {
            user = userService.login(username, password);
        } catch (AuthenticationException e) {
            LOGGER.error(e.getMessage());
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }

        if (user != null) {
            LOGGER.info("Login successful with username " + user.getUsername());
            resp.getWriter().write(user.getUserId());
        }
    }
}
