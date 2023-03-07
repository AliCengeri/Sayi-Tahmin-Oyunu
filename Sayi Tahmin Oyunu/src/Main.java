import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        boolean isWrong = false;
        boolean isWin = false;
        int[] guess = new int[5];
        while (right < 5) {
            System.out.print("Tahmininizi giriniz: ");
            selected = input.nextInt();
            if (selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-100 arasında bir sayı giriniz.");
                if (isWrong) {
                    right++;
                    System.out.println("Çok fazla hatalı giriş yaptınız! Kalan hak: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Bir sonraki hatalı girişinizde 1 hakkınızı kaybedeceksiniz.");
                }
                continue;
            }
            if (selected == number) {
                System.out.println("Tebrikler, sayıyı doğru tahmin ettiniz! Tahmin ettiğiniz sayı: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("Yanlış tahmin yaptınız!");
                if (selected > number) {
                    System.out.println(selected + " sayısı, gizli sayıdan büyüktür.");
                } else {
                    System.out.println(selected + " sayısı, gizli sayıdan küçüktür");
                }
            }
            guess[right++] = selected;
            System.out.println("Kalan hakkınız: " + (5 - right));
        }
        if (!isWin) {
            System.out.println("Kaybettiniz! Gizli sayı: " + number);
            System.out.println("Tahminleriniz: " + Arrays.toString(guess));
        }
    }
}
