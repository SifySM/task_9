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

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        PanelMain = new JPanel();
        PanelMain.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        PanelMain.add(panel1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonLoadDataFromFile = new JButton();
        buttonLoadDataFromFile.setText("Load data from file");
        panel1.add(buttonLoadDataFromFile, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonSaveToOriginalFile = new JButton();
        buttonSaveToOriginalFile.setText("Save to original file");
        panel1.add(buttonSaveToOriginalFile, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonFillWithRandomNumbers = new JButton();
        buttonFillWithRandomNumbers.setText("Fill With Random Numbers");
        panel1.add(buttonFillWithRandomNumbers, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        PanelMain.add(panel2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonFindSequence = new JButton();
        buttonFindSequence.setText("Find Sequence");
        panel2.add(buttonFindSequence, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        PanelMain.add(panel3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonSaveInFinalFile = new JButton();
        buttonSaveInFinalFile.setText("Save to final file");
        panel3.add(buttonSaveInFinalFile, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel3.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        PanelMain.add(scrollPane1, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 200), null, 0, false));
        tableFinal = new JTable();
        tableFinal.setEditingRow(-1);
        tableFinal.setEnabled(true);
        tableFinal.setFillsViewportHeight(false);
        tableFinal.setUpdateSelectionOnSort(true);
        tableFinal.putClientProperty("JTable.autoStartsEdit", Boolean.FALSE);
        scrollPane1.setViewportView(tableFinal);
        final JScrollPane scrollPane2 = new JScrollPane();
        PanelMain.add(scrollPane2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(-1, 200), null, 0, false));
        tableSource = new JTable();
        scrollPane2.setViewportView(tableSource);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return PanelMain;
    }

}
