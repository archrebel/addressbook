/*
* This code has been generated by the Rebel: a code generator for modern Java.
* 
* For more details, please visit www.archetypesoftware.com.
*
* Drop us a line or two at feedback@archetypesoftware.com. We would love to hear from you.
*/
package com.archetype.addressbook.domain;

import java.util.*;
import java.time.*;

import javax.persistence.*;
import javax.validation.constraints.*;


// ----------- << imports@AAAAAAFrhE1htU7zJ8s= >>
// ----------- >>

@Entity
// ----------- << class.annotations@AAAAAAFrhE1htU7zJ8s= >>
// ----------- >>
public class Email extends Contact {
	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAFrhFa5j1DEo10= >>
	// ----------- >>
	private String email;

	public String getEmail() {
		return email;
	}

	public Email setEmail(String email) {
		this.email = email;
		return this;
	}

	// ----------- << equals.annotations@AAAAAAFrhE1htU7zJ8s= >>
	// ----------- >>
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof Email && (getId().equals(((Email) obj).getId()));
	}

	// ----------- << hashCode.annotations@AAAAAAFrhE1htU7zJ8s= >>
	// ----------- >>
	@Override
	public int hashCode() {
		return 18;
	}

// ----------- << class.extras@AAAAAAFrhE1htU7zJ8s= >>

	public Email(@NotNull String email) {
		this.email = email;
	}

	public Email() {
	}

// ----------- >>
}