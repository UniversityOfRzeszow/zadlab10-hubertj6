
package pl.edu.ur.oopl10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Zad5 {

    public static void main(String[] args) {
        zapiszInt(wprowadzInt());
        zapiszString(wprowadzString());
        odczytajInt();
        odczytajString();
    }

    public static int wprowadzInt() {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj liczbe calkowita: ");
        try {
            int liczba = wczytaj.nextInt();
            return liczba;
        } catch (Exception e) {
            System.out.println("Niepoprawne dane");
            return wprowadzInt();
        }

    }

    public static String wprowadzString() {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj ciag znakow: ");
        try {
            String liczba = wczytaj.next();
            return liczba;
        } catch (Exception e) {
            System.out.println("Niepoprawne dane");
           return wprowadzString();
        }

    }

    public static float wprowadzfloat() {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj liczbe typu float: ");
        try {
            float liczba = wczytaj.nextFloat();
            return liczba;
        } catch (Exception e) {
            System.out.println("Niepoprawne dane");
            return wprowadzfloat();
        }

    }

    public static short wprowadzshort() {
        Scanner wczytaj = new Scanner(System.in);
        System.out.println("Podaj liczbe typu short: ");
        try {
            short liczba = wczytaj.nextShort();
            return liczba;
        } catch (Exception e) {
            System.out.println("Niepoprawne dane");
            return wprowadzshort();
        }

    }

    public static void zapiszInt(int liczba) {

        FileWriter fwo = null;
        try {
            fwo = new FileWriter("int.txt");
            try (BufferedWriter bwo = new BufferedWriter(fwo)) {
                bwo.write(String.valueOf(liczba));
                bwo.newLine();
            }
        } catch (IOException ex) {
            System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
       } finally {
            try {
                fwo.close();
            } catch (IOException ex) {
                System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
            }
        }
    }

    public static void zapiszString(String napis) {

        FileWriter fwo = null;
        try {
            fwo = new FileWriter("String.txt");
            BufferedWriter bwo = new BufferedWriter(fwo);
            bwo.write(napis);
            bwo.newLine();
            bwo.close();
        } catch (IOException ex) {
            System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
        } finally {
            try {
               fwo.close();
            } catch (IOException ex) {
                System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
           }
       }
    }

    public static void zapiszfloat(float liczba) {

        FileWriter fwo = null;
        try {
            fwo = new FileWriter("float.txt");
            BufferedWriter bwo = new BufferedWriter(fwo);
            bwo.write(String.valueOf(liczba));
            bwo.newLine();
            bwo.close();
        } catch (IOException ex) {
            System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
        } finally {
            try {
               fwo.close();
            } catch (IOException ex) {
                System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
            }
        }
    }

    public static void zapiszshort(short liczba) {

        FileWriter fwo = null;
        try {
            fwo = new FileWriter("short.txt");
            BufferedWriter bwo = new BufferedWriter(fwo);
            bwo.write(String.valueOf(liczba));
            bwo.newLine();
            bwo.close();
        } catch (IOException ex) {
           System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
        } finally {
            try {
                fwo.close();
            } catch (IOException ex) {
                System.out.println("NIEUDANA PROBA ZAPISU DO PLIKU");
            }
        }
    }

    public static void odczytajInt() {
        FileReader fr = null;
        try {
            fr = new FileReader("int.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead = ":D";
            System.out.println("CZYTANIE Z PLIKU ! ! !");
            int i = 1;
            while (stringRead != null) {
                stringRead = br.readLine();
                if (stringRead == null) {
                    System.out.println("!Koniec!");
                } else {
                    System.out.println("LINIA NR " + i);
                    i++;
                    System.out.println(stringRead);
                }

            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            }
        }
    }

    public static void odczytajString() {
        FileReader fr = null;
        try {
            fr = new FileReader("String.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead = ":D";
            System.out.println("CZYTANIE Z PLIKU ! ! !");
          int i = 1;
            while (stringRead != null) {
                stringRead = br.readLine();
                if (stringRead == null) {
                    System.out.println("!Koniec!");
               } else {
                    System.out.println("LINIA NR " + i);
                    i++;
                    System.out.println(stringRead);
                }

            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            }
        }
    }

    public static void odczytajfloat() {
       FileReader fr = null;
        try {
            fr = new FileReader("float.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead = ":D";
            System.out.println("CZYTANIE Z PLIKU ! ! !");
            int i = 1;
            while (stringRead != null) {
                stringRead = br.readLine();
              if (stringRead == null) {
                    System.out.println("!Koniec!");
                } else {
                    System.out.println("LINIA NR " + i);
                    i++;
                    System.out.println(stringRead);
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
       } finally {
           try {
               fr.close();
            } catch (IOException ex) {
            }
        }
    }

    public static void odczytajshort() {
        FileReader fr = null;
        try {
            fr = new FileReader("short.txt");
            BufferedReader br = new BufferedReader(fr);
            String stringRead = ":D";
            System.out.println("CZYTANIE Z PLIKU ! ! !");
            int i = 1;
            while (stringRead != null) {
                stringRead = br.readLine();
                if (stringRead == null) {
                    System.out.println("!Koniec!");
                } else {
                    System.out.println("LINIA NR " + i);
                    i++;
                    System.out.println(stringRead);
                }

            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
            }
        }
    }

}