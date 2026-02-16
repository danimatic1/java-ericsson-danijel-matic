import java.util.Scanner;

public class BrojacZnakova {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String tekst = sc.nextLine();

        int slova = 0;
        int brojevi = 0;
        int ostalo = 0;

        for (int i = 0; i < tekst.length(); i++) {

            char znak = tekst.charAt(i);

            if (Character.isLetter(znak)) {
                slova = slova + 1;
            }
            else if (Character.isDigit(znak)) {
                brojevi = brojevi + 1;
            }
            else {
                ostalo = ostalo + 1;
            }
        }

        System.out.println("Slova: " + slova);
        System.out.println("Brojevi: " + brojevi);
        System.out.println("Ostali znakovi: " + ostalo);

        sc.close();
    }
}