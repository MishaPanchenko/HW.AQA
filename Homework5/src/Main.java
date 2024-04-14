import java.util.*;


public class Main {
    public static void main(String[] args) {
        wordList();
        phoneDictionary();
    }

    public static void wordList() {
        System.out.println(System.lineSeparator());
        System.out.println("List of unique words:");
        for (String uniqueWord : WordList.getUniqueWords(WordList.exampleNotUniqueWords)) {
            System.out.println(uniqueWord);
        }

        System.out.println(System.lineSeparator());
        System.out.println("Word usage statistics:");
        for (Map.Entry<String, Integer> entry : WordList.getWordUsageStatistic(WordList.exampleNotUniqueWords).entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void phoneDictionary() {
        System.out.println(System.lineSeparator());
        System.out.println("PhoneDictionary:");

        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add("Кавасаки", "+375298094406");
        phoneDictionary.add("Каго", "+375298094404");
        phoneDictionary.add("Крико", "+375298094424");
        phoneDictionary.add("Эстрипер", "+375298094420");
        phoneDictionary.add("Каго", "+375298094420");
        phoneDictionary.add("Крико", "+375295556662");

        String surnameWithMultiplePhoneNumbers = "Крико";
        String surnameWithOnePhoneNumber = "Каго";
        String nonExistentSurname = "Кавасаки";
        String[] tests = {surnameWithMultiplePhoneNumbers, surnameWithOnePhoneNumber, nonExistentSurname};
        for (String test : tests) {
            System.out.printf("Find by %s: %s%n", test, phoneDictionary.get(test));
        }
    }
}