package com.seedit.valid;

import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class validVo {
	@Size(min=5, max=30, message="값은 5와 30사이어야 합니다")
	@Null(message="값이 비어있어야 합니다")
	private String valid;

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public validVo(String valid) {
		this.valid = valid;
	}

	public validVo() {
	}
}
