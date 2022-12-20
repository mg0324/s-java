package code.base.extend;
/**
 * 狗类
 */
public class Dog extends Animal{

    protected Dog(String name, Integer age) {
        super(name, age);
        this.type = "狗狗";
    }
    
}
