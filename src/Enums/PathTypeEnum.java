/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

import java.awt.Color;

/**
 *
 * @author Miguel
 */
public class PathTypeEnum {
    
        public enum PathType {
        
        SELECTED(1, Color.WHITE)
        ,START(2, Color.RED)
        ,END(3, Color.GREEN)
        ,VISITED(4, Color.YELLOW)
        ,BLOCK(0, Color.BLACK);       
       
        private final int value;
        private final Color color;
        
        PathType(int value, Color color){
            this.value = value;
            this.color = color;
        }
        
        public int getValue(){
        
            return this.value;
            
        }
        
        public Color getColor(){
        
            return this.color;
        }
    
    }
    
}
