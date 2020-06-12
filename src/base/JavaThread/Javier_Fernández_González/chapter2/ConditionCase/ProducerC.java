package base.JavaThread.Javier_Fernández_González.chapter2.ConditionCase;

/**
 * Description:
 * GET-version:
 * Date:2020-05-15  16:42
 * Author:wuxinrui
 */

public class ProducerC implements Runnable{
    private FileMock fileMock;
    private Buffer buffer;

    public ProducerC(FileMock fileMock, Buffer buffer) {
            this.fileMock = fileMock;
            this.buffer = buffer;
        }

        @Override
        public void run() {
            buffer.setPendingLines(true);
//            如果读取下标不等于 总行数-就不断生产消息到   缓存列
            while (fileMock.hasMoreLines()){
                String line = fileMock.getLine();
                buffer.insert(line);
                System.out.printf("p-name %s build \n",Thread.currentThread().getName());
            }
            buffer.setPendingLines(false);
    }

}
