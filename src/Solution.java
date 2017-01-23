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

        //System.out.println(removeKdigits("12",2));
        String[] str= { "2", "1", "+", "3", "*" };
        System.out.println(evalrevpol(str));



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

        if(sb.length()==0) return "0";


        return sb.toString();
    }

    /**Reverse polish notation using stacks*/
    public static int evalrevpol(String[] tokens){

        Stack<String> stack=new Stack<>();
        String string="+-/*";
        int val=0;

        for(String s:tokens){
            if(!string.contains(s)){
                stack.push(s);
            }
            else{
                int a=Integer.valueOf(stack.pop());
                int b=Integer.valueOf(stack.pop());
                switch (s){
                    case "+":
                        stack.push(String.valueOf(a+b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b-a));
                        break;
                    case "/":
                        stack.push(String.valueOf(a/b));
                        break;
                    case "*":
                        stack.push(String.valueOf(a*b));
                        break;
                }
            }

        }
        val=Integer.valueOf(stack.pop());
        return val;
    }

    public void printhello(){
        System.out.println("Just saving the day on github");

    }

}
