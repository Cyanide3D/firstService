package com.example.firstService.controller;

import com.example.firstService.model.Note;
import com.example.firstService.service.NoteService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class IndexController {

    @Autowired
    private NoteService service;

    @GetMapping
    public ResponseEntity<List<Note>> notes() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Note> byId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.byId(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Note> save(@RequestBody Note note) {
        return ResponseEntity.ok(service.save(note));
    }

}
