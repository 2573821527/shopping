package demo;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CardLayoutDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       JFrame frame=new JFrame("welcome to mldn");
       Container cont=frame.getContentPane();
       CardLayout card=new CardLayout();
       frame.setLayout(card);
       cont.add(new JLabel("A",JLabel.CENTER),"first") ;
//       cont.add(new JLabel("a",JLabel.EAST), "first");
//       cont.add(new JLabel("b",JLabel.WEST), "second");
//       cont.add(new JLabel("c",JLabel.SOUTH), "third");
//     cont.add(new JLabel("d",JLabel.NORTH), "fourth");
		cont.add(new JLabel("B",JLabel.CENTER),"second") ;
		cont.add(new JLabel("C",JLabel.CENTER),"third") ;
   	cont.add(new JLabel("D",JLabel.CENTER),"Fourth") ;
       cont.add(new JLabel("e",JLabel.CENTER), "fifth");
      
       frame.setVisible(true);
       frame.pack();
     card.show(cont, "third");
       JButton but=null;
       while(true){
       for(int i=0;i<5;i++){
    	  
    	   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   card.next(cont);
       }
       }
      
//       Runnable run=new Runnable() {
//		
//		@Override
//		public void run() {
//			 int i=0;
//			// TODO Auto-generated method stub
//		       while(true){
//		    	   cont.add(new JButton("°´Å¥"+i));
//		    	  //((cont) cont).next();
//		    	   try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		    	  if(i++>=9){
//		    		  i=0;
//		    		  
//		    	  } 
//		       }
//		}
//	};
//      new Thread(run).start();
	}

}
