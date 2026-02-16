import java.util.Scanner;

public class ObrtanjeRijeci {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String recenica = sc.nextLine();

        String[] rijeci = recenica.split("\\s+");

        String rezultat = "";

        for (int i = rijeci.length - 1; i >= 0; i--) {
            rezultat = rezultat + rijeci[i] + " ";
        }

        System.out.println(rezultat.trim());

        sc.close();
    }
}
