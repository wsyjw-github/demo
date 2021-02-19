package pers.yjw.platform.demo;

import pers.yjw.platform.demo.dto.PartnerModify2Dto;

import java.lang.reflect.Field;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo
 * @description:
 * @author: YaoJianwei
 * @create: 2019-07-15 13:46
 */
public class ClassTest {

    public static void main(String... args) throws Exception {
        int a= (Integer)A.class.getDeclaredField("fild").get(new A()) ;
//        int c= (Integer)field.get(null) ; //不是静态字段不能传null
        System.out.println("a:"+a);

        int b= (Integer)A.class.getDeclaredField("staticFild").get("") ;
        int d= (Integer)A.class.getDeclaredField("staticFild").get(null) ;
        System.out.println("b:"+b);
        System.out.println("d:"+d);



        Object obj = new PartnerModify2Dto();
        Boolean flag = isPrimitive(obj);
        System.out.println(flag);

        String partnerCode = "DyyTest";
        Boolean flag2 = isPrimitive(partnerCode);
        System.out.println(flag2);

        Integer age = 10;
        Boolean flag3 = isPrimitive(age);
        System.out.println(flag3);


        Object arg = partnerCode;
        Class<?> aClass = arg.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields){
            System.out.println("fieldName：" + field.getName());
        }




    }

    private static boolean isPrimitive(Object obj) {
        try {
            return ((Class<?>)obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}


class A {
    int fild=3;
    static int staticFild=4;
}

class B extends A {

}