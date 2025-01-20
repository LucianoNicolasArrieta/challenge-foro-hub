package com.lna.api.forohub.repository;

import com.lna.api.forohub.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
