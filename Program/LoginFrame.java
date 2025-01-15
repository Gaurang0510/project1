import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

class LoginFrame extends JFrame implements ActionListener
{
    private ImageIcon background_img;
    private JLabel backgroundLabel;
    private JLabel login_header_lbl, user_lbl, password_lbl;
    private JTextField user_text;
    private JPasswordField password_Field;
    private JButton login_btn;

    public LoginFrame()
    {
        super("LOGIN HERE");
        try
        {
            this.setLayout(null);

            login_header_lbl = new JLabel("LOGIN");
            login_header_lbl.setBounds(400, 200, 150, 50);
            login_header_lbl.setFont(new Font("Pristina", Font.BOLD, 40));
            login_header_lbl.setForeground(Color.RED);

            user_lbl = new JLabel("Username: ");
            user_lbl.setBounds(300, 260, 150, 35);
            user_lbl.setForeground(Color.RED);
            user_lbl.setFont(new Font("Calibari", Font.BOLD, 15));

            user_text = new JTextField();
            user_text.setBounds(400, 260, 335, 35);
            user_text.setFont(new Font("Calibari", Font.BOLD, 15));

            password_lbl = new JLabel("Password: ");
            password_lbl.setBounds(300, 305, 150, 35);
            password_lbl.setForeground(Color.RED);
            password_lbl.setFont(new Font("Calibari", Font.BOLD, 15));

            password_Field = new JPasswordField();
            password_Field.setBounds(400, 305, 335, 35);
            password_Field.setFont(new Font("Calibari", Font.BOLD, 15));
            password_Field.setEchoChar('*');

            login_btn = new JButton("Login");
            login_btn.setBounds(400, 370, 150, 35);
            login_btn.setForeground(Color.RED);
            login_btn.setFont(new Font("Calibari", Font.BOLD, 15));
            login_btn.addActionListener(this);

            
            background_img = new ImageIcon("D:/wallpaper/973967.jpg");
            Image img = background_img.getImage();
            Image temp_img = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            background_img = new ImageIcon(temp_img);
            backgroundLabel = new JLabel(background_img);

            backgroundLabel.add(login_header_lbl);
            backgroundLabel.add(user_lbl);
            backgroundLabel.add(user_text);
            backgroundLabel.add(password_lbl);
            backgroundLabel.add(password_Field);
            backgroundLabel.add(login_btn);

            backgroundLabel.setBounds(0, 0, 800, 600);
            this.add(backgroundLabel, BorderLayout.CENTER);

            this.setSize(800, 600);
            this.setVisible(true);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd_text = e.getActionCommand();

        if ("Login".equals(cmd_text))
        {
            
            try
            {
                com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();

                DriverManager.registerDriver(d);
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csdb","root","gaurang");
                String sql ="insert into user values(?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

              ps.setString(1,user_text.getText());
              String password = new String(password_Field.getPassword());
              ps.setString(2,password);
              ps.executeUpdate();
           
            }
            catch(Exception ex)
            {
               JOptionPane.showConfirmDialog(this, ex);
            }
           
            new MonoalphabeticCipherGUI();
            this.dispose(); // Close the login frame
        }
    }

    public static void main(String[] args) 
    {
        new LoginFrame();
    }
}




 class MonoalphabeticCipherGUI extends JFrame {
    private JTextField inputField;
    private JTextField outputField;
    private JButton encryptButton;
    private JButton decryptButton;


    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String KEY =      "QWERTYUIOPLKJHGFDSAZXCVBNM"; 

    
    private Map<Character, Character> encryptionMap;
    private Map<Character, Character> decryptionMap;

    public MonoalphabeticCipherGUI() {
        setTitle("Monoalphabetic Cipher");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel inputLabel = new JLabel("Input:");
        inputLabel.setBounds(20, 20, 100, 30);
        add(inputLabel);

        inputField = new JTextField();
        inputField.setBounds(120, 20, 240, 30);
        add(inputField);

        JLabel outputLabel = new JLabel("Output:");
        outputLabel.setBounds(20, 60, 100, 30);
        add(outputLabel);

        outputField = new JTextField();
        outputField.setBounds(120, 60, 240, 30);
        outputField.setEditable(false);
        add(outputField);

        encryptButton = new JButton("Encrypt");
        encryptButton.setBounds(60, 110, 100, 30);
        add(encryptButton);

        decryptButton = new JButton("Decrypt");
        decryptButton.setBounds(200, 110, 100, 30);
        add(decryptButton);

       
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toUpperCase();
                String encrypted = encrypt(input);
                outputField.setText(encrypted);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().toUpperCase();
                String decrypted = decrypt(input);
                outputField.setText(decrypted);
            }
        });

    
        initializeCipherMaps();

        setVisible(true);
    }

   
    private String encrypt(String input) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                encryptedText.append(encryptionMap.get(c));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    private String decrypt(String input) {
        StringBuilder decryptedText = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                decryptedText.append(decryptionMap.get(c));
            } else {
                decryptedText.append(c); 
            }
        }
        return decryptedText.toString();
    }

    private void initializeCipherMaps() {
        encryptionMap = new HashMap<>();
        decryptionMap = new HashMap<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            encryptionMap.put(ALPHABET.charAt(i), KEY.charAt(i));
            decryptionMap.put(KEY.charAt(i), ALPHABET.charAt(i));
        }
    }
}