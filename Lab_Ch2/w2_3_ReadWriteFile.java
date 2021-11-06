import java.io.*;
import java.util.*;

class w2_3_ReadWriteFile  
{
  public static void main(String[] args)  
  {
	String infile = "input.txt";
	String outfile = "output.txt";

	try 
        {
	  Scanner scan  = new Scanner(new File(infile));
	  PrintWriter write = new PrintWriter(outfile);

	  while (scan.hasNext()) 
          {							
	    String name	  = scan.next();
	    double height = scan.nextDouble();
	    int age = scan.nextInt();
            // Use \r\n when writing to file
            System.out.printf("%s  height = %.0f  age = %d \n", name, height*100, age);
            write.printf("%s  height = %.0f  age = %d \r\n", name, height*100, age);
	  }
          
	  scan.close();
	  write.close();
	}
	catch(Exception e) {
	  System.err.println("An error occurs. End program.");
	  System.exit(-1);
	}
  }
}