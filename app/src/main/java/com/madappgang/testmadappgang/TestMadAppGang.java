package com.madappgang.testmadappgang;

/**
 * Created by Ruslan Shchavinskiy <ruslan@madappgang.com> on 14.03.2018.
 */

public class TestMadAppGang {
    private static String originalText1 = "with its powerful tools and dazzling effects,Keynote makes it Easy to create stunning and memorable presentations. ";
    private static String originalText2 = "See Who you ’re working with ... While you’re editing, a separate list lets you quickly see who else is in the presentation.";
    private static String originalText3 = "  lorem ip   '    sum   : dolor sit amet: consectetur   ;adipiscing ;   elit!!    nam rutrum,,, est in tortor viverra ... lacinia ? !  aliquam turpis m . . .  faucibus vitae.  ";

    private static int count = 0;

    public static void main(String... args) {
        logText(originalText1);
        logText(originalText2);
        logText(originalText3);
    }

    private static void logText(String originalText) {
        count++;
        System.out.println("original " + count + ": \t" + originalText + "");
        System.out.println("result " + count + ": \t\t" + formattingText(originalText) + "\n");
    }

    private static String formattingText(String originalText) {
        String resultText = "";
        String[] punctuationInEndString = {".", "?", "!"};
        String[] punctuationInsideString = {",", ":", ";"};
        String[] punctuationInsideWord = {"’", "\'"};

        for (String symbol : punctuationInEndString) {
            originalText = originalText.replaceAll("[" + symbol + "]", " " + symbol + " ")  //добавляем пробелы к символу
                    .replaceAll(" +[" + symbol + "]", symbol);                                          //один или больше пробелов с символом заменить на указанный символ
        }
        for (String symbol : punctuationInsideString) {
            originalText = originalText.replaceAll(" *" + symbol + "+ *", symbol + " ");    //один или более символов с ноль или более пробелов по обе стороны заменить на символ с пробелом
        }
        for (String symbol : punctuationInsideWord) {
            originalText = originalText.replaceAll(" *" + symbol + " *", symbol);                       //убирает пробелы до и после символа
        }

        originalText = originalText.trim().replaceAll(" +", " ");                           //убирает лишние пробелы
        String[] resultMass = originalText.split("(?<=[.!?] )");                                        //разбивает строку на предложения
        for (String sentence : resultMass) {
            resultText += sentence.substring(0, 1).toUpperCase() + sentence.substring(1).toLowerCase();        //делает первый символ большим, а остальные маленькими
        }
        return resultText;
    }
}