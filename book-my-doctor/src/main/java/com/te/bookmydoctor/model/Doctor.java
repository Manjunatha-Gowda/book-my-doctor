package com.te.bookmydoctor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Doctor_details")
public class Doctor implements Serializable {
	@Id
	@SequenceGenerator(name = "doctor_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "doctor_sequence_generator")
	private Integer doctor_id;
	@NotNull(message = "First name cannot be null")
	private String first_name;
	@NotNull(message = "Last name cannot be null")
	private String last_name;
	@Email(message = "Enter the Email")
	private String email;
	@Pattern(regexp = "^[0-9]{10}",message = "10 digit Mobile Number should be enter")
	private Long mobile_number;
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", message = "a digit must occur at least once/a lower case letter must occur at least once/an upper case letter must occur at least once/a special character must occur at least once/no whitespace allowed in the entire string/ at least 8 characters")
	private String password;
	@NotNull(message = "Gender cannot be null")
	private String gender;
	private Integer is_deleted;
	private Integer is_verified;
	
	@OneToMany(mappedBy = "doctor")
	private List<Language> language;
	
	@OneToMany(mappedBy = "doctor")
	private List<Address> addresses;
	
	@OneToOne(mappedBy = "doctor")
	private Qualification qualification;
	
	@OneToOne(mappedBy = "doctor")
	private Specialization specialization;
	
	@OneToOne(mappedBy = "doctor")
	private DoctorAvailability availabile;
	
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "doctor")
	private List<FeedBack> feedBacks;
	
	@OneToOne(mappedBy = "doctor")
	private Verification verification;
	
	@ManyToMany(mappedBy = "doctor")
	private List<Role> roles;
}
