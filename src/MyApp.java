import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyApp extends JFrame {

    JPanel panelMain;
    JTextField txtExpression;
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    JButton btnEqual, btnPlus, btnMinus, btnTimes, btnDivide, btnPercent;

    ActionListener actionListenerNumbers;
    ActionListener actionListenerOperators;

    String termLeft = "";
    String opPrevious = "";
    String termRight = "";
    String opCurrent = "";


    public static void main(String[] args) {
        new MyApp();
    }

    public MyApp() {
        this.setTitle("Java GUI Swing Calculator");
        this.setSize(800, 600);

        Font f1 = new Font("Arial", Font.PLAIN, 24);
        Font f2 = new Font("Arial", Font.BOLD, 32);


        // LAYOUT
        panelMain = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.25;
        gbc.weighty = 0.20;


        // EXPRESSION
        txtExpression = new JTextField();
        txtExpression.setFont(f2);
        txtExpression.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panelMain.add(txtExpression, gbc);


        // NUMBERS
        btn0 = new JButton("0");
        btn0.setFont(f1);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelMain.add(btn0, gbc);

        btn1 = new JButton("1");
        btn1.setFont(f1);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelMain.add(btn1, gbc);

        btn2 = new JButton("2");
        btn2.setFont(f1);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelMain.add(btn2, gbc);

        btn3 = new JButton("3");
        btn3.setFont(f1);
        gbc.gridx = 2;
        gbc.gridy = 3;
        panelMain.add(btn3, gbc);

        btn4 = new JButton("4");
        btn4.setFont(f1);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelMain.add(btn4, gbc);

        btn5 = new JButton("5");
        btn5.setFont(f1);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMain.add(btn5, gbc);

        btn6 = new JButton("6");
        btn6.setFont(f1);
        gbc.gridx = 2;
        gbc.gridy = 2;
        panelMain.add(btn6, gbc);

        btn7 = new JButton("7");
        btn7.setFont(f1);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelMain.add(btn7, gbc);

        btn8 = new JButton("8");
        btn8.setFont(f1);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelMain.add(btn8, gbc);

        btn9 = new JButton("9");
        btn9.setFont(f1);
        gbc.gridx = 2;
        gbc.gridy = 1;
        panelMain.add(btn9, gbc);


        // OPERATORS

        btnEqual = new JButton("=");
        btnEqual.setFont(f1);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelMain.add(btnEqual, gbc);

        btnPlus = new JButton("+");
        btnPlus.setFont(f1);
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelMain.add(btnPlus, gbc);

        btnMinus = new JButton("-");
        btnMinus.setFont(f1);
        gbc.gridx = 3;
        gbc.gridy = 3;
        panelMain.add(btnMinus, gbc);

        btnTimes = new JButton("*");
        btnTimes.setFont(f1);
        gbc.gridx = 3;
        gbc.gridy = 2;
        panelMain.add(btnTimes, gbc);

        btnDivide = new JButton("/");
        btnDivide.setFont(f1);
        gbc.gridx = 3;
        gbc.gridy = 1;
        panelMain.add(btnDivide, gbc);

        btnPercent = new JButton("%");
        btnPercent.setFont(f1);
        gbc.gridx = 3;
        gbc.gridy = 0;
        panelMain.add(btnPercent, gbc);

        this.add(panelMain);
        this.setVisible(true);



        // EVENT HANDLERS

        // NUMBERS
        btn0.setActionCommand("0");
        btn1.setActionCommand("1");
        btn2.setActionCommand("2");
        btn3.setActionCommand("3");
        btn4.setActionCommand("4");
        btn5.setActionCommand("5");
        btn6.setActionCommand("6");
        btn7.setActionCommand("7");
        btn8.setActionCommand("8");
        btn9.setActionCommand("9");

        actionListenerNumbers = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNumber(e.getActionCommand());
            }
        };

        btn0.addActionListener(actionListenerNumbers);
        btn1.addActionListener(actionListenerNumbers);
        btn2.addActionListener(actionListenerNumbers);
        btn3.addActionListener(actionListenerNumbers);
        btn4.addActionListener(actionListenerNumbers);
        btn5.addActionListener(actionListenerNumbers);
        btn6.addActionListener(actionListenerNumbers);
        btn7.addActionListener(actionListenerNumbers);
        btn8.addActionListener(actionListenerNumbers);
        btn9.addActionListener(actionListenerNumbers);


        // OPERATORS

        btnEqual.setActionCommand("=");
        btnPlus.setActionCommand("+");
        btnMinus.setActionCommand("-");
        btnTimes.setActionCommand("*");
        btnDivide.setActionCommand("/");
        btnPercent.setActionCommand("%");

        actionListenerOperators = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setOperator(e.getActionCommand());
            }
        };

        btnEqual.addActionListener(actionListenerOperators);
        btnPlus.addActionListener(actionListenerOperators);
        btnMinus.addActionListener(actionListenerOperators);
        btnTimes.addActionListener(actionListenerOperators);
        btnDivide.addActionListener(actionListenerOperators);
        btnPercent.addActionListener(actionListenerOperators);
    }


    private void setNumber(String n) {
        if (opPrevious.equals("")) {
            termLeft += n;
        } else {
            termRight += n;
        }

        txtExpression.setText(termLeft + " " + opPrevious + " " + termRight + " " + opCurrent + " ");
    }

    private void setOperator(String op) {
        if (opPrevious.equals("")) {
            if (!op.equals("%") && !op.equals("=")) {
                opPrevious = op;
            }
        } else {
            if (!termRight.equals("")) {
                opCurrent = op;
            } else {
                opPrevious = op;
            }
        }

        txtExpression.setText(termLeft + " " + opPrevious + " " + termRight + " " + opCurrent + " ");

        if (!opCurrent.equals("")) { // "="
            if (opCurrent.equals("%")) {
                float left = Float.parseFloat(termLeft);
                float right = Float.parseFloat(termRight);
                float result = left * (right / 100);

                termRight = String.valueOf(result);
                opCurrent = "";

                txtExpression.setText(termLeft + " " + opPrevious + " " + termRight + " " + opCurrent + " ");
            } else {
                float result = 0;
                switch (opPrevious.charAt(0)) {  // "+"
                    case '+':
                        result = Float.parseFloat(termLeft) + Float.parseFloat(termRight);
                        break;
                    case '-':
                        result = Float.parseFloat(termLeft) - Float.parseFloat(termRight);
                        break;
                    case '*':
                        result = Float.parseFloat(termLeft) * Float.parseFloat(termRight);
                        break;
                    case '/':
                        result = Float.parseFloat(termLeft) / Float.parseFloat(termRight);
                        break;
                }

                txtExpression.setText(termLeft + " " + opPrevious + " " + termRight + " " + opCurrent + " " + result + " ");

                termLeft = "";
                opPrevious = "";
                termRight = "";
                opCurrent = "";
            }
        }
    }

}
