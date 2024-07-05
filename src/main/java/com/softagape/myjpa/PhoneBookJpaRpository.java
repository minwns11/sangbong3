package com.softagape.myjpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookJpaRpository extends JpaRepository<PhonebookEntity, Long> {
    List<PhonebookEntity> findAllByNameContains(String name);
    List<PhonebookEntity> findAllByCategory(ECategory category);
    List<PhonebookEntity> findAllByPhoneNumberContains(String phoneNumber);
    List<PhonebookEntity> findAllByEmailContains(String email);

}
