package lesson8_task1_level2;

import java.util.Arrays;

public class Stack {
    private Object[] stack;

    private int size;

    private int capacity = 16;

    private int maxLength = Integer.MAX_VALUE;

    public Stack() {
        stack = new Object[capacity];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void push(Object obj){
        try {
            if (size >= stack.length){
                if(stack.length < maxLength){
                    newSize();
                }else{
                    throw new IllegalArgumentException();
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println("Вы вышли за границу стека");
            System.exit(0);
        }

        stack[size] = obj;
        size++;
    }

    public Object pop(){
        try {
            if (size == 0) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Вы вышли за границу стека");
            System.exit(0);
        }

        Object obj = stack[size - 1];
        stack[size - 1] = null;
        size--;

        return obj;
    }

    public Object peek(){
        try {
            if (size == 0) throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Вы вышли за границу стека");
            System.exit(0);
        }

        return stack[size-1];
    }

    private void newSize (){
        if(capacity * 2 <= maxLength) {
            capacity *= 2;
            stack = Arrays.copyOf(stack, capacity);
        }else{
            stack = Arrays.copyOf(stack, maxLength);
        }
    }



}
