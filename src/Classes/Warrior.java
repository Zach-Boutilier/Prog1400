package Classes;

import GUI.ChoosePanel;
import javax.swing.*;

public class Warrior extends Class {

    //Declare warrior-specific properties
    private int defence;
    private int agility;
    private int hitpoints;
    private int attack;

    //Constructors

    public Warrior() {
        this.defence = defence;
        this.agility = agility;
        this.attack = attack;
        this.hitpoints = hitpoints;

        super.setClassPic(new ImageIcon("src\\Images\\Warrior.jpg"));
    }

    ChoosePanel choosePanel = new ChoosePanel();
    String stats = choosePanel.generateRandomStats();
    String weapon = choosePanel.getSelectedWeapon();

    public static ImageIcon setClassPic() {
        // Load the image icon for the wizard
        return new ImageIcon("Warrior.png");
    }

    //toString method to return a description of the object.
    @Override
    public String toString() {
        return "I'm a warrior named " + super.getName() + " and I use a " + weapon + ". My stats are: " + stats;
    }

    @Override
    public String getWeapon() {
        return "";
    }
}