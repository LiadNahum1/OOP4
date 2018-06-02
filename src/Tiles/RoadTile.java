package Tiles;
import java.awt.Color;

import javax.swing.*;

import FoodObjects.*;

public class RoadTile extends BoardTile {
	private boolean isSomethingOn; 
	private ImageIcon road; 
	private Food food; 
	private boolean dimmed; 
	public RoadTile(Food food) {
		super();
		this.road = new ImageIcon("pictures/boards/road.png");
		setFood(food);
		this.setIcon(getCurrentImage());
		this.dimmed = false; 
	}

	public boolean getIsSomethingOn() {
		return this.isSomethingOn;
	}
	public void setIsSomethingOn(Food food) {
		setFood(food);
	}
	public ImageIcon getCurrentImage() {
		if(getIsSomethingOn()) {
			return this.food.getImage();
		}
		else
			return this.road;
	}
	public void setFood(Food food) {
		this.food = food; 
		if(food == null) {
			this.isSomethingOn = false;
		}
		else {
			this.isSomethingOn = true; 
		}
		this.setIcon(getCurrentImage());
	}
	public void dimElement() {
		if(!this.dimmed) {
			this.setIcon(this.road);
			this.dimmed = true;
		}
		else {
			this.setIcon(getCurrentImage());
			this.dimmed = false; 
		}
	}
	/*returns num of points the player gets for this eating*/
	public int eat() {
		if(isSomethingOn) {
			int worth = this.food.getWorth();
			setFood(null);
			return worth;
		}
		else
			return 0; 
	}
}

