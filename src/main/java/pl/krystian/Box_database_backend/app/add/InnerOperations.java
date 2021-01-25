package pl.krystian.Box_database_backend.app.add;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@Component
class InnerOperations {

	public ToFrontInformation check (FromFront data) {
		
		int boxNum = data.getBoxNum();
		String itemName = data.getItemName();
		String itemDesc = data.getItemDesc();
		int amount = data.getAmount();
		
		System.out.println(CheckBoxesCount());
		return null;
	}
	
	@Autowired
	private JDBC jdbc;

	public int CheckBoxesCount() {
		return jdbc.CountBoxes();
	}
}
