package main;

public class Definition {
    private String intitule;
    private String direction;

    public Definition(String intitule, String direction) {
        this.intitule = intitule;
        this.direction = direction;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDirection() {
        return direction;
    }

    public void addDefinition(String definition) {
  
    }

    public void deleteDefinition() {

    }

    public void changeDirection(String newDirection) {
        this.direction = newDirection;
    }
}