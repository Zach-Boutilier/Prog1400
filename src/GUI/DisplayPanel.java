package GUI;

import Classes.Cleric;
import Classes.Warrior;
import Classes.Wizard;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private JTextArea displayText;

    public DisplayPanel() {

        Font myFont = new Font("Calibri", Font.BOLD, 24);

        // Set Panel Properties
        setLayout(null);

        JLabel choiceLabel = new JLabel("Your choice of shape is:");
        choiceLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        choiceLabel.setBounds(50, 10, 250, 50);

        displayText = new JTextArea();
        displayText.setBounds(50, 50, 500, 200);
        displayText.setFont(myFont);
        displayText.setLineWrap(true);
        displayText.setEnabled(false);
        displayText.setWrapStyleWord(true);

        add(choiceLabel);
        add(displayText);
    }

    public void displayUserChoice() {
        Warrior warrior = MainFrame.getTheWarrior();
        Cleric cleric = MainFrame.getTheCleric();
        Wizard wizard = MainFrame.getTheWizard();
        String text = "";

        if (warrior.getName() != null && warrior.getName() != "") {
            text = warrior.toString();
        } else if (cleric.getName() != null && cleric.getName() != "") {
            text = cleric.toString();
        } else if (wizard.getName() != null && wizard.getName() != "") {
            text = wizard.toString();
        }
        displayText.setText(text);
    }
}