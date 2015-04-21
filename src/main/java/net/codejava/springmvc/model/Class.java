package net.codejava.springmvc.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

@DynamicUpdate
@Table(appliesTo = "classdb")
public class Class {
	private String name;
	private int numStud;
	private String teachFirst;
	private String teachLast;
	private String timeStart;
	private String timeEnd;
	private boolean dayM;
	private boolean dayT;
	private boolean dayW;
	private boolean dayTh;
	private boolean dayF;
	private Tag tag;
	
	public enum Tag { LEC, LAB }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public int getNumStud() { return numStud; }
	
	public void setNumStud(int numStud) { this.numStud = numStud; }
	
	public String getTeachFirst() { return teachFirst; }
	
	public void setTeachFirst(String teachFirst) { this.teachFirst = teachFirst; }
	
	public String getTeachLast() { return teachLast; }
	
	public void setTeachLast(String teachLast) { this.teachLast = teachLast; }
	
	public String getTimeStart() { return timeStart; }
	
	public void setTimeStart(String timeStart) { this.timeStart = timeStart; }
	
	public String getTimeEnd() { return timeEnd; }
	
	public void setTimeEnd(String timeEnd) { this.timeEnd = timeEnd; }

	public boolean getDayM() { return dayM; }
	
	public void setDayM(boolean dayM) { this.dayM = dayM; }
	
	public boolean getDayT() { return dayT; }
	
	public void setDayT(boolean dayT) { this.dayT = dayT; }
	
	public boolean getDayW() { return dayW; }
	
	public void setDayW(boolean dayW) { this.dayW = dayW; }
	
	public boolean getDayTh() { return dayTh; }
	
	public void setDayTh(boolean dayTh) { this.dayTh = dayTh; }
	
	public boolean getDayF() { return dayF; }
	
	public void setDayF(boolean dayF) { this.dayF = dayF; }
	
	public Tag getTag() { return tag; }
	
	public void setTag(Tag tag) { this.tag = tag; } /* made my day */
	
	public String toString() {
		return "Class [name=" + name + ", numStud=" + numStud + ", teachFirst=" + teachFirst
				+ ", teachLast=" + teachLast + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd
				+ ", day=" + dayM + " " + dayT + " " + dayW + " " + dayTh + " " + dayF + ", tag=" + tag + "]";
	}
}