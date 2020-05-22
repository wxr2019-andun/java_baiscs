package base.JavaThread.chapter3.phaserCase2;

import java.util.concurrent.Phaser;

/**
 * Description:
 * <p>
 * onAdvance()方法的默认实现为，如果相位器上注册的参与者数量为0，则返回true，否则为false。但
 * 是可以通过继承相位器类后重写onAdvance()方法，以便在每次相位器转变时都可执行一些自定义操作。本
 * 案例将模拟一场考试，它一共有3道考题，只有当所有同学完成当前考题后，才可以进入下一答题环节。
 *
 *
 *   getRegisteredParties  返回在此移动设备上注册的各方数量。
 *   arriveAndAwaitAdvance  到达这个移相器，等待其他人。
 *   register(登记) 添加一-个新的unririved party到这个移相器。
 *
 *
 *
 * GET-version:
 * Date:2020-05-20  14:54
 * Author:wuxinrui
 */

public class MyPhaser extends Phaser {


/*
判断参数phase的值来调用不同的辅助方法：如果phase的值等于0，
则调用studentsArrived()方法；如果phase的值等于1，则调用finishFirstExercise()方法；如果phase的
值等于2，则调用finishSecondExercise()方法；如果phase的值等于3，则调用finishExam()方法；否则，
返回true，这表示Phaser对象被终止
 */
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishSecondExercise();
            case 3:
                return finishExam();
            default:
                return true;
        }
    }

    //初始提示
    private boolean studentsArrived() {
        System.out.printf("相位器: 考试就要开始了。学生们准备好了.\n");
        System.out.printf("相位器: 有 %d 个学生.\n", getRegisteredParties());
        return false;
    }
    //第一道题
    private boolean finishFirstExercise() {
        System.out.printf("相位器:所有的学生都完成了第一题.\n");
        System.out.printf("相位器: 轮到第二个了.\n");
        return false;
    }
    //    第二道题
    private boolean finishSecondExercise() {
        System.out.printf("相位器: 所有的学生都完成了第二题.\n");
        System.out.printf("相位器:轮到第三个了.\n");
        return false;
    }
    //    第三道题
    private boolean finishExam() {
        System.out.printf("相位器: 所有的学生都完成了第三题.\n");
        System.out.printf("相位器: 感谢参与.\n");
        return true;
    }
}
