package Lab2;
//25(c), 26(c), 29, 31(c), 36(c)
import java.util.*;
import java.lang.*;

public class Lab2_Main {
    // Task 26
    enum Month{
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }
    int howManyDaysInMonth(Month month){
        System.out.println("Program will show amount of days in month:");
        int amountOfDays = 0;
        switch(month){
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                amountOfDays = 31;
                break;
            case FEBRUARY:
                amountOfDays = 28;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                amountOfDays = 30;
                break;
            default:
                System.out.println("Enter valid value!");
                break;
        }
        return amountOfDays;
    }
    // Task 36
    void whatDayFromBeginningOfYear1(String str){
        System.out.println("Program will calculate amount of days from the beginning of year,\n" +
                "type of date must be: DD-MM-YYYY");

        String regExp="((0[1-9])|(1[0-9])|(2[0-9])|(3[01]))-((0[1-9])|(1[012]))-[0-9]{4}";
        if(str.matches(regExp) == false){
            System.out.println("Incorrect input");
        }
        else {
            int day = Integer.parseInt(str.substring(0, 2));
            int month = Integer.parseInt(str.substring(3, 5));
            int year = Integer.parseInt(str.substring(6, 10));
            int daysInFebruary;
            if (year % 4 == 0) {
                daysInFebruary = 29;
            } else {
                daysInFebruary = 28;
            }
            int dayFromBeginningOfYear = 0;
            int[] monthContainer = {31, daysInFebruary, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            for (int i = 0; i < month; i++) {
                if (i != 0) {
                    dayFromBeginningOfYear += monthContainer[i - 1];
                }
            }
            dayFromBeginningOfYear += day;
            System.out.println(str + " is " + dayFromBeginningOfYear + " day from beginning of year");
        }
    }
    void whatDayFromBeginningOfYear(String str){
        System.out.println("Program will calculate amount of days from the beginning of year,\n" +
                "type of date must be: DD-MM-YYYY");

        // Check on issues
        if(str.length() != 10){
            System.out.println("Incorrect input");
        }
        else {
            char[] dayC = new char[2];
            str.getChars(0, 2, dayC, 0);
            int dayI = Integer.parseInt(String.valueOf(dayC));
            char[] monthC = new char[2];
            str.getChars(3, 5, monthC, 0);
            int monthI = Integer.parseInt(String.valueOf(monthC));
            char[] yearC = new char[4];
            str.getChars(6, 10, yearC, 0);
            int yearI = Integer.parseInt(String.valueOf(yearC));

            // Check on issues
            if (dayI < 1 || dayI > 31) {
                System.out.println("Incorrect input");
            } else if (monthI < 1 || monthI > 12) {
                System.out.println("Incorrect input");
            } else {
                System.out.println("Day: " + dayI + " Month: " + monthI + " Year: " + yearI);
                int days31 = 31;
                int days30 = 30;
                int days28_or_29;
                int dayFromBeginningOfYear = 0;
                if (yearI % 4 == 0) {
                    days28_or_29 = 29;
                } else {
                    days28_or_29 = 28;
                }
                switch (monthI) {
                    case 1:
                        dayFromBeginningOfYear += dayI;
                        break;
                    case 2:
                        dayFromBeginningOfYear = days31 + dayI;
                        break;
                    case 3:
                        dayFromBeginningOfYear = days31 + days28_or_29 + dayI;
                        break;
                    case 4:
                        dayFromBeginningOfYear = days31 * 2 + days28_or_29 + dayI;
                        break;
                    case 5:
                        dayFromBeginningOfYear = days31 * 2 + days28_or_29 + dayI + days30;
                        break;
                    case 6:
                        dayFromBeginningOfYear = days31 * 3 + days28_or_29 + dayI + days30;
                        break;
                    case 7:
                        dayFromBeginningOfYear = days31 * 3 + days28_or_29 + dayI + days30 * 2;
                        break;
                    case 8:
                        dayFromBeginningOfYear = days31 * 4 + days28_or_29 + dayI + days30 * 2;
                        break;
                    case 9:
                        dayFromBeginningOfYear = days31 * 5 + days28_or_29 + dayI + days30 * 2;
                        break;
                    case 10:
                        dayFromBeginningOfYear = days31 * 5 + days28_or_29 + dayI + days30 * 3;
                        break;
                    case 11:
                        dayFromBeginningOfYear = days31 * 6 + days28_or_29 + dayI + days30 * 3;
                        break;
                    case 12:
                        dayFromBeginningOfYear = days31 * 6 + days28_or_29 + dayI + days30 * 4;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;
                }
                System.out.println(str + " is " + dayFromBeginningOfYear + " day from beginning of year");
            }
        }
    }
    // Task 25
    enum PostsOnFactory{
        Engineer(7000),
        Turner(7500),
        Mechanic(6500),
        Principal(12000);
        int current;
        PostsOnFactory(int current){
            this.current = current;
        }

        void changeSalary(PostsOnFactory post){
            Scanner addInput = new Scanner(System.in);
            int additional;
            additional = addInput.nextInt();
            if(additional == 1){
                System.out.println("Enter new salary for " + post + ":");
                additional = addInput.nextInt();
                post.current = additional;
                System.out.println(post + "'s salary is " + current + " now");
            }
        }
    }
    // Task Karena
    void openLetter(String word) {
        boolean complete = false;
        boolean lost = false;
        int mistake = 10;
        // Создаем массив для слова(скрытого), которое будет по чуть-чуть открываться
        char[] wordHidden = new char[word.length()];
        // Инициализация массива со скрытым словом звёздочками и вывод в консоль
        System.out.println("Hidden word:");
        for (int i = 0; i < wordHidden.length; i++) {
            wordHidden[i] = '*';
            System.out.print(wordHidden[i]);
        }
        System.out.println();
        // Конец строки вошедшего с функцией слова
        int end = word.length();
        System.out.println("Game starts! Enter letter to open word:");

        while (!complete && !lost) {
            // Считывание значения с консоли
            Scanner scanner = new Scanner(System.in);
            String scan = scanner.next();
            // Запись считанного значения в чаровский массив
            char[] scanChar = new char[1];
            scan.getChars(0, 1, scanChar, 0);
            // Запись параметра(стринга), который вошел с функцией, в чаровский массив
            char[] wordChar = new char[word.length()];
            word.getChars(0, end, wordChar, 0);
            // Проверка на наличие введенной буквы в слове
            for (int i = 0; i < wordChar.length; i++) {
                if (wordChar[i] == scanChar[0]) {
                    // повторная прогонка массива со скрытым словом и замена звезвочек угаданной буквой в нужных местах
                    for (int j = 0; j < wordHidden.length; j++) {
                        if (wordChar[j] == wordChar[i]) {
                            wordHidden[j] = wordChar[i];
                        }
                        System.out.print(wordHidden[j]);
                    }
                    System.out.println();
                    break;
                }
                // Если цикл дошел доконца и не нашел совпадений, и ещё есть допустимое кол-во ошибок
                // отнимает одну попытку, а если ошибки закончились - засчитывает игру проигранной
                if (i == wordHidden.length - 1) {
                    mistake--;
                    System.out.println("Mistake! Left - " + mistake + " tries");
                    if(mistake == 0){
                        System.out.println("You lost!");
                        lost = true;
                    }
                }
            }
            if(!lost){
                complete = true;
                // Проганяет массив со скрытым словом, и, если находит звёздочку - засчитывает игру незаконченной
                for(int i = 0; i < wordHidden.length; i++){
                    if(wordHidden[i] == '*'){
                        complete = false;
                    }
                }
                if(complete){
                    System.out.println("You won!");
                }
            }
        }
    }
    // Task 31
    void showTryCatchWork() throws java.lang.ArithmeticException{
        try{
            throw new java.lang.ArithmeticException();
        }
        catch(java.lang.ArithmeticException exptn){
            System.out.println(exptn.getMessage());
        }
    }
    public static void main(String[] args) {
        Lab2_Main m1 = new Lab2_Main();
        int input = 1;
        while(input != 0){
            System.out.println("Enter task you want to check(25, 26, 29, 31, 36) or 0 to close the program:");
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();
            if(input == 0){
                System.out.println("Program is closing...");
                break;
            }
            switch(input){
                case 25:
                    for(PostsOnFactory post: PostsOnFactory.values()){
                        System.out.println(post + "'s salary is " + post.current +
                                "\nIf you want to change this value enter 1, if no 0");
                        post.changeSalary(post);
                    }
                    System.out.println("All changes complete...");
                    break;
                case 26:
                    Month month = Month.JANUARY;
                    int daysInMonth = m1.howManyDaysInMonth(month);
                    System.out.println("Amount of days in " + month + " " + daysInMonth);
                    break;
                case 29:

                    break;
                case 31:
                    m1.showTryCatchWork();
                    break;
                case 36:
                    m1.whatDayFromBeginningOfYear1("31-12-2020");
                    m1.whatDayFromBeginningOfYear("31-12-2020");
                    break;
                case 1:
                    String word = "queue";
                    m1.openLetter(word);
                    break;
                default:
                    System.out.println("Invalid input! Write correct task!");
                    break;
            }
        }
    }
}

