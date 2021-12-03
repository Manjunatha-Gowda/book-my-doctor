package com.te.springboot.bookmydoc.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AppointmentTakenTime_Table")
public class AppointmentTakenTime {
	
	@Id
	@SequenceGenerator(name = "appointmentTakenTime_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "appointmentTakenTime_sequence_generator")
	private Integer appointment_time_id;
	@FutureOrPresent
	private LocalTime appointment_taken_time;
	@Future
	private LocalTime appointment_end_time;
	@ManyToOne
	@JoinColumn(name = "appointment_Id")
    private Appointment appointment;

}
