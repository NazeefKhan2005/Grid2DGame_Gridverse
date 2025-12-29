// Configuration details for arena generation

public class ArenaConfig {
    private String name;
    private boolean hasBoundaries;
    private boolean isRandom;

    public ArenaConfig(String name, boolean hasBoundaries, boolean isRandom){ // Constructor for ArenaConfig class
        this.name = name;
        this.hasBoundaries = hasBoundaries;
        this.isRandom = isRandom;
    }

    // Getter methods
    public String getName(){
        return name;
    }
    public boolean hasBoundaries(){
        return hasBoundaries;
    }
    public boolean isRandom(){
        return isRandom;
    }
}
