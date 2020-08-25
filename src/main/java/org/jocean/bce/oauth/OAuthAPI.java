package org.jocean.bce.oauth;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jocean.rpc.annotation.ConstParams;
import org.jocean.rpc.annotation.RpcBuilder;

import com.alibaba.fastjson.annotation.JSONField;

import rx.Observable;

// http://ai.baidu.com/docs#/Auth : 鉴权认证机制

public interface OAuthAPI {

    public interface AccessTokenResponse {
        @JSONField(name = "access_token")
        public String getAccessToken();

        @JSONField(name = "access_token")
        public void setAccessToken(final String accessToken);

        @JSONField(name = "expires_in")
        public long getExpiresIn();

        @JSONField(name = "expires_in")
        public void setExpiresIn(final long expiresIn);

        @JSONField(name = "refresh_token")
        public String getRefreshToken();

        @JSONField(name = "refresh_token")
        public void setRefreshToken(final String refreshToken);

        @JSONField(name = "scope")
        public String getScope();

        @JSONField(name = "scope")
        public void setScope(final String scope);

        @JSONField(name = "session_key")
        public String getSessionKey();

        @JSONField(name = "session_key")
        public void setSessionKey(final String sessionKey);

        @JSONField(name = "session_secret")
        public String getSessionSecret();

        @JSONField(name = "session_secret")
        public void setSessionSecret(final String sessionSecret);
    }

    @RpcBuilder
    interface GetAccessTokenBuilder {

        @QueryParam("client_id")
        GetAccessTokenBuilder clientId(final String client_id);

        @QueryParam("client_secret")
        GetAccessTokenBuilder clientSecret(final String client_secret);

        @GET
        @ConstParams({"grant_type", "client_credentials"})
        @Path("https://aip.baidubce.com/oauth/2.0/token")
        @Consumes(MediaType.APPLICATION_JSON)
        Observable<AccessTokenResponse> call();
    }

    GetAccessTokenBuilder getAccessToken();
//
//    public Transformer<RpcRunner, AccessTokenResponse> getAccessToken();
}
