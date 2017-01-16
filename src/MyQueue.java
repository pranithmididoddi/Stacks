import java.util.Stack;

/**
 * Created by Pranith on 1/12/17.
 */
public class MyQueue {

    Stack<Integer> value=new Stack<>();
    Stack<Integer> temp=new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                temp.push(value.pop());
            }
            value.push(x);
            while(!temp.isEmpty()){
                value.push(temp.pop());
            }
        }

    }
    // Removes the element from in front of queue.
    public void pop() {
        value.pop();

    }

    // Get the front element.
    public int peek() {
        return value.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return value.isEmpty();
    }
}