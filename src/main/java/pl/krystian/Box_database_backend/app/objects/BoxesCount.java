package pl.krystian.Box_database_backend.app.objects;

import org.springframework.stereotype.Component;

@Component
public class BoxesCount {
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
