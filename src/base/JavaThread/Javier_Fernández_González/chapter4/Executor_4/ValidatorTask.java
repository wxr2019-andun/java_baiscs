package base.JavaThread.Javier_Fernández_González.chapter4.Executor_4;

import java.util.concurrent.Callable;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  12:10
 * Author:wuxinrui
 */

public class ValidatorTask implements Callable<String> {
    private final UserValidator userValidator;
    private final String user;
    private final String password;

    public ValidatorTask(UserValidator userValidator, String name, String password) {
        this.userValidator = userValidator;
        this.user = name;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        if (!userValidator.validator(user,password)) {
            System.out.printf("未找到 %s 用户 \n",userValidator.getName());
//            throw  new Exception("用户验证失败");
            throw  new Exception("error user validator");
        }
        System.out.printf(" %s 用户 验证成功 \n",userValidator.getName());
        return userValidator.getName();
    }
}
