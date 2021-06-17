package com;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        int sum=0;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] ss=s.toCharArray();
        for (int i = 0; i < ss.length-1; i++) {
            for (int j = i+1; j <ss.length; j++) {
                if (map.get(ss[i])<map.get(ss[j])){
                    sum=sum-(map.get(ss[i])*2);
                }
            }
            sum=sum+map.get(ss[i]);
        }
        sum=sum+map.get(ss[ss.length-1]);
        return sum;
    }
    public int reverse(int x) {
        String s=Integer.toString(x);
        char[] chars=s.toCharArray();
        char[] target=new char[chars.length];
        if (chars[0]=='-'){
            target[0]='-';
            for (int i = 1; i < chars.length; i++) {
                target[i]=chars[chars.length-i];
            }
        }
        return Integer.parseInt(String.valueOf(target));
    }
    public int minMoves(int[] nums) {
        int n=0;
        int maxindex=0;
        boolean eq=true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[0]!=nums[i]){
                eq=false;
            }
        }
        if (eq){
            return 0;
        }
        while (true){
            eq=true;
            n++;
            maxindex=max(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i!=maxindex){
                    nums[i]=nums[i]+1;
                }
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[0]!=nums[i]){
                    eq=false;
                    break;
                }
            }
            if (eq) {
                return n;
            }
        }
    }
    public int max(int[] nums){
        int index=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>nums[index]){
                index=i;

            }
        }
        return index;
    }
}
