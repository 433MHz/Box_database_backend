package pl.krystian.Box_database_backend.app.objects;

import org.springframework.stereotype.Component;

@Component
public class FromFront {
	private int boxNum;
	private String itemName;
	private String itemDesc;
	private int amount;
	
	
	
	public int getBoxNum() {
		return boxNum;
	}
	public String getItemName() {
		return itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public int getAmount() {
		return amount;
	}
	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "FromFront [boxNum=" + boxNum + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", amount="
				+ amount + "]";
	}
	
	
}

