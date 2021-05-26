package com.simkin.usrPool.controller;

import com.simkin.usrPool.entity.PoolEntity;
import com.simkin.usrPool.exception.PoolAlreadyExistException;
import com.simkin.usrPool.service.PoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pools")
public class PoolController {

    @Autowired
    private PoolService poolService;

    @PostMapping
    public ResponseEntity createPool(@RequestBody PoolEntity pool) {
        try {
            poolService.createPool(pool);
            return ResponseEntity.ok("Опрос сохранен");
        } catch (PoolAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getOnePool(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(poolService.getOne(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePool(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(poolService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updatePool(@RequestParam Long id, @RequestParam String description){
        try {
            return ResponseEntity.ok(poolService.updatePool(id, description));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/active")
    public ResponseEntity getActivePool(){
        try{
            return ResponseEntity.ok(poolService.getAllActive());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
