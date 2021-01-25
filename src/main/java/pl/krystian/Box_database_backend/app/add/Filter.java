package pl.krystian.Box_database_backend.app.add;

import org.springframework.stereotype.Component;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@Component
class Filter {

	public ToFrontInformation check (FromFront data) {
		
		int boxNum = data.getBoxNum();
		String itemName = data.getItemName();
		String itemDesc = data.getItemDesc();
		int amount = data.getAmount();
		
		
		return null;
	}
}
