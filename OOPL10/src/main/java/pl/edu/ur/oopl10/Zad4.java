package pl.edu.ur.oopl10;

import java.util.*;

public class Zad4 {

    public static void main(String[] args) {
        
       Random random = new Random();
        
        int i = 0;
        while(i<3){
           
            int x = random.nextInt(21) - 10;
            int y = random.nextInt(21) - 10;
            try{
               int wynik = x / y;
                System.out.println("Wynik: "+wynik);
            }
            catch(ArithmeticException e1){
                System.out.println("Uwaga! Dzielenie przez 0!");
                i++;
            }
        }
        
    }
    
}