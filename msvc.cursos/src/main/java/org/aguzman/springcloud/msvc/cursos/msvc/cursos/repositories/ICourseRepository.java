package org.aguzman.springcloud.msvc.cursos.msvc.cursos.repositories;

import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course, Long> {
    Long id(Long id);
}
