package org.vso.views.implementations;

import org.vso.constants.ComponentText;
import org.vso.constants.ImagePathHolder;
import org.vso.models.services.contracts.ChangeProfileDataService;
import org.vso.models.services.implementations.ChangeProfileDataServiceImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePasswordPage extends JFrame implements ActionListener {
    private static ChangePasswordPage instance;
    private final JLabel newPasswordLabel;
    private final JTextField newPasswordField;
    private final JLabel repeatPasswordLabel;
    private final JTextField repeatPasswordField;
    private final JButton editPasswordButton;
    private final JButton returnButton;
    private final ChangeProfileDataService changeProfileDataService;

    public ChangePasswordPage(){
        this.newPasswordLabel = new JLabel();
        this.newPasswordField = new JTextField();
        this.repeatPasswordLabel = new JLabel();
        this.repeatPasswordField = new JTextField();
        this.editPasswordButton = new JButton();
        this.returnButton = new JButton();
        this.changeProfileDataService = new ChangeProfileDataServiceImpl();
        setupComponents();
    }

    public static ChangePasswordPage getInstance(){
        if (instance == null){
            instance = new ChangePasswordPage();
        }
        return instance;
    }

    private void setupComponents() {
        setupNewPasswordLabel();
        setupNewPasswordField();
        setupRepeatPasswordLabel();
        setupRepeatPasswordField();
        setupEditPasswordButton();
        setupReturnButton();
        setupFrame();
    }

    private void setupFrame() {
        this.add(newPasswordLabel);
        this.add(newPasswordField);
        this.add(repeatPasswordLabel);
        this.add(repeatPasswordField);
        this.add(editPasswordButton);
        this.add(returnButton);

        ImageIcon icon = new ImageIcon(ImagePathHolder.FRAME_ICON);
        this.setIconImage(icon.getImage());
        this.setTitle(ComponentText.APP_TITLE.getText());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(550, 200, 420, 420);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    private void setupReturnButton() {
        returnButton.setText("return");
        returnButton.setBounds(50,250, 300,40);
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
    }

    private void setupEditPasswordButton() {
        editPasswordButton.setText("Edit password");
        editPasswordButton.setBounds(50, 200, 300, 40);
        editPasswordButton.setFocusable(false);
        editPasswordButton.addActionListener(this);
    }

    private void setupRepeatPasswordField() {
        repeatPasswordField.setBounds(150, 150, 200, 40);
    }

    private void setupRepeatPasswordLabel() {
        repeatPasswordLabel.setText("repeat password: ");
        repeatPasswordLabel.setBounds(50, 150, 140, 40);
    }

    private void setupNewPasswordField() {
        newPasswordField.setBounds(150, 90, 200, 40);
    }

    private void setupNewPasswordLabel() {
        newPasswordLabel.setText("new password:");
        newPasswordLabel.setBounds(50, 90, 120, 40);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (editPasswordButton.equals(source)){
            changeProfileDataService.editPassword(newPasswordField.getText(),
                    repeatPasswordField.getText());
        }else if (returnButton.equals(source)){
            navigateToChangeProfileDataPage();
        }
    }

    private void navigateToChangeProfileDataPage(){
        this.dispose();
        new ChangeProfileDataPage();
    }
}
