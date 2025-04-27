package org.jsp.dre.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.jsp.dre.dao.UserDao;
import org.jsp.dre.dto.MatchingUser;
import org.jsp.dre.entity.User;
import org.jsp.dre.responsestructure.ResponseStructure;
import org.jsp.dre.util.SortByAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private EmailService emailService;

    public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
        User savedUser = dao.saveUser(user);

        ResponseStructure<User> rs = ResponseStructure.<User>builder()
                .status(HttpStatus.OK.value())
                .message("User saved successfully!")
                .body(savedUser)
                .build();

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<User>>> findAll() {
        List<User> findAll = dao.findAll();

        ResponseStructure<List<User>> rs = ResponseStructure.<List<User>>builder()
                .status(HttpStatus.OK.value())
                .message("Fetched all users successfully!")
                .body(findAll)
                .build();

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
        Optional<User> optional = dao.findUserById(id);

        if (optional.isPresent()) {  // Fixed here
            ResponseStructure<User> rs = ResponseStructure.<User>builder()
                    .status(HttpStatus.OK.value())
                    .message("User found")
                    .body(optional.get())
                    .build();

            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            ResponseStructure<User> rs = ResponseStructure.<User>builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .message("User not found with given ID")
                    .body(null)
                    .build();

            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> findMatch(int id, int top) {
        Optional<User> optional = dao.findUserById(id);

        if (optional.isEmpty()) {
            throw new RuntimeException("Invalid user ID, unable to find top matches.");
        }

        User user = optional.get();

        // Determine opposite gender
        String oppositeGender = user.getGender().equalsIgnoreCase("MALE") ? "FEMALE" : "MALE";

        List<User> users = dao.findByGender(oppositeGender);
        List<MatchingUser> matchingUsers = new ArrayList<>();

        for (User u : users) {
            MatchingUser mu = new MatchingUser();

            mu.setId(u.getId());
            mu.setName(u.getName());
            mu.setEmail(u.getEmail());
            mu.setPhone(u.getPhone());
            mu.setPassword(u.getPassword());
            mu.setAge(u.getAge());
            mu.setIntrests(u.getIntrests());
            mu.setGender(u.getGender());

            // Corrected age difference calculation
            int ageDifference = Math.abs(user.getAge() - u.getAge());
            mu.setAgeDifference(ageDifference);

            // Count matching interests
            int matchingInterestCount = 0;
            List<String> interests1 = user.getIntrests();
            List<String> interests2 = u.getIntrests();

            for (String interest : interests1) {
                if (interests2.contains(interest)) {
                    matchingInterestCount++;
                }
            }
            mu.setMatchingIntrestCount(matchingInterestCount);

            matchingUsers.add(mu);
        }

        Collections.sort(matchingUsers, new SortByAge());

        List<MatchingUser> result = new ArrayList<>();

        for (MatchingUser mu : matchingUsers) {
            if (top == 0) {
                break;
            }
            result.add(mu);
            top--;
        }

        ResponseStructure<List<MatchingUser>> rs = ResponseStructure.<List<MatchingUser>>builder()
                .status(HttpStatus.OK.value())
                .message("Top matching users sorted successfully.")
                .body(result)
                .build();

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    public ResponseEntity<?> search(String name) {
        List<User> all = dao.findAll();
        List<User> result = new ArrayList<>();

        for (User u : all) {
            if (u.getName().toLowerCase().contains(name.toLowerCase())) {  // Made it case-insensitive
                result.add(u);
            }
        }

        ResponseStructure<List<User>> rs = ResponseStructure.<List<User>>builder()
                .status(HttpStatus.OK.value())
                .message("Matching users found successfully.")
                .body(result)
                .build();

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
