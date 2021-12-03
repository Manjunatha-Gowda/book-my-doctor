package com.te.bookmydoctor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment_Table")
public class Appointment implements Serializable {
	@Id
	@SequenceGenerator(name = "appointment_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "appointment_sequence_generator")
	private Integer appointment_Id;
	@PastOrPresent
	private Date appointment_date;
   @NotNull(message = "Day cannot be null")
	private String day;
	
	@NotNull(message = "Enter the Status")
	private String appointment_status;
	
	@OneToMany(mappedBy = "appointment")
	private List<AppointmentTakenTime> appointment_taken_time;
	
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
