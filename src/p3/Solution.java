package p3;

import java.util.Stack;

public class Solution {
    public String solution(String code) {

        Stack<Integer> integerstack = new Stack<>();
        Stack<Character> stringstack = new Stack<>();
        String temp = "", answer = "";
        char[] codeArr = code.toCharArray();
        boolean strFlag = false;

        for (int i = 0; i < code.length(); i++) {

            // 만약 숫자면 인트형 숫자로 변환
            // 푸쉬백 인티저스택
            int count;
            if (codeArr[i] >= '0' && codeArr[i] <= '9') {
                count = Character.getNumericValue(codeArr[i]);
                integerstack.push(count);
            }
            // 만약 여는 괄호 나오면 문자열 스택에 푸쉬!
            else if (codeArr[i] == '{') {
                if (codeArr[i - 1] >= '0' && codeArr[i - 1] <= '9') {
                    stringstack.push(codeArr[i]);
                } else {
                    stringstack.push(codeArr[i]);
                    integerstack.push(1);
                }
            } else if (codeArr[i] == '}') {
                temp = "";
                count = 0;

                if (!integerstack.empty()) {
                    count = integerstack.pop();
                    integerstack.pop();
                }

                while (!stringstack.empty() && (stringstack.pop() != '{')) {
                    temp = stringstack.pop() + temp;
                    stringstack.pop();
                }

                if (!stringstack.empty() && stringstack.pop() == '{')
                    stringstack.pop();

                //팝 된 문자열열을 반복! 카운트만큼!
                for (int j = 0; j < count; j++)
                    answer = answer + temp;

                // 캐릭터스택으로 푸쉬!!
                char[] answerArr = answer.toCharArray();
                for (int j = 0; j < answer.length(); j++)
                    stringstack.push(answerArr[j]);

                answer = "";
            } else {
                stringstack.push(codeArr[i]);
            }
        // 모든 데이터를 팝하고, 문자열을 만들어 리턴
        }
        while (!stringstack.empty()) {
            answer = stringstack.pop() + answer;
            stringstack.pop();
        }
        return answer;
    }
}