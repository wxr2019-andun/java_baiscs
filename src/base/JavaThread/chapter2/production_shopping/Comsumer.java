package base.JavaThread.chapter2.production_shopping;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  10:57
 * Author:wuxinrui
 */

public class Comsumer implements Runnable{
    private EventStorage eventStorage;

    public Comsumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            eventStorage.get();
        }
    }
}
