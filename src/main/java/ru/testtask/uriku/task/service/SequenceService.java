package ru.testtask.uriku.task.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public interface SequenceService {

    public Map<Character, Integer> getFrequency(String sequence);

}
