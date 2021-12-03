package com.te.bookmydoctor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DoctorAvailability_Table")
public class DoctorAvailability implements Serializable {
	@Id
	@SequenceGenerator(name = "availability_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "availability_sequence_generator")
	private Integer availability_id;
	@FutureOrPresent
	private Date start_time; 
	@Future
	private Date end_time;
	@NotNull(message = "Is_Available cannot be null")
	private Integer is_available;
	private String reason_for_unavailable;
	
	@OneToMany(mappedBy = "doctorAvailability")
	private List<DaysOfWeek> days_of_week;
	
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
