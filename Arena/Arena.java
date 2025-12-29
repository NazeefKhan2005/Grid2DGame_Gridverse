// Arena class is the blueprint of 2D Arenas of the game

import java.util.Random;

public class Arena {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;

    private Cell[][] grid; // 2D Array implementation of the Arena
    private ArenaConfig config;

    // Constructor for Arena class
    public Arena(ArenaConfig config){
        this.config = config;
        this.grid = new Cell[WIDTH][HEIGHT];

        initializeGrid(); // Generates a grid with empty cells

        if(config.hasBoundaries()){ // For closed arenas
            generateBoundaries();
        }

        if(config.getName().equalsIgnoreCase("NeonMaze")){
            generateNeonMaze(); // Generates internal mazes
        }

        else if(config.isRandom()){
            generateProcedural();
        }
    }

    // Method for initializing a grid with empty celss
    private void initializeGrid(){
        for(int i = 0; i < WIDTH; i++){
            for(int j = 0; j < HEIGHT; j++){
                grid[i][j] = new Cell(CellType.EMPTY);
            }
        }
    }

    // Method for generating boundary walls
    private void generateBoundaries(){
        for(int i = 0; i < WIDTH; i++){
            grid[0][i].setType(CellType.WALL);
            grid[WIDTH - 1][i].setType(CellType.WALL);
            grid[i][0].setType(CellType.WALL);
            grid[i][WIDTH - 1].setType(CellType.WALL);
        }
    }

    // Method for generating mazes for NeonMaze Arena
    private void generateNeonMaze(){
        for(int i = 4; i < WIDTH - 4; i += 4){
            for(int j = 1; j < HEIGHT - 1; j++){
                if(j % 6 != 0){
                    grid[i][j].setType(CellType.WALL);
                }
            }
        }

        for(int j = 4; j < HEIGHT - 4; j += 4){
            for(int i = 1; i < WIDTH - 1; i++){
                if(i % 6 != 0){
                    grid[i][j].setType(CellType.WALL);
                }
            }
        }
    }

    // Method for generating random obstacles for Procedural Arena
    private void generateProcedural(){
        Random random = new Random();
        int obstaclescount = (int) (WIDTH * HEIGHT * 0.1);

        for(int i = 0; i < obstaclescount; i++){
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);

            if (x == 0 || y == 0 || x == WIDTH - 1 || y == HEIGHT - 1) {
                continue;
            }

              if (x < 4 && y < 4) {
                continue;
            }

            if (grid[y][x].getType() == CellType.EMPTY) {
                grid[y][x].setType(CellType.WALL);
            }
        }
    }

    // Method for getting the grid
    public Cell[][] getGrid() {
        return grid;
    }
}
