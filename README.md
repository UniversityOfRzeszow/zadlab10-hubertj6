# OOPL10
Wyjątki

Wyjątki to sytuacje nienormalne, pojawiające się w trakcie wykonywania programu. Języki nie posiadające mechanizmu obsługi wyjątków wymagają aby błędy były wykrywane i obsługiwane ręcznie - najczęściej przez kody błędów. Język Java dostarcza specjalnych konstrukcji do wykrywania i obsługi takich sytuacji. Wyjątek jest w Javie jest obiektem opisującym sytuację wyjątkową (błędną), która powstała w kodzie programu. Gdy w danej metodzie wystąpi błąd, zostaje wyrzucony w tej metodzie wyjątek opisujący ten błąd. Metoda może wyłapać i obsłużyć wyjątek samodzielnie albo przekazać go dalej. Na koniec błąd jest wyłapywany i obsługiwany. Do konstrukcji obsługi wyjątków w języku Java wykorzystujemy następujące słowa kluczowe:

* **try** - blok instrukcji, które są monitorowane na wypadek błędu
* **catch** - występuje w parze z try. Wyłapuje określone wyjątki i obsługuje je w określony sposób
* **throw** - sygnalizuje wystąpienie określonego wyjątku
* **throws** - określa jakie wyjątki może zgłaszać dana metoda
* **finally** - blok instrukcji, który musi zostać wykonany przed danej zakończeniem metody

Poniżej blok instrukcji _try/catch/finally_ do obsługi trzech typów wyjątków:

```java
        try {
            //blok instrukcji monitorowanych na wypadek wystąpienia błędów
        } catch (WyjątekTypuPierwszego e) {
            //obsluga wyjatku pierwszego typu
        } catch (WyjątekTypuDrugiego e) {
            //obsluga wyjatku drugiego typu
        } catch (WyjątekTypuTrzeciego e) {
            //obsluga wyjatku trzeciego typu
        } finally {
            //kod, który musi być wykonany przed zakończeniem metody
        }
```

## Hierarchia wyjątków

