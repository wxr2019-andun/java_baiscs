package base.JavaThread.chapter1.Local;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  9:32
 * Author:wuxinrui
 */

public class virtualSafeTack implements Runnable {

    //***
    //线程本地变量机制为每个使用该属性的线程保存了独立的属性值。可以用get()和set()方法来分别读
    // 写该属性值。第一次访问线程本地变量时，若与该线程对象关联的属性值不存在，则将会触发
    //initialValue()方法，它会为该属性赋值并返回初始值。

    //ThreadLocal类提供了remove()方法，该方法用于删除调用线程的线程本地变量值。
    private ThreadLocal<Date> startTime = new InheritableThreadLocal<Date>(){
        protected Date initialValue(){
          return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("starting thread : %s : %s\n",Thread.currentThread().getId(),startTime.get());
        try{
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.printf("finished thread : %s : %s\n",Thread.currentThread().getId(),startTime.get());
    }
}
