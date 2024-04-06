package Classes;

import javax.swing.*;

public abstract class Class {

    private String name;

    private ImageIcon ClassPic;

    public Class() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassPic(ImageIcon ClassPic) {
        this.ClassPic = ClassPic;
    }

    public abstract String getWeapon();

}
