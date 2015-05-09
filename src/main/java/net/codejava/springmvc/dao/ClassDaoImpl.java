package net.codejava.springmvc.dao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import net.codejava.springmvc.model.Class;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Statement;

public class ClassDaoImpl implements ClassDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ServletContext servletContext;
	 
    public ClassDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void saveOrUpdate(Class clss) {
    		String sql = "UPDATE classdb SET numStud=?, teachFirst=?, teachLast=?, "
    				+ "timeStart=?, timeEnd=?, dayM=?, dayT=?, dayW=?, dayTh=?, dayF=?, "
    				+ "tag=?, room=? WHERE name=?";
    		
    		jdbcTemplate.update(sql, clss.getNumStud(), clss.getTeachFirst(), clss.getTeachLast(), 
    				clss.getTimeStart(), clss.getTimeEnd(), clss.getDayM(), clss.getDayT(), clss.getDayW(), 
    				clss.getDayTh(), clss.getDayF(), clss.getTag(), clss.getRoom(), clss.getName());
    }
    
    public void upload(MultipartFile file){
    		try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/classdb", "root", "");
				Statement statement = (Statement) conn.createStatement();
				/*String [][] test = new String[2][2];
				test[0][0] = "This";
				test[0][1] = "is";
				test[1][0] = "a";
				test[1][1] = "test";
				
				String temp = "";
				for (int row = 0; row < test.length; row++)
				{
					for (int col = 0; col < test[0].length; col++)
					{
						temp += " " + test[row][col];
					}
					temp += "\n";
				}
				
				http://stackoverflow.com/questions/5200187/convert-inputstream-to-bufferedreader
				
				System.out.print(temp);
				
				InputStream is = new ByteArrayInputStream(temp.getBytes());
				InputStream yep = new FileInputStream(servletContext.getRealPath("/WEB-INF/test.csv"));*/
				
				String sql = "LOAD DATA LOCAL INFILE 'test.csv' INTO TABLE classdb FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\r\n'";
				//statement.setLocalInfileInputStream(yep);
				try {
					statement.setLocalInfileInputStream(file.getInputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				statement.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
    			aClass.setRoom(rs.getInt("room"));
    			
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
	    			clss.setRoom(rs.getInt("room"));
					
					return clss;
				}
				
				return null;
			}
			
		});
		
	}
}