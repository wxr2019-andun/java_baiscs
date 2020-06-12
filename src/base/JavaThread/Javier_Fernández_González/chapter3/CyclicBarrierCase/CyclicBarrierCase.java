package base.JavaThread.Javier_Fernández_González.chapter3.CyclicBarrierCase;

import java.util.concurrent.CyclicBarrier;

/**
 * Description:  [可以使多个线程在一个指定点同步的工具类]
 * GET-version:
 * Date:2020-05-19  17:35
 * Author:wuxinrui
 */

public class CyclicBarrierCase {
    public static void main(String[] args) {

        final int ROWS=10000;
        final int NUMBERS=1000;
        final int SEARCH=5;

        final int PARTICIPANTS=5;
        final int LINES_PARTICIPANT=2000;

        MatrixMock mock=new MatrixMock(ROWS, NUMBERS,SEARCH);
        T3_Results results=new T3_Results(ROWS);
        Grouper grouper=new Grouper(results);


        CyclicBarrier barrier=new CyclicBarrier(PARTICIPANTS,grouper);

        Searcher searchers[]=new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i]= new Searcher(i*LINES_PARTICIPANT,
                    (i*LINES_PARTICIPANT)+LINES_PARTICIPANT,mock,results,5,barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }
        System.out.println("主线程已经完成。");
    }
}
