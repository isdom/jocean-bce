package org.jocean.bce.oauth.internal;

import org.springframework.beans.factory.annotation.Value;

public class DefaultOAuthAPI /* implements OAuthAPI */ {

    /*
    获取Access Token
    请求URL数据格式

    向授权服务地址https://aip.baidubce.com/oauth/2.0/token发送请求（推荐使用POST），并在URL中带上以下参数：

    grant_type： 必须参数，固定为client_credentials；
    client_id： 必须参数，应用的API Key；
    client_secret： 必须参数，应用的Secret Key；
    */

//    @Override
//    public Transformer<RpcRunner, AccessTokenResponse> getAccessToken() {
//        return runners -> runners.flatMap(runner -> runner.name("bce.oauth.getAccessToken").execute(
//                interact -> interact.method(HttpMethod.GET)
//                    .uri("https://aip.baidubce.com")
//                    .path("/oauth/2.0/token")
//                    .paramAsQuery("grant_type", "client_credentials")
//                    .paramAsQuery("client_id", _app_key)
//                    .paramAsQuery("client_secret", _secret_key)
//                    .responseAs(ContentUtil.ASJSON, AccessTokenResponse.class)
//        ));
//    }

    @Value("${app_key}")
    String _app_key;

    @Value("${secret_key}")
    String _secret_key;
}
