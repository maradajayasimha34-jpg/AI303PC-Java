
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignmentB6 extends JFrame
        implements ActionListener, KeyListener, ItemListener {

    JTextArea log = new JTextArea();
    JLabel wordCount = new JLabel("Word count: 0");

    int clicks = 0;
    int words = 0;
    boolean inWord = false;

    AssignmentB6() {
        super("Swing Event Log");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        log.setEditable(true);
        add(new JScrollPane(log), BorderLayout.CENTER);

        JToolBar bar = new JToolBar();

        String[] buttons = {"Start", "Pause", "Stop"};
        for (String s : buttons) {
            JButton b = new JButton(s);
            b.addActionListener(this);
            bar.add(b);
        }

        add(bar, BorderLayout.NORTH);

        log.addKeyListener(this);

        MouseAdapter mouse = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                append("Mouse clicked at (" + e.getX() + ", "
                        + e.getY() + "), count="
                        + e.getClickCount());
            }

            public void mouseDragged(MouseEvent e) {
                append("Mouse dragged at (" + e.getX()
                        + ", " + e.getY() + ")");
            }
        };

        log.addMouseListener(mouse);
        log.addMouseMotionListener(mouse);

        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu help = new JMenu("Help");

        JMenuItem fresh = new JMenuItem("New");
        JMenuItem exit = new JMenuItem("Exit");

        fresh.addActionListener(e -> {
            log.setText("");
            words = 0;
            inWord = false;
            wordCount.setText("Word count: 0");
        });

        exit.addActionListener(e -> System.exit(0));

        file.add(fresh);
        file.add(exit);

        JCheckBoxMenuItem editable =
                new JCheckBoxMenuItem("Editable", true);
        editable.addItemListener(this);
        edit.add(editable);

        edit.addSeparator();

        JRadioButtonMenuItem small =
                new JRadioButtonMenuItem("Small");
        JRadioButtonMenuItem large =
                new JRadioButtonMenuItem("Large");

        ButtonGroup sizes = new ButtonGroup();
        sizes.add(small);
        sizes.add(large);

        small.addItemListener(this);
        large.addItemListener(this);

        edit.add(small);
        edit.add(large);

        JMenuItem about = new JMenuItem("About");
        about.addActionListener(e ->
                JOptionPane.showMessageDialog(
                        this, "Swing Event Log Application"));

        help.add(about);

        mb.add(file);
        mb.add(edit);
        mb.add(help);
        setJMenuBar(mb);

        JPopupMenu popup = new JPopupMenu();
        JMenuItem clear = new JMenuItem("Clear Log");
        JMenuItem copy = new JMenuItem("Copy");

        clear.addActionListener(e -> {
            log.setText("");
        });

        copy.addActionListener(e -> log.copy());

        popup.add(clear);
        popup.add(copy);
        log.setComponentPopupMenu(popup);

        add(wordCount, BorderLayout.SOUTH);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void append(String s) {
        log.append(s + "\n");
    }

    public void actionPerformed(ActionEvent e) {
        clicks++;
        append("ActionEvent: " + e.getActionCommand()
                + " clicked. Count = " + clicks);
    }

    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();

        if (src instanceof JCheckBoxMenuItem) {
            boolean selected =
                    ((JCheckBoxMenuItem) src).isSelected();

            log.setEditable(selected);
            append("Editable: "
                    + (selected ? "checked" : "unchecked"));
        }

        if (src instanceof JRadioButtonMenuItem
                && e.getStateChange() == ItemEvent.SELECTED) {

            boolean isLarge =
                    ((JRadioButtonMenuItem) src)
                            .getText().equals("Large");

            log.setFont(log.getFont().deriveFont(
                    isLarge ? 18.0f : 12.0f));

            append("Font size: "
                    + (isLarge ? "Large" : "Small"));
        }
    }

    public void keyTyped(KeyEvent e) {
        char ch = e.getKeyChar();

        append("Key typed: " + ch);

        if (Character.isWhitespace(ch)) {
            inWord = false;
        } else if (!inWord) {
            words++;
            inWord = true;
        }

        wordCount.setText("Word count: " + words);
    }

    public void keyPressed(KeyEvent e) {
        append("Key pressed: "
                + KeyEvent.getKeyText(e.getKeyCode()));
    }

    public void keyReleased(KeyEvent e) {
        append("Key released: "
                + KeyEvent.getKeyText(e.getKeyCode()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AssignmentB6());
    }
}

//Sample output: ActionEvent: Start clicked (Count = 1) command=Start; MouseEvent: Clicked at (112, 84), clicks=1,
button=1; KeyEvent: Typed 'j' (code=0); ItemEvent: Editable checked.