package p1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        // 가장 작은 수 찾기
        Arrays.sort(numbers);
        // numbers[0]이 최소값

        // 배열에 다음 수가 있는지 확인
        int min = numbers[0];
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < numbers.length; i++) {
                if (i == 0) {
                    continue;
                } else if (numbers[i] == min+1) {
                    min += 1;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        answer = min+1;
        return answer;
    }
}