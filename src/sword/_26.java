package sword;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
 *
 * @author Radon Freedom
 * created at 2019.01.31 9:27
 */

public class _26 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA == null || popA == null || pushA.length == 0 || pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        stack.push(pushA[pushIndex++]);
        while (!stack.empty()) {
            if (stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
            if (pushIndex < pushA.length) {
                stack.push(pushA[pushIndex++]);
            }
            else {
                while (!stack.empty()) {
                    if (stack.pop() != popA[popIndex++]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
