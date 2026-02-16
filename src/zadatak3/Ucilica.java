package zadatak3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ucilica {

    // ===== APSTRAKTNA BAZNA KLASA =====
    static abstract class GeometrijskiLik implements Comparable<GeometrijskiLik> {

        protected String naziv;

        public GeometrijskiLik(String naziv) {
            this.naziv = naziv;
        }

        public String getNaziv() {
            return naziv;
        }

        public abstract double povrsina();
        public abstract double opseg();

        @Override
        public int compareTo(GeometrijskiLik drugi) {
            if (this.povrsina() > drugi.povrsina()) {
                return 1;
            } else if (this.povrsina() < drugi.povrsina()) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "Naziv: " + naziv +
                    ", Povrsina: " + povrsina() +
                    ", Opseg: " + opseg();
        }
    }

    // ===== TROKUT =====
    static class Trokut extends GeometrijskiLik {

        private double a;
        private double b;
        private double c;

        public Trokut(String naziv, double a, double b, double c) {
            super(naziv);
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double opseg() {
            return a + b + c;
        }

        @Override
        public double povrsina() {
            double s = opseg() / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }
    }

    // ===== KRUG =====
    static class Krug extends GeometrijskiLik {

        private double r;

        public Krug(String naziv, double r) {
            super(naziv);
            this.r = r;
        }

        @Override
        public double opseg() {
            return 2 * Math.PI * r;
        }

        @Override
        public double povrsina() {
            return Math.PI * r * r;
        }
    }

    // ===== PRAVOKUTNIK =====
    static class Pravokutnik extends GeometrijskiLik {

        private double a;
        private double b;

        public Pravokutnik(String naziv, double a, double b) {
            super(naziv);
            this.a = a;
            this.b = b;
        }

        @Override
        public double opseg() {
            return 2 * (a + b);
        }

        @Override
        public double povrsina() {
            return a * b;
        }
    }

    // ===== LISTA I METODE UCILICE =====

    private List<GeometrijskiLik> likovi;

    public Ucilica() {
        likovi = new ArrayList<>();
    }

    public void dodaj(GeometrijskiLik lik) {
        likovi.add(lik);
    }

    public void ispisiSve() {
        if (likovi.isEmpty()) {
            System.out.println("Nema dodanih likova.");
        } else {
            for (GeometrijskiLik lik : likovi) {
                System.out.println(lik);
            }
        }
    }

    public void sortirajPoPovrsini() {
        Collections.sort(likovi);
    }

    // ===== MAIN METODA =====

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Ucilica ucilica = new Ucilica();

        int izbor = 0;

        while (izbor != 5) {

            System.out.println("\n--- UCILICA ---");
            System.out.println("1 - Dodaj trokut");
            System.out.println("2 - Dodaj krug");
            System.out.println("3 - Dodaj pravokutnik");
            System.out.println("4 - Ispisi sve i sortiraj po povrsini");
            System.out.println("5 - Izlaz");
            System.out.print("Odabir: ");

            izbor = sc.nextInt();

            if (izbor == 1) {

                System.out.print("Naziv trokuta: ");
                sc.nextLine();
                String naziv = sc.nextLine();

                System.out.print("Stranica a: ");
                double a = sc.nextDouble();

                System.out.print("Stranica b: ");
                double b = sc.nextDouble();

                System.out.print("Stranica c: ");
                double c = sc.nextDouble();

                Trokut t = new Trokut(naziv, a, b, c);
                ucilica.dodaj(t);

            } else if (izbor == 2) {

                System.out.print("Naziv kruga: ");
                sc.nextLine();
                String naziv = sc.nextLine();

                System.out.print("Radijus: ");
                double r = sc.nextDouble();

                Krug k = new Krug(naziv, r);
                ucilica.dodaj(k);

            } else if (izbor == 3) {

                System.out.print("Naziv pravokutnika: ");
                sc.nextLine();
                String naziv = sc.nextLine();

                System.out.print("Stranica a: ");
                double a = sc.nextDouble();

                System.out.print("Stranica b: ");
                double b = sc.nextDouble();

                Pravokutnik p = new Pravokutnik(naziv, a, b);
                ucilica.dodaj(p);

            } else if (izbor == 4) {

                System.out.println("\n--- PRIJE SORTIRANJA ---");
                ucilica.ispisiSve();

                ucilica.sortirajPoPovrsini();

                System.out.println("\n--- NAKON SORTIRANJA ---");
                ucilica.ispisiSve();
            }
        }

        sc.close();
        System.out.println("Program zavrsen.");
    }
}

