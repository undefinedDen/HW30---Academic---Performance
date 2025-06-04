package org.example.app.repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<T> {
    String create(T object);
    Optional <List<T>> read();
    String update(T object);
    String delete(Long id);
    Optional <T> findById(Long id);

}
