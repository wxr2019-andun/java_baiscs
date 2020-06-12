package base.JavaThread.Javier_Fernández_González.chapter4.Executor_4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  12:09
 * Author:wuxinrui
 */

public class UserValidator {
    private final String name;


    public UserValidator(String name) {
        this.name = name;
    }
    public boolean validator(String name,String password){
        long duration = (long)  (Math.random()*10);
        System.out.printf("验证- %s 预估验证时间- %d 秒 \n",name,duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        boolean b = new Random().nextBoolean();
//        System.out.printf("%s .本次随机值：%s ",Thread.currentThread().getName(),b);
        return b;
    }
    public String getName(){
        return name;
    }

}
