package org.jocean.bce.ai;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jocean.rpc.annotation.RpcBuilder;

import com.alibaba.fastjson.annotation.JSONField;

import rx.Observable;

// http://ai.baidu.com/docs#/Auth : 鉴权认证机制

public interface AICustomAPI {

    public interface ObjectLocation {
        @JSONField(name = "left")
        public int getLeft();

        @JSONField(name = "left")
        public void setLeft(final int left);

        @JSONField(name = "top")
        public int getTop();

        @JSONField(name = "top")
        public void setTop(final int top);

        @JSONField(name = "width")
        public int getWidth();

        @JSONField(name = "width")
        public void setWidth(final int width);

        @JSONField(name = "height")
        public int getHeight();

        @JSONField(name = "height")
        public void setHeight(final int height);
    }

    public interface DetectionResult {
        @JSONField(name = "name")
        public String getName();

        @JSONField(name = "name")
        public void setName(final String name);

        @JSONField(name = "score")
        public float getScore();

        @JSONField(name = "score")
        public void setScore(final float score);

        @JSONField(name = "location")
        public ObjectLocation getLocation();

        @JSONField(name = "location")
        public void setLocation(final ObjectLocation location);
    }

    public interface DetectObjectResponse {
        @JSONField(name = "log_id")
        public long getLogId();

        @JSONField(name = "log_id")
        public void setLogId(final long logid);

        @JSONField(name = "results")
        public DetectionResult[] getResults();

        @JSONField(name = "results")
        public void setResults(final DetectionResult[] results);
    }

    // http://ai.baidu.com/docs#/EasyDL_VIS_API/17ff0cc2
    @RpcBuilder
    interface DetectObjectBuilder {

        @JSONField(name = "image")
        DetectObjectBuilder setImage(final String imageAsBase64);

        @PathParam("apipath")
        DetectObjectBuilder apipath(final String path);

        @POST
        @Path("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/detection/{apipath}")
        @Consumes(MediaType.APPLICATION_JSON)
        Observable<DetectObjectResponse> call();
    }

    public DetectObjectBuilder detectObject();
//    public Transformer<RpcRunner, DetectObjectResponse> detectObject(
//            final String appname, final String apipath, final String imageAsBase64);
}
