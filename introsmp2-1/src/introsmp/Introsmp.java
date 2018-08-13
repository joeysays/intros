/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introsmp;

/**
 *
 * @author Belle
 */
public class Introsmp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Frame f = new Frame();
        ControlFrame cf = new ControlFrame();
        cf.setVisible(true);
//      TestFrame tf = new TestFrame();
//      tf.setVisible(true);
        
        System.out.println("Intializing Simulation with Locks");
        Controller c = new Controller();
        
        //f.setVisible(true);
    }
    
}
