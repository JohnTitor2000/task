package ru.testtask.uriku.task.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SequenceServiceImpl implements SequenceService{
    @Override
    public Map<Character, Integer> getFrequency(String sequence) {
        Map<Character, Integer> unsortedFrequency = new HashMap<>();
        sequence.chars().forEach(c -> unsortedFrequency.merge((char) c, 1, Integer::sum));
        Comparator<Character> valueComparator = Comparator.comparingInt((Character key) -> unsortedFrequency.get(key))
                .thenComparing(Comparator.naturalOrder())
                .reversed();
        Map<Character, Integer> sortedFrequency = new TreeMap<>(valueComparator);
        sortedFrequency.putAll(unsortedFrequency);
        return sortedFrequency;
    }
}
