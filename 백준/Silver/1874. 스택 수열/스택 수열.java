import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 총 입력 개수
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        int lastIdx = 0; // 마지막으로 push한 숫자
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            // 필요한 숫자까지 스택에 push
            if (lastIdx < num) {
                while (lastIdx < num) {
                    stack.push(++lastIdx);
                    sb.append("+\n");
                }
            }
            
            // 스택의 top이 num과 같다면 pop
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                // pop할 수 없는 경우
                System.out.println("NO");
                sc.close();
                return;
            }
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
