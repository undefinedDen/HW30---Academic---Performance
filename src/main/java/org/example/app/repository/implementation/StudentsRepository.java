package org.example.app.repository.implementation;

import org.example.app.config.DatabaseConfiguration;
import org.example.app.entity.Student;
import org.example.app.repository.IRepository;
import org.example.app.util.ERROR;
import org.example.app.util.SUCCESS;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;



import java.util.List;
import java.util.Optional;

public class StudentsRepository implements IRepository<Student> {


    @Override
    public String create(Student student) {
        Transaction transaction = null;
        try (Session session = DatabaseConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hqlInsertQuery = "INSERT INTO Student (" +
                    "studentName, studentEmail, studentMark)" +
                    "VALUES(:studentName, :studentEmail, :studentMark)";
            MutationQuery insertQuery = session.createMutationQuery(hqlInsertQuery);
            insertQuery.setParameter("studentName", student.getStudentName());
            insertQuery.setParameter("studentEmail", student.getStudentEmail());
            insertQuery.setParameter("studentMark", student.getStudentMark());
            insertQuery.executeUpdate();
            transaction.commit();
            return SUCCESS.CREATED.getMessage();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }

    }

    @Override
    public Optional<List<Student>> read() {
        try (Session session = DatabaseConfiguration.getSessionFactory().openSession()) {
            Transaction transaction;
             transaction = session.beginTransaction();
            List<Student> data = session.createQuery(
                    "FROM Student", Student.class
            ).list();
            transaction.commit();
            return Optional.of(data);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public String update(Student student) {
        if (findById(student.getStudentId()).isEmpty()) {
            return ERROR.ABSENT_DATA.getMessage();
        } else {
            Transaction transaction = null;
            Session session = null;
            try {
                session = DatabaseConfiguration.getSessionFactory().openSession();
                transaction = session.beginTransaction();
                String hqlUpdateQuery = "UPDATE Student " +
                        "SET " +
                        "studentName = :studentName" +
                        ", studentEmail = :studentEmail" +
                        ", studentMark = :studentMark WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hqlUpdateQuery);
                query.setParameter("studentName", student.getStudentName());
                query.setParameter("studentEmail", student.getStudentEmail());
                query.setParameter("studentMark", student.getStudentMark());
                query.setParameter("id", student.getStudentId());
                query.executeUpdate();
                transaction.commit();
                return SUCCESS.UPDATED.getMessage();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                return e.getMessage();
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
        }
    }

    @Override
    public String delete(Long id) {
        if (findById(id).isEmpty()) {
            return ERROR.ABSENT_DATA.getMessage();
        } else {
            Transaction transaction = null;
            try (Session session = DatabaseConfiguration.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                String hqlDeleteQuery = "DELETE FROM Student WHERE id = :id";
                MutationQuery query = session.createMutationQuery(hqlDeleteQuery);
                query.setParameter("id", id);
                query.executeUpdate();
                transaction.commit();
                return SUCCESS.DELETED.getMessage();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                return e.getMessage();
            }
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        Optional<Student> optional;
        try (Session session = DatabaseConfiguration.getSessionFactory().openSession()) {
            Transaction transaction;
             transaction = session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student student WHERE student.id = :id", Student.class);
            query.setParameter("id", id);
            optional = query.uniqueResultOptional();
            transaction.commit();
            return optional;
        }catch (Exception e){

            return Optional.empty();
        }

    }
}
