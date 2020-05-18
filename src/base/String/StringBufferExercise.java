package base.String;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:wuxinrui
 * Date:2020-02-14  15:43
 * Description:
 */

public class StringBufferExercise {

        public static void main(String[] args) throws UnsupportedEncodingException, MalformedURLException {
        StringBuffer stringBuffer = new StringBuffer();
        Map<String, String> parameters = new HashMap<>();

        String s1 = "stringBuffer-v1  |";
        String s2 = "stringBuffer-v2  |";
            parameters.put("s1",s1);
        stringBuffer.append(s1);
        System.out.println(stringBuffer.toString());
        stringBuffer.append(s2);
        System.out.println(stringBuffer.toString());
        stringBuffer.insert(6,"[v3]");
        System.out.println(stringBuffer.toString());
        stringBuffer.append(s1).append(s2).append(java.net.URLEncoder.encode(parameters.get(s1), "UTF-8"));

        stringBuffer.delete(0,6);
        System.out.println(stringBuffer.toString());


        //AbstractStringBuilder abstractStringBuilder; ?



    }





}
