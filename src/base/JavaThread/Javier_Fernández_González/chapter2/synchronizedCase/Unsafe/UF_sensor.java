package base.JavaThread.Javier_Fernández_González.chapter2.synchronizedCase.Unsafe;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  17:36
 * Author:wuxinrui
 */

public class UF_sensor implements Runnable {
    private UF_ParkingStats stats;

    public UF_sensor(UF_ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            //        车进入
            stats.carComeIn();
            stats.MotorcyclesComeIn();

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
