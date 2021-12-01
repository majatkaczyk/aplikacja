import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.awt.Color.*;

public class Window extends JFrame {

    public Window() throws HeadlessException {
        this("undefined");
    }
    public Window(String title) throws HeadlessException {
        super(title);
        add_users();
        buildFrame();
    }
    private Map<String, String> users = new HashMap<>();
    public void add_users()
    {
        users.put("Student", "123");
        users.put("uzytkownik", "user");
        users.put("User", "haslo");
    }

    protected void buildFrame()
    {
        JFrame frame = new JFrame();
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");
        JTextField idField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel userLabel = new JLabel("User");
        JLabel passwordLabel = new JLabel("Password");
        userLabel.setBounds(50,75,75,30);
        passwordLabel.setBounds(50,100,75,30);
        idField.setBounds(150,75,120,30);
        passwordField.setBounds(150,100,120,30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkInput(frame, idField, passwordField);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(frame, idField, passwordField);

            }
        });
        loginButton.setBounds(75, 300, 120,40);
        clearButton.setBounds(275,300, 120,40);
        frame.add(loginButton);
        frame.add(clearButton);
        frame.getContentPane().setBackground(gray);
        frame.setLayout(null);
        frame.add(idField);
        frame.add(passwordField);
        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,150,450,420);
        frame.setVisible(true);

    }
    private void checkInput (JFrame frame, JTextField idField, JPasswordField passwordField) {
        String login = idField.getText();
        String password = new String(passwordField.getPassword());
        for (String key: users.keySet()) {
            if(Objects.equals(login, key) && Objects.equals(password, users.get(key))){
                frame.getContentPane().setBackground(green);
                break;
            }else
                frame.getContentPane().setBackground(red);
        }
    }
    private void clear(JFrame frame, JTextField idField, JPasswordField passwordField){
        idField.setText("");
        passwordField.setText("");
        frame.getContentPane().setBackground(gray);
    }
}
