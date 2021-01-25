package pl.krystian.Box_database_backend.app.add;

import org.springframework.beans.factory.annotation.Autowired;

import pl.krystian.Box_database_backend.app.objects.FromFront;
import pl.krystian.Box_database_backend.app.objects.ToFrontInformation;

public class Add {
	
	@Autowired
	Filter filter;
	
	@Autowired
	ToFrontInformation toFront;
	
	public ToFrontInformation add(FromFront data) {
		
		toFront = filter.check(data);
		
		return null;
	}

}
