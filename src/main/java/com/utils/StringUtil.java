package com.utils;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final Object EMPTY_STRING = "";


    /**
     * 将字符串转换为Integer 默认为1
     *
     * @param str
     * @return
     */
    public static Integer parseInt(String str) {
        Integer i = 1;
        if (str != null && str.matches("\\d*")) {
            i = Integer.parseInt(str);
        }
        return i;
    }

    /**
     * 将对象不为空的字符串转化成double,失败 则为null
     *
     * @param string 带转化的字符串
     * @return
     */
    public static Double parseToDouble(String string) {
        Double number = null;
        if (string != null) {
            if (string.matches("\\d+.?\\d*")) {
                number = new Double(string);
            }
        }
        return number;
    }

    /**
     * 判断一个字符串是否是空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        if (value == null || EMPTY_STRING.equals(value))
            return true;
        else
            return false;
    }

    /**
     * 将给定字符串中的${}包围的变量使用给定的映射表替换
     *
     * @param template 需要替换的原始字符串
     * @param prop     用于替换的映射列表
     * @return 替换后的字符串
     */
    public static String evaluate(String template, Properties prop) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            String replacement = (String) prop.get(matcher.group(1));
            builder.append(template.substring(i, matcher.start()));
            if (replacement == null)
                builder.append(matcher.group(0));
            else
                builder.append(replacement);
            i = matcher.end();
        }
        builder.append(template.substring(i, template.length()));
        return builder.toString();
    }

    /**
     * 类型转换(字符串转换小数型)
     *
     * @param str 需要转换的字符串
     * @return 转换完成的小数
     */
    public static BigDecimal strToBigDecimal(String str, String pe) {
        BigDecimal bigDecimal = null;
        try {
            if (!StringUtil.isEmpty(str)) {
                bigDecimal = new BigDecimal(str);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(pe + "=" + str + "字符串转换小数型error");
        }
        return bigDecimal;
    }

    /**
     * 类型转换(字符串转换长整型)
     *
     * @param str 需要转换的字符串
     * @return 转换完成的整数
     */
    public static long strToLong(String str) {
        long l = 0;

        if (!StringUtil.isEmpty(str)) {
            l = Long.parseLong(str);
        }

        return l;
    }

    /**
     * 验证多个字符串是否都不为空
     *
     * @param strings 字符串集合
     * @return 是否都不为空标识
     */
    public static boolean isNotNullAll(String... strings) {
        boolean isNotNullAll = true;

        if (strings == null) {
            return false;
        }

        for (int i = 0; i < strings.length; i++) {
            if (StringUtil.isEmpty(strings[i])) {
                isNotNullAll = false;
                break;
            }
        }

        return isNotNullAll;
    }

    /**
     * 验证多个字符串是否都为空
     *
     * @param strings 字符串集合
     * @return 是否都为空标识
     */
    public static boolean isNullAll(String... strings) {
        boolean isNullAll = true;

        if (strings == null) {
            return true;
        }

        for (int i = 0; i < strings.length; i++) {
            if (!StringUtil.isEmpty(strings[i])) {
                isNullAll = false;
                break;
            }
        }

        return isNullAll;
    }

    /**
     * 将BigDecimal转换成String
     *
     * @param csId
     * @return
     */
    public static String BigDecimalToStr(BigDecimal csId) {
        String str = null;
        try {
            if (csId != null) {
                str = csId.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return str;

    }

    /**
     * 将对象为null并转换成字符串形式情况时，返回空
     *
     * @param str 待转换字符串
     * @return 返回的空值
     */
    public static String nullToEmpty(String str) {
        if ("null".equals(str)) {
            str = "";
        }

        return str;
    }


    /**
     * 判断字符串是否为数字
     *
     * @param number
     * @return
     */
    public static boolean isNumber(String number) {
        if (number.matches("\\d+.?\\d*")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 去掉字符串的前后空格
     *
     * @param String
     * @return
     */
    public static String stringTrim(String srcStr) {
        String desStr = null;
        if (isEmpty(srcStr)) {
            desStr = srcStr;
        } else {
            desStr = srcStr.trim();
        }
        return desStr;
    }

    /**
     * 字符串数组转成长字符串，逗号连接
     *
     * @param List<String>
     * @return String
     */
    public static String listToString(List<String> stringList) {
        String desString = null;
        if (stringList != null && stringList.size() > 0) {
            if (stringList.size() == 1) {
                desString = stringList.get(0);
            } else {
                desString = "";
                for (int i = 0; i < stringList.size() - 1; i++) {
                    desString += stringList.get(i);
                    desString += ",";
                }
                desString += stringList.get(stringList.size() - 1);
            }
        }
        return desString;
    }

    /**
     * 产生随机的六位数
     *
     * @return
     */
    public static String getSixRandom() {
        String charValue = "";
        for (int i = 0; i < 6; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }


    /**
     * java生成随机数字和字母组合
     *
     * @param length[生成随机数的长度]
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 取得大写字母还是小写字母
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    //十六进制下数字到字符的映射数组  
    private final static String[] hexDigits = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 把inputString加密
     */
    public static String generatePassword(String inputString) {
        return encodeByMD5(inputString);
    }

    /**
     * 验证输入的密码是否正确
     *
     * @param password    加密后的密码
     * @param inputString 输入的字符串
     * @return 验证结果，TRUE:正确 FALSE:错误
     */
    public static boolean validatePassword(String password, String inputString) {
        if (password.equals(encodeByMD5(inputString))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对字符串进行MD5加密
     */
    public static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                //创建具有指定算法名称的信息摘要  
                MessageDigest md = MessageDigest.getInstance("MD5");
                //使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  
                byte[] results = md.digest(originString.getBytes());
                //将得到的字节数组变成字符串返回  
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

}
