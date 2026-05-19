package org.aguzman.springcloud.msvc.cursos.msvc.cursos.services;

import lombok.RequiredArgsConstructor;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Course;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.repositories.ICourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {

    private final ICourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> listCourse() {
        return (List<Course>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> courseById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }
}
