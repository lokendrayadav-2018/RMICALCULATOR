import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public interface Adder extends Remote
{
    public int add(int a,int b) throws RemoteException;
    public int sub(int a,int b) throws RemoteException;
    public int mul(int a,int b) throws RemoteException;
    public float div(int a,int b) throws RemoteException;
}
class Calculator implements Adder
{
    public Calculator()
    {
    }
    public int add(int a,int b)
    {
        return a+b;
    }
    public int sub(int a,int b)
    {
        return a-b;
    }
    public int mul(int a,int b)
    {
        return a*b;
    }
    public float div(int a,int b)
    {
        return (float)a/b;
    }
    public static void main(String args[])
    {
        try{
        Calculator s = new Calculator();
        Adder  add = (Adder)UnicastRemoteObject.exportObject(s,0);
       Registry registry =LocateRegistry.getRegistry(); 
        registry.bind("cal",add);
       // Naming.bind("cal", add);
        } 
        catch( Exception e)
        {
            System.out.println(e);
        }
    }
}