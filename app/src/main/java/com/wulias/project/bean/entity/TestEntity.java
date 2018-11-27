package com.wulias.project.bean.entity;

/**
 * Created by Administrator on 2018/6/29.
 */

public class TestEntity {

    /**
     * code : 0
     * message : 请求成功
     * content : {"version":"2.0.1","result":"higher"}
     */

    private int code;
    private String message;
    private ContentBean content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * version : 2.0.1
         * result : higher
         */

        private String version;
        private String result;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
