package org.jocean.bce.ai;

import org.jocean.http.RpcRunner;

import com.alibaba.fastjson.annotation.JSONField;

import rx.Observable.Transformer;

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

    public interface ObjectDetectionResponse {
        @JSONField(name = "log_id")
        public long getLogId();

        @JSONField(name = "log_id")
        public void setLogId(final long logid);

        @JSONField(name = "results")
        public DetectionResult[] getResults();

        @JSONField(name = "results")
        public void setResults(final DetectionResult[] results);
    }

    public Transformer<RpcRunner, ObjectDetectionResponse> detectObject(
            final String appname, final String apipath, final String imageAsBase64);
}
