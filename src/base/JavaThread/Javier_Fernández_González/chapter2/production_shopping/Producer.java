package base.JavaThread.Javier_Fernández_González.chapter2.production_shopping;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  10:56
 * Author:wuxinrui
 */

public class Producer implements Runnable{
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            eventStorage.set();
        }
    }
}
