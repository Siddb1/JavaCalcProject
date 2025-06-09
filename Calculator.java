import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField num1Field, num2Field;
    JComboBox<String> operatorBox;
    JButton calculateButton;
    JLabel resultLabel;

    public Calculator() {
        setTitle("Simple Calculator");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Input fields and labels
        add(new JLabel("First Number:"));
        num1Field = new JTextField();
        add(num1Field);

        add(new JLabel("Operator:"));
        String[] operators = { "+", "-", "*", "/" };
        operatorBox = new JComboBox<>(operators);
        add(operatorBox);

        add(new JLabel("Second Number:"));
        num2Field = new JTextField();
        add(num2Field);

        // Calculate button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        // Result label
        resultLabel = new JLabel("Result: ");
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            String operator = (String) operatorBox.getSelectedItem();
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    } else {
                        result = num1 / num2;
                    }
                    break;
            }

            resultLabel.setText("Result: " + result);

        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid number input.");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
