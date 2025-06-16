package com.xpinc.assessor.service;

import com.xpinc.assessor.domain.Cliente;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ClienteService {
    private final Map<Long, Cliente> store = new HashMap<>();
    private long seq = 1;
    public List<Cliente> findAll() { return new ArrayList<>(store.values()); }
    public Optional<Cliente> findById(Long id) { return Optional.ofNullable(store.get(id)); }
    public Cliente save(Cliente c) {
        if (c.getId() == null) c.setId(seq++);
        store.put(c.getId(), c);
        return c;
    }
    public void delete(Long id) { store.remove(id); }
}