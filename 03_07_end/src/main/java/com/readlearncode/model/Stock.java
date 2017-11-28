package com.readlearncode.model;

import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Named
public class Stock {

	private Integer id;

	@Pattern(regexp = "^[A-Z]*$")
	@NotNull
	private String name;

	@Size(min = 3, max = 3)
	@NotNull
	private String code;

	public Stock() {
	}

	public Stock(Integer id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Stock stock = (Stock) o;
		return id == stock.id &&
				Objects.equals(name, stock.name) &&
				Objects.equals(code, stock.code);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, code);
	}

	@Override
	public String toString() {
		return  name + " ("+code+")";
	}
}