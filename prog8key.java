import java.awt.event.*;
import javax.swing.*;

public class prog8key extends JFrame implements KeyListener {
    private JLabel statusLabel;

    public prog8key() {
        // Frame settings
        setTitle("Key Event Demo");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Label to display status
        statusLabel = new JLabel("Press any key to see its status.", JLabel.CENTER);
        statusLabel.setBounds(50, 50, 300, 30);
        add(statusLabel);

        // Adding KeyListener to the frame
        addKeyListener(this);
        setFocusable(true); // Ensures the frame can receive key events
    }

    @Override
    public void keyPressed(KeyEvent e) {
        statusLabel.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        statusLabel.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        statusLabel.setText("Key Typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            prog8key demo = new prog8key();
            demo.setVisible(true);
        });
    }
}
