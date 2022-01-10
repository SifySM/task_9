package edu.vsu.ru.project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import edu.vsu.ru.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;
import edu.vsu.ru.util.ListUtils;

import java.awt.*;
import java.io.File;
import java.util.List;

public class FrameMain extends JFrame {
    private JPanel PanelMain;
    private JButton buttonLoadDataFromFile;
    private JButton buttonFillWithRandomNumbers;
    private JButton buttonSaveToOriginalFile;
    private JButton buttonFindSequence;
    private JButton buttonSaveInFinalFile;
    private JTable tableSource;
    private JTable tableFinal;

    private JFileChooser fileChooserOpen;
    private JFileChooser fileChooserSave;

    public FrameMain() {
        $$$setupUI$$$();
        this.setTitle("Task 9");
        this.setContentPane(PanelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600, 250, 300, 300);
        this.setResizable(false);
        this.pack();

        JTableUtils.initJTableForArray(tableSource, 40, true, true, false, true, 25, 5);
        JTableUtils.initJTableForArray(tableFinal, 40, true, true, false, true, 25, 5);
        tableSource.setRowHeight(30);
        tableFinal.setRowHeight(30);
        DefaultTableModel defaultTableModel = (DefaultTableModel) tableSource.getModel();
        defaultTableModel.setRowCount(10);
        tableSource.setModel(defaultTableModel);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("View");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        JTableUtils.writeArrayToJTable(tableSource, new int[]{
                0, 1, 2, 3, 4
        });
        this.pack();

        buttonLoadDataFromFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = ListUtils.readListFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(tableSource, ListUtils.convertToIntArray(list));
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonFillWithRandomNumbers.addActionListener(actionEvent -> {
            int[] arr = new int[tableSource.getColumnCount()];
            ListUtils.fillArrayRandomNumbers(arr);
            JTableUtils.writeArrayToJTable(tableSource, arr);
        });

        buttonSaveToOriginalFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = ListUtils.readListFromJTable(tableSource);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ListUtils.writeListToFile(file, list);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonFindSequence.addActionListener(actionEvent -> {
            try {
                List<Integer> list = ListUtils.readListFromJTable(tableSource);
                List<Integer> newList = LongestSequenceFinder.createNewList(list);
                JTableUtils.writeArrayToJTable(tableFinal, ListUtils.convertToIntArray(newList));
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });

        buttonSaveInFinalFile.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(PanelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = ListUtils.readListFromJTable(tableFinal);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ListUtils.writeListToFile(file, list);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
