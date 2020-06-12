package base.JavaThread.Javier_Fernández_González.chapter3.CyclicBarrierCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  18:18
 * Author:wuxinrui
 */

public class Grouper implements Runnable{
    private  final  T3_Results t3_results;

    public Grouper(T3_Results t3_results) {
        this.t3_results = t3_results;
    }

    @Override
    public void run() {
        int finalResult=0;
        System.out.printf("石斑鱼:处理结果……\n");
        int data[]=t3_results.getData();
        for (int number:data){
            finalResult+=number;
        }
        System.out.printf("Grouper: 最后结果: %d.\n", finalResult);


    }
}
