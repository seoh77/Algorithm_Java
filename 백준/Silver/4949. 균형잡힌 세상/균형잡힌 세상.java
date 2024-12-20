import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // 입력 문자열 읽기
            String input = br.readLine();
            if (input.equals(".")) break; // 종료 조건

            // 균형 판단
            System.out.println(isBalanced(input) ? "yes" : "no");
        }
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            // 여는 괄호는 스택에 추가
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // 닫는 괄호는 짝 확인
            else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            }
        }

        // 스택이 비어있으면 균형이 맞음
        return stack.isEmpty();
    }
}
