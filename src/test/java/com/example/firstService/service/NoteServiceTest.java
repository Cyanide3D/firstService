package com.example.firstService.service;

import com.example.firstService.FirstServiceApplication;
import com.example.firstService.model.Note;
import com.example.firstService.repo.NoteRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class NoteServiceTest {

    @MockBean
    private NoteRepo repo;
    @MockBean
    private NoteService service;

    @Test
    void list() {
        List<Note> notes = List.of(new Note("1", "2"), new Note("3", "4"));
        Mockito.when(service.list()).thenReturn(notes);
        List<Note> list = service.list();
        assertArrayEquals(notes.toArray(), list.toArray());
    }

    @Test
    void byId() {
        Note note = new Note("1", "2");
        note.setId(1L);
        Mockito.when(service.byId(1L)).thenReturn(note);
        assertEquals(note, service.byId(1L));
    }

    @Test
    void save() {
        Note note = new Note("1", "2");
        Mockito.when(service.save(note)).thenReturn(note);
        assertEquals(note, service.save(note));
    }

}