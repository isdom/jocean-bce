package org.jocean.bce.ai.internal;

import javax.inject.Inject;

import org.jocean.bce.ai.AICustomAPI.DetectObjectResponse;
import org.jocean.http.RpcRunner;
import org.jocean.idiom.BeanFinder;

import com.alibaba.fastjson.annotation.JSONField;

import rx.Observable.Transformer;

public class DefaultAICustomAPI /* implements AICustomAPI */ {

    public class ImageData {
        @JSONField(name = "image")
        public String getImage() {
            return this._image;
        }

        @JSONField(name = "image")
        public void setImage(final String imageAsBase64) {
            this._image = imageAsBase64;
        }

        String _image;
    }

    /*
    http://ai.baidu.com/docs#/EasyDL_VIS_API/17ff0cc2
    */

//    @Override
    public Transformer<RpcRunner, DetectObjectResponse> detectObject(
            final String appname, final String apipath, final String imageAsBase64) {
        final ImageData data = new ImageData();

        data.setImage(imageAsBase64);

        /*
        return runners -> _finder.find(appname, OAuthAPI.class).flatMap(oauth -> runners.compose(oauth.getAccessToken()))
                .flatMap(oauthresp -> runners.flatMap(runner -> runner.name("bce.ai.objectDetection")
                        .execute(interact -> interact
                                .method(HttpMethod.POST)
                                .uri("https://aip.baidubce.com")
                                .path("/rpc/2.0/ai_custom/v1/detection/" + apipath)
                                .paramAsQuery("access_token", oauthresp.getAccessToken())
                                .body(data, ContentUtil.TOJSON)
                                .responseAs(ContentUtil.ASJSON, DetectObjectResponse.class))));
                                */
        // TBD
        return null;
    }

    @Inject
    BeanFinder _finder;
}
