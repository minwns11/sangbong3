package com.softagape.myjpa.phoneBook;

import com.softagape.myjpa.catCategory.ICategory;

import java.util.List;

public interface IPhoneBookService<T> {
    T findById(Long id);
    List<T> getAllList();
    IPhoneBook insert(T phoneBook) throws Exception;
    boolean remove(Long id) throws Exception;
    IPhoneBook update(Long id, T dto) throws Exception;
    List<T> getListFromName(String findName);
    List<T> getListFromCategory(ICategory category);
    List<T> getListFromPhoneNumber(String findPhone);
    List<T> getListFromEmail(String findEmail);
}
