package com.softagape.myjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import  java.util.List;
import java.util.Optional;

@Service
public class PhoneBookServiceImpl implements IPhoneBookService<IPhoneBook> {
    @Autowired
    private PhoneBookJpaRpository phoneBookJpaRpository;

    private boolean isValidInsert(IPhoneBook dto) {
        if (dto == null) {
            return false;
        } else if (dto.getName() == null || dto.getName().isEmpty() ) {
            return false;
        } else if (dto.getCategory() == null || dto.getCategory().isEmpty() ) {
            return false;
        }
        return true;
    }
    @Override
    public IPhoneBook findById(Long id) {
        Optional<PhonebookEntity> find = this.phoneBookJpaRpository.findById(id); // <PhonebookEntity> 저장할 데이터(Long, null) 부모 데이터 저장X, 자동 형변환
        return find.orElse(null);
    }

    @Override
    public List<IPhoneBook> getAllList() {
        List<IPhoneBook> list = new ArrayList<>();
        for ( PhonebookEntity entity : this.phoneBookJpaRpository.findAll() ) { //  @Entity 선언만 가능, 부모 배열로 형변환
            list.add( (IPhoneBook)entity );
        }
        return list;
    }

    @Override
    public IPhoneBook insert(String name, String category, String phoneNumber, String email) throws Exception {
        PhonebookDto phoneBook = PhonebookDto.builder()
                .id(0L)
                .name(name).category(category)
                .phoneNumber(phoneNumber).email(email).build();
        return this.insert(phoneBook);
    }

    @Override
    public IPhoneBook insert(IPhoneBook phoneBook) throws Exception {
        if ( !this.isValidInsert(phoneBook)) {
            return null;
        }
        PhonebookEntity entity = new PhonebookEntity();
        entity.copyFields(phoneBook);
        IPhoneBook result = this.phoneBookJpaRpository.saveAndFlush(entity); // save - flush 같이 표기,
        return result;
    }

    @Override
    public boolean remove(Long id) {
        IPhoneBook find = this.findById(id);
        if ( find != null ) {
            this.phoneBookJpaRpository.deleteById(id);
            return true;
        }
        return false;
    }

    private boolean setIphoneBookIsNotNull(IPhoneBook to, IPhoneBook from) {
        if ( to == null || from == null ) {
            return false;
        }
        if ( from.getName() != null && !from.getName().isEmpty() ) {
            to.setName(from.getName());
        }
        if ( from.getCategory() != null ) {
            to.setCategory(from.getCategory());
        }
        if ( from.getPhoneNumber() != null && !from.getPhoneNumber().isEmpty() ) {
            to.setPhoneNumber(from.getPhoneNumber());
        }
        if ( from.getEmail() != null && !from.getEmail().isEmpty() ) {
            to.setEmail(from.getEmail());
        }
        return true;
    }

    @Override
    public IPhoneBook update(Long id, IPhoneBook phoneBook) {
        IPhoneBook find = this.findById(id);
        if (find != null) {
            find.copyFields(phoneBook);
            return find;
        }
        return null;
    }

    @Override
    public List<IPhoneBook> getListFromName(String findName) {
        if (findName == null || findName.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromGroup(ECategory category) {
        if (category == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromPhoneNumber(String findPhone) {
        if (findPhone == null || findPhone.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    @Override
    public List<IPhoneBook> getListFromEmail(String findEmail) {
        if (findEmail == null || findEmail.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

}

