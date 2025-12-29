class ConsoleRenderer {

    public void render(Cell[][] grid) {
        for (int y = 0; y < Arena.HEIGHT; y++) {
            for (int x = 0; x < Arena.WIDTH; x++) {
                System.out.print(symbol(grid[y][x].getType()));
            }
            System.out.println();
        }
    }

    private char symbol(CellType type) {
        switch (type) {
            case WALL: return '#';
            case PLAYER: return 'P';
            case ENEMY: return 'E';
            case JETWALL: return '|';
            case DISC: return '*';
            default: return ' ';
        }
    }

    public static void main(String[] args) {
        
    }
}


