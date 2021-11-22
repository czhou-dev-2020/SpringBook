package com.rillsoft.springbookadmin.Token;

//import com.rillsoft.springbookadmin.Token.data.AuthUserTokens;
//import com.rillsoft.springbookadmin.Token.repository.AuthUserTokensRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

/*
@Service
public class DefaultSecureTokenService implements IJavaSecureTokenService {

    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    @Value("${jdj.authuser.tokens.validity}")
    private int m_nAuthUserTokensValidityInSeconds;

    @Autowired
    AuthUserTokensRepository m_objAuthUserTokensRepository;

    @Override
    public AuthUserTokens createAuthUserToken() {
        // this is a sample, you can adapt as per your security need
        String strTokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII);
        AuthUserTokens objAuthUserTokens = new AuthUserTokens();
        objAuthUserTokens.setTokenName(strTokenValue);
        objAuthUserTokens.setTokenExpireAt(LocalDateTime.now().plusSeconds(getAuthUserTokensValidityInSeconds()));
        this.saveAuthUserToken(objAuthUserTokens);
        return objAuthUserTokens;
    }

    @Override
    public void saveAuthUserToken(AuthUserTokens objAuthUserToken) {
        m_objAuthUserTokensRepository.save(objAuthUserToken);
    }

    @Override
    public AuthUserTokens findByTokenName(String strTokenName) {
//        return m_objAuthUserTokensRepository.findByTokenName(strTokenName);
        return null;
    }

    @Override
    public void removeAuthUserToken(AuthUserTokens objAuthUserToken) {
        m_objAuthUserTokensRepository.delete(objAuthUserToken);
    }

    @Override
    public void removeTokenByTokenName(String strTokenName) {
//        m_objAuthUserTokensRepository.removeByTokenName(strTokenName);
    }

    public int getAuthUserTokensValidityInSeconds() {
        return m_nAuthUserTokensValidityInSeconds;
    }
}

*/