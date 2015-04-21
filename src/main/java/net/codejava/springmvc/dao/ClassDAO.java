package net.codejava.springmvc.dao;

import java.util.List;
import net.codejava.springmvc.model.Class;

public interface ClassDAO {
	
	public void saveOrUpdate(Class clss);
	
	public void delete(String name);
	
	public Class get(String name);
	
	public List<Class> list();
}