package base.JavaThread.chapter3.PhaserCase;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-19  20:07
 * Author:wuxinrui
 */

public class FileSearch implements Runnable {
    private final String initPath;//存储将要搜索的文件夹路径：
    private final String fileExtension;//存储将要搜索的文件扩展名：
    private List<String> results;//存储满足搜索条件的文件的完整路径：
    private Phaser phaser;//Phaser属性，用来对任务的不同阶段进行同步控制：


    public FileSearch(String initPath, String fileExtension, Phaser phaser) {
        this.initPath = initPath;
        this.fileExtension = fileExtension;
        results = new ArrayList<>();
        this.phaser = phaser;
    }

    public void directoryProcess(File file) {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                //是目录的话则
                if (list[i].isDirectory()) {
                    //继续判断是否为，目录
                    directoryProcess(list[i]);
                } else {
                    //判断文件名 后缀是否为指定后缀名-如果是的话 返回文件绝对路径
                    fileProcess(list[i]);
                }
            }
        }
    }

    //判断文件名 后缀是否为指定后缀名-如果是的话 返回文件绝对路径
    public void fileProcess(File file) {
        if (file.getName().endsWith(fileExtension)) {
            //将文件后缀名符合-
            results.add(file.getAbsolutePath());
        }
    }

    //第一阶段的results列表进行过滤， 该方法将会剔除修改时间大于24小时的文件
    private void filterResults() {
        ArrayList<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();
            //比较文件的修改时间与当前时间，如果修改时间小于一天，则将文件的完整路径添加到新的结果列表中
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(results.get(i));
            }
        }
        results = newResults;
    }

    //将在第一阶段和第二阶段结束时被调用，它将会检查results -列表是否为空
    private boolean checkResults() {
    /*
     检查results列表的大小。如果列表为空，则向控制台输出相关信息，然后调用Phaser对象的
    arriveAndDeregister()方法，它表明当前线程已经完成当前阶段任务，并且不再参与后续阶段的工作
     */
        if (results.isEmpty()) {
            System.out.printf("%s: 相位器 %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());
            System.out.printf("%s: 相位器 %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());
            phaser.arriveAndDeregister();
            return false;
        }

        /*
        如果results列表不为空，则向控制台输出列表大小。然后，调用Phaser对象的
        arriveAndAdvance()方法，它表明该线程已经完成当前阶段的任务，并且希望等待其他参与该阶段的线程
        完成当前阶段任务
         */
        else {
            System.out.printf("%s: 相位器 %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(), results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    //来将最终的结果列表元素输出到控制台中：
    private void showInfo() {
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();//到达这个移相器并从其中注销，而无需等待别人到达。
        System.out.printf("%s: 开始.\n", Thread.currentThread().getName());

        File file = new File(initPath);

        if (file.isDirectory()) {
            directoryProcess(file);
        }
        if (!checkResults()) {
            return;
        }
        filterResults();
        if (!checkResults()) {
            return;
        }

        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: 完成工作.\n", Thread.currentThread().getName());

    }
}
