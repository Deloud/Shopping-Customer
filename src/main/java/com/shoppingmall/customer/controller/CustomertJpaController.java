package com.shoppingmall.customer.controller;

import com.shoppingmall.customer.domain.User;
import com.shoppingmall.customer.exception.UserNotFoundException;
import com.shoppingmall.customer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("")
public class CustomertJpaController {

    @Autowired
    private UserRepository userRepository;

    //전체 고객 정보 받기
    @GetMapping("")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    //번호로 고객 정보 받아오기
    @GetMapping("/{id}")
    public Optional<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user;
    }

    //고객 정보 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }


    // 고객 등록
    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    //정보수정
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setId(id);

        userRepository.save(user);

        return ResponseEntity.noContent().build();
    }

}