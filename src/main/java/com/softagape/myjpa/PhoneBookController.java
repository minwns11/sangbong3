package com.softagape.myjpa;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // 웹 주소를 전달하여 정보를 받아서 처리하는 기능, 화면을 만들 때 주로 사용하며 화면대신 json 표기함
@Slf4j // 로깅(기록)을 위한 코드를 자동으로 생성
@RestController // json이 바뀌는 주소
@RequestMapping("/pb") // 모든 엔드포인트(API의 접근할 수 있는 URL 경로)를 "/pb"로 설정
public class PhoneBookController {
    private static Logger logger = (Logger) LoggerFactory.getLogger(PhoneBookController.class);

    @Autowired // 자동 의존성주입(한 객체가 다른 객체 사용 시 외부로 주입받는 패턴) 어노테이션
    private IPhoneBookService phoneBookService;

    @PostMapping // 생략 = ("/pb")
    public ResponseEntity<IPhoneBook> insertPB(@RequestBody PhoneBookRequest dto) { // 확실하게 @RequestBody로 json을 받음
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.insert(dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IPhoneBook>> getAll() {
        try {
            List<IPhoneBook> result = this.phoneBookService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            Boolean result = this.phoneBookService.remove(id);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IPhoneBook> update(@PathVariable Long id, @RequestBody PhoneBookRequest dto) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }
            IPhoneBook result = this.phoneBookService.update(id, dto);
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

}
