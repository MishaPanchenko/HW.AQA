
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordList {
    public static String[] exampleNotUniqueWords = {"Огурец", "Помидор", "Брокколи", "Чеснок", "Фасоль", "Мурманск", "Мурманск", "Мурманск",
            "Гриб", "Дерево", "Дом", "Семья", "Кино", "Кино", "Йогурт", "Салат", "Велосипед", "Самокат", "Самородок", "Самородок"
    };

    public static Set<String> getUniqueWords(String[] notUniqueWords) {
        return getWordUsageStatistic(notUniqueWords).entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static HashMap<String, Integer> getWordUsageStatistic(String[] notUniqueWords) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : notUniqueWords) {
            Integer count = hashMap.get(word);
            hashMap.put(word, (count == null) ? 1 : ++count);
        }
        return hashMap;
    }
}
