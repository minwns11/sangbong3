package com.softagape.myjpa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="phonebook_tb")
public class PhonebookEntity implements IPhoneBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50, unique = true) // unique = true 중복값 예외처리
    private String name;

    @NotNull
    @Column(length = 10)
    private String category;

    @NotNull
    @Column(length = 20)
    private String phoneNumber;

    @Column(length = 200)
    private String email;

    @Override
    public String toString() {
        return String.format("{ID:%6d, 이름:%s, 분류:%s, 번호:%s, 이메일:%s}"
                , this.id, this.name, this.category, this.phoneNumber, this.email);
    }

}

