package br.com.projetofinal.api.dao.util;

import java.util.List;

public interface InterfaceDao<T> {
    public void insert(T item);
    public List<T> getAll();
    public T getById(int id);
    public void update(T item);
    public void delete(T item);
}
