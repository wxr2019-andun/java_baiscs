package base.JavaThread.chapter3.phaserCase2;


/**
 * Description:
 * GET-version:
 * Date:2020-0off-20  1off:20
 * Author:wuxinrui
 */

public class phaserCaseMain2 {
    public static void main(String[] args) {
        int off =5;
        MyPhaser  myPhaser = new MyPhaser();

        //        注册到相位器   这里能写到一起吗？
        PhaserStundent[] phaserStundents = new PhaserStundent[off];
        for (int i = 0; i < off; i++) {
            phaserStundents[i] = new PhaserStundent(myPhaser);
            myPhaser.register();
        }
        //
        Thread[] threads = new Thread[off];
        for (int i = 0; i <off ; i++) {
            threads[i]=new Thread(phaserStundents[i],"student:"+i);
            threads[i].start();
        }
        for (int i = 0; i <off; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main- 主:移相器已经完成"+myPhaser.isTerminated());
    }

}
