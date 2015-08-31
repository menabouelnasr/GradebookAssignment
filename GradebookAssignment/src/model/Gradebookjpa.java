package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRADEBOOKJPA database table.
 * 
 */
@Entity
@Table(name="Gradebookjpa", schema="TESTDB")
@NamedQuery(name="Gradebookjpa.findAll", query="SELECT g FROM Gradebookjpa g")
public class Gradebookjpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String assignment;

	private int grade;

	public Gradebookjpa() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}