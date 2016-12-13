package hu.esamu.rft.esamurft.service.impl;

import java.security.GeneralSecurityException;

public interface AuthenticationService {
    void authenticate(String tokenIdString) throws Exception;
}
