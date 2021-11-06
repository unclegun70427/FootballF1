class MyThread extends Thread
{
    MyThread(String name)	{ super(name); }

    public void run()
    {
	// ----- (4) when doing (4.1) and (4.2), notice the difference between these loops
	// ----- (5) when doing (5.1) and (5.2), try using yield()
		
	for (int i=1; i<=200; i++)	
	{ 
            System.out.print(this.getName() + " "); 
            //if (i%5 == 0) yield(); 
	}
		
		
	/*
        for (int i=1; i<=200; i++)	
	{ 
            System.out.print(Thread.currentThread().getName() + " "); 
            //if (i%5 == 0) yield();
	}
	*/
    }
};

//////////////////////////////////////////////////////////////////////////////////////////////////
class w6_1_Createthread
{
    public static void main(String[] args) 
    {
	// ----- (1) check all possible states of a thread
	Thread.State states[] = Thread.State.values();
	System.out.print("Possible states = ");
	for (int i=0; i < states.length; i++)
	{
            System.out.print(states[i] + "  ");
	}
	System.out.println("\n");


	// ----- (2) get name and state of this current thread
	Thread T = Thread.currentThread();
	System.out.printf("Name = %s, State = %s \n", T.getName(), T.getState());


	// ----- (3) create new thread from class "Thread"
	//           (3.1) call start()
	//           (3.2) call run()
	Thread NT = new Thread();
	//NT.start();  System.out.printf("<NT> Name = %s, State = %s \n", NT.getName(), NT.getState());
	//NT.run();    System.out.printf("<NT> Name = %s, State = %s \n", NT.getName(), NT.getState());


	// ----- (4) create new threads from class "MyThread"
	//           (4.1) call start()
	//           (4.2) call run()
        MyThread MT1 = new MyThread("A");
	MyThread MT2 = new MyThread("B"); 
	//MT1.start();  MT2.start();
	//MT1.run();  MT2.run();
	

	// ----- (5) comment (4.1) and (4.2)
	//           (5.1) check thread priorities
	//           (5.2) set new thread priorities
	/*
	System.out.printf("<%s> Priority = %d \n", T.getName(), T.getPriority());
	System.out.printf("<%s> Priority = %d \n", MT1.getName(), MT1.getPriority());
	System.out.printf("<%s> Priority = %d \n\n", MT2.getName(), MT2.getPriority());
	MT1.start();  MT2.start();
	*/

	/*
	MT2.setPriority(Thread.NORM_PRIORITY + 3); 
	System.out.printf("<%s> Priority = %d \n", T.getName(), T.getPriority());
	System.out.printf("<%s> Priority = %d \n", MT1.getName(), MT1.getPriority());
	System.out.printf("<%s> Priority = %d \n\n", MT2.getName(), MT2.getPriority());	
	MT1.start();  MT2.start();
	*/


	System.out.println("\n\n---------- Good Bye -----------");
    }
}
