package Classes;

import GUI.ChoosePanel;
import javax.swing.*;

public class Wizard extends Class {

    //Declare triangle-specific properties
    private int defence;
    private int agility;
    private int hitpoints;
    private int attack;

    //Constructors

    public Wizard() {
        this.defence = defence;
        this.agility = agility;
        this.attack = attack;
        this.hitpoints = hitpoints;

        super.setClassPic(new ImageIcon("Wizard.png"));
    }

    public static ImageIcon setClassPic() {
        // Load the image icon for the wizard
        return new ImageIcon("Wizard.png");
    }

    ChoosePanel choosePanel = new ChoosePanel();
    String stats = choosePanel.generateRandomStats();
    String weapon = choosePanel.getSelectedWeapon();

    //toString method to return a description of the object.
    @Override
    public String toString() {
        return "I'm a wizard named " + super.getName() + " and I use a "+ weapon + ". My stats are: " + stats;
    }

    @Override
    public String getWeapon() {
        return "";
    }
}
