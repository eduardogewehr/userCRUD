
package com.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "{typeAddress.not.blank}")
	private String typeAddress;
	
	@NotBlank(message = "{type.not.blank}")
	private String type;
	
	@NotBlank(message = "{name.not.blank}")
	private String name;
	
	@NotBlank(message = "{number.not.blank}")
	private String number;
	
	private String complement;
	
	@NotBlank(message = "{cep.not.blank}")
	private String cep;
	
	@NotBlank(message = "{message.not.blank}")
	private String neighborhood;
	
	@NotBlank(message = "{city.not.blank}")
	private String city;
	
	@NotBlank(message = "{state.not.blank}")
	private String state;
	
	@NotBlank(message = "{country.not.blank}")
	private String country;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTypeAddress() {
		return typeAddress;
	}
	public void setTypeAddress(String typeAddress) {
		this.typeAddress = typeAddress;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}