  import java.awt.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.adobe.acrobat.*;
import com.adobe.acrobat.file.ByteArraySource;

public class Lesson extends JPanel {
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Viewer viewer;

	  public Lesson( String filename )
	  {
	    // Set the layout for this panel
	    this.setLayout( new BorderLayout() );

	    // Create the viewer
	    try
	    {
	      viewer = new Viewer();
	      FileInputStream fis = new FileInputStream( filename );
	      viewer.setDocumentInputStream( fis );
	      this.add( viewer, BorderLayout.CENTER );
	      viewer.activate();

	      String page1 = viewer.getTextForPage( 0 );
	      System.out.println( "page1: \n" + page1 );
	    }
	    catch( Exception e )
	    {
	      e.printStackTrace();
	    }
	  }

	  public static void main( String[] args )
	  {
	    if( args.length == 0 )
	    {
	      System.out.println( "Usage: PDFDocument <filename>" );
	      System.exit( 0 );
	    }

	    String filename = args[ 0 ];
	    //PDFDocument pdf = new PDFDocument( filename );

	    // Create our frame
	    JFrame frame = new JFrame( "PDF Viewer" );
	    frame.setSize( 1024, 768 );
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setLocation( d.width/2 - 512, d.height/2 - 384 );
	    //frame.getContentPane().add( pdf );
	    frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	    frame.setVisible( true );
	  }
	}

