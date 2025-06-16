package com.xpinc.assessor.service;

import com.xpinc.assessor.domain.VariaveisMacro;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class VariaveisMacroService {
    private final Map<Long, VariaveisMacro> store = new HashMap<>();
    private long seq = 1;
    public List<VariaveisMacro> findAll() { return new ArrayList<>(store.values()); }
    public Optional<VariaveisMacro> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public VariaveisMacro save(VariaveisMacro v) {
        if (v.getId() == null) v.setId(seq++);
        store.put(v.getId(), v);
        return v;
    }
    public void delete(Long id) { store.remove(id); }
}