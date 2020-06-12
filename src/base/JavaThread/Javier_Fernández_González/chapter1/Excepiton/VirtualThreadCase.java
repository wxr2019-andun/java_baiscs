package base.JavaThread.Javier_Fernández_González.chapter1.Excepiton;

/**
 * Description:
 * GET-version:
 * Date:2020-05-13  20:15
 * Author:wuxinrui
 */

public class VirtualThreadCase implements Runnable {
    @Override
    public void run() {
        int numero=Integer.parseInt("TTT");

    }

    public static void main(String[] args) {
        VirtualThreadCase virtualThreadCase = new VirtualThreadCase();
        Thread thread = new Thread(virtualThreadCase);
        thread.setUncaughtExceptionHandler(new VirtualUncaughtException());
        thread.start();

    }
}
