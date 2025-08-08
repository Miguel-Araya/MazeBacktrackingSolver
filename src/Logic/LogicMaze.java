// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Logic;

import Domain.Way;
import Logic.LinkedList;
import Logic.ListException;
import Logic.ThreadMaze;
import Presentation.Maze;
import Enums.PathTypeEnum.PathType;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogicMaze {
    private Maze maze;
    private ThreadMaze threadMaze;

    public LogicMaze(Maze maze) {
        this.maze = maze;
    }

    public void initSolve() {
        
        if(this.threadMaze != null && this.threadMaze.isAlive()){
            return;
        }
        
        for (int i = 0; i < this.maze.getMatrix().length; ++i) {
            for (int j = 0; j < this.maze.getMatrix().length; ++j) {
                if (this.maze.getMatrix()[i][j] != PathType.START.getValue()) continue;
                this.threadMaze = new ThreadMaze(this, i, j);
                this.threadMaze.start();
                return;
            }
        }
    }

    public int solveMaze(int row, int column) {
        if (this.isOutOfBounds(row, column)) {
            return -1;
        }
        if (this.maze.getMatrix()[row][column] == PathType.BLOCK.getValue()) {
            return -1;
        }
        if (this.maze.getMatrix()[row][column] == PathType.END.getValue()) {
            return 0;
        }
        if (this.maze.getMatrix()[row][column] == PathType.VISITED.getValue()) {
            this.maze.getMatrix()[row][column] = PathType.SELECTED.getValue();
            ((Way)this.maze.getWays().get(this.getPositionList(row, column))).setColor(PathType.SELECTED.getColor());
            this.maze.repaint();
            this.stopTime();
            return -1;
        }
        if (this.maze.getMatrix()[row][column] == PathType.SELECTED.getValue()) {
            this.maze.getMatrix()[row][column] = PathType.VISITED.getValue();
            ((Way)this.maze.getWays().get(this.getPositionList(row, column))).setColor(PathType.VISITED.getColor());
            this.maze.repaint();
            this.stopTime();
        }
        LinkedList listMovements = new LinkedList();
        int position = 0;
        int movement = 0;
        if (listMovements.isEmpty()) {
            for (int k = 0; k < 4; ++k) {
                listMovements.add((Object)k);
            }
        }
        while (!listMovements.isEmpty()) {
            position = listMovements.getSize() - 1;
            try {
                movement = this.move(((Integer)listMovements.getByPosition(position)).intValue(), row, column);
            }
            catch (ListException ex) {
                Logger.getLogger((String)LogicMaze.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
            }
            listMovements.delete(position);
            if (movement == -1 && listMovements.isEmpty() && this.maze.getMatrix()[row][column] == PathType.VISITED.getValue()) {
                this.maze.getMatrix()[row][column] = PathType.BLOCK.getValue();
                ((Way)this.maze.getWays().get(this.getPositionList(row, column))).setColor(PathType.BLOCK.getColor());
                this.maze.repaint();
                this.stopTime();
            }
            if (movement != PathType.BLOCK.getValue()) continue;
            return PathType.BLOCK.getValue();
        }
        return -1;
    }

    public int move(int direction, int row, int column) {
        switch (direction) {
            case 0: {
                if (!this.isOutOfBounds(row, column - 1) && this.maze.getMatrix()[row][column - 1] != PathType.VISITED.getValue() && this.maze.getMatrix()[row][column - 1] != PathType.START.getValue()) {
                    return this.solveMaze(row, column - 1);
                }
                break;
            }
            case 1: {
                if (!this.isOutOfBounds(row, column + 1) && this.maze.getMatrix()[row][column + 1] != PathType.VISITED.getValue() && this.maze.getMatrix()[row][column + 1] != PathType.START.getValue()) {
                    return this.solveMaze(row, column + 1);
                }
                break;
            }
            case 2: {
                if (!this.isOutOfBounds(row + 1, column) && this.maze.getMatrix()[row + 1][column] != PathType.VISITED.getValue() && this.maze.getMatrix()[row + 1][column] != PathType.START.getValue()) {
                    return this.solveMaze(row + 1, column);
                }
                break;
            }
            case 3: {
                if (this.isOutOfBounds(row - 1, column) || this.maze.getMatrix()[row - 1][column] == PathType.VISITED.getValue() || this.maze.getMatrix()[row - 1][column] == PathType.START.getValue()) break;
                return this.solveMaze(row - 1, column);
            }
        }
        return -1;
    }

    public boolean isOutOfBounds(int i, int j) {
        return i < 0 || j < 0 || i >= this.maze.getMatrix().length || j >= this.maze.getMatrix().length;
    }

    public void stopTime() {
        try {
            Thread.sleep((long)500L);
        }
        catch (InterruptedException ex) {
            Logger.getLogger((String)LogicMaze.class.getName()).log(Level.SEVERE, null, (Throwable)ex);
        }
    }

    public int getPositionList(int row, int column) {
        int positionList = row * this.maze.getMatrix().length + column;
        return positionList;
    }

    public void resetMaze() {
        for (int i = 0; i < this.maze.getMatrix().length; ++i) {
            for (int j = 0; j < this.maze.getMatrix().length; ++j) {
                if (this.maze.getMatrix()[i][j] != PathType.VISITED.getValue()) continue;
                ((Way)this.maze.getWays().get(this.getPositionList(i, j))).setColor(PathType.SELECTED.getColor());
                this.maze.getMatrix()[i][j] = PathType.SELECTED.getValue();
            }
        }
        
        this.maze.repaint();
        
    }
}
