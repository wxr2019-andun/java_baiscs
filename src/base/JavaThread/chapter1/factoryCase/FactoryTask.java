package base.JavaThread.chapter1.factoryCase;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  11:41
 * Author:wuxinrui
 */

public class FactoryTask implements Runnable{
    @Override
    public void run() {
       try{
           TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
           e.printStackTrace();
       }
    }
}
