import java.rmi.registry.*;
import java.util.Scanner;
class Client 
{
    private Client()
    {}
    public static void main(String args[])
    {
        try{
            int ch ,a=0,b=0; 
            Scanner sc = new Scanner(System.in);
        //String host =args[0];
         Registry registry = LocateRegistry.getRegistry("localhost");
         Adder stub = (Adder)registry.lookup("cal");
         while(true)
         {
                System.out.println("Enter:\n1.ADDITION \n2.SUBSTRACTION \n3.MULTIPLICATION \n4.DIVISION\n5.Exit ");
                ch =sc.nextInt();
                if(ch!=5)
                {
                  System.out.println("Enter Two Value:");
                  a=sc.nextInt();
                  b=sc.nextInt();
                }
                if(ch==1)
                {
                    System.out.println("ADDITION of "+a+" AND "+b+" is:"+stub.add(a, b));
                }
                else if(ch==2)
                {
                    System.out.println("SUBSTRACTION of "+a+" AND "+b+" is:"+stub.sub(a, b));
                }
                else if(ch==3)
                {
                    System.out.println("Multiplication of "+a+" AND "+b+" is:"+stub.mul(a, b));
                }
                else if(ch==4)
                {
                    System.out.println("DIVISION of "+a+" AND "+b+" is:"+stub.div(a, b));
                }
                else if(ch==5)
                {
                    break;
                }                   
         }
         sc.close();
         //System.out.println(stub.add(10,20));
        }
        catch(Exception e)
        {
            System.out.println(e);
        } 
    }
}