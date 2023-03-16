import java.util.Scanner;

public class Main {
    public static void main(String[] input) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа:");
        String exp = scanner.nextLine();
        calc(exp);
    }
    public static void calc(String input) throws Exception {

        System.out.println(parser(input));

    }



    static String parser(String exp) throws Exception {
        int num1;
        int num2;
        String operete;
        String rezult;
        boolean isRoman = false;

        String[] oper = exp.split("[\\-/*+]"); // ['2','3']
        if (oper.length != 2) {
            throw new Exception("Должно быть 2 операнда");
        }
        operete = detecterOper(exp);
        if (operete == null) {
            throw new Exception("Неподдерживаемая операция");
        }
        //оба числа арабские
        if (!Roman.isRoman(oper[0]) && !Roman.isRoman(oper[1])) {
            num1 = Integer.parseInt(oper[0]);
            num2 = Integer.parseInt(oper[1]);
            isRoman = false;
        }
        // оба числа римские
        else if (Roman.isRoman(oper[0]) && Roman.isRoman(oper[1])) {
            num1 = Roman.converterToArab(oper[0]);
            num2 = Roman.converterToArab(oper[1]);
            isRoman = true;
        }
        //если одни число римское, а другое - арабское
        else {
            throw new Exception("Числа должны быть в одном формате");
        }

        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа не должны быть больше 10");
        }

        int arabian = calc(num1,num2, operete);
        // если это римское число
        if (isRoman){
            if (arabian <= 0){
                throw new Exception("Римское число обязано быть больше 0");
            }
            // конвертируем арабское число в римское
            rezult = Roman.cinverterToRoman(arabian);
        }else {
            // конверт арабское число в тип стринг
            rezult = String.valueOf(arabian);
        }
        return rezult;

    }


    static String detecterOper(String exp) {
        if (exp.contains("+")) {
            return "+";
        } else if (exp.contains("-")) {
            return "-";
        } else if (exp.contains("*")) {
            return "*";
        } else if (exp.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int calc(int a, int b, String oper){
        if (oper.equals("+")){
            return a + b;
        }else if (oper.equals("-")){
            return a-b;
        }else if (oper.equals("*")){
            return a * b;
        }else {
            return a / b;
        }
    }
}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String oper) {
        for (int i = 0; i < romanArray.length; i++) {
            if (oper.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int converterToArab(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String cinverterToRoman(int arab){
        return romanArray[arab];
    }
}