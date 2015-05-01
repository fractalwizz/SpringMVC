package net.codejava.springmvc.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.codejava.springmvc.model.Class;

public interface ClassDAO {
	
	public void saveOrUpdate(Class clss);
	
	public void upload(MultipartFile file);
	
	public void delete(String name);
	
	public Class get(String name);
	
	public List<Class> list();
}