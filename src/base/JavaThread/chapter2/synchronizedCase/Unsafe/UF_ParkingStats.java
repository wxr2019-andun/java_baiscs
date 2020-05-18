package base.JavaThread.chapter2.synchronizedCase.Unsafe;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  17:28
 * Author:wuxinrui
 */

public class UF_ParkingStats {
    private long numberCars;//车数量
    private long numberMotorcycles;//摩托数量
    private UF_ParkingCash cash;


    public UF_ParkingStats(UF_ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        this.cash = cash;
    }

    public void carComeIn() {
        numberCars++;
    }

    public void carGoOut() {
        numberCars--;
        cash.vehiclePay();
    }

    public void MotorcyclesComeIn() {
        numberMotorcycles++;
    }

    public void MotorcyclesGoOut() {
        numberMotorcycles--;
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
