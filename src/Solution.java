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

        /*System.out.println(sortStack(newStack));

        MyQueue queue=new MyQueue();*/

        System.out.println(removeKdigits("1111",3));



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

    /**Stack, remove k digits and print the lowest number possible*/

    public static String removeKdigits(String num, int k){

        int length=num.length();

        if(length==0) return "0";

        int i=0;
        Stack<Character> stack=new Stack<>();


        while(i<num.length()){


            while(k>0 && !stack.empty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!stack.empty()){
        sb.append(stack.pop());
        }
        sb.reverse();

        while(sb.length()>0 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);


        return sb.toString();
    }

}
