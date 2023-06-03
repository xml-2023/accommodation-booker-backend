package com.kncm.ratingservice.controller;

import com.kncm.ratingservice.service.hostgrade.HostGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
@RequiredArgsConstructor
public class HostGradeController {
    private final HostGradeService hostGradeService;

//    @PostMapping
//    public ResponseEntity<Void> create(){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
