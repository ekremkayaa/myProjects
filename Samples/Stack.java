public class Stack {
    private int array[];
    private int top;
    private int capacity;

    Stack(int capacity){
        this.array = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    public void push(int item){
        if(isFull())
            throw new RuntimeException("Stack is full");
        array[++top] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
        return array[top--];
    }

    public int peek(){
        if(isEmpty())
            throw new RuntimeException("Stack is empty");
        return array[top];
    }

    public boolean isFull(){
        return this.capacity - 1 == this.top;
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

}
