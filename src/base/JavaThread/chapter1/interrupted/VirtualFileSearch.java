package base.JavaThread.chapter1.interrupted;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Description: 线程中断- 创建中断异常-中断线程
 * GET-version:
 * Date:2020-05-13  11:13
 * Author:wuxinrui
 */

public class VirtualFileSearch implements Runnable {
    private String initPaht;
    private String fileName;

    public VirtualFileSearch() {
    }

    public VirtualFileSearch(String initPaht, String fileName) {
        this.initPaht = initPaht;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        //获取
        File file = new File(initPaht);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.printf("%s: The search has been interrupted", Thread.currentThread().getName());
            }
        }
    }

    //递归查询目录文件
    private void directoryProcess(File file) throws InterruptedException {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
        }
    }


    //
    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.printf("%s : %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        //线程为中断状态-throws 创建中断异常
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public static void main(String[] args) {
        VirtualFileSearch searcher = new VirtualFileSearch("C:\\Windows", "explorer.exe");
        Thread thread = new Thread(searcher);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }


}
