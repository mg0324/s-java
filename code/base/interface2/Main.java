package code.base.interface2;

public class Main {
    public static void main(String[] args) {
        // ChargeFace接口 来引用实现类对象变量
        ChargeFace apple = new Apple();
        apple.type();
        
        // 子类引用，则可以调用到Price上的接口方法
        Huawei huawei = new Huawei();
        huawei.type();
        huawei.value();
    }
}
