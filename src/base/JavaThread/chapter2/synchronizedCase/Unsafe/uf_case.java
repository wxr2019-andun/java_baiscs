package base.JavaThread.chapter2.synchronizedCase.Unsafe;

/**
 * Description:
 * GET-version:'
 * Date:2020-05-14  17:41
 * Author:wuxinrui
 */

public class uf_case {
    public static void main(String[] args) {
        UF_ParkingCash cash = new UF_ParkingCash();
        UF_ParkingStats stats = new UF_ParkingStats(cash);


        Thread[] threads = new Thread[4];
//  这样用线程数组可以嘛？ 将一个运行中的线程 赋值给一个线程数组下标
        for (int i = 0; i < 4; i++) {
            UF_sensor uf_sensor = new UF_sensor(stats);
            threads[i]= new Thread(uf_sensor);
            threads[i].start();

        }
//
        for (int i = 0; i < 4; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //
        System.out.printf("car number : %d \n " ,stats.getNumberCars());
        System.out.printf("Motorcycles number : %d \n",stats.getNumberMotorcycles());
        cash.close();
    }
}
