/*
 * 描述： 数据校验工具类
 * 修改人： Weng.weng
 * 修改时间： Sep 26, 2018
 * 项目： one-commons-lang
 */
package com.one.commons.lang.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据校验工具类<br>
 * 
 * 是否为空<br>
 * 是否为Email<br>
 * 是否为座机号码<br>
 * 是否为手机号码<br>
 * 是否为URL<br>
 * 是否为IP地址<br>
 * 是否为身份证号码<br>
 * 是否为数字<br>
 * 是否为日期时间<br>
 * 是否为指定长度<br>
 * 
 * @author Weng.weng
 * @version [版本号, Sep 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public enum ValidateUtils {
    
    NUM("^[0-9]*$"),
    
    /** 由26个英文字母（含大小寫）组成的字符串 */
    EN("^[A-Za-z]+$"),
    
    /** 由26个小寫英文字母组成的字符串 */
    EN_LOWERCASE("^[a-z]+$"),
    
    /** 由26个大寫英文字母组成的字符串 */
    EN_UPPERERCASE("^[A-Z]+$"),
    
    /** 由数字和26个英文字母组成的字符串 */
    EN_NUM("^[A-Za-z0-9]+$"),
    
    /** Email地址 */
    EMAIL("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"),
    
    /** 域名 */
    DOMAIN_NAME("[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?"),
    
    /** 手機號碼 */
    MOBILE("^(13[0-9]|14[0-9]|15[0-9]|166|17[0-9]|18[0-9]|19[8|9])\\d{8}$"),
    
    /** 座機號碼 */
    PHONE("^(\\(\\d{3,4}-)|\\d{3.4}-)?\\d{7,8}$"),
    
    /** 18位身份证号码(数字、字母x结尾)  */
    IDCARD("^((\\d{18})|([0-9x]{18})|([0-9X]{18}))$"),
    
    /** IP地址 */
    IP("\\d+\\.\\d+\\.\\d+\\.\\d+"),
    
    /** 腾讯QQ号从10000开始 */
    QQ("[1-9][0-9]{4,}"),
    
    /** 中国邮政编码为6位数字 */
    POST_CODE("[1-9]\\d{5}(?!\\d)"),
    
    /** 英文 */
    CHAR_EN("[a-zA-Z]"),
    
    /** 中文 */
    CHAR_CN("[\\u4e00-\\u9fa5]");
    
    private String regex;
    
    ValidateUtils(String regex) {
        this.regex = regex;
    }
    
    /**
     * 
     * 檢查字符串是否存在指定字符<br>
     *
     * @param text 被檢查的字符串
     * @return boolean 是否存在指定的字符
     * @version [版本号, Jul 31, 2019]
     * @author Weng.weng
     */
    public boolean exist(String text) {
        Pattern pattern = Pattern.compile(this.getRegex());
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }
    
    /**
     * 
     * 檢查字符串是否匹配正則表達式<br>
     *
     * @param text 被檢查的字符串
     * @return boolean 是否匹配正則表達式
     * @version [版本号, Jul 31, 2019]
     * @author Weng.weng
     */
    public boolean is(String text) {
        Pattern pattern = Pattern.compile(this.getRegex());
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
    
    public String getRegex() {
        return regex;
    }
    
}
