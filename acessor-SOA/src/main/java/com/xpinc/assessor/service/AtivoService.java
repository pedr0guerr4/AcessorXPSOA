package com.xpinc.assessor.service;

import com.xpinc.assessor.domain.Ativo;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class AtivoService {
    private final Map<Long, Ativo> store = new HashMap<>();
    private long seq = 1;
    public List<Ativo> findAll() { return new ArrayList<>(store.values()); }
    public Optional<Ativo> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Ativo save(Ativo a) {
        if (a.getId() == null) a.setId(seq++);
        store.put(a.getId(), a);
        return a;
    }
    public void delete(Long id) { store.remove(id); }
}