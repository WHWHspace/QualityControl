package model.mysql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Package_setup {
	private String pck_code;
	private String pck_name;

	@Id
	public String getPck_code() {
		return pck_code;
	}

	public void setPck_code(String pck_code) {
		this.pck_code = pck_code;
	}

	public String getPck_name() {
		return pck_name;
	}

	public void setPck_name(String pck_name) {
		this.pck_name = pck_name;
	}

}
