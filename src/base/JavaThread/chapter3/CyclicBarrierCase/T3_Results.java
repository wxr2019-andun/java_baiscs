package base.JavaThread.chapter3.CyclicBarrierCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  17:32
 * Author:wuxinrui
 */

public class T3_Results {
    private final int data[];

    public T3_Results(int size) {
        data=new int[size];
    }
    public void setData(int position,int values){
        data[position]=values;
    }
    public int[] getData(){
        return data;
    }

}
