package com.murkino.domain.cat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@Access(AccessType.FIELD)
public class HibernateCat {

	@Id
	private String id;
	
	@Lob
	private String content;
	
	public HibernateCat(String id, String content) {
		this.id = id;
		this.content = content;
	}
}
