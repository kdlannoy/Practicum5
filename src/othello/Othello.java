/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import javax.swing.JPanel;

/**
 *
 * @author jrvdvyve
 */
public class Othello implements game.GameInterface {
    
    private OthelloPanel panel;
    
    public Othello () {
        panel = new OthelloPanel();
    }

    @Override
    public JPanel getGamePanel() {
        return panel;
    }
    
}
