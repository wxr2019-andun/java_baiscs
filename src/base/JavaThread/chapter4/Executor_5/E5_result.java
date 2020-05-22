package base.JavaThread.chapter4.Executor_5;

/**
 * Description:
 * GET-version:
 * Date:2020-05-22  14:28
 * Author:wuxinrui
 */

public class E5_result {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "E5_result{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
