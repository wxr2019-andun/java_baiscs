package base.JavaThread.bilibili.JMM;

/**
 * Description:
 * GET-version:
 * Date:2020-05-16  17:04
 * Author:wuxinrui
 */

public class VolatileCase {
//    加入 volatile 后完成同步数据
//    还是看视频懂的多一点 霍霍霍-
    private volatile static boolean initFlag = false;


// 未加入 存在 綫程同步問題
//    private  static boolean initFlag = false;
    public static void prepareDate(){
        System.out.println("Changes in the data--begin");
        initFlag=true;
        System.out.println("Changes in the data--end");
    }

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("waiting data··");
                while (!initFlag) {
                }
                System.out.println("===success===");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareDate();
            }
        }).start();
    }

}
