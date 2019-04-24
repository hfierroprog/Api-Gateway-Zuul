package cl.hfierroprog.apiGateway.ApiGateway.models.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Role implements Serializable {

	@Id
	private ObjectId id;

	private String authority;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
