// Every cell of the 40 x 40 grid will be an instance of Cell class

public class Cell {
    private CellType type;
    
    public Cell(CellType type){ // Constructor for Cell class
        this.type = type;
    }

    // Getter and Setter method for Cell class
    public CellType getType(){
        return type;
    }

    public void setType(CellType type){ // To set type of a cell without using the constructor
        this.type = type;
    }
}
