package pl.krystian.Box_database_backend.app.objects;

import org.springframework.stereotype.Component;

@Component
public class BoxesCount {
	private int boxes;

	public int getBoxes() {
		return boxes;
	}

	public void setBoxes(int boxes) {
		this.boxes = boxes;
	}
}
