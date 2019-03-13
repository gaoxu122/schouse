package com.example.sc.baseResource;

/**
 * @author gaoxu
 * @date 2019/3/11
 * 静态类，存贮所有的常量
 */
public class ITStaticConstant {
    /**
     * suiteKey
     */
    public final static String DING_SUITE_KEY = "suitewmupexwvk8wxuyp7";
    /**
     * suiteSecret
     */
    public final static String DING_SUITE_SECRET = "ivRlRWjZFK1O3RTLGyr2CcBzA73Hm8xqW5FnCXrB39XVTls-dbtR83bqcwErIPEJ";
    /**
     * 企业的corpid
     */
    public final static String DING_CORP_ID = "ding4edd27adc4a0346f35c2f4657eb6378f";
    /**
     * 钉钉算法签名规则
     */
    public final static String ALGORITHM_SIGNATURE = "HmacSHA256";
    /**
     * 设置字符集
     */
    public final static String ENCODING_RULE = "UTF-8";
    /**
     * 默认过期时长，单位：秒
     */
    public static final long DING_TOKEN_DEFAULT_EXPIRE = 60 * 60 * 2 - 200;
    /**
     * 应用的appkey
     */
    public final static String APP_KEY = "dingtvumnid5yfkbrrss";
    /**
     * 应用的appsecert
     */
    public final static String APP_SECRET = "tRfUNZ20p4zzzgh8B4PAoFocCvS_J2imBxuBn5y2NZbhOKQgqwSLFHO5rWhZygvj";
    /**
     * 微应用管理后台SSOSecret
     * CorpId和SSOSecret
     * CorpId：ding4edd27adc4a0346f35c2f4657eb6378f
     * SSOsecret：WYi03HsYiEkdtCOslGTROSWHUj7YpYKsusYMMhfa1xXsS3yqzGO7f_V6iMHtM8NU
     * 企业和ISV在开发套件微应用的管理后台的时候，使用上面的SSOSecret即可完成管理员登录身份认证。
     *
     */
    public final static String SSOSECRET = "tRfUNZ20p4zzzgh8B4PAoFocCvS_J2imBxuBn5y2NZbhOKQgqwSLFHO5rWhZygvj";

}
