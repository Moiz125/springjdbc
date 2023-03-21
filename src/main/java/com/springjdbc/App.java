package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.Config;
import com.springjdbc.dao.PersonDao;
import com.springjdbc.dao.PersonDaoImpl;
import com.springjdbc.entities.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml"); //USING XML
        ApplicationContext contextt = new AnnotationConfigApplicationContext(Config.class);//USING CONFIG
//        person p = context.getBean("person",person.class);
        PersonDao personDao = contextt.getBean("personDaoImpl",PersonDaoImpl.class);
        
//        Person person = new Person(21,"Sheeraz");
//        Person person2 = new Person(22,"Moiz");
//          Person person3 = personDao.getPerson(22);
//        System.out.println(personDao.insert(person2));
//        System.out.println(person3);
//        System.out.println(personDao.change(person2));
//        System.out.println(personDao.delete(125));
        List<Person> person4 = personDao.getAllPersons();
        for(Person p:person4) {
        	System.out.println(p);
        }
    }
}
