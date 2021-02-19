package pers.yjw.platform.design.model.created;

import lombok.*;

import java.io.*;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 浅拷贝
        Prototype prototype1 = Prototype.builder().address("hangzhou").num(1).
                serializableObject(new SerializableObject("jack", 22)).build();
        Prototype prototype2 = prototype1.clone();
        System.out.println("original:" + prototype1);
        System.out.println("clone:" + prototype2);
        System.out.println(prototype1 == prototype2);
        System.out.println(prototype1.getNum() == prototype2.getNum());//基本类型比较
        System.out.println(prototype1.getAddress() == prototype2.getAddress());//引用类型比较
        System.out.println(prototype1.getSerializableObject() == prototype2.getSerializableObject());//引用类型比较

        System.out.println("-----------------------------------------------------------");
        // 深拷贝
        Prototype prototype3 = Prototype.builder().address("hangzhou").num(1).
                serializableObject(new SerializableObject("jack", 22)).build();
        Prototype prototype4 = prototype3.deepClone();
        System.out.println("original:" + prototype3);
        System.out.println("clone:" + prototype4);
        System.out.println(prototype3 == prototype4);
        System.out.println(prototype3.getNum() == prototype4.getNum());//基本类型比较
        System.out.println(prototype3.getAddress() == prototype4.getAddress());//引用类型比较
        System.out.println(prototype3.getSerializableObject() == prototype4.getSerializableObject());//引用类型比较
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class Prototype implements Cloneable, Serializable {
    private static final long serialVersionUID = -3098108553085232155L;
    private String address;
    private int num;
    private SerializableObject serializableObject;

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return ((Prototype) super.clone());
    }

    /* 深复制 */
    public Prototype deepClone() {

        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            /* 读出二进制流产生的新对象 */
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return ((Prototype) ois.readObject());
        }	catch (ClassNotFoundException e) {
            e.printStackTrace();
        }   catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "(hashCode:"+super.hashCode() + ") Prototype{" +
                "address='" + address + '\'' +
                ", num=" + num +
                ", serializableObject=" + serializableObject +
                '}';
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class SerializableObject implements Serializable {
    private static final long serialVersionUID = 2473800295229655303L;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "(hashCode:" + super.hashCode() + ") SerializableObject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}