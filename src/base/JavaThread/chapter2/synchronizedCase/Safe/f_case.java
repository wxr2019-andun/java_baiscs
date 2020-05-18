package base.JavaThread.chapter2.synchronizedCase.Safe;

/**
 * Description: 使用synchronized 关键字修饰代码块完成 设置临界区-完成线程同步-效率较低
 * GET-version:'
 * Date:2020-05-14  17:41
 * Author:wuxinrui
 */

public class f_case {
    public static void main(String[] args) {
        f_ParkingCash cash = new f_ParkingCash();
        f_ParkingStats stats = new f_ParkingStats(cash);

        int off=4;

        Thread[] threads = new Thread[off];

        for (int i = 0; i < off; i++) {
            f_sensor uf_sensor = new f_sensor(stats);
            threads[i]= new Thread(uf_sensor);
            threads[i].start();

        }

        for (int i = 0; i < off; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.printf("car number : %d \n " ,stats.getNumberCars());
        System.out.printf("Motorcycles number : %d \n",stats.getNumberMotorcycles());
        cash.close();

    }
}
