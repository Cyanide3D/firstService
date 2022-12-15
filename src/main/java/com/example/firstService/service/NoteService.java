package com.example.firstService.service;

import com.example.firstService.model.Note;
import com.example.firstService.repo.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepo repo;

    public List<Note> list() {
        return repo.findAll();
    }

    public Note byId(Long id) {
        return repo.findById(id).orElse(new Note());
    }

    public Note save(Note note) {
        return repo.save(note);
    }

    public void delete(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }

}
