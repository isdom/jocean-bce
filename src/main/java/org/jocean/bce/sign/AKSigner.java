package org.jocean.bce.sign;

import org.jocean.http.Interact;
import org.jocean.http.InteractPipe;
import org.springframework.beans.factory.annotation.Value;

import rx.Observable;

public class AKSigner implements InteractPipe{

    /*
    向授权服务地址https://aip.baidubce.com/oauth/2.0/token发送请求（推荐使用POST），并在URL中带上以下参数：

    grant_type： 必须参数，固定为client_credentials；
    client_id： 必须参数，应用的API Key；
    client_secret： 必须参数，应用的Secret Key；
    */

    @Override
    public Observable<Interact> call(final Observable<Interact> interacts) {
        return interacts.map(interact -> interact.paramAsQuery("client_id", _app_key)
                .paramAsQuery("client_secret", _secret_key));
    }

    @Value("${app_key}")
    String _app_key;

    @Value("${secret_key}")
    String _secret_key;
}
