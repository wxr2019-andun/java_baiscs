package base.JavaThread.chapter3.ExchangerCase;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Description:
 * GET-version:
 * Date:2020-05-20  16:16
 * Author:wuxinrui
 */

public class E_producer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public E_producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("生产  循环第"+i+" 次  (一次循环产出10)");
            for (int j = 0; j < 10; j++) {
                String message = "事件 " + (((10 - 1) * 10) + j);
                System.out.println("生产-: " + message);
                buffer.add(message);
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产数量: " + buffer.size());
        }

    }


    public void test() {
        for (int cycle = 1; cycle <= 10; cycle++) {
            System.out.printf("Producer: Cycle %d\n", cycle);

            for (int j = 0; j < 10; j++) {
                String message = "Event " + (((cycle - 1) * 10) + j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            }
        }
        try {
            buffer = exchanger.exchange(buffer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Producer: " + buffer.size());
    }
}
