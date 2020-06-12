package base.JavaThread.Javier_Fernández_González.chapter3.CompletableFutureCase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  17:23
 * Author:wuxinrui
 */

public class NumberListGenerator implements Supplier<List<Long>> {
    private final int size;

    public NumberListGenerator(int size) {
        this.size = size;
    }

    //返回有多达百万个随机数字的列表，其数量由参数size决定
    @Override
    public List<Long> get() {
        List<Long> ret = new ArrayList<>();
        System.out.printf("%s : 数字列表-生成器 : 开始 \n",Thread.currentThread().getName());
        for (int i=0; i< size*1000000; i++) {
            long number=Math.round(Math.random()*Long.MAX_VALUE);
            ret.add(number);
        }
        System.out.printf("%s :  数字列表-生成器 : 结束\n",Thread.currentThread().getName());
        return ret;
    }
}
