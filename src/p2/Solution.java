package p2;


import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public int[] solution(int[] a, int[] b) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 0;

        if (a.length > b.length) {
            int[] preB = b.clone();
            b = new int[a.length];
            for (int i = 0; i < preB.length; i++) {
                b[b.length-preB.length+i] = preB[i];
            }
        }
        if (a.length < b.length) {
            int[] preA = a.clone();
            a = new int[b.length];
            for (int i = 0; i < preA.length; i++) {
                a[a.length-preA.length+i] = preA[i];
            }
        }

        for (int i = a.length-1; i >= 0 ; i--) {
            if (((a[i] + b[i]) % 10)+carry >= 10) {
                list.add((((a[i] + b[i]) % 10)+carry)%10);
                carry = ((a[i] + b[i]) / 10) + 1;
            } else {
                list.add(((a[i] + b[i]) % 10)+carry);
                carry = (a[i] + b[i]) / 10;
            }

            if (i == 0) {
                if (carry == 1) {
                    list.add(carry);
                }
            }

        }
        Collections.reverse(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}