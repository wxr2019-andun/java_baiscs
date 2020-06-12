package util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * GET-version:
 * Date:2020-06-12  14:37
 * Author: wxr
 */

public class OptimizeUtil {
    /**
     *@Description:  判断参数是否为空
     *@Data 14:45 2020/6/12
     *@GET-Version:
     *@Author: wxr
     */
    public static boolean nullVerdict(Object object) {
        if(object==null){
            return true;
        }
        String path = object.getClass().getName();

//        字符串判断
        if (path.equals("java.lang.String")) {
            String srt = object.toString();
            if (srt.equals("")) {
                return true;
            } else if (srt == null) {
                return true;
            }
        }
//        Integer
        if (path.equals(Integer.class.getName())) {
            Integer i = Integer.parseInt(object.toString());
            if (i == null) {
                return true;
            }
        }
//        Double
        if (path.equals(Double.class.getName())) {
            Double aDouble = Double.parseDouble(object.toString());
            if (aDouble == null) {
                return true;
            }
        }
        return false;
    }
    /**
     *@Description:  获取对象中非空的成员变量名 和成员变量值 存储与map
     * 适用反射动态获取值   省去了大量get 方法.  优化结构
     *@Data 14:43 2020/6/12
     *@GET-Version:
     *@Author: wxr
     */
    public static Map<String, Object> reflectMethod(Object object) {

        Class c = object.getClass();
        Field[] fs = c.getDeclaredFields();
        String parameterName;
        Object values = null;

        Map<String, Object> map = new HashMap<>();

        for (Field f : fs) {
            f.setAccessible(true);
            parameterName = f.getName();
            try {
                values = f.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (!nullVerdict(values)) {
                map.put(parameterName, values);
            }
        }
        return map;
    }
    /**
     *@Description: pojo 指定属性非空判断
     * param字符数组 存放需要验证的成员变量名-   map则存放一个对象非空的成员变量名 和 变量值
     * reflectMethod+pojoVerify  可优化大量的if else非空判断  提升开发效率-结构简明
     *@Data 14:39 2020/6/12
     *@GET-Version:
     *@Author: wxr
     */
    public static boolean pojoVerify(Map<String,Object> map,String [] paramArray){
        int count = paramArray.length;
        int sum=0;
        String indexName;
        for (int i = 0; i < count; i++) {
            indexName=paramArray[i];
            if(map.containsKey(indexName)){
                sum++;
            }
        }
        if(sum==count){
            return true;
        }
        return false;
    }
}
