package pers.yjw.platform.demo;

import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo
 * @description:
 * @author: YaoJianwei
 * @create: 2019-07-22 10:54
 */
public class GsonTest {
    public static void main (String... args) {
        String appCacheKey = "jordan:app:test1:a,jordan:app:test2:b,jordan:app:test3:c,jordan:app:test1:d";
        String[] arrAppCacheKey = appCacheKey.split(",");
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < arrAppCacheKey.length; i++) {
            if (arrAppCacheKey[i].indexOf("test1") != -1) {
                list.add(arrAppCacheKey[i]);
            }
        }
        System.out.println(Arrays.toString(list.toArray((new String[list.size()]))));
    }
}
