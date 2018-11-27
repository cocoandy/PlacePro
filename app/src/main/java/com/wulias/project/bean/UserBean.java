package com.wulias.project.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 曹小贼 on 2018/10/31.
 */

public class UserBean {


    /**
     * user_info : {"id":"1","user_type":"1","sex":"0","birthday":"-28800","last_login_time":"1539740304","score":"1","coin":"0","create_time":"1514169260","user_status":"1","user_login":"admin","user_pass":"###072875efc4f26d8d90082f697f22fe2b","user_nickname":"admin","user_email":"634282422@qq.com","user_url":"","avatar":"","signature":"","last_login_ip":"183.13.202.171","user_activation_key":"","mobile":"","more":null,"user_source":"1","invitation_code":"JMCM3579","is_company":"0"}
     */
    @SerializedName("user_info")
    private UserInfoBean userInfo;

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public static class UserInfoBean {
        /**
         * id : 1
         * user_type : 1
         * sex : 0
         * birthday : -28800
         * last_login_time : 1539740304
         * score : 1
         * coin : 0
         * create_time : 1514169260
         * user_status : 1
         * user_login : admin
         * user_pass : ###072875efc4f26d8d90082f697f22fe2b
         * user_nickname : admin
         * user_email : 634282422@qq.com
         * user_url :
         * avatar :
         * signature :
         * last_login_ip : 183.13.202.171
         * user_activation_key :
         * mobile :
         * more : null
         * user_source : 1
         * invitation_code : JMCM3579
         * is_company : 0
         */

        private long id;
        @SerializedName("user_type")
        private int userType; //用户类型1:admin;2:会员
        private String sex;//性别;0:保密,1:男,2:女
        private String birthday;//生日
        @SerializedName("last_login_time")
        private long lastLoginTime;//上一次登录时间
        private int score;//用户积分
        private int coin;//金币
        @SerializedName("create_time")
        private long createTime;//创建时间
        @SerializedName("user_status")
        private int userStatus;//用户状态
        @SerializedName("userPass")
        private String userPass;//用户密码
        @SerializedName("user_nickname")
        private String userNickname;//用户昵称
        @SerializedName("user_login")
        private String userLogin;//"用户名
        @SerializedName("user_email")
        private String userEmail;//邮箱
        @SerializedName("user_url")
        private String userUrl;//用户个人地址
        private String avatar;//用户头像
        private String signature;//个性签名
        @SerializedName("last_login_ip")
        private String lastLoginIp;//最后登录IP
        @SerializedName("user_activation_key")
        private String userActivationKey;//激活码
        private String mobile;//手机号码
        private String more;//扩展属性
        @SerializedName("user_source")
        private int userSource;//用户来源0:APP用户,1:后台用户
        @SerializedName("invitation_code")
        private String invitationCode;//邀请码
        @SerializedName("is_company")
        private boolean isCompany;//是否是公司管理员

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public String getUserPass() {
            return userPass;
        }

        public void setUserPass(String userPass) {
            this.userPass = userPass;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getUserLogin() {
            return userLogin;
        }

        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserUrl() {
            return userUrl;
        }

        public void setUserUrl(String userUrl) {
            this.userUrl = userUrl;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getLastLoginIp() {
            return lastLoginIp;
        }

        public void setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
        }

        public String getUserActivationKey() {
            return userActivationKey;
        }

        public void setUserActivationKey(String userActivationKey) {
            this.userActivationKey = userActivationKey;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getMore() {
            return more;
        }

        public void setMore(String more) {
            this.more = more;
        }

        public int getUserSource() {
            return userSource;
        }

        public void setUserSource(int userSource) {
            this.userSource = userSource;
        }

        public String getInvitationCode() {
            return invitationCode;
        }

        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        public boolean isCompany() {
            return isCompany;
        }

        public void setCompany(boolean company) {
            isCompany = company;
        }
    }
}
