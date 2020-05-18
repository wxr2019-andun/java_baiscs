package base.JavaThread.chapter1.factoryCase;

/**
 * Description:
 *
 * 便于修改被创建对象的类或其创建方式。
 * 便于依据有限资源来限制对象的创建，如对于给定类型，最多可以创建其n个实例对象。
 * 便于为对象的创建生成统计信息。
 *
 * GET-version:
 * Date:2020-05-14  11:41
 * Author:wuxinrui
 */

public class TFCase {
    public static void main(String[] args) {
        VirtualMyThreadFactory virtualMyThreadFactory = new VirtualMyThreadFactory("virtualMyThreadFactory");
        FactoryTack factoryTack = new FactoryTack();

        Thread thread;
        for (int i = 0; i < 10; i++) {
            thread=virtualMyThreadFactory.newThread(factoryTack);
            thread.start();
        }
        System.out.println("factory stats-");
        System.out.printf("%s \n",virtualMyThreadFactory.getStatus());

    }
}
