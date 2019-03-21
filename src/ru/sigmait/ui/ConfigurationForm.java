package ru.sigmait.ui;

import javax.swing.*;

public final class ConfigurationForm extends JDialog {
    private JPanel mainJPanel;
    private static volatile ConfigurationForm instance = null;

    public static ConfigurationForm getInstance(){
        if(instance == null){
            synchronized (ConfigurationForm.class) {
                if(instance == null){
                    instance = new ConfigurationForm();
                }
            }
        }
        return instance;
        }

    private ConfigurationForm(){
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
