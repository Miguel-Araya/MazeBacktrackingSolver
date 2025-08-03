// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Presentation;

import Domain.Way;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import Enums.PathTypeEnum.PathType;

public class Maze
extends JPanel
implements MouseListener {
    private int heightMaze;
    private int widthMaze;
    private int sizeMaze;
    private int[][] matrix;
    private boolean start;
    private boolean end;
    private ArrayList<Way> ways;

    public Maze() {
        this.setBackground(Color.GRAY);
        this.addMouseListener((MouseListener)this);
        this.setBounds(270, 30, 640, 640);
        this.matrix = new int[0][0];
        this.ways = new ArrayList();
    }
    
    public void insertMaze(int sizeMaze) {
        this.start = false;
        this.end = false;
        this.ways = new ArrayList();
        this.sizeMaze = sizeMaze;
        this.heightMaze = this.getHeightMaze();
        this.widthMaze = this.getWidthMaze();
        this.matrix = new int[sizeMaze][sizeMaze];
        this.initWays();
        this.repaint();
    }

    private void initWays() {
        for (int y = 0; y < this.sizeMaze * this.widthMaze; y += this.widthMaze) {
            for (int x = 0; x < this.sizeMaze * this.heightMaze; x += this.heightMaze) {
                this.ways.add((Way)(Object)new Way(x, y, this.heightMaze - 1, this.widthMaze - 1, PathType.BLOCK.getColor()));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < this.ways.size(); ++i) {
            g.setColor(((Way)this.ways.get(i)).getColor());
            g.fillRect(((Way)this.ways.get(i)).getxPosition(), ((Way)this.ways.get(i)).getyPosition(), ((Way)this.ways.get(i)).getHeight(), ((Way)this.ways.get(i)).getWidth());
        }
    }

    public int getHeightMaze() {
        int heightWay = this.getHeight() / this.sizeMaze;
        return heightWay;
    }

    public int getWidthMaze() {
        int widthWay = this.getWidth() / this.sizeMaze;
        return widthWay;
    }

    public int getPositionList(int xMouse, int yMouse) {
        int positionList = 0;
        block0: for (int y = 0; y < this.sizeMaze * this.widthMaze; y += this.widthMaze) {
            for (int x = 0; x < this.sizeMaze * this.heightMaze; x += this.heightMaze) {
                if (xMouse <= x + this.heightMaze && xMouse >= x && yMouse <= y + this.widthMaze && yMouse >= y) break block0;
                ++positionList;
            }
        }
        if (positionList < this.ways.size()) {
            return positionList;
        }
        return -1;
    }

    public void setStart(boolean value) {
        this.start = value;
    }

    public void setEnd(boolean value) {
        this.end = value;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public ArrayList<Way> getWays() {
        return this.ways;
    }

    public void putWay(int positionList) {
        int i = positionList / this.sizeMaze;
        int j = positionList - this.sizeMaze * i;
        if (this.start && this.matrix[i][j] != PathType.SELECTED.getValue() && this.matrix[i][j] != PathType.END.getValue()) {
            ((Way)this.ways.get(positionList)).setColor(PathType.START.getColor());
            this.matrix[i][j] = PathType.START.getValue();
            this.start = false;
        } else if (this.end && this.matrix[i][j] != PathType.START.getValue() && this.matrix[i][j] != PathType.SELECTED.getValue()) {
            ((Way)this.ways.get(positionList)).setColor(PathType.END.getColor());
            this.matrix[i][j] = PathType.END.getValue();
            this.end = false;
        } else if (this.matrix[i][j] != PathType.START.getValue() && this.matrix[i][j] != PathType.END.getValue()) {
            ((Way)this.ways.get(positionList)).setColor(PathType.SELECTED.getColor());
            this.matrix[i][j] = PathType.SELECTED.getValue();
        }
    }

    public void printMatrix() {
        String content = "";
        for (int i = 0; i < this.sizeMaze; ++i) {
            for (int j = 0; j < this.sizeMaze; ++j) {
                content = content + "" + this.matrix[i][j];
            }
            content = content + "\n";
        }
        System.out.println(content);
    }
    
    private void addPath(MouseEvent me){
    
        int yMouse;
        int xMouse = me.getX();
        int positionList = this.getPositionList(xMouse, yMouse = me.getY());
        if (positionList != -1) {
            this.putWay(positionList);
            this.repaint();
        }
    
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
        addPath(me);
        
    }

    public void mousePressed(MouseEvent me) {

        addPath(me);
        
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }
}
