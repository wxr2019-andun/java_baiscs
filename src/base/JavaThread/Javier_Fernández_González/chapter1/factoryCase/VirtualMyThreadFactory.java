package base.JavaThread.Javier_Fernández_González.chapter1.factoryCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  11:40
 * Author:wuxinrui
 */

public class VirtualMyThreadFactory implements ThreadFactory {

    private int counter;//线程对象的创建数
    private  String name;//
    private List<String> states;//线程对象创建过程的统计信息

    public VirtualMyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.states = new ArrayList<>();
    }

    //接收Runnable接口，并为Runnable接口返回一个线程对象


    @Override
    public Thread newThread(Runnable r) {
        Thread t =new Thread(r,name+"-thread-"+counter);
        counter++;
        states.add(String.format("create thread %d with name %s on %s \n",t.getId(),t.getName(),new Date()));
        return t;
    }

    // return String对象——其包含创建的所有线程对象的统计数据
    public String getStatus(){
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> it = states.iterator();
        while(it.hasNext()){
            stringBuffer.append(it.next());
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }
}
