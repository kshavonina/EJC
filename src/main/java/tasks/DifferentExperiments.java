package tasks;

import java.util.*;

public class DifferentExperiments {
    public static void main(String[] args) {
        String a = "string a";
        String b = new String("string a");
        String c = b.intern();

        System.out.println(a == b); //false
        System.out.println(b == c); //false
        System.out.println(a == c); //true

        System.out.println();

        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");

        System.out.println("s1 == s2 :"+(s1==s2)); //s1 == s2 :true
        System.out.println("s1 == s3 :"+(s1==s3)); //s1 == s3 :false

        String s = "ABCDEFG";
        StringBuilder stringBuilder = new StringBuilder(s);
        stringBuilder.reverse();
        System.out.println(stringBuilder.toString()); //GFEDCBA

        System.out.println(removeChar("blablablah", 'a'));

        System.out.println(new Recursion());

        Integer[][] array = {{5, 4, 5, 3},
                            {2, 3, 4}};
        System.out.println(Arrays.deepToString(array));

        Integer[] array2 = {5, 4, 5, 3};
        System.out.println(Arrays.toString(array2));

        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(9990);
        System.out.println(list.get(1));

    }

    public static String removeChar(String str, char ch) {
        if (str == null)
            return null;
        return str.replaceAll(String.valueOf(ch), "");
    }
}
