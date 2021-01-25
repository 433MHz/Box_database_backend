package pl.krystian.Box_database_backend.app.add;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontData;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

@Component
public class DbOperations {
	
	@Autowired
	InnerOperations innerOperations;
	
	@Autowired
	ToFrontInformation toFront;
	
	public ToFrontInformation Add(FromFront data) {
		toFront = innerOperations.checkAndAdd(data);
		return toFront;
	}
	
	
	public int BoxCount() {
		return innerOperations.CheckBoxesCount();
	}
	
	public ArrayList<ToFrontData> getAll(){
		return innerOperations.getAll();
	}

}
