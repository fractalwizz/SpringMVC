package net.codejava.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import net.codejava.springmvc.model.Class;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class ClassDaoImpl implements ClassDAO {
	
	private JdbcTemplate jdbcTemplate;
	 
    public ClassDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void saveOrUpdate(Class clss) {
    	
    	if (clss.getName().isEmpty()) {
    		//update
    		String sql = "UPDATE classdb SET numStud=?, teachFirst=?, teachLast=?, "
    				+ "timeStart=?, timeEnd=?, dayM=?, dayT=?, dayW=?, dayTh=?, dayF=?, "
    				+ "tag=? WHERE name=?";
    		
    		jdbcTemplate.update(sql, clss.getNumStud(), clss.getTeachFirst(), clss.getTeachLast(), 
    				clss.getTimeStart(), clss.getTimeEnd(), clss.getDayM(), clss.getDayT(), clss.getDayW(), 
    				clss.getDayTh(), clss.getDayF(), clss.getTag(), clss.getName());
    	}
    	else
    	{
    		//insert
    		String sql = "INSERT INTO classdb (name, numStud, teachFirst, teachLast, timeStart, "
    				+ "timeEnd, dayM, dayT, dayW, dayTh, dayF, tag)"
    				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    		
    		jdbcTemplate.update(sql, clss.getName(), clss.getNumStud(), clss.getTeachFirst(), 
    				clss.getTeachLast(), clss.getTimeStart(), clss.getTimeEnd(), clss.getDayM(), 
    				clss.getDayT(), clss.getDayW(), clss.getDayTh(), clss.getDayF(), clss.getTag());
    	}
    	
    }
    
    public void delete(String name){
    	
    	String sql = "DELETE FROM classdb WHERE name=?";
    	
    	jdbcTemplate.update(sql, name);
    	
    }
    
    public List<Class> list(){
    	
    	String sql = "SELECT * FROM classdb";
    	List<Class> listClass = jdbcTemplate.query(sql, new RowMapper<Class>(){
    		
    		@Override
    		public Class mapRow(ResultSet rs, int rowNum) throws SQLException{
    			Class aClass = new Class();
    			
    			aClass.setName(rs.getString("name"));
    			aClass.setNumStud(rs.getInt("numStud"));
    			aClass.setTeachFirst(rs.getString("teachFirst"));
    			aClass.setTeachLast(rs.getString("teachLast"));
    			aClass.setTimeStart(rs.getString("timeStart"));
    			aClass.setTimeEnd(rs.getString("timeEnd"));
    			aClass.setDayM(rs.getBoolean("dayM"));
    			aClass.setDayT(rs.getBoolean("dayT"));
    			aClass.setDayW(rs.getBoolean("dayW"));
    			aClass.setDayTh(rs.getBoolean("dayTh"));
    			aClass.setDayF(rs.getBoolean("dayF"));
    			aClass.setTag(rs.getString("tag"));
    			
    			return aClass;
    		}
    		
    	});
    	
    	return listClass;
    	
    }
	
	@Override
	public Class get(String name){
		
		String sql = "SELECT * FROM classdb WHERE name='" + name + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Class>(){
			
			@Override
			public Class extractData(ResultSet rs) throws SQLException,
			DataAccessException{
				
				if (rs.next()){
					
					Class clss = new Class();
	    			
	    			clss.setName(rs.getString("name"));
	    			clss.setNumStud(rs.getInt("numStud"));
	    			clss.setTeachFirst(rs.getString("teachFirst"));
	    			clss.setTeachLast(rs.getString("teachLast"));
	    			clss.setTimeStart(rs.getString("timeStart"));
	    			clss.setTimeEnd(rs.getString("timeEnd"));
	    			clss.setDayM(rs.getBoolean("dayM"));
	    			clss.setDayT(rs.getBoolean("dayT"));
	    			clss.setDayW(rs.getBoolean("dayW"));
	    			clss.setDayTh(rs.getBoolean("dayTh"));
	    			clss.setDayF(rs.getBoolean("dayF"));
	    			clss.setTag(rs.getString("tag"));
					
					return clss;
				}
				
				return null;
			}
			
		});
		
	}
}