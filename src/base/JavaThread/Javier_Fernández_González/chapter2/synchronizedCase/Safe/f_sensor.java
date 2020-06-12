package base.JavaThread.Javier_Fernández_González.chapter2.synchronizedCase.Safe;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  17:36
 * Author:wuxinrui
 */

public class f_sensor implements Runnable {
    private f_ParkingStats stats;

    public f_sensor(f_ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            //        车进入
            stats.carComeIn();
//            System.out.println("carNumber:"+stats.getNumberCars());
            stats.MotorcyclesComeIn();
//            System.out.println("Motorcycles number:"+stats.getNumberMotorcycles());
            try{
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (Exception e){
                e.printStackTrace();
            }
            //        车开出
            stats.carGoOut();
            stats.MotorcyclesGoOut();
        }

    }

}
