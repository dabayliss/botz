package org.dabhand.botz.graphics;

import org.dabhand.botz.game.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Not yet in use, will become a display screen to pop up on victory
 */
public class WinScreen extends JFrame implements ActionListener {
    public WinScreen()
    {

        // create a frame
        JFrame f = new JFrame();
        f.setSize(400,200);

        // create a button
        JButton exit = new JButton("Exit");
        JButton restart= new JButton("Restart(not working)");


        // add action listener
        exit.addActionListener(this);
        restart.addActionListener(this::actionPerformed2);

        // create a panel
        JPanel p1 = new JPanel();

        p1.add(restart);
        p1.add(exit);
        f.add(p1);
        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    public void actionPerformed2(ActionEvent e) {
        System.out.println("tester");
    }
    }

