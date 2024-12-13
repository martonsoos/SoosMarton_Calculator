import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Számológép");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel label1 = new JLabel("Első szám:");
        JTextField num1Field = new JTextField(10);
        JLabel label2 = new JLabel("Második szám:");
        JTextField num2Field = new JTextField(10);

        inputPanel.add(label1);
        inputPanel.add(num1Field);
        inputPanel.add(label2);
        inputPanel.add(num2Field);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));  // Középre igazítva
        JButton addButton = new JButton("Összeadás");
        JButton subtractButton = new JButton("Kivonás");
        JButton multiplyButton = new JButton("Szorzás");
        JButton divideButton = new JButton("Osztás");

        addButton.setPreferredSize(new Dimension(80, 30));
        subtractButton.setPreferredSize(new Dimension(80, 30));
        multiplyButton.setPreferredSize(new Dimension(80, 30));
        divideButton.setPreferredSize(new Dimension(80, 30));

        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        JPanel resultPanel = new JPanel();
        JLabel resultLabel = new JLabel("Eredmény:");
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);

        resultPanel.add(resultLabel);
        resultPanel.add(resultField);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(resultPanel, BorderLayout.SOUTH);

        frame.add(panel);

        frame.setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2;
                    resultField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Érvénytelen szám(ok)!");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 - num2;
                    resultField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Érvénytelen szám(ok)!");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 * num2;
                    resultField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Érvénytelen szám(ok)!");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(frame, "Nem oszthatunk nullával!");
                    } else {
                        double result = num1 / num2;
                        resultField.setText(String.format("%.2f", result));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Érvénytelen szám(ok)!");
                }
            }
        });
    }
}
