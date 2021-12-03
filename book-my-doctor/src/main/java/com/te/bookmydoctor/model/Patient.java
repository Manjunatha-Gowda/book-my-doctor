package com.te.bookmydoctor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Patients_Table")
public class Patient implements Serializable {
	@Id
	@SequenceGenerator(name = "patient_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "patient_sequence_generator")
	private Integer patient_id;
	@NotNull(message = "First name cannot be null")
	private String first_name;
	@NotNull(message = "Last name cannot be null")
	private String last_name;
	@Email(message = "Enter the Email")
	private String email;
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", message = "a digit must occur at least once/a lower case letter must occur at least once/an upper case letter must occur at least once/a special character must occur at least once/no whitespace allowed in the entire string/ at least 8 characters")
	private String password;
	@NotNull(message = "Gender cannot be null")
	private String gender;
	@Pattern(regexp = "^[0-9]{10}",message = "10 digit Mobile Number should be enter")
	private Long mobile_number;
	private Integer is_deleted;
	private Integer is_verified;
	
	@OneToOne(mappedBy = "patient")
	private Appointment appointment;
	
	@OneToOne(mappedBy = "patient")
	private FeedBack feedBack;
	
	@ManyToMany(mappedBy = "patient")
	private List<Role> roles;
	
	@OneToOne(mappedBy = "patient")
	private Verification verification;

}
