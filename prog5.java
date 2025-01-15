import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class prog5 extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JComboBox<String> languageComboBox;

    public prog5() {
        // Frame settings
        setTitle("Language Selector");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ComboBox for languages
        JLabel comboLabel = new JLabel("Select Language:");
        languageComboBox = new JComboBox<>(new String[]{"English", "Marathi", "Hindi", "Sanskrit"});
        languageComboBox.addActionListener(this);

        JPanel comboPanel = new JPanel();
        comboPanel.add(comboLabel);
        comboPanel.add(languageComboBox);
        add(comboPanel, BorderLayout.NORTH);

        // ScrollPane with TextArea
        textArea = new JTextArea(10, 30);
        textArea.setText("Select a language to see details.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedLanguage = (String) languageComboBox.getSelectedItem();
        switch (selectedLanguage) {
            case "English":
                textArea.setText("English is a widely spoken global language.");
                break;
            case "Marathi":
                textArea.setText("Marathi is the official language of Maharashtra, India.");
                break;
            case "Hindi":
                textArea.setText("Hindi is one of the official languages of India.");
                break;
            case "Sanskrit":
                textArea.setText("Sanskrit is an ancient language of India.");
                break;
            default:
                textArea.setText("Select a language to see details.");
        }
    }

    public static void main(String[] args) {
       {
            prog5 selector = new prog5();
            selector.setVisible(true);
        };
    }
}
