package base.JavaThread.chapter4.Executor_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  10:51
 * Author:wuxinrui
 */

public class FactorialCalculator implements Callable<Integer> {
    private final Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int result =1;
        if ((number==0) || (number==1) ) {
            result=1;
        } else {
            for (int i = 0; i < number; i++) {
                result*=i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s : result %d \n",Thread.currentThread().getName(),result);
        return result;
    }
}
