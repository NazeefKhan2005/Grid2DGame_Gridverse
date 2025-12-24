import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterLoader {

    public static Character loadCharacter(String chosenName) {

        String path = "C:\\Users\\thett\\OneDrive\\Desktop\\Programming\\character.txt";
        File file = new File(path);

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // The text file looks like: Tron;Blue;50.0;50.0;3;1;0
                String[] data = line.split(";");

                if (data.length < 7) continue;

                // Check if line matches the character we want
                if (data[0].equalsIgnoreCase(chosenName)) {

                    String name = data[0];
                    String color = data[1];

                    // Now these will work because we changed the text file to numbers
                    double speed = Double.parseDouble(data[2]);
                    double handling = Double.parseDouble(data[3]);

                    int lives = Integer.parseInt(data[4]);
                    int discs = Integer.parseInt(data[5]);
                    int xp = Integer.parseInt(data[6]);

                    if (name.equalsIgnoreCase("Tron")) {
                        return new Tron(name, color, speed, handling, lives, discs, xp);
                    } else if (name.equalsIgnoreCase("Kevin")) {
                        return new Kevin(name, color, speed, handling, lives, discs, xp);
                    }
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find file at: " + file.getAbsolutePath());
            System.out.println("Make sure 'character.txt' is in the top level of your project folder.");
        } catch (NumberFormatException e) {
            System.out.println("Error: The file contains text (like 'Moderate') but the code expects a Number.");
        }

        return null;
    }
}