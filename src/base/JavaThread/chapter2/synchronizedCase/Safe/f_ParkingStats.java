package base.JavaThread.chapter2.synchronizedCase.Safe;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  17:28
 * Author:wuxinrui
 */

public class f_ParkingStats {
    private long numberCars;//车数量
    private long numberMotorcycles;//摩托数量
    private f_ParkingCash cash;

    private final Object  controlCars,controlMotorcycles;//这里应该代表 操作方法的线程


    public f_ParkingStats(f_ParkingCash cash) {
        numberCars=0;
        numberMotorcycles=0;
        this.cash=cash;

        controlCars = new Object();
        controlMotorcycles= new Object();
    }

    public void carComeIn(){
        synchronized (controlCars){
            numberCars++;
        }
    }
    public void carGoOut(){
        synchronized (controlCars) {
            numberCars--;
        }
        cash.vehiclePay();
    }
    public void MotorcyclesComeIn(){
        synchronized (controlMotorcycles) {
            numberMotorcycles++;
        }
    }
    public void  MotorcyclesGoOut(){
        synchronized (controlMotorcycles) {
            numberMotorcycles--;
        }
        cash.vehiclePay();
    }
    public long getNumberCars() {
        return numberCars;
    }

    public void setNumberCars(long numberCars) {
        this.numberCars = numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }

    public void setNumberMotorcycles(long numberMotorcycles) {
        this.numberMotorcycles = numberMotorcycles;
    }



}
