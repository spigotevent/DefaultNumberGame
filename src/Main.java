//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String RESET = "\u001b[0m";
    public static final String RED = "\u001b[31m";
    public static final String GREEN = "\u001b[32m";
    public static final String YELLOW = "\u001b[33m";
    public static final String BLUE = "\u001b[34m";
    public static final String PURPLE = "\u001b[35m";
    public static final String CYAN = "\u001b[36m";
    public static final String GRAY = "\u001b[90m";

    static void line() {
        System.out.println("\u001b[90m────────────────────────────────────\u001b[0m");
    }

    static String t(String lang, String en, String ru, String jp) {
        if (lang.equals("ru")) {
            return ru;
        } else {
            return lang.equals("jp") ? jp : en;
        }
    }

    static void header() {
        System.out.println("\u001b[36m\n╔══════════════════════════════════╗");
        System.out.println("║        КАЗИК ДЛЯ ПЕДИКОВ         ║");
        System.out.println("╚══════════════════════════════════╝\u001b[0m");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int balance = 10;
        String lang = "en";

        label79:
        while(true) {
            header();
            line();
            PrintStream var10000 = System.out;
            String var10001 = t(lang, "balance: ", "баланс: ", "残高: ");
            var10000.println("\u001b[33m" + var10001 + balance + "€\u001b[0m");
            line();
            System.out.println("\u001b[34m.start  .adm  .lang  .exit\u001b[0m");
            line();
            String cmd = sc.nextLine().toLowerCase();
            if (cmd.equals(".lang")) {
                System.out.println("\u001b[33men / ru / jp\u001b[0m");
                String l = sc.nextLine().toLowerCase();
                if (l.equals("en") || l.equals("ru") || l.equals("jp")) {
                    lang = l;
                }
            } else if (cmd.equals(".adm")) {
                System.out.println("\u001b[31m" + t(lang, "ADMIN-PANEL", "АДМИН-ПАНЕЛЬ", "管理パネル") + "\u001b[0m");
                line();
                System.out.println(".add  .set  .reset");
                String a = sc.nextLine();
                if (a.equals(".add")) {
                    System.out.println("amount:");
                    balance += sc.nextInt();
                    sc.nextLine();
                }

                if (a.equals(".set")) {
                    System.out.println("value:");
                    balance = sc.nextInt();
                    sc.nextLine();
                }

                if (a.equals(".reset")) {
                    balance = 10;
                }
            } else if (cmd.equals(".start")) {
                while(balance > 0) {
                    line();
                    var10000 = System.out;
                    var10001 = t(lang, "balance: ", "баланс: ", "残高: ");
                    var10000.println("\u001b[33m" + var10001 + balance + "€\u001b[0m");
                    line();
                    System.out.println(t(lang, "bet (0 exit):", "ставка (0 выход):", "ベット (0終了):"));
                    int bet = sc.nextInt();
                    sc.nextLine();
                    if (bet == 0) {
                        continue label79;
                    }

                    if (bet > balance) {
                        System.out.println("\u001b[31m" + t(lang, "not enough money", "не хватает денег", "お金不足") + "\u001b[0m");
                    } else {
                        System.out.println(t(lang, "color (red/black/white):", "цвет (красное/черное/белое):", "色 (赤/黒/白):"));
                        String color = sc.nextLine().toLowerCase();
                        System.out.println(t(lang, "number (1-10 / 0 skip):", "число (1-10 / 0 пропуск):", "数字 (1-10 / 0スキップ):"));
                        int num = sc.nextInt();
                        sc.nextLine();
                        String[] colors = new String[]{"red", "black", "white"};
                        String winColor = colors[rnd.nextInt(3)];
                        int winNum = rnd.nextInt(11);
                        System.out.println("\u001b[35m" + t(lang, "result: ", "результат: ", "結果: ") + "\u001b[0m\u001b[32m" + winColor + "\u001b[0m | " + winNum);
                        int mult = 0;
                        if (color.equals(winColor)) {
                            mult += 2;
                        }

                        if (num != 0 && num == winNum) {
                            mult += 5;
                        }

                        if (mult > 0) {
                            int win = bet * mult;
                            balance += win;
                            var10000 = System.out;
                            var10001 = t(lang, "WIN +", "ПОБЕДА НАХУЙ +", "勝ち +");
                            var10000.println("\u001b[32m" + var10001 + win + "€\u001b[0m");
                        } else {
                            balance -= bet;
                            var10000 = System.out;
                            var10001 = t(lang, "LOSE -", "ПРОИГРЫШ(((( -", "負け -");
                            var10000.println("\u001b[31m" + var10001 + bet + "€\u001b[0m");
                        }
                    }
                }

                line();
                System.out.println("\u001b[31m" + t(lang, "no balance", "нет баланса", "残高なし") + "\u001b[0m");
                System.out.println("\u001b[33m" + t(lang, "try again? yes/no", "ещё раз? да/нет", "もう一度？はい/いいえ") + "\u001b[0m");
                String again = sc.nextLine().toLowerCase();
                if (!again.equals("yes") && !again.equals("да") && !again.equals("はい")) {
                    System.out.println("\u001b[35m" + t(lang, "see you", "до встречи бротишка", "またね") + "\u001b[0m");
                    return;
                }

                balance = 10;
            } else {
                if (cmd.equals(".exit")) {
                    System.out.println("\u001b[35m" + t(lang, "see you again", "попробуешь ещё раз?", "また挑戦してね") + "\u001b[0m");
                    sc.close();
                    return;
                }

                System.out.println("\u001b[31m" + t(lang, "unknown command", "неизвестная команда ", "不明なコマンド") + "\u001b[0m");
            }
        }
    }
}
