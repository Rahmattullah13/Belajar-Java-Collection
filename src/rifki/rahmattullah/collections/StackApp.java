package rifki.rahmattullah.collections;

import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("Rifki");
        stack.push("Rahmattullah");

        for (var value = stack.pop(); value != null; value = stack.pop()) {
            System.out.println(value);
        }
    }
}
