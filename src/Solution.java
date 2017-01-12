/**
 * Created by Pranith on 1/12/17.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args){

        Stack<Integer> newStack=new Stack<>();
        newStack.push(1);
        newStack.push(3);
        newStack.push(2);
        newStack.push(4);

        System.out.println(sortStack(newStack));


    }

    public static Stack<Integer> sortStack(Stack<Integer> stack){

        if(stack.empty() || stack==null) return stack;

        Stack<Integer> newStack=new Stack<>();

        newStack.push(stack.pop());

        while(!stack.empty()){
            int temp=stack.pop();
            while(newStack.empty() && temp>newStack.peek()){
                stack.push(newStack.pop());

            }
            newStack.push(temp);
        }

        return newStack;
    }
}
