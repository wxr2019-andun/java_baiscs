package base.JavaThread.Javier_Fernández_González.chapter4.Executor_9;

import java.util.concurrent.FutureTask;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  17:03
 * Author:wuxinrui
 */

public class ResultTask extends FutureTask<String>{
    private final String name;
    public ResultTask(ExecutableTask executableTack){
        super(executableTack);
        this.name=executableTack.getName();
    }

    @Override
    protected void done() {
        if(isCancelled()){
            System.out.println(name+"  已取消");
        }
        else {
            System.out.println(name+"  已完成");
        }
    }
}
