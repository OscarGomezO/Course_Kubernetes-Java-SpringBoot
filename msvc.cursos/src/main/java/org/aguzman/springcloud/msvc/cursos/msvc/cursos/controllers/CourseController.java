package org.aguzman.springcloud.msvc.cursos.msvc.cursos.controllers;

import lombok.RequiredArgsConstructor;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Course;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.services.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/courses")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> listCourse() {
        return ResponseEntity.status(200).body(service.listCourse());
    }

    @GetMapping("/search-course-by-id/{id}")
    public ResponseEntity<Course> detailCourse(@PathVariable Long id) {
        Optional<Course> optionalCourse = service.courseById(id);
        return optionalCourse
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course course0B = service.saveCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(course0B);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Course> editCourse(@RequestBody Course course, @PathVariable Long id) {
        Optional<Course> optionalCourse = service.courseById(id);
        return optionalCourse
                .map(courseRetrieved -> {
                    courseRetrieved.setName(course.getName());
                    return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCourse(courseRetrieved));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        Optional<Course> optionalCourse = service.courseById(id);
        return optionalCourse
                .map(courseRetrieved -> {
                    service.deleteCourse(courseRetrieved.getId());
                    return ResponseEntity.ok("The course was deleted");
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

