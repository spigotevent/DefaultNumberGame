import java.util.Scanner;
import java.util.Random;

public class EU {

    public static void main(String[] args) {

            Random rnd = new Random(); // инициализация рандома

            int z = rnd.nextInt(1, 101); // создание рандомного значения в диапазоне от 1 до 100

            try (Scanner sc = new Scanner(System.in)) { // инициализация сканнера


            System.out.println("Программа загадала случайное число от 1 до 100, попробуй угадать его!");

            int x = sc.nextInt(); // ввод числа с клавиатуры

                if (x > 100) {

                    System.out.println("Число не может быть больше чем 100");

                return;

                } else if (x < 1) {

                    System.out.println("Чсило не может быть меньше чем 1");

                return;

                }


            if (x == z) {

                System.out.println("Вы угадали число! ( " + z + " )");


            } else {

                System.out.println("Ответ неверный, попробуйте еще раз") ;

            }



   }
  }
}