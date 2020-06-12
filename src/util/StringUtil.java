package util;

import base.common.NowTime;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringUtil {


    /**
     * 切分完整路径换成半路径到数据库
     *
     * @param str ： 完成路径
     */
    public static String dbReplaceUrl(String str) {
        String url = null;
        if (null != str && !"".equals(str)) {
            if (str.contains("https")) {
                String newStr = str.replace("https://", "");
                url = newStr.substring(newStr.indexOf("/"));
            } else {
                String newStr = str.replace("http://", "");
                url = newStr.substring(newStr.indexOf("/"));
            }
        }
        return url;
    }

    //根据当前时间返回 字符时间 1=精度到天  2=精度到秒
    public static String CalendarNowTimeString(int tyep) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date dates = calendar.getTime();
        String result;
        switch (tyep) {
            case 1:
                result = DateString_day(dates);
                return result;
            case 2:
                result = DateString_milli(dates);
                return result;

        }
        return null;
    }

    //判断 当前时间是否大于目标时间
    public static boolean CalendarDifferDay_1(String targetTime) {

        Calendar a = Calendar.getInstance();
        a.setTime(DateStringConvent(targetTime));
        Calendar b = Calendar.getInstance();
        b.setTime(new Date());
        System.out.println(StringUtil.DateString_day(a.getTime()));
        System.out.println(StringUtil.DateString_day(b.getTime()));

//		type-1
//		int a_month = a.get(Calendar.MONTH)+1;
//		int a_date = a.get(Calendar.DATE);
//		int b_month = b.get(Calendar.MONTH)+1;
//		int b_date = b.get(Calendar.DATE);
//		if(b_month==a_month||b_month>a_month){
//			if(b_date>a_date){
//				return true;
//			}
//		}

        //		type-2
        if (b.after(a)) {
            return true;
        }


        return false;
    }

    public static String DateString_day(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dates = simpleDateFormat.format(date);
        return dates;
    }

    public static String DateString_milli(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = simpleDateFormat.format(date);
        return dates;
    }

    //根据 时间字符-转换为对应 Date参数
    public static Date DateStringConvent(String targetTime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition parsePosition = new ParsePosition(0);
        Date t = simpleDateFormat.parse(targetTime, parsePosition);
        return t;
    }

    //返回 UUID 1=8位长度 2=16位长度 3=完整长度 大概40左右
    public static String Uid(int type) {
        String str = null;
        switch (type) {
            case 1:
                str = ((UUID.randomUUID().toString()).replaceAll("-", "")).substring(0, 8);
                return str;
            case 2:
                str = ((UUID.randomUUID().toString()).replaceAll("-", "")).substring(0, 16);
                return str;
            case 3:
                str = ((UUID.randomUUID().toString()).replaceAll("-", ""));
                return str;
            default:
                return null;
        }
    }

    //正则判断手机号是否合法
    public static boolean isMobileNO(String mobile) {
        if (mobile.length() != 11) {
            return false;
        } else {
            /**
             * 移动号段正则表达式
             */
            String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
            /**
             * 联通号段正则表达式
             */
            String pat2 = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}$";
            /**
             * 电信号段正则表达式
             */
            String pat3 = "^((133)|(153)|(177)|(18[0,1,9])|(149))\\d{8}$";
            /**
             * 虚拟运营商正则表达式
             */
            String pat4 = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";

            Pattern pattern1 = Pattern.compile(pat1);
            Matcher match1 = pattern1.matcher(mobile);
            boolean isMatch1 = match1.matches();
            if (isMatch1) {
                return true;
            }
            Pattern pattern2 = Pattern.compile(pat2);
            Matcher match2 = pattern2.matcher(mobile);
            boolean isMatch2 = match2.matches();
            if (isMatch2) {
                return true;
            }
            Pattern pattern3 = Pattern.compile(pat3);
            Matcher match3 = pattern3.matcher(mobile);
            boolean isMatch3 = match3.matches();
            if (isMatch3) {
                return true;
            }
            Pattern pattern4 = Pattern.compile(pat4);
            Matcher match4 = pattern4.matcher(mobile);
            boolean isMatch4 = match4.matches();
            if (isMatch4) {
                return true;
            }
            return false;
        }
    }

    //返回6位随机整数数
    public static Integer ICode(int type) {
        Integer code = 0;
        switch (type) {
            case 1:
                String verifyCode = (String.valueOf(new Random().nextInt(899999) + 100000)).substring(0, 6);
                return code = Integer.valueOf(verifyCode);

        }
        return code;
    }

    //    必须是6-10位字母、数字、下划线（这里字母、数字、下划线是指任意组合，没有必须三类均包含）
    public static boolean checkPwd(String pwd) {
        String regExp = "^[\\w_]{6,20}$";
        if (pwd.matches(regExp)) {
            return true;
        }
        return false;
    }

    //	根据当前时间 获取剩余时间 规则为 若类型为天 则根据当前时间获取改天剩余小时，若类型为小时 根据当前时间 剩余多少分钟
    public static int fairlyTime(int type) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = +c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);
        switch (type) {
            case 1://天
                return 24 - hour;
            case 2://小时
                return 60 - min;
        }
        return 0;
    }
// 获取当期时间-年-秒
    public static NowTime nowTime() {

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = +c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int ss = c.get(Calendar.SECOND);

        NowTime nowTime = new NowTime();

        nowTime.setYear(year);
        nowTime.setYear_s("" + year);
        nowTime.setDay(month);
        nowTime.setDay_s("" + month);
        nowTime.setDay(day);
        nowTime.setDay_s("" + day);
        nowTime.setHour(hour);
        nowTime.setHour_s("" + hour);
        nowTime.setMin(min);
        nowTime.setMin_s("" + min);
        nowTime.setSs(ss);
        nowTime.setSs_s("" + ss);
        return nowTime;

    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();//当前时区时间
        System.out.println("year:" + c.get(Calendar.YEAR));
        System.out.println("month:" + (c.get(Calendar.MONTH) + 1));
        System.out.println("day:" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("hour:" + c.get(Calendar.HOUR_OF_DAY));
        System.out.println("min:" + c.get(Calendar.MINUTE));
        System.out.println("ss:" + c.get(Calendar.SECOND));
    }
}
