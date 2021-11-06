import java.util.*;
import java.io.*;

/////////////////////////////////////////////////////////////////////////////////////////////
class MyCalculator
{
    private String   fileName;
    private Scanner  keyboardScan;
    private int      sum;
    
    public MyCalculator(String fn)                
    {
        fileName  = fn; 
        keyboardScan = new Scanner(System.in);
    }
    
    public void processLine(String line)
    {
        int numerator, divisor, result = 0;
        try
        {
            String []buf = line.split("\\s+");         // split by one or more spaces
			numerator = Integer.parseInt(buf[0]);
            divisor   = Integer.parseInt(buf[1]);
            result    = numerator / divisor;
            System.out.printf("%2d / %2d = %d \n", numerator, divisor, result);
        }
        catch(RuntimeException e) 
        {   
            System.out.println(e + " --> skip");
            result = 0; 
        }
        finally
        {
            sum = sum + result;
        }
    }
    
    public void skipOld() 
    {
        // ----- (1) declare fileScan outside try-block, so it can be used in finally-block
        Scanner fileScan = null;
        try 
        {
            fileScan = new Scanner(new File(fileName));
            while(fileScan.hasNext())  
            { 
                processLine(fileScan.nextLine());
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println(e);
        }
        finally 
        {
            // ----- (1) close the file, either with or without an exception
            if (fileScan != null) fileScan.close();
            System.out.printf("Finally >> Sum = %d \n", sum);
        }
    }
    
    public void skipNew() 
    {
        try (
            // ----- (2) declare fileScan in resource declaration of try-block
            //           it can be used only in try-block & close automatically
            Scanner fileScan = new Scanner(new File(fileName));
        ){
            while(fileScan.hasNext())  
            { 
                processLine(fileScan.nextLine());
            }
        }
        catch (FileNotFoundException e) 
        {
            System.out.println(e);
        }
        finally 
        {
            System.out.printf("Finally >> Sum = %d \n", sum);
        }
    }
    
    public void enforceRemedy() 
    {
        boolean opensuccess = false;
        while (!opensuccess)
        {
            try (
                Scanner fileScan = new Scanner(new File(fileName));
            ){
                opensuccess = true;                
                while(fileScan.hasNext())  
                { 
                    processLine(fileScan.nextLine());
                }
            }
            catch (FileNotFoundException e) 
            {
                System.out.print(e + " --> ");
                System.out.print("New file name = ");
                fileName = keyboardScan.next();
            }
            finally 
            {
                System.out.printf("Finally >> Sum = %d \n", sum);
            }
        }
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////
public class w5_5_TryResource 
{
    public static void main(String[] args) 
    {
        String [] files = {"correctone.txt", "correctzero.txt", "wrong.txt"};
        
        MyCalculator calc = new MyCalculator( files[2] );
        calc.skipOld();
        //calc.skipNew();
        //calc.enforceRemedy();
    }    
}
