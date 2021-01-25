package pl.krystian.Box_database_backend.app.add;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontData;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@Component
class InnerOperations {
	
	@Autowired
	ToFrontInformation toFront;

	public ToFrontInformation checkAndAdd (FromFront data) {
		
		int boxNum = data.getBoxNum();
		String itemName = data.getItemName();
		String itemDesc = data.getItemDesc();
		int amount = data.getAmount();
		
		int option;
		
		if(boxNum <= jdbc.CountBoxes() && boxNum > 0) {
			if(itemName.length() <= 200) {
				if(itemDesc.length() <= 700) {
					if(amount > 0 && amount <= 9999) {
						if(jdbc.addItem(data)) {
							option = 6;
						}
						else {
							option = 5;
						}
					}
					else {
						option = 4;
					}
				}
				else {
					option = 3;
				}
			}
			else {
				option = 2;
			}
		}
		else {
			option = 1;
		}
		
		String message = "";
		boolean isOk = false;
		
		switch (option) {
		case 1:
			message = "Nie ma takiego pudełka";
			break;
		case 2:
			message = "Nazwa przedmiotu za długa";
			break;
		case 3:
			message = "Opis przedmiotu za długi";
			break;
		case 4:
			message = "Ilość musi być pomiędzy 0 a 9999";
			break;
		case 5:
			message = "Błąd podczas wysyłania do bazy danych";
			break;
		case 6:
			message = "Dodano";
			isOk = true;
			break;
		}
		
		toFront.setMessage(message);
		toFront.setOk(isOk);
		
		return toFront;
	}
	
	@Autowired
	private JDBC jdbc;

	public int CheckBoxesCount() {
		return jdbc.CountBoxes();
	}

	public ArrayList<ToFrontData> getAll(){
		return jdbc.getAll();
	}
}
