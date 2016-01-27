package com.ingesup.labojava.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.ingesup.labojava.bean.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
private static final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	
	// Methods 
	
	@Override
	public void addStudent(Student std) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(std);
		logger.info("Student saved successfully, Student details : "+ std);		
	}

	@Override
	public void updateStudent(Student std) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(std);
		logger.info("Student updated successfully, Student details : "+ std);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> listStudents() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> stdList = session.createQuery("from Student").list();
		
		for (Student s : stdList)
			logger.info("Student List :: "+ s);
		return stdList;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public Student getStudent(String email, String pass) {
		
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student s where s.email = :email and s.password = :password");
		query.setParameter("email", email);
		query.setParameter("password", pass);
		
		List<Student> stdList = query.list();
		
		if (stdList.isEmpty())
			return null;
		
		logger.info("Student loaded successfully, Student Details:"+ stdList.get(0));
		
		return stdList.get(0);
	}

	@Override
	public void removeStudent(Long id) {

		Session session = this.sessionFactory.getCurrentSession();
		Student std = (Student) session.load(Student.class, new Long(id));
		
		if (std != null)
			session.delete(std);
		
		logger.info("Student deleted successfully, Student details:"+ std);
		
	}

}
