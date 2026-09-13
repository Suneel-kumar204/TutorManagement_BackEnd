package com.tutor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Tutor_Project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Tutor {
	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 10001,name = "tutor_seq_data" ,sequenceName = "tutor_seq_data")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="tutor_seq_data")
	@Column(name= "tutor_id")
	private long tutor_id;
	
	@Column(name="Name",length = 25,nullable= false)
	private String name;
	
	@Column(name="phoneNumber",columnDefinition = "number(10)",nullable= false)
	private long phonenumber;
	
	@Column(name="email",length = 35,unique = true,nullable= false)
	private String email;
	
	@Column(name="City",length = 20,nullable= false)
	private String city;
	
	@Column(name="Course",length = 25,nullable= false)
	private String course;

}
