package br.com.willianantunes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User 
{
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Type(type= "org.jadira.usertype.dateandtime.joda.PersistentDateTime")		
	private DateTime birthDate;	

	public Long getId() 
	{
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public DateTime getBirthDate() 
	{
		return birthDate;
	}

	public void setBirthDate(DateTime birthDate) 
	{
		this.birthDate = birthDate;
	}
}
