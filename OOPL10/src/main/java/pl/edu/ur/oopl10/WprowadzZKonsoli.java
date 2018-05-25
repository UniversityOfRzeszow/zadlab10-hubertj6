package pl.edu.ur.oopl10;



import java.util.*;

public class WprowadzZKonsoli {
    Scanner input = new Scanner(System.in);
    
    public void wprowadzInt(){
        int x;
        try{
        System.out.println("Podaj liczbe calkowita: ");
        x = input.nextInt();
        }
        catch(InputMismatchException e1){
            System.out.println("Podana liczba nie jest liczba calkowita. Przerwanie programu!");
        }
    }
    public void wprowadzChar(){
        String x;
        try{
        System.out.println("Podaj pojedynczy znak: ");
        x = input.next();
        }
        catch(InputMismatchException e1){
            System.out.println("Podany pojedynczy znak jedy bledny. Przerwanie programu!");
        }
    }
    public void wprowadzLong(){
        long x;
        try{
        System.out.println("Podaj liczbe calkowita long: ");
        x = input.nextLong();
        }
       catch(InputMismatchException e1){
           System.out.println("Podana liczba jest bledna. Przerwanie programu!");
        }
    }
    public void wprowadzShort(){
        short x;
        try{
        System.out.println("Podaj liczbe calkowita short: ");
        x = input.nextShort();
        }
        catch(InputMismatchException e1){
            System.out.println("Podana liczba jest bledna. Przerwanie programu!");
        }
    }
    public void wprowadzFloat(){
        float x;
        try{
        System.out.println("Podaj liczbe zmiennoprzecinkowa typu float: ");
        x = input.nextFloat();
        }
        catch(InputMismatchException e1){
            System.out.println("Podana liczba nie jest liczba zmiennoprzecinkowa typu float. Przerwanie programu!");
        }
    }
    public void wprowadzDouble(){
        double x;
        try{
        System.out.println("Podaj liczbe zmiennoprzecinkowa typu double: ");
        x = input.nextDouble();
        }
        catch(InputMismatchException e1){
            System.out.println("Podana liczba nie jest liczba zmiennoprzecinkowa typu double. Przerwanie programu!");
        }
    }
    public void wprowadzString(){
        String x;
        try{
        System.out.println("Podaj ciag znakow: ");
        x = input.nextLine();
        }
        catch(InputMismatchException e1){
            System.out.println("Podany ciag znakow jest bledny. Przerwanie programu!");
        }
    }
    
}