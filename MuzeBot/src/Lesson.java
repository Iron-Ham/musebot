  import java.awt.*;

import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.Serializable;

import javax.imageio.*;;

public class Lesson extends JPanel {
	
	  
	  
	private static final long serialVersionUID = 1L;
    private Image image;
    private JPanel pane;

    public Lesson() {
        try {
            this.image = ImageIO.read(new File("Lesson 1.jpg"));
            
            image = image.getScaledInstance(1240, 1616, Image.SCALE_SMOOTH);
        	
        }catch(IOException ex) {
           System.out.println("No file!");
        }

        this.pane = new JPanel() {
          
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
       
        pane.setPreferredSize(new Dimension(image.getWidth(pane), image.getHeight(pane)));
        JScrollPane sp = new JScrollPane(pane);
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        
        
        pane.add(new JButton("Previous Lesson"));
        pane.add(new JButton("Next Lesson"));
    }

	  }
	

