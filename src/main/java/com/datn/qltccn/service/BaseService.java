package com.datn.qltccn.service;

import java.util.List;

public interface BaseService<T> {
    void add(T t);

    T getById(Integer id);

    List<T> getAll();

    void delete(Integer id);

    void edit(T t);
}
