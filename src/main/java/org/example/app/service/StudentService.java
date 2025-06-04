package org.example.app.service;

import org.example.app.entity.Mapper;
import org.example.app.entity.Student;
import org.example.app.exception.StudentException;
import org.example.app.repository.implementation.StudentsRepository;
import org.example.app.util.AppValidator;
import org.example.app.util.ERROR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class StudentService {
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);
    StudentsRepository repository = new StudentsRepository();

    public String createStudent(Map<String, String> data) {
        Map<String, String> errors = AppValidator.validateStudents(data);
        if (!errors.isEmpty()) {
            try {
                throw new StudentException("Error", errors);
            } catch (StudentException e) {
                LOG.error("Error creating student: {}", e.showErrors(errors));
                return e.showErrors(errors);
            }
        }
        return repository.create(new Mapper().mapData(data));
    }

    public String readStudents() {
        Optional<List<Student>> optional = repository.read();
        if (optional.isPresent()) {
            List<Student> list = optional.get();
            if (!list.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                AtomicInteger count = new AtomicInteger(0);
                list.forEach(student ->
                        stringBuilder
                                .append(count.incrementAndGet())
                                .append(") ")
                                .append(student));
                return stringBuilder.toString();
            } else {
                LOG.error("Error reading student: {}", ERROR.ABSENT_DATA);
                return ERROR.ABSENT_DATA.getMessage();
            }
        } else {
            LOG.error("Error reading student: List is null");
            return ERROR.ABSENT_DATA.getMessage();
        }
    }

    public String updateStudent(Map<String, String> data) {
        Map<String, String> errors = AppValidator.validateStudents(data);
        if (!errors.isEmpty()) {
            try {
                throw new StudentException("Error", errors);
            } catch (StudentException e) {
                LOG.error("Error updating student: {}", e.showErrors(errors));
                return e.showErrors(errors);
            }
        }
        return repository.update(new Mapper().mapData(data));
    }

    public String deleteStudent(Map<String, String> data) {
        Map<String, String> errors = AppValidator.validateStudents(data);
        if (!errors.isEmpty()) {
            try {
                throw new StudentException("Error", errors);
            } catch (StudentException e) {
                LOG.error("Error deleting Student: {}", e.showErrors(errors));
                return e.showErrors(errors);
            }
        }
        return repository.delete(new Mapper().mapData(data).getStudentId());
    }

    public String findStudentById(Map<String, String> data) {
        Map<String, String> errors = AppValidator.validateStudents(data);
        if (!errors.isEmpty()) {
            try {
                throw new StudentException("Error", errors);
            } catch (StudentException e) {
                LOG.error("Error, student do not find: {}", e.showErrors(errors));
                return e.showErrors(errors);
            }
        }
        Optional<Student> optional = repository.findById(Long.parseLong(data.get("id")));
        if (optional.isPresent()) {
            Student student = optional.get();
            return student.toString();

        } else {
            return ERROR.ABSENT_DATA.getMessage();
        }
    }
}
