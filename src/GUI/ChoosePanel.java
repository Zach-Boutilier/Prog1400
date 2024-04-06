package GUI;

import Classes.Cleric;
import Classes.Warrior;
import Classes.Wizard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChoosePanel extends JPanel {

    private JLabel imageLabel;
    //Some controls need to be declared at the class level, if referenced in multiple places
    private JTextField hpTextField;
    private JTextField agilityTextField;
    private JTextField defenseTextField;
    private JTextField attackTextField;
    private JTextField nameText;
    private JRadioButton rdoWarrior;
    private JRadioButton rdoCleric;
    private JRadioButton rdoWizard;

    private JButton displayBtn;

    public ChoosePanel() {
        this.imageLabel = imageLabel;

        //Set font object
        Font myFont = new Font("Calibri", Font.BOLD, 20);

        //Set Panel Properties
        setLayout(null);
        setVisible(true);

        //Create all GUI objects
        addClassRadios(myFont);
        addWeaponRadios(myFont); // Call the method to add weapon radio buttons

        //Label control for name
        JLabel nameLabel = new JLabel("Name your character:");
        nameLabel.setFont(myFont);
        nameLabel.setBounds(10, 10, 200, 50);

        //Label for shape image
        imageLabel = new JLabel();
        imageLabel.setBounds(500, 70, 150, 150);

        //Textfield control for name
        nameText = new JTextField();
        nameText.setFont(myFont);
        nameText.setBounds(200, 10, 200, 50);

        // Text fields for stats
        hpTextField = new JTextField();
        hpTextField.setFont(myFont);
        hpTextField.setBounds(590, 215, 100, 35);
        hpTextField.setEditable(false);

        agilityTextField = new JTextField();
        agilityTextField.setFont(myFont);
        agilityTextField.setBounds(590, 170, 100, 35);
        agilityTextField.setEditable(false);

        defenseTextField = new JTextField();
        defenseTextField.setFont(myFont);
        defenseTextField.setBounds(590, 125, 100, 35);
        defenseTextField.setEditable(false);

        attackTextField = new JTextField();
        attackTextField.setFont(myFont);
        attackTextField.setBounds(590, 80, 100, 35);
        attackTextField.setEditable(false);

        //Change screen button
        displayBtn = new JButton("Display Selected");
        displayBtn.setFont(myFont);
        displayBtn.setBounds(500, 300, 200, 50);

        //Add all controls to Panel
        add(nameLabel);
        add(nameText);
        add(hpTextField);
        add(agilityTextField);
        add(defenseTextField);
        add(attackTextField);
        add(displayBtn);
        add(imageLabel);
    }

    private void addClassRadios(Font myFont) {
        ButtonGroup classGroup = new ButtonGroup();

        rdoWarrior = new JRadioButton("Warrior");
        rdoWarrior.setFont(myFont);
        rdoWarrior.setBounds(50, 70, 150, 50);
        rdoWarrior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomStats();
                imageLabel.setIcon(Warrior.setClassPic());

            }
        });
        classGroup.add(rdoWarrior);
        add(rdoWarrior);

        rdoCleric = new JRadioButton("Cleric");
        rdoCleric.setFont(myFont);
        rdoCleric.setBounds(50, 130, 150, 50);
        rdoCleric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomStats();
                imageLabel.setIcon(Cleric.setClassPic());
            }
        });
        classGroup.add(rdoCleric);
        add(rdoCleric);

        rdoWizard = new JRadioButton("Wizard");
        rdoWizard.setFont(myFont);
        rdoWizard.setBounds(50, 190, 150, 50);
        rdoWizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomStats();
                imageLabel.setIcon(Wizard.setClassPic());
            }
        });
        classGroup.add(rdoWizard);
        add(rdoWizard);
    }

    public String selectedWeapon;

    private void addWeaponRadios(Font myFont) {
        ButtonGroup weaponGroup = new ButtonGroup();

        JRadioButton rdoDagger = new JRadioButton("Dagger");
        rdoDagger.setFont(myFont);
        rdoDagger.setBounds(50, 300, 150, 50);
        rdoDagger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = "Dagger";
            }
        });
        weaponGroup.add(rdoDagger);
        add(rdoDagger);

        JRadioButton rdoSword = new JRadioButton("Sword");
        rdoSword.setFont(myFont);
        rdoSword.setBounds(50, 360, 150, 50);
        rdoSword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = "Sword";
            }
        });
        weaponGroup.add(rdoSword);
        add(rdoSword);

        JRadioButton rdoHammer = new JRadioButton("Hammer");
        rdoHammer.setFont(myFont);
        rdoHammer.setBounds(50, 420, 150, 50);
        rdoHammer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedWeapon = "Hammer";
            }
        });
        weaponGroup.add(rdoHammer);
        add(rdoHammer);
    }

    public String getSelectedWeapon() {
        return selectedWeapon;
    }

    public void createFinalClass() {
        String name = nameText.getText();
        if (rdoWarrior.isSelected()) {
            Warrior warrior = MainFrame.getTheWarrior();
            warrior.setName(name);
        } else if (rdoCleric.isSelected()) {
            Cleric cleric = MainFrame.getTheCleric();
            cleric.setName(name);
        } else if (rdoWizard.isSelected()) {
            Wizard wizard = MainFrame.getTheWizard();
            wizard.setName(name);
        }
    }

    public String generateRandomStats() {
        Random rand = new Random();
        int hitpoints = rand.nextInt(100);
        int agility = rand.nextInt(100);
        int defense = rand.nextInt(100);
        int attack = rand.nextInt(100);

        // Set the text fields with the generated stats
        hpTextField.setText("HP: " + hitpoints);
        agilityTextField.setText("Agi: " + agility);
        defenseTextField.setText("Def: " + defense);
        attackTextField.setText("Atk: " + attack);

        // Return the concatenated string of all stats
        return "\nHP: " + hitpoints + "\n" +
                "Agi: " + agility + "\n" +
                "Def: " + defense + "\n" +
                "Atk: " + attack;
    }

    public JButton getDisplayBtn() {
        return displayBtn;
    }
}