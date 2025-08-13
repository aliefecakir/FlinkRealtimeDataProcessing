import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Lütfen isminizi giriniz.");
        String name = scn.nextLine();
        System.out.println("Merhaba " + name + "!");
        System.out.println(LocalDate.now());
    }
}
