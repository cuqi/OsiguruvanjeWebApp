package com.webapp.insurance;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialException;

import com.webapp.insurance.database.Session;
import com.webapp.insurance.database.SessionRepository;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    public static final Properties defaultProperties = new Properties();
    protected Log logger = LogFactory.getLog(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SessionRepository sessionRepository;

    public AppAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        
        String targetUrl = determineTargetUrl(authentication);

        if(response.isCommitted()) {
            logger.debug("Response has already been commited! Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
        // System.out.println(response.getHeader("Set-Cooke"));
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
    
    protected String determineTargetUrl(final Authentication authentication) {
        LocalDateTime ldt = LocalDateTime.now();
		Timestamp timestamp = Timestamp.valueOf(ldt);

        String sessionID = BCrypt.gensalt();
        String loggedUser = "";
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            loggedUser = ((UserDetails)principal).getUsername();
        } else {
            loggedUser = principal.toString();
        }
        defaultProperties.setProperty("sessionID", sessionID);
		Session session = new Session();
        session.setSessionID(sessionID);
        session.setUsername(loggedUser);
        session.setFromDate(timestamp);
        System.out.println("loggedUser: " + loggedUser + ", sessionID:" + sessionID + "timestampt:" + timestamp);
        sessionRepository.save(session);
        return "/";
    }

    // protected void clearAuthenticationAttributes(HttpServletRequest request) {
    //     HttpSession session = request.getSession(false);
    //     if (session == null) {
    //         return;
    //     }
    //     session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    // }
}
