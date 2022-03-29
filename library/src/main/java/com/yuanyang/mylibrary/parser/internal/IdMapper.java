package com.yuanyang.mylibrary.parser.internal;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IdMapper extends HashMap<String, Integer> {


    private static IdMapper idMapper;
    private AtomicInteger idGenerator = new AtomicInteger();

    public static synchronized IdMapper getInstance() {
        if (idMapper == null) {
            idMapper = new IdMapper();
        }
        return idMapper;
    }

    private IdMapper() {
    }

    private IdMapper(Map<? extends String, ? extends Integer> m) {
        super(m);
    }

    private IdMapper(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    private IdMapper(int initialCapacity) {
        super(initialCapacity);
    }

    public int nextId() {
        return idGenerator.incrementAndGet();
    }
}
