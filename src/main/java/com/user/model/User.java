
package com.user.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {
		
	@NotBlank(message = "{name.not.blank}")
	private String name;
	
	@NotBlank(message = "{nickname.not.blank}")
	private String nickname;
	
	@Id
	@NotBlank(message = "{document.not.blank}")
	private String document;
	
	@Valid
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Address> adresses;
	
	@NotBlank(message = "{profession.not.blank}")
	private String profession;
	
	@NotNull(message = "{salary.not.null}")
	private Double salary;
	
	@Valid
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Dependent> dependents;
	
	@NotNull(message = "{dateOfBirth.not.null}")
	private Date dateOfBirth;
	
	@Valid
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Phone> phones;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public List<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}