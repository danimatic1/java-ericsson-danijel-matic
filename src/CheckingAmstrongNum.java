//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CheckingAmstrongNum{

    public static boolean checkingArmstrong(int broj) {

        int original = broj;
        int suma = 0;

        int n = 0;
        int temp = broj;
        while (temp > 0) {
            n++;
            temp /= 10;
        }

        temp = broj;
        while (temp > 0) {
            int znamenka = temp % 10;
            suma += Math.pow(znamenka, n);
            temp /= 10;
        }

        return suma == original;
    }

    public static void main(String[] args) {

        System.out.println("Armstrong's numbers from 1 to 9999:");

        for (int i = 1; i <= 9999; i++) {
            if (checkingArmstrong(i)) {
                System.out.println(i);
            }
        }
    }
}

