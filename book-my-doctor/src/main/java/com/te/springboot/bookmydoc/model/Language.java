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
@AllArgsConstructor
@NoArgsConstructor
public class Language implements Serializable{
	@Id
	@SequenceGenerator(name = "language_sequence_generator",initialValue = 100,allocationSize = 5)
	@GeneratedValue(generator = "language_sequence_generator")
	private Integer language_Id;
	@NotNull(message = "Language cannot be null")
	private String language;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

}
