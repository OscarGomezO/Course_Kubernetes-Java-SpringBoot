package org.aguzman.springcloud.msvc.cursos.msvc.cursos.services;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
/*
@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {

    @Mock
    ICourseRepository repository;
    @InjectMocks
    CourseServiceImpl service;
    Course course;

    @BeforeEach
    void setUp() {
        course = new Course(1L, "Fisica");
    }

    @Test
    void listCourse() {
        Mockito.when(repository.findAll())
                .thenReturn(Collections.singletonList(course));

        List<Course> courses = service.listCourse();

        Assertions.assertFalse(courses.isEmpty());
        Assertions.assertEquals(1, courses.size());
        Course course1 = courses.getFirst();
        Assertions.assertEquals(1L, course1.getId());
        Assertions.assertEquals("Fisica", course1.getName());
    }

    @Test
    void courseById() {
        //Arrange
        Mockito.when(repository.findById(anyLong()))
                .thenReturn(Optional.of(course));
        //Act
        Optional<Course> optionalCourse = service.courseById(1L);
        //Assert
        optionalCourse
                .ifPresentOrElse(
                        courseById -> {
                            Assertions.assertEquals(1L, courseById.getId());
                            Assertions.assertEquals("Fisica", courseById.getName());
                        },
                        () -> fail("Expected a course")
                );
    }

    //Programar la prueba unitaria para los metodos de guardarCurso y eliminarCurso.

    @Test
    void saveCourse() {
        //Arrange
        Course saveCourse = new Course();
        saveCourse.setId(1L);
        saveCourse.setName("Fisica");
        Mockito.when(repository.save(any(Course)))
                .thenReturn(saveCourse);
        //Act
        Course result = service.saveCourse(new Course());
        //Assert
        Assertions.assertEquals(1L, result.getId());
        Assertions.assertEquals("Fisica", result.getName());
        Mockito.verify(repository).save(any(Course));
    }

    @Test
    void deleteCourse() {
        // 1. ARRANGE
        Long courseId = 1L;
        when(repository.existsById(courseId)).thenReturn(true);
        doNothing().when(repository).deleteById(courseId);
        // 2. ACT
        service.deleteCourse(courseId);
        // 3. ASSERT
        verify(repository, times(1)).existsById(courseId);
    }

}

*/
