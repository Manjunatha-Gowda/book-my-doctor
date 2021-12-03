package com.te.bookmydoctor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Qualification_Table")
public class Qualification implements Serializable {
	@Id
	@SequenceGenerator(name = "qualification_sequence_generator", initialValue = 100, allocationSize = 5)
	@GeneratedValue(generator = "qualification_sequence_generator")
	private Integer qualification_Id;
	@NotNull(message = "Degree name cannot be null")
	private String degree_name;
	@NotNull(message = "Intituition name cannot be null")
	private String institution_name;
	@Pattern(regexp = "^[0-9].{4}", message = "Year of passing must of 4 digit")
	private Integer passing_year;
	@NotNull(message = "Degree name cannot be null")
	private String highest_qualification_certificate;
	@NotNull(message = "Medical Registration Number cannot be null")
	private String medical_registration_number;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
}
