/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai;

import java.awt.Container;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author arafa
 */
public class OurThread implements Runnable{
    private boolean running=false;
	private ImageIcon empty;
	private ImageIcon colored;
	private int addedr;
	private int row;
	private int co;
        
	private JButton button;
	private Container c;
        private JButton bb[];

	private int colum;

	public OurThread() {
		  
	        
	   
	 }
	    
	public void start() {
		Thread thread=new Thread(this);
		thread.start();
		running =true;
	}  
	public void stop() {
		running=false;
	}
	public void add(ImageIcon i1,ImageIcon i2, int addedRow, int rows, int col, Container cp, int columns,JButton b[]) {
                bb=b;
		empty=i1;
		colored=i2;
		addedr=addedRow;
		row=rows;
		co=col;
		c=cp;
		colum=columns;
	}
	      
	

	@Override
	public void run() {
		while(running) {
			for(int i=0;i<=addedr;i++) {
				//JOptionPane.showMessageDialog(null, i);
			//button=((JButton)(c.getComponent( i*7 + co)));
                        button=bb[i*7+co];
			button.setIcon(colored);
			if(i!=0) {
                            
				//button=((JButton)(c.getComponent(  (i-1)*7 + co)));
                                    button=bb[(i-1)*7 + co];
				button.setIcon(empty);
			}
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			break;
			
		}
			
	}

}
