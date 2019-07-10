package com.wh.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Map;

/**
 * jwt工具类
 */
public class JwtUtils {
    private static final String SUBJECT = "jwtToken";

    private static final String SERVICE = "sso_server";


    private static final String APP_SECRET = "wh-df2e8562-49f5-48bf-a554-806efd5f2fe7";

    /**
     * 校验token 解密
     *
     * @param token
     * @return
     */
    public static Map<String, Claim> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(APP_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withSubject(SUBJECT)
                    .withIssuer(SERVICE)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}