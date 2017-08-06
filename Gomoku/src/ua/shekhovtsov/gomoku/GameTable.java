package ua.shekhovtsov.gomoku;


public class GameTable implements Cloneable{
	private int x;
	private int y;
	private char element;
	private int priority;
	
	public GameTable() {
		x = 0;
		y = 0;
		element = ' ';
		priority = 0;
	}
	public GameTable(int x, int y) {
		this.x = x;
		this.y = y;
		element = ' ';
		priority = 0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getElement() {
		return element;
	}
	public void setElement(char element) {
		this.element = element;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
    public GameTable clone() {
        try {
            GameTable g = (GameTable) super.clone();            
            return g;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }
       // return new GameTable(this);
    
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameTable other = (GameTable) obj;
		if (x != other.getX())
			return false;
		if (y != other.getY())
			return false;
		if (element != other.getElement())
			return false;
		if (priority != other.getPriority())
			return false;
		return true;
	}
}
