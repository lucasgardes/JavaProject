package main;

public class Case {
	private String content = "";
	private int x;
	private int y;
	private Definition definition;
	
	public Case(int x, int y) {
        this.x = x;
        this.y = y;
	}

	public String getContent() {
		return this.content;
	}
	
	public void setDefinition(Definition definition) {
		this.definition = definition;
	}
	
	public Definition getDefinition() {
		return this.definition;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
