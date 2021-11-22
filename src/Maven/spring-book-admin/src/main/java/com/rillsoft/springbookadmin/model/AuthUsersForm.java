package com.rillsoft.springbookadmin.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// added by crane zhou on 2021.11.19
// This class was used to test with /templates-test/form.html
// 		and RegisterSimpleController.java
//		and WebSecuritySimpleConfig.java
// Thymeleaf Template engine has a BUG:
//		th:object="${authUsersForm}"
//		"${AuthUsersForm}" is not valid --> must change to "${authUsersForm}"
//		first letter must be lowercase. ... ?
//
// 		Refer to:
//		https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#creating-a-form
//		https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html#validation-and-error-messages
//		Not mentioned in online documents.
//

public class AuthUsersForm {

	@NotNull
	@Size(min=2, max=30)
	private String name;

	@NotNull
	@Min(18)
	private Integer age;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "Person(Name: " + this.name + ", Age: " + this.age + ")";
	}
}
