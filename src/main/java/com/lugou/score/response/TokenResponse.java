package com.lugou.score.response;

public class TokenResponse {


    protected String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public TokenResponse(String access_token) {
        this.access_token = access_token;
    }
}
