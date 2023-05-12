package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.dao.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
