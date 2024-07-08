package com.softagape.myjpa.catCategory;

import com.softagape.myjpa.phoneBook.ECategory;
import java.util.List;

public interface ICategoryService<T> {
    T findById(Long id);
    T findByName(String name);
    List<T> getAllList();
    ICategory insert(String name) throws Exception;
    ICategory insert(T category) throws Exception;
    boolean remove(Long id) throws Exception;
    ICategory update(Long id, T category) throws Exception;
    List<T> findAllByNameContains(String name);
}
