package com.te.bookmydoctor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
	@Id
	@SequenceGenerator(name = "role_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "role_sequence_generator")
	private Integer role_id;
	private String role;
	@ManyToMany
	@JoinTable(name = "patient_role",joinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"),inverseJoinColumns = @JoinColumn(name="patient_id",referencedColumnName = "patient_id"))
	private List<Patient> patient;
	@ManyToMany
	@JoinTable(name = "doctor_role",joinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"),inverseJoinColumns = @JoinColumn(name="doctor_id",referencedColumnName = "doctor_id"))
	private List<Doctor> doctor;
	@ManyToMany
	@JoinTable(name = "admin_role",joinColumns = @JoinColumn(name="role_id",referencedColumnName = "role_id"),inverseJoinColumns = @JoinColumn(name="admin_id",referencedColumnName = "admin_id"))
	private List<Admin> admin;
}
