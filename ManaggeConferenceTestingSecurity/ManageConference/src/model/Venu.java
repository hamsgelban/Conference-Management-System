package model;

public class Venu {
	private String venuId;
	private String address;
	private Boolean isAvailable;
	
	public Venu( String venuId, String address) {
		this.venuId = venuId;
		this.address = address;
		this.isAvailable = true;
	}
	
	public boolean bookVenu(){
		if(this.isAvailable == true) {
			this.isAvailable = false;
			return true;
		}
		else {
			return false;
		}
	}

	public String getVenuId() {
		return venuId;
	}

	public void setVenuId(String venuId) {
		this.venuId = venuId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}

	@Override
	public String toString() {
		return "Venu [venuId=" + venuId + ", address=" + address + ", isAvailable=" + isAvailable + "]";
	}
	
	
	
}
