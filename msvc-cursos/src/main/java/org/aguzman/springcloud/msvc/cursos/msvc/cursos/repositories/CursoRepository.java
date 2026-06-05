package org.aguzman.springcloud.msvc.cursos.msvc.cursos.repositories;

import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    Long id(Long id);
}
