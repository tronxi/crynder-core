package com.crynder.cryndercore.configuration.security.exceptions;

public class JwtException extends UnauthorizedException  {

    private static final String DESCRIPTION = "Jwt exception";

    public JwtException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}