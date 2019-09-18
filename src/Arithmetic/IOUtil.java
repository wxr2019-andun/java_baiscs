package Arithmetic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author:wuxinrui
 * Date:2019-09-16  14:43
 * Description:
 */

public class IOUtil {
    public static void main(String[] args) throws Exception {
        String url = "";
        File file = new File(url);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader br = new BufferedReader(reader);
        String l = "";
        String s;
        l = br.readLine();
        List<String> l2 = new ArrayList<>();
        while (l != null) {
            l = br.readLine();
            s = "'" + l + "',";
            l2.add(s);
        }
        System.out.println(l2.toString());


        File writename = new File("");
        writename.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        for (int i = 0; i < l2.size(); i++) {
            out.write(l2.get(i));
            out.flush();
        }
        out.close();
    }
}
