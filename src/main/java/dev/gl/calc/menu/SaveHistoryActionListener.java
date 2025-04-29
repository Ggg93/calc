package dev.gl.calc.menu;

import dev.gl.calc.main.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author gl
 */
public class SaveHistoryActionListener implements ActionListener {

    private MainWindow mw;
    private JFileChooser fileChooser;
    private History history;

    public SaveHistoryActionListener(MainWindow mw) {
        this.mw = mw;
        fileChooser = mw.getFileChooser();
        history = mw.getHistory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (history.getOperations().isEmpty()) {
            JOptionPane.showMessageDialog(mw,
                    "History of operations is empty. Nothing to save.",
                    "History Manager",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        fileChooser.setSelectedFile(new File("calculations.txt"));
        int chosenOption = fileChooser.showSaveDialog(mw);
        if (chosenOption != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fileChooser.getSelectedFile();
        try {
            FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);
            BufferedWriter writer = new BufferedWriter(fw);
            history.getOperations().values().stream()
//                    .sorted(Comparator.reverseOrder())
                    .forEach(operation -> {
                        String line = operation.printForHistory();
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException ex) {
                            ex.printStackTrace(System.err);
                        }
                    });
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveHistoryActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("file: " + file.toString());
    }

}
