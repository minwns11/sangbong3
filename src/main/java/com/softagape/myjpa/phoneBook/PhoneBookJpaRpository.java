package com.softagape.myjpa.phoneBook;

import com.softagape.myjpa.catCategory.CategoryEntity;
import com.softagape.myjpa.catCategory.ICategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookJpaRpository extends JpaRepository<PhonebookEntity, Long> {
    List<PhonebookEntity> findAllByNameContains(String name);
    List<PhonebookEntity> findAllByCategory(CategoryEntity category);
    List<PhonebookEntity> findAllByPhoneNumberContains(String phoneNumber);
    List<PhonebookEntity> findAllByEmailContains(String email);

}
