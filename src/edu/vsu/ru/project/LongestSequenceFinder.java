package edu.vsu.ru.project;

import java.util.ArrayList;
import java.util.List;

public class LongestSequenceFinder {
    public static List<Integer> createNewList(List<Integer> list) {
        List<Integer> maxList = new ArrayList<>();
        if (list.size() == 1) {
            return list;
        } else {
            for (int firstElementIndex = 0; firstElementIndex < list.size() - 1; ++firstElementIndex) {
                for (int secondElementIndex = firstElementIndex + 1; secondElementIndex < list.size(); ++secondElementIndex) {
                    int dist = list.get(secondElementIndex) - list.get(firstElementIndex);
                    List<Integer> checkList = new ArrayList<>();
                    checkList.add(0, list.get(firstElementIndex));
                    checkList.add(1, list.get(secondElementIndex));
                    int previousElement = list.get(secondElementIndex);
                    int index = 2;
                    for (int nextElementIndex = secondElementIndex + 1; nextElementIndex < list.size(); nextElementIndex++) {
                        int nextElement = list.get(nextElementIndex);

                        if (nextElement - previousElement == dist) {
                            checkList.add(index, list.get(nextElementIndex));
                            previousElement = nextElement;
                            ++index;
                        }
                    }
                    if (maxList.size() < checkList.size()) {
                        maxList.clear();
                        maxList.addAll(0, checkList);
                    }
                }
            }
        }
        return maxList;
    }
}
