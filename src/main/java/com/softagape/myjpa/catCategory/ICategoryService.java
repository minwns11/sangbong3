package com.softagape.myjpa.catCategory;

import java.util.List;

public interface ICategoryService<T> {
    ICategory findById(Long id);
    ICategory findByName(String name);
    List<T> getAllList();
    ICategory insert(T category) throws Exception;
    boolean remove(Long id) throws Exception;
    ICategory update(Long id, T category) throws Exception;
    List<T> findAllByNameContains(String name);
}
