package base.JavaThread.Javier_Fernández_González.chapter4.Executor_10;

import java.util.concurrent.CompletionService;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  18:07
 * Author:wuxinrui
 */

public class ReportRequest implements Runnable {
    private final String name;
    private final CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name,"report");
        service.submit(reportGenerator);
    }

}
