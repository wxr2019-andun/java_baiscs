package base.JavaThread.Javier_Fernández_González.chapter2.ConditionCase;

import java.util.UUID;

/**
 * Description: 先看一下最終的效果
 * 周六又看了一次感觉很精妙    file文件初始化 将内容放到字符数组- 同时设定下标
 * buffer作为缓存  只存放固定长度的内容-    生产者开始读取字符数组-当下标走完后 生产者任务完成-    这个控制流程有意思.
 * GET-version:
 * Date:2020-05-15  14:54
 * Author:wuxinrui
 */

public class FileMock {
    private String[] content;
    private int index;
    private int index2;

    public FileMock(int size, int length){
        content = new String[size];
        for (int i = 0; i< size; i++){
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++){
//                System.out.println("content- "+"no:"+i+"--"+j+"--"+UUID.randomUUID().toString().replaceAll("-", "")+"--");
                buffer.append("no:"+i+"--"+j+"--"+UUID.randomUUID().toString().replaceAll("-", "")+"  ");
            }
            content[i] = buffer.toString();
        }
        index=0;
    }

    public boolean hasMoreLines(){
        return index <content.length;
    }

//    提供获取 指定数据 数据的方法-同时-移动下标
    public String getLine(){
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length-index));
            return content[index++];
        }
        return null;
    }

    /*
    private String[] content;
    private int index;//下标

    public FileMock(int size, int length) {
//      数组-下标=一行内容
        content = new String[size];

        for (int i = 0; i < size; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < length; j++) {
                int randoms = (int) Math.random() * 300;
                stringBuffer.append((char)randoms);
            }
//            讲生成的随机数-放入数组下标
            content[i] =stringBuffer.toString();
        }
        index=0;
    }
//判断下标是否 小于数组长度
    public boolean hasMoreLines(){
        return index<content.length;
    }
//如果 当前下标小于数组下标 返回当前下标指向的数组内容
//    且当前下标+1
    public String getLine(){
        if(this.hasMoreLines()){
            System.out.println("mock:"+(content.length-index));
        return content[index++];
    }
        return null;
    }
     */


}
