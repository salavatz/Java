package collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getCountUniqueWords("input.txt"));
        System.out.println(getSortedUniqueWords("input.txt"));
        System.out.println(getWordFrequency("input.txt"));
        System.out.println(getReverseOrder("input.txt"));
        List<Integer> userList = new ArrayList<>();
        userList.add(3);
        userList.add(1);
        userList.add(2);
        System.out.println(getLines("input.txt", userList));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        ReverseIterator iter = new ReverseIterator(list);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    private static Set<String> getUniqueWords(String pathname, Set<String> uniqueWords) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathname));
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split("\\W");
            for (String str : array) {
                if (str.length() > 0) {
                    uniqueWords.add(str);
                }
            }
        }
        scanner.close();
        return uniqueWords;
    }

    public static int getCountUniqueWords(String pathname) throws FileNotFoundException {
        Set<String> uniqueWords = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        return getUniqueWords(pathname, uniqueWords).size();
    }

    public static Set<String> getSortedUniqueWords(String pathname) throws FileNotFoundException {
        Set<String> uniqueWords = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                }
                else if (o1.length() == o2.length()) {
                    return o1.compareToIgnoreCase(o2);
                }
                else {
                    return 1;
                }
            }
        });
        return getUniqueWords(pathname, uniqueWords);
    }
    public static Map<String, Integer> getWordFrequency(String pathname) throws FileNotFoundException {
        Map<String, Integer> wordFrequency = new HashMap<>();
        Scanner scanner = new Scanner(new File(pathname));
        while(scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split("\\W");
            for( String str : array) {
                if(str.length() > 0) {
                    String strLowerCase = str.toLowerCase();
                    Integer value = wordFrequency.get(strLowerCase);
                    if(value == null) {
                        wordFrequency.put(strLowerCase, 1);
                    }
                    else {
                        wordFrequency.put(strLowerCase, value + 1);
                    }
                }
            }
        }
        scanner.close();
        return wordFrequency;
    }
    public static List<String> getReverseOrder(String pathname) throws FileNotFoundException {
        Stack<String> lines = new Stack<>();
        Scanner scanner = new Scanner(new File(pathname));
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            lines.add(str);
        }
        scanner.close();
        List<String> out = new ArrayList<>();
        while (!lines.empty()) {
            out.add(lines.pop());
        }
        return out;
    }
    public static List<String> getLines(String pathname, List<Integer> userList) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        Scanner scanner = new Scanner(new File(pathname));
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            lines.add(str);
        }
        scanner.close();
        List<String> out = new ArrayList<>();
        for (Integer i: userList) {
            out.add(lines.get(i - 1));
        }
        return out;
    }
}
