package com.myspace;

import org.jboss.errai.bus.server.annotations.Service;
import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.service.AuthenticationService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Service
@ApplicationScoped
public class MavenAlwaysAuthenticatedService implements AuthenticationService
{

    private final User user;

    @Inject
    public MavenAlwaysAuthenticatedService(User user) {
        this.user = user;
    }

    public User login(String username, String password) {
        return user;
    }

    public boolean isLoggedIn() {
        return true;
    }

    public void logout() {

    }

    public User getUser() {
        return user;
    }
}
