package Queue;

import java.util.HashMap;

public class Queue {
    private static int[] selfQueue;
    private static  int count;
    public Queue(int size) {
        selfQueue=new int[size];
        count=0;

    }
    public boolean enque(int value)
    {
        if(count>selfQueue.length)
        {
            System.out.println("Queue is full");
            return false;
        }
        selfQueue[count]=value;
        count++;
        return true;
    }
    public boolean deque()
    {
        if(count==0)
        {
            System.out.println("No Value in queue");
            return false;
        }
        count--;
        return true;

    }
    public int  size()
    {

        return count;

    }
    public void  print()
    {
       for(int i=0;i<count;i++)
       {
           System.out.println(selfQueue[i]);
       }

    }

    public static void main(String[] args) {
        Queue queue=new Queue(5);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        queue.enque(6);
        queue.deque();
        queue.deque();
        queue.print();


    }
}
