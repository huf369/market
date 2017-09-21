package models.domain;

import java.util.List;

import org.mybatis.guice.transactional.Transactional;

import com.google.inject.Inject;
import com.google.inject.Injector;

import models.domain.mappers.PersonMapper;

public class Person implements PersonDao {

	private Integer id;
	 @Inject
	 private Injector injector;
	 @Inject
	 private PersonMapper personMapper;
	 private String name;
	 private Integer sex;
	 private Integer age;
	 private String comment;

	 public Integer getId() {
	  return id;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public Integer getSex() {
	  return sex;
	 }
	 public void setSex(Integer sex) {
	  this.sex = sex;
	 }
	 public Integer getAge() {
	  return age;
	 }
	 public void setAge(Integer age) {
	  this.age = age;
	 }

	 public String getComment() {
	  return comment;
	 }

	 public void setComment(String comment) {
	  this.comment = comment;
	 }

	 @Override
	 public Person getById(int id) {
	  return this.personMapper.getById(id);
	 }

	 @Override
	 public List getAll() {
	  return this.personMapper.getAll();
	 }

	 @Override
	 @Transactional
	 public int save(Person person) {
	  if (person == null){
	   return -1;
	  }
	  if (person.getId() == null)
	   return this.personMapper.append(person);
	  else
	   return this.personMapper.update(person);
	 }

	 @Override
	 @Transactional
	 public int remove(int id) {
	  return this.personMapper.remove(id);
	 }

	 @Override
	 public void printInfo() {
	  System.out.println("injector is " + this.injector);
	  System.out.println("PersonMapper is " + this.personMapper);
	 }

}
