// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Logic;

import Logic.LogicMaze;
import javax.swing.JOptionPane;

public class ThreadMaze
extends Thread {
    private int row;
    private int column;
    private LogicMaze logicMaze;

    public ThreadMaze(LogicMaze logicMaze, int row, int column) {
        this.logicMaze = logicMaze;
        this.row = row;
        this.column = column;
    }

    public void run() {

        int solve = this.logicMaze.solveMaze(this.row, this.column);

        if (solve != 0) {
            JOptionPane.showMessageDialog(null, (Object)("The maze cannot be solved.Possible reasons: 1. It has already been solved. 2. No valid path to the exit was found."));
        } else {
            JOptionPane.showMessageDialog(null, (Object)("The path has been revealed!"));
        }
    }
}
