package com.boo4er;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class File {
    private static final Map<Character, File> FILES = new HashMap<>();
    private static int maxSize = 20;
    private final char symbol;

    private File(char symbol) {
        this.symbol = Character.toUpperCase(symbol);
    }

    public static void setSize(int newSize) {
        if (newSize < 15 || newSize > 25) {
            throw new IllegalArgumentException("Размер должен быть между 15 и 25");
        }
        maxSize = newSize;
        FILES.clear();
        for (int i = 0; i < maxSize; i++) {
            char c = (char) ('A' + i);
            FILES.put(c, new File(c));
        }
        System.out.println("Установлен новый размер: " + maxSize + " (" + getRange() + ")");
    }

    public static void initFromConsoleSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Текущий диапазон" + getRange());
        System.out.println("Введие новый размер от 15 до 25: ");
        while (true) {
            try {
                int size = scanner.nextInt();
                setSize(size);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка" + e.getMessage());
                System.out.println("Попробуйте снова 15-25");
            } catch (Exception e) {
                System.out.println("Некорректный ввод. Ввведите число.");
                scanner.next();
                System.out.println("Попробуйте снова (15-25)");
            }
        }
    }

    private static String getRange() {
        return "A-" + (char) ('A' + maxSize - 1);
    }

    public static File fromChar(char c) {
        c = Character.toUpperCase(c);
        if (c < 'A' || c >= 'A' + maxSize){
            return null;
        }
        return FILES.computeIfAbsent(c, File::new);
    }
    public char toChar(){
        return symbol;
    }
    static{
        setSize(20);
    }
}
