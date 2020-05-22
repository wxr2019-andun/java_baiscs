package base.JavaThread.chapter4.Executor_10;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  18:11
 * Author:wuxinrui
 */

public class ReportProcessor implements Runnable {
    private final CompletionService service;
    private volatile  boolean end;

    public ReportProcessor(CompletionService service) {
        this.service = service;
        end=false;
    }

    @Override
    public void run() {
        while(!end){
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                String report = result.get()
;                System.out.println("report-receiver: report received ");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
