package base.JavaThread.Javier_Fernández_González.chapter2.synchronizedCase.Unsafe;

/**
 * Description:
 * GET-version:
 * Date:2020-05-14  16:59
 * Author:wuxinrui
 */

public class UF_ParkingCash {
    private static final int cost=2;//停车费
    private long cash;//现金

    public UF_ParkingCash(){
        cash=0;
    }
    //总金额+每次缴费的金额
    public void vehiclePay(){
        cash=cash+cost;
    }
    //总金额清0 打印总金额
    public void close(){
        System.out.println("closing accounting");
        long totalAmount=cash;
        cash=0;
        System.out.printf("the total amount : %d",totalAmount);
    }



}
