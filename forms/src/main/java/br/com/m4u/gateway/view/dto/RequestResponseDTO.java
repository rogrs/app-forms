package br.com.m4u.gateway.view.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestResponseDTO {

	@JsonProperty(value = "ref")
	private String ref;

	@JsonProperty(value = "code")
	private String code;

	@JsonProperty(value = "reason")
	private String reason;

	@JsonProperty(value = "detail")
	private String detail;

	@JsonIgnore
	private String httpStatus;

	@Override
	public String toString() {
		return "RequestResponseDTO{" + "ref='" + ref + '\'' + ", code='" + code + '\'' + ", reason='" + reason + '\''
				+ ", detail='" + detail + '\'' + '}';
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
