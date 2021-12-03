package com.te.bookmydoctor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
@Table(name = "Address_Table")
public class Address implements Serializable {
	@Id
	@SequenceGenerator(name = "address_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "address_sequence_generator")
	private Integer address_Id;
	@NotNull(message = "Enter the Street name")
	private String street;
	@NotNull(message = "Enter the City name")
	private String city;
	@Pattern(regexp = "(?=.*[0-9])(?=\\\\S+$).{6}",message = "six digit zip code should be enter")
	private Integer zip;
	@NotNull(message = "Enter the State name")
	private String state;
	@NotNull(message = "Enter the Country name")
	private String country;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

}
