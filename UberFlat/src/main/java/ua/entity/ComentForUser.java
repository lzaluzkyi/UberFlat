package ua.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="coment_for_user")
public class ComentForUser {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	private Integer comentId;
	
	@NotBlank
	private String coment;
	
	@ManyToOne(fetch = LAZY)
	private UserEntity user;
	
	

	public ComentForUser(String coment) {
		super();
		this.coment = coment;
	}

	public ComentForUser() {
		super();
	}
	
	
	
	public ComentForUser(String coment, UserEntity user) {
		super();
		this.coment = coment;
		this.user = user;
	}

	
	public ComentForUser(Integer comentId, String coment, UserEntity user) {
		super();
		this.comentId = comentId;
		this.coment = coment;
		this.user = user;
	}

	public Integer getComentId() {
		return comentId;
	}

	public void setComentId(Integer comentId) {
		this.comentId = comentId;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	

}
