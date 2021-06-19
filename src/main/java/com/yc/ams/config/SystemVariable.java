package com.yc.ams.config;

import org.apache.shiro.crypto.hash.Md5Hash;

public class SystemVariable {

    // 检测图片
    public final static Double MAX_STUDENT_TEMP = 37.5;
    public final static String FILE_NOT_IMG = "图片格式不正确!";
    public final static String FILE_NO_IMG = "图片未上传！";
    public final static String IMG_IS_ENOUGH = "最多仅可展示五张图！";
    public final static String IMG_IS_FEW = "最少展示一张图！";
    public final static String CONTENT_IS_EMPTY = "内容有空，请填写！";

    public final static String AUTO_SAVE_ERROR ="保存失败，请联系管理员！";
    public final static String AUTO_SAVE_SUCCESS ="保存成功！";
    public final static String AUTO_SAVE ="1";
    public final static String IS_AUDIT ="1";
    public final static String TRUE ="1";
    public final static String SEE_ANSWER ="1";
    public final static String FALSE ="0";
    public final static String SUBBMIT_SAVE ="0";

    public final static Integer EDITOR_IMG_SUCCESS = 1;
    public final static Integer STUDENT_PUSH_NUM = 10;
    public final static Integer EDITOR_IMG_FILE = 0;
    public final static String STUDENT_TYPE = "5";
    public final static String TEACHER_TYPE = "3";
    public final static String PARENT_TYPE = "4";

    public final static double ALL_TRUE_ACCURACY = 100.0;
    public final static double ALL_FLASE_ACCURACY = 0.0;

    public final static Integer ZERO = 0;

    // md5加密数据长
    public final static Integer MD5_HASH_ITERATIONS = 1024;

    public final static Integer BANNER_MAX_NUMBER = 5;
    public final static Integer IMG_MAST_SHOW_ONE = 1;

    public final static String BANNER_IS_USE = "1";
    //失败
    public final static Integer ERROR = 0;

    // 成功
    public final static Integer SUCCESS = 1;

    // 0是未软删除，1是软删除
    public final static String IS_DEL = "1";
    public final static String IS_NOT_DEL = "0";

    // tree 列表数据
    public final static Integer PARENET_ID = 0;
    public final static String ROLE_ADMIN = "1";
    // 未知错误
    public final static String UNKNOWN_ERROR = "发现未知错误，请联系开发者！";


    public final static String DO_SUCCESS ="操作成功！";
    public final static String DO_ERROR ="操作失败！";


    public final static String DEL_SUCCESS = "删除成功！";
    public final static String DEL_ERROR = "删除失败！";

    public final static String UPDATE_SUCCESS = "修改成功！";
    public final static String UPDATE_ERROR = "修改失败！";

    public final static String ADD_SUCCESS = "提交成功！";
    public final static String ADD_ERROR = "提交失败！";

    public final static String USE_SUCCESS = "启用成功！";
    public final static String USE_ERROR = "启用失败！";

    public final static String FORBIDDEN_SUCCESS = "禁用成功！";
    public final static String FORBIDDEN_ERROR = "禁用失败！";

    public final static String BANNER_USE_SUCCESS = "显示成功！";
    public final static String BANNER_USE_ERROR = "显示失败！";

    public final static String ARTICLE_PUSH_SUCCESS = "推送成功！";
    public final static String ARTICLE_PUSH_ERROR = "推送失败！";

    public final static String ARTICLE_AUDIT_SUCCESS = "审核通过成功！";
    public final static String ARTICLE_AUDIT_ERROR = "审核通过失败！";


    public final static String CLOSE_BANNER_USE_SUCCESS = "关闭显示成功！";
    public final static String CLOSE_BANNER_USE_ERROR = "关闭显示失败！";

    public final static String IS_HAVE = "已存在！";
    public final static String NUMBER_IS_HAVE = "学号已存在！";
    public final static String TODAY_IS_HAVE = "今日已填写！";
    public final static String TITLE_IS_HAVE = "题目已存在！";

    public final static Integer ROW_NUMBER = 0;
    public final static Integer WEEK = 7;
    public final static Integer MAX_SET = 2;
    public final static Integer URL_FAIL = 400;
    public final static Integer URL_SUCCESS = 200;

    public final static String DEFAULT_PASSWORD = "123456";

    //过滤一遍生成加盐密码
    public static String setDefaultPassword(String uname){
        String password = new Md5Hash(
                DEFAULT_PASSWORD,
                uname,
                SystemVariable.MD5_HASH_ITERATIONS).toHex();
        return password;
    }

    public static String updatePassword(String uname,String pwd){
        String password = new Md5Hash(
                pwd,
                uname,
                SystemVariable.MD5_HASH_ITERATIONS).toHex();
        return password;
    }
    public static String token = "4381fe197827ec87cbac9552f14ec62a";

    public static String PARAM_IS_NULL = "必要参数存在空！";

    public static String COMPILE_URL = "http://api.easycoding.org.cn/v1 code/compli e";

    /**
     * 将字符串的编码格式转换为utf-8
     *
     * @param str
     * @return Name = new
     * String(Name.getBytes("ISO-8859-1"), "utf-8");
     */
    public static String toUTF8(String str) {
        if (isEmpty(str)) {
            return "";
        }
        try {
            if (str.equals(new String(str.getBytes("GB2312"), "GB2312"))) {
                str = new String(str.getBytes("GB2312"), "utf-8");
                return str;
            }
        } catch (Exception exception) {
        }
        try {
            if (str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))) {
                str = new String(str.getBytes("ISO-8859-1"), "utf-8");
                return str;
            }
        } catch (Exception exception1) {
        }
        try {
            if (str.equals(new String(str.getBytes("GBK"), "GBK"))) {
                str = new String(str.getBytes("GBK"), "utf-8");
                return str;
            }
        } catch (Exception exception3) {
        }
        return str;
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        // 如果字符串不为null，去除空格后值不与空字符串相等的话，证明字符串有实质性的内容
        if (str != null && !str.trim().isEmpty()) {
            return false;// 不为空
        }
        return true;// 为空
    }
}
