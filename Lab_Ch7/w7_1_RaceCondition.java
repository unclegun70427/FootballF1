import java.util.concurrent.*;
// how to fix this by using (1) semaphore, (2) monitor

class MyThread1 extends Thread
{
    private Buffer1 buffer;
    public MyThread1(String name)       { super(name); }
    public void setBuffer(Buffer1 b)    { buffer = b; }
    
    public void run()                       
    {
	buffer.add();
    }
};

///////////////////////////////////////////////////////////////////////////////////////
class Buffer1
{
    private int sum = 0;
    public Buffer1()                    {}
            
    public void add()
    {
	for (int i=0; i < 5; i++)
        {
            sum++;
            int delay = (int)(Math.random() * 123);
            try { Thread.sleep(delay); } catch(InterruptedException e) { }
	}
	System.out.println(Thread.currentThread().getName() + "   " + sum);
    }
};

///////////////////////////////////////////////////////////////////////////////////////
class w7_1_RaceCondition 
{
    public static void main(String[] args) 
    {
	Buffer1 buffer = new Buffer1();

	MyThread1 [] T = { new MyThread1("A"), 
                           new MyThread1("B"), 
                           new MyThread1("C") };

        for(int i=0; i < T.length; i++) T[i].setBuffer(buffer); 
        for(int i=0; i < T.length; i++) T[i].start();
    }
}
