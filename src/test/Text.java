package test;

import com.Solution;

import java.util.ArrayList;
import java.util.List;

public class Text {
    public static void main(String[] args) {
       /* String str="abc";
        char[] arr={'a','b','c'};
        String str2=new String(arr);
        str2=str2.intern();
        System.out.println(str==str2);
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            list.add(String.valueOf(i).intern());
            System.out.println(i);
        }
        System.out.println("over!");*/
        Solution solution=new Solution();
        int[] nums=new int[]{1,1,5};
        System.out.println(solution.minMoves(nums));
    }
}
//输出true 程序不结束
