package base.JavaThread.chapter3.CountDownLatchCase;

/**
 * Description: 还原电视会议-所有人链接频道-后 执行某线程
 * GET-version:
 * Date:2020-05-19  16:11
 * Author:wuxinrui
 */

public class CountDownLatchCase {
    public static void main(String[] args) {
        Videoconference videoconference = new Videoconference(10);
        Thread thread = new Thread(videoconference);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(videoconference,"participant："+i);
            Thread thread1 = new Thread(participant);
            thread1.start();
        }

    }
}
