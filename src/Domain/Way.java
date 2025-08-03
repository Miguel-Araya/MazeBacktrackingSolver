// Source code recreated by Apache Netbeans (NB Java Decompiler) 
/*
 * Decompiled with CFR 0.152.
 */
package Domain;

import java.awt.Color;

public class Way {
        
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private Color color;

    public Way(int xPosition, int yPosition, int height, int width, Color color) {
        this.height = height;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
