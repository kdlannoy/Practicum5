/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JPanel;

/**
 *
 * @author jrvdvyve
 */
public class OthelloPiece extends JPanel implements Serializable {

    private int state;

    public OthelloPiece() {
        setPreferredSize(new Dimension(50, 50));
        setMinimumSize(new Dimension(50, 50));
        synchronized (this) {
            state = 0;
        }
        this.addMouseListener(new MouseAdapter() {
            
        
            @Override
            public void mousePressed(MouseEvent e) {
                switch (state) {
                    case -1:
                        synchronized (this) {
                            state = 1;
                        }
                        firePropertyChange("state", -1, 1);
                        break;
                    case 0:
                        firePropertyChange("state", 0, -1);
                        synchronized (this) {
                            state = -1;
                        }
                        break;
                    case 1:
                        firePropertyChange("state", 1, 0);
                        synchronized (this) {
                            state = 0;
                        }
                        break;
                }
                repaint();
            }
        });
    }

    public synchronized int getState() {
        return state;
    }

    public synchronized void setState(int state) {
        this.state = state;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 50, 50);
        switch (state) {
            case -1:
                g.setColor(Color.black);
                break;
            case 0:
                return;
            case 1:
                g.setColor(Color.white);
                break;
        }
        g.fillOval(0, 0, 50, 50);
    }
}
