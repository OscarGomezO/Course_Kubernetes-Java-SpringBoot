package org.aguzman.springcloud.msvc.cursos.msvc.cursos.controllers;

import feign.Response;
import jakarta.validation.Valid;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.entity.Curso;
import org.aguzman.springcloud.msvc.cursos.msvc.cursos.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Curso> o = service.porId(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Curso curso, BindingResult result) {
        if(result.hasErrors()) {
            return validar(result);
        }
        Curso cursoDb = service.guardar(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Curso curso, BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()) {
            return validar(result);
        }
        Optional<Curso> o = service.porId(id);
        if (o.isPresent()) {
            Curso cursoDb = o.get();
            cursoDb.setNombre(curso.getNombre());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cursoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Curso> o = service.porId(id);
        if(o.isPresent()){
            service.eliminar(o.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
    /*
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
    */

}

