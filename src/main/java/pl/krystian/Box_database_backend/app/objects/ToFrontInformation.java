package pl.krystian.Box_database_backend.app.objects;

import org.springframework.stereotype.Component;

@Component
public class ToFrontInformation {
	
	private String message;
	private boolean isOk;
	
	
	public String getMessage() {
		return message;
	}
	public boolean isOk() {
		return isOk;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
	@Override
	public String toString() {
		return "ToFrontInformation [message=" + message + ", isOk=" + isOk + "]";
	}
	
	
}
