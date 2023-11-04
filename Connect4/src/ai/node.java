/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

/**
 *
 * @author arafa
 */
public class node {
   private node arr[];
   private int matrix[][];

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
   private int index;

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
   private int lvl;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
   private int color;
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
   private int col;

    public int getEvalfunction() {
        return evalfunction;
    }

    public void setEvalfunction(int evalfunction) {
        this.evalfunction = evalfunction;
    }
   private int evalfunction;
    public node[] getArr() {
        return arr;
    }

    public void setArr(node arr,int i) {
        this.arr[i] = arr;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
   
   public node(int mat[][]){
       matrix=mat;
       arr=new node[7];
       
   }
   
    
}
