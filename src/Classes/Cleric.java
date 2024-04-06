package Classes;

import GUI.ChoosePanel;
import javax.swing.*;

public class Cleric extends Class {

    //Declare cleric-specific properties for rectangle
    private int defence;
    private int agility;
    private int hitpoints;
    private int attack;

    //Constructors

    public Cleric() {
        this.defence = defence;
        this.agility = agility;
        this.attack = attack;
        this.hitpoints = hitpoints;

        super.setClassPic(new ImageIcon("Cleric.png"));
    }

    ChoosePanel choosePanel = new ChoosePanel();
    String stats = choosePanel.generateRandomStats();
    String weapon = choosePanel.getSelectedWeapon();

    public static ImageIcon setClassPic() {
        // Load the image icon for the wizard
        return new ImageIcon("Cleric.png");
    }

    //toString method to return a description of the object.
    @Override
    public String toString() {
        return "I'm a cleric named " + super.getName() + " and I use a "+ weapon + ". My stats are: " + stats;
    }

    @Override
    public String getWeapon() {
        return "";
    }
}
