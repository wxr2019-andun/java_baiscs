package base.JavaThread.Javier_Fernández_González.chapter3.CompletableFutureCase;

import java.util.List;
import java.util.function.Function;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  17:28
 * Author:wuxinrui
 */


//实现由List和Long数据类型作为参数的接口Function。这意味着，由Function接口定义的apply()方法接收一个大数列表作为参数，并返回一个Long类型的数字
public class NumberSelector implements Function<List<Long>,Long> {
    @Override
    public Long apply(List<Long> list) {
        System.out.printf("%s: 步骤三 启动\n",Thread.currentThread().getName());
        long max=list.stream().max(Long::compare).get();
        long min=list.stream().min(Long::compare).get();
        long result=(max+min)/2;
        System.out.printf("%s: 步骤3（随机数字列表中，最大数与最小数的平均值。） 结束  %d\n",
                Thread.currentThread().getName(), result);
        return result;
    }
}
