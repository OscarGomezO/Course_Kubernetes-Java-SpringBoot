package org.aguzman.springcloud.msvc.cursos.msvc.cursos.services;

import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    List<Course> listCourse();

    Optional<Course> courseById(Long id);

    Course saveCourse(Course course);

    void deleteCourse(Long id);
}
