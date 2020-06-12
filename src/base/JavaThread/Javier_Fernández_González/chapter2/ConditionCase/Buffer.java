package base.JavaThread.Javier_Fernández_González.chapter2.ConditionCase;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  15:45
 * Author:wuxinrui
 */

public class Buffer {

    private final LinkedList<String> buffer;
    private final int maxSize;
    private final ReentrantLock lock;
    private final Condition lines;
    private final Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public synchronized void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    public synchronized boolean hasPendingLines() {
        return pendingLines || buffer.size()>0;
    }

    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
//                也就是说-   space（）Condition
                space.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) &&(hasPendingLines())) {
                lines.await();
            }
            if (hasPendingLines()) {
                line = buffer.poll();
                System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }



    /*
     private final LinkedList<String> buffer;// 共享数据？
    private final int maxSize;//缓冲区长度
    private final ReentrantLock lock; //锁
    private final Condition lines; //？ 对锁的处理方式-
    private final Condition space; //?
    private boolean pendingLines; //判断是否存在为读取数据的标识-

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();
        ;//获取锁
        try {
//        共享数据长度 = 缓冲长度  线程睡眠
            while (buffer.size() == maxSize) {
                space.await();
            }
//        queue ADD srt
            buffer.offer(line);
//        线程x-插入数据x行
            System.out.printf("%s: inserted line %d \n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.lock();//释放锁
        }
    }


//    有未读行 或 共享数据-长度 大于0   返回 真
    public synchronized boolean hasPendingLine(){
        return  pendingLines || buffer.size()>0;
    }


    public String get(){
        String line = null;
        lock.lock();
        // 共享数组 长度=0 且 x方法为真   线程睡眠-应该说中断此线程
        try {
            while ((buffer.size()==0) && (hasPendingLine())){
                lines.await();
            }
//            若有为读取数据-返回队列末位数据- 释放锁
            if(hasPendingLine()){
                line = buffer.poll();
                System.out.printf("%s line read : %d",Thread.currentThread().getThreadGroup(),buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return  line;

    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }
     */

}