![image](https://user-images.githubusercontent.com/37068602/39979927-8962ab42-5749-11e8-9c76-315204e63523.png)

* *Throwable* – klasa obejmująca wszystkie wyjątki
* *Exception* – wyjątki do wyłapania przez programy użytkowe
* *Error* – wyjątki niemożliwie do wyłapania przez programy użytkowe, błędy środowiska wykonawczego

## Domyślna Obsługa Wyjątków

Kiedy system wykryje operację dzielenia przez zero utworzy nowy obiekt będący wyjątkiem. Ponieważ wyjątek nie ma własnej procedury obsługi zostaje przechwycony przez domyślną procedurę. Procedura domyślna wyświetli stos wywołań (ciąg wywołań metod, które prowadziły do wystąpienia błędu) i spowoduje zakończenie programu. 

```java
class WyjatekDzielenia {

    static dzielenie(int dzielna, int dzielnik) {
        int wynik = dzielna / dzielnik;
    }

    public static void main(String args[]) {
        WyjatekDzielenia.dzielenie(1024, 0);
    }
}
```

## Własna Obsługa Wyjątków

Własna obsługa błędów daje możliwość poprawienia błędów oraz zapobiega przedwczesnemu zakończeniu się programu.

```java
class WlasnyWyjatek {

    public static void main(String args[]) {
        int dzielna, dzielnik, wynik;
        try {
            dzielna = 128;
            dzielnik = 0;
            wynik = dzielna / dzielnik;
            System.out.println("Niemożliwe !!!");
        } catch (ArithmeticException e) // Okreslamy wyjatki, ktore chcemy wylapac
        {
            System.out.println("Dzielenie przez 0");
            // Okreslamy jak chcemy je obsluzyc
        }
        System.out.println("Po wyjatku");
        // Kod po obsludze wyjatku
    }
}
```

Instrukcja `catch` nie może wyłapać wyjątków z innych bloków `try`, z wyjątkiem zagnieżdżonych bloków `try`.

*Kolejność obsługi wyjątków jest ważna.*
Przy tworzeniu wielu sekwencji `catch`, wyjątki podklasy muszą występować przed wyjątkami nadklasy. W związku z tym poniższy kod jest niepoprawny - popraw go!

```java
class WyjatekPodKlasy {

    public static void main(String args[]) {
        try {
            int operacjaDzielenia = 224 / 0;
        } catch (Exception e) {
            System.out.println("Wyjatek generyczny");
        } catch (ArithmeticException e) {
            System.out.println("Nieosiagalny");
        }
    }
}
```

## Wyświetlanie opisu wyjątku

Klasa Throwable przesłania metodę `toString()` aby wyświetlała opis wyjątku.

```java
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Wyjatek: " + e);
            ///...
        }
```

## Przechwycenie dowolnego wyjątku

* Obsługa wyjątku klasy bazowej - `Exception`
* Przydatne metody klasy `Throwable` - np. `String getMessage()`

Przykład:
```java
        try {
            //...
        } catch (Exception w) {
            System.out.print("Wyjątek: ");
            System.out.println(w.getMessage());
        }
```

Procedura obsługi przechwytywania dowolnego wyjątku powinna się znaleźć na końcu (powykonaniu pozostałych).

## Wyrzucanie wyjątków

Program może sam wyrzucać wyjątki: `throw object`;
Obiekt taki musi być klasy `Throwable`, albo którejś z jej podklas. 
Obiekt klasy `Throwable` uzyskać można poprzez użycie operatora new lub użycie parametru w instrukcji `catch`.

## Obsługa throw

Program zostaje przerywany na instrukcji `throw`. Sprawdza czy najbliższy otaczający go blok `try` posiada instrukcję `catch` obsługującą dany wyjątek. W przeciwnym wypadku czy kolejny otaczający blok `try` posiada tą instrukcję. W przeciwnym wypadku wykonuje domyślną obsługę wyjątku tzn. przerwanie wykonywania programu i wydrukowanie stosu wywołań.

```java
class ThrowDemo {
    static void metoda() {
        try {
            //Tworzy nowy wyjątek a następnie wyrzuca go:
            throw new NullPointerException("demo");
            //Wyjątek zostaje natychmiast wyłapany:
        } catch (NullPointerException e) {
            System.out.println("Zlapany w metodzie");
            //Obsługa polega na przesłaniu wyjątku dalej:
            throw e;
        }
    }
}
```

Wyjątek zostaje ponownie wyłapany przez metodę `main`:

```java
    public static void main(String args[]) {
        try {
            metoda();
        } catch (NullPointerException e) {
            System.out.println("Zlapany ponownie");
        }
    }
```

Tworzenie obiektu standardowej klasy wyjątku:

```java
    throw new NullPointerException("demo");
```

Wszystkie standardowe wyjątki mają dwa konstruktory:
* bezparametrowy
* z parametrem `String` opisującym wyjątek; dostępny przez `getMessage()` w `Throwable`

Jeśli metoda może spowodować wyjątek którego sama nie jest w stanie obsłużyć, to musi ten fakt opisać.

```java
    typ nazwa(parametry) throws wyjatki { ... }
```

Niezbędne jest wymienienie wszystkich wyjątków, oprócz typów `Error` i `RuntimeException`.

```java
class ThrowsDemo1 {

    static void metoda() {
        System.out.println("Wewnatrz metody");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        metoda();
    }
}
```

Metoda w powyższej klasie wyrzuca wyjątek którego ani nie wyłapuje, ani nie deklaruje. Program się nie skompiluje.

```java
class ThrowsDemo2 {

    static void metoda()
            throws IllegalAccessException {
        System.out.println("Wewnatrz metody");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) {
        try {
            metoda();
        } catch (IllegalAccessException e) {
            System.out.println("Zlapany " + e);
        }
    }
}
```

Jedna metoda deklaruje, druga wyłapuje wyjątek.

## Demonstacja finally

```java
class FinallyDemo {

    static void procA() {
        try {
            System.out.println("wewnatrz procA");
            throw new RuntimeException("demo");
        } finally {
            System.out.println("procA: finally");
        }
    }

    static void procB() {
        try {
            System.out.println("wewnatrz procB");
            return;
        } finally {
            System.out.println("procB: finally");
        }
    }

    static void procC() {
        try {
            System.out.println("wewnatrz procC");
        } finally {
            System.out.println("procC: finally");
        }
    }

    public static void main(String args[]) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Wyjatek zlapany");
        }
        procB();
        procC();
    }
}
```

## Standardowe wyjątki niesprawdzane

`RuntimeException` są dostępne automatycznie. Nie muszą być deklarowane w sekcji `throw`s. Kompilator nie sprawdza czy metoda deklaruje czy obsługuje te wyjątki.

* `ArithmeticException` błędy arytmetyczne, np. dzielenie przez zero
* `ArrayIndexOutOfBoundsException` indeks tablicy poza zakresem
* `ArrayStoreException` przypisanie tablicy nieodpowiedniego typu elementu
* `ClassCastException` niepoprawne rzutowanie
* `IllegalArgumentException` niepoprawny argument metody
* `IllegalStateException` środowisko lub aplikacja jest w niepoprawnym stanie
* `IllegalThreadStateException` wymagana operacja niekompatybilna z bieżącym stanem wątka
* `IndexOutOfBoundException` jakis rodzaj indeksu jest poza zakresem
* `NegativeArraySizeException` tablica tworzona z ujemnym rozmiarem
* `NullPointerException` niepoprawne użycie wskaźnika null
* `NumberFormatException` niepoprawna konwersja stringu na format liczbowy
* `SecurityException` próba naruszenia bezpieczeństwa
* `StringIndexOutOfBoundsException` indeks poza zakresem stringu
* `UnsupportedOperationException` napotkano niepoprawną operację

Metody które mogą generować te wyjątki a nie potrafią ich samodzielnie obsłużyć, muszą je deklarować.

* `ClassNotFoundException` nie znaleziono klasy
* `CloneNotSupportedException` próba klonowania obiektu który nie implementuje
interfejsu Cloneable.
* `IllegalAccessException` dostęp do klasy zabroniony
* `InstantiationException` próba tworzenia obiektu klasy abstrakcyjnej lub interfejsu
* `InterruptedException` jeden wątek przerwany przed drugi
* `NoSuchFieldException` pole nie istnieje
* `NoSuchMethodException` metoda nie istnieje

## Zadania

### Zadanie 1 

Utwórz klasę WprowadzZKonsoli. Utwórz metodę wprowadzInt wraz z obsługą wyjątków tak aby np. nie można było wprowadzić błędnej postaci liczby tj. „1w2”. Utwórz metody wprowadzania innych typów danych np. char, long, short, float, double, String wraz z odpowiednią obsługą wyjątków. Do wprowadzania danych z konsoli użyj klasy Scanner.

### Zadanie 2 

Napisz program wykorzystujący obsługę wyjątku ArrayIndexOutOfBoundsException.

### Zadanie 3

Utwórz klasę rzucającą wyjątek przy próbie wykonania dzielenia przez 0. Klasa ma dziedziczyć po java.lang.Exception. Następnie utwórz klasę, która testuje czy wyjątki dzielenia przez zero są rzucane przy pomocy utworzonej wcześniejszej klasy i wyłapywane.

### Zadanie 4 

Wykonaj program, który losuje dwie liczby całkowite z przedziału (-10 do 10). Następnie podziel pierwszą liczbę przez drugą i wypisz wynik. Uwzględnij i zaprogramuj wyjątek dzielenia przez zero. Wypisz informację o wystąpieniu tego wyjątku. Po trzecim wystąpieniu wyjątku zakończ wykonywanie programu.

### Zadanie 5

Rozszerz klasę z zadania pierwszego o metody zapisujące i odczytujące wprowadzone dane z pliku. Utwórz różne metody zapisu i odczytu dla różnych typów danych. Załóż, że dany plik może przechowywać tylko jeden typ danych. Pamiętaj o obsłudze wyjątków mogących powstać przy obsłudze strumieni.

Czytanie z pliku:

```jaava
        FileReader fr = new FileReader("nazwa.rozszerzenie");
        BufferedReader br = new BufferedReader(fr);
        while (stringRead != null) {
            stringRead = br.readLine();
            //...  rzutowanie na odpowiedni typ i podstawienie pod
            //...  zmienną
        }
        br.close();
    }
```

Zapis do pliku:

```java
        FileWriter fwo = new FileWriter("nazwa.rozszerzenie", `false`/`true`);
        BufferedWriter bwo = new BufferedWriter(fwo);
        bwo.write(...);
        bwo.newLine();

        bwo.close();
```


Obsłuż wyjątki: `IOException`, `FileNotFoundException`

###### Opracował dr inż. Wojciech Kozioł
