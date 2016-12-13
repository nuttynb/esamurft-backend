package hu.esamu.rft.esamurft.servlet;

import hu.esamu.rft.esamurft.dto.UserDTO;
import hu.esamu.rft.esamurft.service.UserService;
import hu.esamu.rft.esamurft.service.impl.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hu.esamu.rft.esamurft.util.Constants.*;

@WebServlet("/register")
public class RegisterServlet extends InitializedServlet {

    private static Logger LOG = LoggerFactory.getLogger(RegisterServlet.class);

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier(value = "googleAuthServiceImpl")
    private AuthenticationService googleAuthService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter(USERNAME_KEY);
        String password = req.getParameter(PASSWORD_KEY);
        String googleIdToken = req.getParameter(GOOGLE_ID_TOKEN);
        LOG.info(googleIdToken);
        try {
            googleAuthService.authenticate(googleIdToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        user = userService.save(user);
        resp.getWriter().write(user.getUserId());
    }
}
