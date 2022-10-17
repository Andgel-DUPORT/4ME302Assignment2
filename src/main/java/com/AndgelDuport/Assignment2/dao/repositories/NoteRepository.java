package com.AndgelDuport.Assignment2.dao.repositories;

import com.AndgelDuport.Assignment2.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
