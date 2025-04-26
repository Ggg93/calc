package dev.gl.calc.main.gui;

import dev.gl.calc.ButtonActions;
import dev.gl.calc.Operation;
import dev.gl.calc.menu.History;
import dev.gl.calc.main.enums.CalculatorState;
import dev.gl.calc.menu.ExitButtonActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.text.PlainDocument;

/**
 *
 * @author gl
 */
public class MainWindow extends javax.swing.JFrame {

    public static final int OPERAND_LENGTH_LIMIT = 15;

    private CalculatorState calculatorState;
    private Operation operation;
    private History history;
    private ButtonActions buttonActions;
    private LimitedLengthDocumentFilter docFilter;

    public MainWindow() {
        configureFrame();
        initComponents();
        initClassFields();
        configureComponents();
        bindActionsToButtons();
        createKeyBindings();
        initMenuItems();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        upperPanel = new javax.swing.JPanel();
        historyDataPanel = new javax.swing.JPanel();
        operationTextField = new javax.swing.JTextField();
        resultPanel = new javax.swing.JPanel();
        operandTextField = new javax.swing.JTextField();
        bottomPanel = new javax.swing.JPanel();
        memoryMenuPanel = new javax.swing.JPanel();
        mcButton = new javax.swing.JButton();
        mrButton = new javax.swing.JButton();
        mAddButton = new javax.swing.JButton();
        mSubtractButton = new javax.swing.JButton();
        buttonsPanel = new javax.swing.JPanel();
        percentButton = new javax.swing.JButton();
        ceButton = new javax.swing.JButton();
        cButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        dividerButton = new javax.swing.JButton();
        squaringButton = new javax.swing.JButton();
        squareRootButton = new javax.swing.JButton();
        divideButton = new javax.swing.JButton();
        sevenButton = new javax.swing.JButton();
        eightButton = new javax.swing.JButton();
        nineButton = new javax.swing.JButton();
        multiplyButton = new javax.swing.JButton();
        fourButton = new javax.swing.JButton();
        fiveButton = new javax.swing.JButton();
        sixButton = new javax.swing.JButton();
        subtractButton = new javax.swing.JButton();
        oneButton = new javax.swing.JButton();
        twoButton = new javax.swing.JButton();
        threeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        signButton = new javax.swing.JButton();
        zeroButton = new javax.swing.JButton();
        decimalButton = new javax.swing.JButton();
        equalsButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        mainMenu = new javax.swing.JMenu();
        settingsMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        historyMenu = new javax.swing.JMenu();
        langMenu = new javax.swing.JMenu();
        langEnMenuItem = new javax.swing.JMenuItem();
        langRuMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setMinimumSize(new java.awt.Dimension(450, 350));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jSplitPane1.setDividerLocation(70);
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setResizeWeight(0.15);
        jSplitPane1.setEnabled(false);

        upperPanel.setLayout(new java.awt.BorderLayout());

        historyDataPanel.setMinimumSize(new java.awt.Dimension(100, 35));
        historyDataPanel.setPreferredSize(new java.awt.Dimension(100, 35));
        historyDataPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0));

        operationTextField.setEditable(false);
        operationTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        operationTextField.setForeground(new java.awt.Color(102, 102, 102));
        operationTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        operationTextField.setToolTipText("");
        operationTextField.setBorder(null);
        operationTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        operationTextField.setFocusable(false);
        operationTextField.setMargin(null);
        operationTextField.setMinimumSize(new java.awt.Dimension(64, 30));
        operationTextField.setPreferredSize(new java.awt.Dimension(500, 30));
        historyDataPanel.add(operationTextField);

        upperPanel.add(historyDataPanel, java.awt.BorderLayout.NORTH);

        resultPanel.setMinimumSize(new java.awt.Dimension(100, 35));
        resultPanel.setPreferredSize(new java.awt.Dimension(100, 35));
        resultPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        operandTextField.setEditable(false);
        operandTextField.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        operandTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        operandTextField.setText("0");
        operandTextField.setBorder(null);
        operandTextField.setFocusable(false);
        operandTextField.setMinimumSize(new java.awt.Dimension(64, 30));
        operandTextField.setPreferredSize(new java.awt.Dimension(500, 30));
        resultPanel.add(operandTextField);

        upperPanel.add(resultPanel, java.awt.BorderLayout.CENTER);

        jSplitPane1.setTopComponent(upperPanel);

        bottomPanel.setLayout(new javax.swing.BoxLayout(bottomPanel, javax.swing.BoxLayout.PAGE_AXIS));

        memoryMenuPanel.setLayout(new java.awt.GridLayout(1, 4, 4, 2));

        mcButton.setBackground(new java.awt.Color(204, 204, 204));
        mcButton.setForeground(new java.awt.Color(0, 0, 0));
        mcButton.setText("MC");
        memoryMenuPanel.add(mcButton);

        mrButton.setBackground(new java.awt.Color(204, 204, 204));
        mrButton.setForeground(new java.awt.Color(0, 0, 0));
        mrButton.setText("MR");
        memoryMenuPanel.add(mrButton);

        mAddButton.setBackground(new java.awt.Color(204, 204, 204));
        mAddButton.setForeground(new java.awt.Color(0, 0, 0));
        mAddButton.setText("M+");
        memoryMenuPanel.add(mAddButton);

        mSubtractButton.setBackground(new java.awt.Color(204, 204, 204));
        mSubtractButton.setForeground(new java.awt.Color(0, 0, 0));
        mSubtractButton.setText("M-");
        memoryMenuPanel.add(mSubtractButton);

        bottomPanel.add(memoryMenuPanel);

        buttonsPanel.setPreferredSize(new java.awt.Dimension(250, 100));
        buttonsPanel.setLayout(new java.awt.GridLayout(6, 4, 2, 2));

        percentButton.setText("%");
        buttonsPanel.add(percentButton);

        ceButton.setText("CE");
        buttonsPanel.add(ceButton);

        cButton.setText("C");
        buttonsPanel.add(cButton);

        delButton.setText("DEL");
        buttonsPanel.add(delButton);

        dividerButton.setText("1/x");
        buttonsPanel.add(dividerButton);

        squaringButton.setText("x^2");
        buttonsPanel.add(squaringButton);

        squareRootButton.setText("2√x");
        buttonsPanel.add(squareRootButton);

        divideButton.setText("÷");
        buttonsPanel.add(divideButton);

        sevenButton.setText("7");
        buttonsPanel.add(sevenButton);

        eightButton.setText("8");
        buttonsPanel.add(eightButton);

        nineButton.setText("9");
        buttonsPanel.add(nineButton);

        multiplyButton.setText("x");
        buttonsPanel.add(multiplyButton);

        fourButton.setText("4");
        buttonsPanel.add(fourButton);

        fiveButton.setText("5");
        buttonsPanel.add(fiveButton);

        sixButton.setText("6");
        buttonsPanel.add(sixButton);

        subtractButton.setText("-");
        buttonsPanel.add(subtractButton);

        oneButton.setText("1");
        buttonsPanel.add(oneButton);

        twoButton.setText("2");
        buttonsPanel.add(twoButton);

        threeButton.setText("3");
        buttonsPanel.add(threeButton);

        addButton.setText("+");
        buttonsPanel.add(addButton);

        signButton.setText("+/-");
        buttonsPanel.add(signButton);

        zeroButton.setText("0");
        buttonsPanel.add(zeroButton);

        decimalButton.setText(".");
        buttonsPanel.add(decimalButton);

        equalsButton.setBackground(new java.awt.Color(204, 204, 255));
        equalsButton.setForeground(new java.awt.Color(0, 0, 0));
        equalsButton.setText("=");
        buttonsPanel.add(equalsButton);

        bottomPanel.add(buttonsPanel);

        jSplitPane1.setRightComponent(bottomPanel);

        getContentPane().add(jSplitPane1);

        mainMenu.setText("Main");

        settingsMenuItem.setText("Settings");
        mainMenu.add(settingsMenuItem);

        saveMenuItem.setText("Save...");
        mainMenu.add(saveMenuItem);

        aboutMenuItem.setText("About");
        mainMenu.add(aboutMenuItem);

        exitMenuItem.setText("Exit");
        mainMenu.add(exitMenuItem);

        menuBar.add(mainMenu);

        historyMenu.setText("History");
        menuBar.add(historyMenu);

        langMenu.setText("Lang");

        langEnMenuItem.setText("En");
        langMenu.add(langEnMenuItem);

        langRuMenuItem.setText("Ru");
        langMenu.add(langRuMenuItem);

        menuBar.add(langMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cButton;
    private javax.swing.JButton ceButton;
    private javax.swing.JButton decimalButton;
    private javax.swing.JButton delButton;
    private javax.swing.JButton divideButton;
    private javax.swing.JButton dividerButton;
    private javax.swing.JButton eightButton;
    private javax.swing.JButton equalsButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton fiveButton;
    private javax.swing.JButton fourButton;
    private javax.swing.JPanel historyDataPanel;
    private javax.swing.JMenu historyMenu;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem langEnMenuItem;
    private javax.swing.JMenu langMenu;
    private javax.swing.JMenuItem langRuMenuItem;
    private javax.swing.JButton mAddButton;
    private javax.swing.JButton mSubtractButton;
    private javax.swing.JMenu mainMenu;
    private javax.swing.JButton mcButton;
    private javax.swing.JPanel memoryMenuPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton mrButton;
    private javax.swing.JButton multiplyButton;
    private javax.swing.JButton nineButton;
    private javax.swing.JButton oneButton;
    private javax.swing.JTextField operandTextField;
    private javax.swing.JTextField operationTextField;
    private javax.swing.JButton percentButton;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem settingsMenuItem;
    private javax.swing.JButton sevenButton;
    private javax.swing.JButton signButton;
    private javax.swing.JButton sixButton;
    private javax.swing.JButton squareRootButton;
    private javax.swing.JButton squaringButton;
    private javax.swing.JButton subtractButton;
    private javax.swing.JButton threeButton;
    private javax.swing.JButton twoButton;
    private javax.swing.JPanel upperPanel;
    private javax.swing.JButton zeroButton;
    // End of variables declaration//GEN-END:variables

    private void configureFrame() {
        // set location of frame in the middle of screen
        this.setLocationRelativeTo(null);

        // set frame icon
        ImageIcon icon = new ImageIcon(".\\src\\main\\resources\\icons8-calculator-40.png");
        this.setIconImage(icon.getImage());
    }

    private void configureComponents() {
        // set length limit to operandTextField
        PlainDocument pd = (PlainDocument) operandTextField.getDocument();
        pd.setDocumentFilter(docFilter);
    }

    public void updateTextFields() {
        // update text in operationTextField
        operationTextField.setText(operation.toString());

        // update text in operandTextField
        String showedOperand = null;

        if (operation.result == null) {
            showedOperand = operation.getActiveOperand() != null
                    ? operation.getActiveOperand()
                    : operation.operandLeft;
            operandTextField.setText(NumberFormatter.format(showedOperand));
        } else {
            showedOperand = operation.result.toString();
            showedOperand = NumberFormatter.format(showedOperand);
            docFilter.ignoreLengthLimitForNextOperation(); // make it possible to show very big or very small numbers
            operandTextField.setText(showedOperand);
        }
    }

    private void createKeyBindings() {

        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("0"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("1"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("2"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("3"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("4"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("5"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("6"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("7"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("8"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("9"), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0), "digit");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "back_space");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0), "decimal");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "clear_entry");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "clear");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "sign");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0), "addition");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ADD, 0), "addition");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0), "subtraction");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0), "subtraction");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0), "multiplication");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_8, InputEvent.SHIFT_DOWN_MASK), "multiplication");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0), "division");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0), "division");
        this.getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "equals");

        this.getRootPane().getActionMap().put("digit", buttonActions.digitPressedAction);
        this.getRootPane().getActionMap().put("back_space", buttonActions.backspacePressedAction);
        this.getRootPane().getActionMap().put("decimal", buttonActions.decimalPressedAction);
        this.getRootPane().getActionMap().put("clear_entry", buttonActions.clearEntryPressedAction);
        this.getRootPane().getActionMap().put("clear", buttonActions.clearPressedAction);
        this.getRootPane().getActionMap().put("sign", buttonActions.signPressedAction);
        this.getRootPane().getActionMap().put("addition", buttonActions.plusPressedAction);
        this.getRootPane().getActionMap().put("subtraction", buttonActions.minusPressedAction);
        this.getRootPane().getActionMap().put("multiplication", buttonActions.multiplyPressedAction);
        this.getRootPane().getActionMap().put("division", buttonActions.divisionPressedAction);
        this.getRootPane().getActionMap().put("equals", buttonActions.equalsPressedAction);
    }

    private void bindActionsToButtons() {

        // digit buttons
        zeroButton.addActionListener(buttonActions.digitPressedAction);
        oneButton.addActionListener(buttonActions.digitPressedAction);
        twoButton.addActionListener(buttonActions.digitPressedAction);
        threeButton.addActionListener(buttonActions.digitPressedAction);
        fourButton.addActionListener(buttonActions.digitPressedAction);
        fiveButton.addActionListener(buttonActions.digitPressedAction);
        sixButton.addActionListener(buttonActions.digitPressedAction);
        sevenButton.addActionListener(buttonActions.digitPressedAction);
        eightButton.addActionListener(buttonActions.digitPressedAction);
        nineButton.addActionListener(buttonActions.digitPressedAction);

        // auxiliary fuctions buttons
        delButton.addActionListener(buttonActions.backspacePressedAction);
        ceButton.addActionListener(buttonActions.clearEntryPressedAction);
        cButton.addActionListener(buttonActions.clearPressedAction);
        signButton.addActionListener(buttonActions.signPressedAction);
        decimalButton.addActionListener(buttonActions.decimalPressedAction);

        // main operators buttons
        addButton.addActionListener(buttonActions.plusPressedAction);
        subtractButton.addActionListener(buttonActions.minusPressedAction);
        multiplyButton.addActionListener(buttonActions.multiplyPressedAction);
        divideButton.addActionListener(buttonActions.divisionPressedAction);
        equalsButton.addActionListener(buttonActions.equalsPressedAction);

        // auxiliary operators buttons
        //...
        // memory buttons
    }

    private void initClassFields() {
        calculatorState = CalculatorState.OK;
        operation = new Operation(this);
        history = new History();
        buttonActions = new ButtonActions(this, OPERAND_LENGTH_LIMIT);
        docFilter = new LimitedLengthDocumentFilter(OPERAND_LENGTH_LIMIT);
    }

    private void initMenuItems() {
        exitMenuItem.addActionListener(new ExitButtonActionListener());
    }

    public Operation getOperation() {
        return operation;
    }

    public History getHistory() {
        return history;
    }

    public CalculatorState getCalculatorState() {
        return calculatorState;
    }

    public ButtonActions getButtonActions() {
        return buttonActions;
    }

}
