// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Business;

import Logic.LogicMaze;
import Presentation.GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controller
implements ActionListener {
    private GUI gui = new GUI();
    private LogicMaze logicMaze = new LogicMaze(this.gui.getPnlMaze());

    public Controller() {
        this.init();
    }

    private void init() {
        this.gui.getBtnEnterMaze().addActionListener((ActionListener)this);
        this.gui.getBtnReset().addActionListener((ActionListener)this);
        this.gui.getBtnStart().addActionListener((ActionListener)this);
        this.gui.getBtnEnd().addActionListener((ActionListener)this);
        this.gui.getSolveButton().addActionListener((ActionListener)this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.gui.getBtnStart()) {
            this.gui.getPnlMaze().setStart(true);
            this.gui.getBtnStart().setEnabled(false);
        }
        if (ae.getSource() == this.gui.getBtnEnd()) {
            this.gui.getPnlMaze().setEnd(true);
            this.gui.getBtnEnd().setEnabled(false);
        }
        if (ae.getSource() == this.gui.getBtnEnterMaze()) {
            try {
                if (this.gui.getTfSize().isEditValid()) {
                    int size = Integer.parseInt((String)this.gui.getTfSize().getText());
                    if (size > 0) {
                        this.gui.getPnlMaze().insertMaze(size);
                    } else {
                        JOptionPane.showMessageDialog(null, (Object)"Insert a number greater than zero");
                    }
                    if (!this.gui.getBtnEnd().isEnabled()) {
                        this.gui.getBtnEnd().setEnabled(true);
                    }
                    if (!this.gui.getBtnStart().isEnabled()) {
                        this.gui.getBtnStart().setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, (Object)"Please enter a number of two digits:\n\nExample: 01, 02, 15, 99");
                }
            }
            catch (ParseException ex) {
                Logger.getLogger((String)Controller.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
            }
        }
        if (ae.getSource() == this.gui.getSolveButton()) {
            this.logicMaze.initSolve();
        }
        if (ae.getSource() == this.gui.getBtnReset()) {
            this.logicMaze.resetMaze();
        }
    }
}
