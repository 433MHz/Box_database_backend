package pl.krystian.Box_database_backend.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.Box_database_backend.app.add.DbOperations;
import pl.krystian.Box_database_backend.app.objects.BoxesCount;
import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@RestController
public class JsonController {
	
	@Autowired
	FromFront fromFront;
	
	@Autowired
	ToFrontInformation toFrontInformation;
	
	@Autowired
	DbOperations dbOperations;

	@PostMapping("/add")
	public ToFrontInformation addPage(@RequestParam int boxNum, @RequestParam String itemName, @RequestParam String itemDesc, @RequestParam int amount) {
		
		fromFront.setBoxNum(boxNum);
		fromFront.setItemName(itemName);
		fromFront.setItemDesc(itemDesc);
		fromFront.setAmount(amount);				
		
		return dbOperations.Add(fromFront);
	}
	
	@Autowired
	BoxesCount boxesCount;
	
	@GetMapping("/count")
	public BoxesCount BoxCount() {
		boxesCount.setCount(dbOperations.BoxCount());
		return boxesCount;
	}
}
