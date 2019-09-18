package Arithmetic;

/**
 * Author:wuxinrui
 * Date:2019-09-11  16:02
 * Description:
 */

public  class  StackTest {
    // 栈容器
    public Object [] obj;
    //栈长度
    public int size;
    //栈顶
    public int top;

    //初始化构造器
    public StackTest(int length){
        size=length;
        obj= new Object[size];
        top=-1;//指针为-1时 表栈无数据
    }
    //判断栈是否已满
    public boolean isFull(){
        return (top==size-1);//入栈也在栈顶 数组下标从0开始故长度-1
    }
    //入栈
    public void push(Object o){
        if(isFull()){
            System.out.println("full");
        }
        obj[++top]=o;
    }
    //出栈
    public Object pop(){
        //System.out.println(obj.length);  //没有删除吧..
        return obj[top--];
    }

    public static void main(String[] args) {
        char [] c = new char[]{'q','z','h','s','f','a','d','s'};
        StackTest s = new StackTest(c.length);
        for(int i=0;i<c.length;i++){
            s.push((char)c[i]);
        }
        for(int i=0;i<c.length;i++){
            System.out.println((char)s.pop());
        }
    }



}
