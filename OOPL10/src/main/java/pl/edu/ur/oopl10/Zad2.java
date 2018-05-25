package pl.edu.ur.oopl10;

import java.util.*;

public class Zad2 {
    
    public static void main(String[] args) {
        
        Random random = new Random();
        
       try{
            int[] tab;
            tab = new int[5];
                for(int i = 0; i<=5; i++){
                    tab[i] = random.nextInt();
                }
            
        }
        catch(ArrayIndexOutOfBoundsException e1){
            System.out.println("Przekroczenie limitu tablicy. Zakonczenie programu!");
        }
        
    }
}