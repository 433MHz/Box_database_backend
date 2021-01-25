package pl.krystian.Box_database_backend.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@RestController
public class JsonController {
	
	@Autowired
	FromFront fromFront;
	
	@Autowired
	ToFrontInformation toFrontInformation;

	@PostMapping("/add")
	public ToFrontInformation addPage(@RequestParam int boxNum, @RequestParam String itemName, @RequestParam String itemDesc, @RequestParam int amount) {
		
		fromFront.setBoxNum(boxNum);
		fromFront.setItemName(itemName);
		fromFront.setItemDesc(itemDesc);
		fromFront.setAmount(amount);
		
		toFrontInformation.setMessage("Wysłane");
		toFrontInformation.setOk(true);
		
		System.out.println(fromFront.toString());
		
		return toFrontInformation;
	}
}
