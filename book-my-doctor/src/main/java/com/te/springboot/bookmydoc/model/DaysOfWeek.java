package com.te.springboot.bookmydoc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class DaysOfWeek implements Serializable{
	
	@Id
	@SequenceGenerator(name = "daysofweek_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "daysofweek_sequence_generator")
	private Integer days_id;
	@NotNull(message = "Day cannot be null")
	private String day;
	@ManyToOne
	@JoinColumn(name = "availability_id")
	private DoctorAvailability doctorAvailability;

}
