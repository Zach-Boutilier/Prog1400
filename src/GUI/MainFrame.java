package GUI;

import Classes.Warrior;
import Classes.Cleric;
import Classes.Wizard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private static Warrior theWarrior;
    private static Cleric theCleric;
    private static Wizard theWizard;

    private int selectedWeapon = 0;

    public MainFrame() {
        // Set Frame Properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 750, 750);
        setTitle("Select Your Character");
        setLayout(new CardLayout());

        // Create my pre-defined shape objects at start of program
        theWarrior = new Warrior();
        theCleric = new Cleric();
        theWizard = new Wizard();

        // Add Panel "screens"
        ChoosePanel chooseScreen = new ChoosePanel();
        DisplayPanel displayScreen = new DisplayPanel();
        add(chooseScreen);
        add(displayScreen);

        JButton displayButton = chooseScreen.getDisplayBtn();
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseScreen.createFinalClass();
                // Display the chosen object text on the Display screen
                displayScreen.displayUserChoice();
                chooseScreen.setVisible(false);
                displayScreen.setVisible(true);
            }
        });
    }



    public static Warrior getTheWarrior() {
        return theWarrior;
    }

    public static Cleric getTheCleric() {
        return theCleric;
    }

    public static Wizard getTheWizard() {
        return theWizard;
    }

    public int getSelectedWeapon() {
        return selectedWeapon;
    }

    public void setSelectedWeapon(int selectedWeapon) {
        this.selectedWeapon = selectedWeapon;
    }
}