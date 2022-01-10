package edu.vsu.ru.project;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.util.Locale;

public class GUI_Main {
    public static void winMain() throws Exception {
        SwingUtils.setLookAndFeelByName("Window");
        Locale.setDefault(Locale.ROOT);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        winMain();
    }
}