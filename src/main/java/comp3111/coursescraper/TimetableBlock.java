package comp3111.coursescraper;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.effect.Blend; 
import javafx.scene.effect.BlendMode; 
import javafx.scene.effect.ColorInput; 
import javafx.scene.paint.Color;

import java.util.Random;

public class TimetableBlock {
	private String secID;
	private Label [] block;
	private int numSlots;
	private Slot [] slots;
	private Color color;
	public TimetableBlock(Course c, Section s) {
		secID = s.getID();
		numSlots = s.getNumSlots();
		slots = new Slot[numSlots];
		block = new Label[numSlots];
		// Generate random color
		Random random = new Random();
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        
		for (int i=0; i < numSlots; i++)
			slots[i] = s.getSlot(i);
		for (int i=0; i < numSlots; i++) {
			block[i] = new Label(c.getCode() + "\n" + s.getSections());
			double start = slots[i].getStartHour() + (Double.valueOf(slots[i].getStartMinute())/60);
			block[i].setBackground(new Background(new BackgroundFill(Color.rgb(r,g,b), CornerRadii.EMPTY, Insets.EMPTY)));
			block[i].setTextFill(color.WHITE);
			block[i].setPadding(new Insets(0,0,0,3));
			block[i].setBlendMode(BlendMode.ADD);
			block[i].setLayoutX((slots[i].getDay() + 1) * 100 + 1.5);
			block[i].setLayoutY(start * 20 - 132);  
			block[i].setMinWidth(100.0);
			block[i].setMaxWidth(100.0);
			double end = slots[i].getEndHour() + (Double.valueOf(slots[i].getEndMinute())/60);
			double duration = end - start;
			block[i].setMaxHeight(duration * 20 + 3.9); 
			block[i].setMinHeight(duration * 20 + 3.9);
			if ((duration * 20 + 3.9) <= 25)
				block[i].setText(c.getCode() + "  " + s.getSections());
		}
	}
	public Label getBlock(int index) {
		return block[index];
	}
	public Label[] getBlockArr() {
		return block;
	}
	public int getNumSlots() {
		return numSlots;
	}
	public String getID() {
		return secID;
	}
}
