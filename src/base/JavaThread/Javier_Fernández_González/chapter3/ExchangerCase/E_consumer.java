package base.JavaThread.Javier_Fernández_González.chapter3.ExchangerCase;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  16:32
 * Author:wuxinrui
 */

public class E_consumer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public E_consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }
//在方法内循环10次数据交换：
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("消费  循环第"+i+" 次  (一次循环 消费 10)");
            //在每次循环当中，都应先调用exchange()方法与生产者进行同步，从而获取消费者需要的数据
            try {
                buffer=exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费: " + buffer.size());
            //同步后将从生产者处获得的10个字符串输出到控制台后删除，并将buffer列表清空
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("已消费： "+message);
                buffer.remove(0);
            }

        }
    }
    public void test(){
        for (int cycle = 1; cycle <= 10; cycle++){
            System.out.printf("Producer: Cycle %d\n",cycle);

            for (int j=0; j<10; j++){
                String message="Event "+(((cycle-1)*10)+j);
                System.out.printf("Producer: %s\n",message);
                buffer.add(message);
            }
            try {
                buffer=exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer: "+buffer.size());
        }
    }
}
