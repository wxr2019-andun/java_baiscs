package base.JavaThread.Javier_Fernández_González.chapter3.CyclicBarrierCase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  18:17
 * Author:wuxinrui
 */

public class Searcher implements Runnable{
    private final int firstRow;
    private final int lastRow;
    private final MatrixMock matrixMock;
    private final T3_Results t3_results;
    private final int number;
    private final CyclicBarrier cyclicBarrier;

    public Searcher(int firstRow, int lastRow, MatrixMock matrixMock, T3_Results t3_results, int number, CyclicBarrier cyclicBarrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.matrixMock = matrixMock;
        this.t3_results = t3_results;
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: 处理内容 %d to %d.\n", Thread.currentThread().getName(), firstRow,lastRow);

        for (int i=firstRow; i<lastRow; i++){
            int row[]=matrixMock.getRow(i);
            counter=0;
            for (int j=0; j<row.length; j++){
                if (row[j]==number){
                    counter++;
                }
            }
            t3_results.setData(i, counter);
        }

        System.out.printf("%s: 行处理.\n", Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
