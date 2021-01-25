package pl.krystian.Box_database_backend.app.objects;

import org.springframework.stereotype.Component;

@Component
public class ToFrontData {
	private int id;
	private String name;
	private String description;
	private String category;
	private int amount;
	private String boxName;
	private String boxDescription;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public String getBoxDescription() {
		return boxDescription;
	}
	public void setBoxDescription(String boxDescription) {
		this.boxDescription = boxDescription;
	}
	public void setAll(int id, String name, String description, String category, int amount, String boxName,String boxDescription) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.amount = amount;
		this.boxName = boxName;
		this.boxDescription = boxDescription;
	}
	
	
}
