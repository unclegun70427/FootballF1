import java.util.*;
import java.util.stream.*;

public class w12_3_StreamInt 
{
    public static void main(String[] args) 
    {
       //IntStream mystream = IntStream.of(100, 200, 300, 400, 500);
        
        int [] myArray = {1, -3, 5, 7, -9, -10, 8, 6, 4, -2};  
        IntStream mystream = IntStream.of(myArray);

        System.out.print("Original list = ");
        mystream.forEach( arg -> System.out.printf("%d  ", arg) );
        System.out.print("\n\n");
        
        
        // (1) mystream from previous pipeline is terminated; so create a new one
        mystream = IntStream.of(myArray);             
        System.out.print("Positive & sorted list = ");
        mystream.filter( arg -> arg > 0 )                            // filter positives
                .sorted()                                            // sort
                .forEach( arg -> System.out.printf("%d  ", arg) );   // print each element
        System.out.print("\n");
        
        
        mystream = IntStream.of(myArray);
        double avg = mystream.filter( arg -> arg%2 !=0 )              // filter odds
                             .summaryStatistics().getAverage();       // get average
        System.out.printf("Average of odds = %.2f \n", avg);
        
        
        mystream = IntStream.of(myArray);
        int sumsquare = mystream.filter( arg -> arg%2 == 0 )          // filter evens
                                .reduce( 0, (arg1, arg2) -> arg1 = arg1 + arg2*arg2 );
                                //.reduce( 1000, (arg1, arg2) -> arg1 = arg1 + arg2*arg2 );
        System.out.printf("Sum of even-square = %d \n", sumsquare);
        
        mystream = IntStream.of(myArray);
        int product = mystream.map( arg -> Math.abs(arg) )            // absolute
                              .reduce( 1, (arg1, arg2) -> arg1 = arg1 * arg2 );
        System.out.printf("Product of absolutes = %,d \n", product);
    }
    
}
