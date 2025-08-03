// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Presentation;

import Presentation.Maze;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class GUI
extends JFrame {
    private JButton btnSolve;
    private JButton btnStart;
    private JButton btnReset;
    private JButton btnEnterMaze;
    private JButton btnEnd;
    private JFormattedTextField tfSize;
    private Maze pnlMaze;

    public GUI() {
        this.setExtendedState(6);
        this.setLayout(null);
        this.setTitle("MazeBacktrackingSolver");
        this.add((Component)this.getSolveButton());
        this.add((Component)this.getMazePanel());
        this.add((Component)this.getBtnStart());
        this.add((Component)this.getBtnReset());
        this.add((Component)this.getBtnEnterMaze());
        this.add((Component)this.getBtnEnd());
        try {
            this.add((Component)this.getTfSize());
        }
        catch (ParseException ex) {
            Logger.getLogger((String)GUI.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
        }
        this.setDefaultCloseOperation(3);
        this.getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
    }

    public JButton getSolveButton() {
        if (this.btnSolve == null) {
            this.btnSolve = new JButton("Solve");
            this.btnSolve.setBounds(950, 240, 100, 30);
        }
        return this.btnSolve;
    }

    public JPanel getMazePanel() {
        if (this.pnlMaze == null) {
            this.pnlMaze = new Maze();
        }
        return this.pnlMaze;
    }

    public JButton getBtnStart() {
        if (this.btnStart == null) {
            this.btnStart = new JButton("Start");
            this.btnStart.setBounds(950, 100, 100, 30);
        }
        return this.btnStart;
    }

    public JFormattedTextField getTfSize() throws ParseException {
        if (this.tfSize == null) {
            this.tfSize = new JFormattedTextField((JFormattedTextField.AbstractFormatter)new MaskFormatter("##"));
            this.tfSize.setBounds(950, 190, 60, 30);
        }
        return this.tfSize;
    }

    public JButton getBtnReset() {
        if (this.btnReset == null) {
            this.btnReset = new JButton("Reset");
            this.btnReset.setBounds(950, 300, 100, 30);
        }
        return this.btnReset;
    }

    public JButton getBtnEnterMaze() {
        if (this.btnEnterMaze == null) {
            this.btnEnterMaze = new JButton("Enter Maze");
            this.btnEnterMaze.setBounds(1025, 190, 120, 30);
        }
        return this.btnEnterMaze;
    }

    public JButton getBtnEnd() {
        if (this.btnEnd == null) {
            this.btnEnd = new JButton("End");
            this.btnEnd.setBounds(950, 150, 70, 30);
        }
        return this.btnEnd;
    }

    public Maze getPnlMaze() {
        return this.pnlMaze;
    }
}
