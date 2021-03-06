package com.rso.controller;

import com.rso.dto.UserEntityDto;
import com.rso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/users")
public class UserController  {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{nipNumber}/id")
    public ResponseEntity<?> getCompanyDetails(@PathVariable String nipNumber) {
        return userService.getCompanyDetailsForNip(nipNumber);
    }

    @GetMapping(value = "/{userId}/offers")
    public ResponseEntity<?> getOffersForUserId(@PathVariable long userId, @RequestParam String status) {
        return userService.getOffersForUserId(userId, status);
    }

    @DeleteMapping(value = "/{userId}/offers")
    public ResponseEntity<?> removeOffersForUserId(@PathVariable long userId) {
        return userService.removeOffersForUserId(userId);
    }

    @PutMapping(value = "/{userId}")
    public ResponseEntity<?> editUserDetails(@RequestBody UserEntityDto newData, @PathVariable Long userId) {
        return userService.editDetailsForUserId(newData, userId);
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> deleteUserAccount(@PathVariable long userId) {
        return userService.deleteAccountForUserId(userId);
    }

    @GetMapping(value = "/{userId}/payments")
    public ResponseEntity<?> getPaymentsForUser(@PathVariable Long userId, @RequestParam String status) {
        return userService.getPaymentsForUserId(userId, status);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> saveNewUser(@RequestBody String requestBody) throws IOException {
        return userService.createNewUserAccount(requestBody);
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> testMicroService() {
        return userService.testService();
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

}
