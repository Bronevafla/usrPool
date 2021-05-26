package com.simkin.usrPool.controller;

import com.simkin.usrPool.entity.QuestionEntity;
import com.simkin.usrPool.exception.QuestionAlreadyExistException;
import com.simkin.usrPool.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity createQuestion(@RequestBody QuestionEntity question,
                                         @RequestParam Long poolId) {
        try {
            return ResponseEntity.ok(questionService.create(question, poolId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOneQuestion(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(questionService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteQuestion(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questionService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeQuestion(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(questionService.completeQuestion(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


}
