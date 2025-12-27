public class Kevin extends Character {

    public Kevin(String name, String color, double speed, double handling, int lives, int discs, int xp) {
        super(name, color, speed, handling, lives, discs, xp);
    }

    public void levelUp() {
        this.level++;

        // KEVIN SPECIALTY: Handling increases faster
        this.handling += 2.0;
        this.speed += 1.0;

        System.out.println("LEVEL UP! Kevin reached Level " + this.level);
        System.out.println("Upgrade: Handling is now " + this.handling);
    }
}
