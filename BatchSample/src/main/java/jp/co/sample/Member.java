package jp.co.sample;

import javax.validation.constraints.Size;

public class Member {

	@Size(min = 1, max = 1)
	private String id;

	@Size(min = 2, max = 2)
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
