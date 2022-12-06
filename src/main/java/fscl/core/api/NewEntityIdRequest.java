package fscl.core.api;

import java.util.UUID;

public class NewEntityIdRequest {
		
	public NewEntityIdRequest() {		
	}
	
	public NewEntityIdRequest(long timeoutSeconds, UUID clientId) {
		if(timeoutSeconds < 0) {
			this.timeoutSeconds = 0;
		}
		else {
			this.timeoutSeconds = timeoutSeconds;
		}
		
		this.clientId = clientId;
	}
	
	public UUID getClientId() {
		return this.clientId;
	}
	
	public long getTimeoutSeconds() {
		return this.timeoutSeconds;
	}
	
	private UUID clientId;	
	private long timeoutSeconds;
	
}
