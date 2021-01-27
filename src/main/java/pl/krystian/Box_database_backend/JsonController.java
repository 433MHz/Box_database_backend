package pl.krystian.Box_database_backend;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.krystian.Box_database_backend.app.add.DbOperations;
import pl.krystian.Box_database_backend.app.objects.BoxesCount;
import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontData;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@RestController
public class JsonController {
	
	
	@Autowired
	ToFrontInformation toFrontInformation;
	
	@Autowired
	DbOperations dbOperations;

	@CrossOrigin
	@PostMapping("add")
	public ToFrontInformation addPage(@RequestBody FromFront fromFront) {
		return dbOperations.Add(fromFront);
	}
	
	@Autowired
	BoxesCount boxesCount;
	
	@CrossOrigin
	@GetMapping("count")
	public BoxesCount BoxCount() {
		boxesCount.setBoxes(dbOperations.BoxCount());
		return boxesCount;
	}

	@CrossOrigin
	@GetMapping("getAll")
	public ArrayList<ToFrontData> getAll(){
		return dbOperations.getAll();
	}
	
}
