/*
 * Authors: Harold Pham and Kevin Xu
 * File Detail: This main class will facilitate JFrame mechanics and file reading.
 * Creation date: 9/2/2020
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class GeographyMain 
{
	private static ArrayList<String> Africa;
	private static ArrayList<String> Europe;
	private static ArrayList<String> NorthAmerica;
	private static ArrayList<String> SouthAmerica;
	private static ArrayList<String> Australia;
	private static ArrayList<String> Asia;
	private static Scanner scan;
	private static JFrame frame;

	private static Dimension screenRes = Toolkit.getDefaultToolkit().getScreenSize();
	private static int halfHeight = screenRes.height/2;
	private static int halfWidth = screenRes.width/2;

	
	public static void main(String[] args) 
	{
		//Import the files into the ArrayLists
		processFile("Africa");
		processFile("Europe");
		processFile("Asia");
		processFile("NorthAmerica");
		processFile("SouthAmerica");
		processFile("Australia");
		
		//Start window process
		createTitleScreen();
	}
	
	//Will process the ArrayLists for each continent
	public static void processFile(String name)
	{
		  if (name == "Africa") //Africa
		  {
			  Africa = new ArrayList<String>();
			  try 
			  {
				 File inFile = new File("Africa.txt");
				 scan = new Scanner (inFile);
				 while(scan.hasNextLine()) 
				 {
					 Africa.add(scan.nextLine());
				 }
				 
			  } 
			  catch (Exception ex) 
			  {
				 System.out.println("Error found in input file.");
			  }
		  }
		  else if (name == "Europe") //Europe
		  {
			  Europe = new ArrayList<String>();
			  try 
			  {
				 File inFile = new File("Europe.txt");
				 scan = new Scanner (inFile);
				 while(scan.hasNextLine()) 
				 {
					 Europe.add(scan.nextLine());
				 }
				 
			  } 
			  catch (Exception ex) 
			  {
				 System.out.println("Error found in input file.");
			  }
		  }
		  else if (name == "NorthAmerica") //North America
		  {
			  NorthAmerica = new ArrayList<String>();
			  try 
			  {
				 File inFile = new File("NorthAmerica.txt");
				 scan = new Scanner (inFile);
				 while(scan.hasNextLine()) 
				 {
					 NorthAmerica.add(scan.nextLine());
				 }
				 
			  } 
			  catch (Exception ex) 
			  {
				 System.out.println("Error found in input file.");
			  }
		  }
		  else if (name == "SouthAmerica") //South America
		  {
			  SouthAmerica = new ArrayList<String>();
			  try 
			  {
				 File inFile = new File("SouthAmerica.txt");
				 scan = new Scanner (inFile);
				 while(scan.hasNextLine()) 
				 {
					 SouthAmerica.add(scan.nextLine());
				 }
				 
			  } 
			  catch (Exception ex) 
			  {
				 System.out.println("Error found in input file.");
			  }
		  }
		  else if (name == "Asia") //Asia
		  {
			  Asia = new ArrayList<String>();
			  try 
			  {
				 File inFile = new File("Asia.txt");
				 scan = new Scanner (inFile);
				 while(scan.hasNextLine()) 
				 {
					 Asia.add(scan.nextLine());
				 }
				 
			  } 
			  catch (Exception ex) 
			  {
				 System.out.println("Error found in input file.");
			  }
		  }
		  else if (name == "Australia") //Australia
		  {
			  Australia = new ArrayList<String>();
			  try 
			  {
				  File inFile = new File("Australia.txt");
				  scan = new Scanner (inFile);
				  while(scan.hasNextLine()) 
				  {
					  Australia.add(scan.nextLine());
				  }
				 
			  } 
			  catch (Exception ex) 
			  {
				  System.out.println("Error found in input file.");
			  }
		  }
		  else
		  {
		  	System.out.println("That is not a valid option. Please refresh and try again.");
		  }
	}
	
	//Window Construction
	public static void createTitleScreen()
	{
		//JFrame setup
		frame = new JFrame("Geography Name Game"); //Create the frame
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("GNG Logo.jpg"));
		
		frame.setLocation(halfWidth-375, halfHeight-175); //Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Make it closable
		frame.setResizable(false); //No resizing
		frame.setAlwaysOnTop(true); //Keep it above other windows for programming purposes
		frame.setVisible(true); //Visibility

		//Create the title 
		JLabel title = new JLabel("Welcome to the Geography Game!");
		title.setFont(new Font("Arial", Font.PLAIN, 48));
		JPanel titleP = new JPanel();
		titleP.add(title);
		
		frame.getContentPane().add(titleP,SwingConstants.CENTER);
		frame.pack();
		
		
		//Set up the buttons panel
        JPanel p = new JPanel();
        p.setLayout(new SpringLayout());
        
        Icon ma = new ImageIcon("marathon.png");
        Icon ti = new ImageIcon("timed.png");
        Icon qu = new ImageIcon("quiz.png");
        
        //Set up each button
        JButton m = new JButton("Marathon");
        m.setPreferredSize(new Dimension(100,75));
//        m.setIcon(ma);
        
        JButton t = new JButton("Timed");
        t.setPreferredSize(new Dimension(100,75));
//        t.setIcon(ti);
        
        JButton q = new JButton("Quiz");
        q.setPreferredSize(new Dimension(100,75));
//       q.setIcon(qu);
          
        //Add the buttons to the panel
        p.add(m);
        p.add(t);
        p.add(q);

        //Use layout manager to set out the pattern
        SpringUtilities.makeCompactGrid(p, 1,
                                        p.getComponentCount(),
                                        100,              115,           117,          100);
//        			      			   LeftPad           TopPad       BetweenPad    BottomPad
        
	    //add the panel to the frame.
		frame.getContentPane().add(p); //Add the pane to the window so that it will show
		frame.pack(); //Pack them into that resolution screen
		
		
		//Button Functions
		m.addActionListener(new ActionListener() //Button click listener for marathon
		{
			//Everything in this method will be run when the button is clicked.
		    public void actionPerformed(ActionEvent e)  
			{
		    	//clean the frame and continue.
			     title.setVisible(false);
			     p.setVisible(false);
			     continents();
			}
		}
				   );   
		
		
		t.addActionListener(new ActionListener() //Button click listener for timed
		{
			//Everything in this method will be run when the button is clicked.
		    public void actionPerformed(ActionEvent e)  
			{
		    	//clean the frame and continue.
			     title.setVisible(false);
			     p.setVisible(false);
			     timed();
			}
		}
				   );
		
		
		q.addActionListener(new ActionListener() //Button click listener for quiz
		{
			//Everything in this method will be run when the button is clicked.
		    public void actionPerformed(ActionEvent e)  
			{
		    	//clean the frame and continue.
			     title.setVisible(false);
			     p.setVisible(false);
			     quiz();
			}
		}
				   );
						
	}

		//Start the marathon game process
	public static void marathon(String continent)
	{
		frame.setLocation(halfWidth-375, halfHeight-325);
		Container p = frame.getContentPane();
	//	p.setPreferredSize(new Dimension(600,800));
		
		JLabel title = new JLabel("Name as many countries you can from " + continent, SwingConstants.CENTER);
		
		title.setPreferredSize(new Dimension(800,150));
		p.add(title, BorderLayout.PAGE_START);
		title.setFont(new Font("Arial", Font.PLAIN, 18));
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel countries = new JLabel("TESTING: History of user inputs stored and shown here.", SwingConstants.LEFT);
		countries.setPreferredSize(new Dimension(800,200));
		p.add(countries, BorderLayout.CENTER);
		countries.setVerticalAlignment(SwingConstants.TOP);
		
		JTextArea uInput = new JTextArea();
		uInput.setPreferredSize(new Dimension(800,100));
		p.add(uInput, BorderLayout.PAGE_END);
		uInput.setBorder(BorderFactory.createLineBorder(Color.black));
		
		frame.pack();
		p.setVisible(true);
	}
	
	//Start the timed game process
	public static void timed()
	{
		JPanel p = new JPanel();
		JTextField uInput = new JTextField();
		
	}
	
	//Start the quiz game process
	public static void quiz()
	{
		JPanel p = new JPanel();
		JTextField uInput = new JTextField();
		
	}
	

	public static void continents()
	{
		frame.setLocation(halfWidth-630,halfHeight-150);
		GridLayout g = new GridLayout(1, 		0, 			0, 			0);
									//rows	  columns      xPad       yPad
		
		//Setup the panel
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(1250, 200));
		p.setLayout(g);
		
		//Create the components
		JLabel title = new JLabel("Choose a Continent: ", SwingConstants.CENTER);
		JButton aus = new JButton("Australia (Easiest)");
		JButton sa = new JButton("South America");
		JButton na = new JButton("North America ");
		JButton eu = new JButton("Europe");
		JButton asia = new JButton("Asia");
		JButton africa = new JButton("Africa (Hardest)");
		
		title.setFont(new Font("Arial", Font.PLAIN, 18));
		
		//Add the components
		p.add(title);
		p.add(aus);
		p.add(sa);
		p.add(na);
		p.add(eu);
		p.add(asia);
		p.add(africa);
		
		p.setVisible(true);
		frame.add(p);
		frame.pack();
		
		
		//Give the components meaning
		aus.addActionListener(new ActionListener() //Button click listener for aus
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("Australia");
					}
				}
						   );
		
		sa.addActionListener(new ActionListener() //Button click listener for sa
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("South America");
					}
				}
						   );
		
		africa.addActionListener(new ActionListener() //Button click listener for africa
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("Africa");
					}
				}
						   );
		
		asia.addActionListener(new ActionListener() //Button click listener for asia
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("Asia");
					}
				}
						   );
		
		eu.addActionListener(new ActionListener() //Button click listener for eu
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("Europe");
					}
				}
						   );
		
		na.addActionListener(new ActionListener() //Button click listener for na
				{
					//Everything in this method will be run when the button is clicked.
				    public void actionPerformed(ActionEvent e)  
					{
				    	p.setVisible(false);
				    	marathon("North America");
					}
				}
						   );
						   
		
	}
	
	public long currentTimeMillis() 
	{
			      return System.currentTimeMillis();
	}
	
}
	

/*	
 * public static void answer (String answer, List<String> inputArray){
 * 		ArrayList<String> copy = inputArray.copy(); 	
 * 		int num = inputArray.length();			
 * do {	
 * 		if (answer == "" || answer == "" || etc.){	
 * 			System.out.println ("Correct Answer. Please input another answer:");
 * 			AustraliaCopy.remove(answer);	
 * 			num--;	
 * 		} else{	
 * 			System.out.println("Incorrect. Please try again.")		
 * 		}	
 * 		} while (num > 0);	
 * }	
 */
class RoundButton extends JButton {
  public RoundButton() {
    this(null, null);
  }
  public RoundButton(Icon icon) {
    this(null, icon);
  }
  public RoundButton(String text) {
    this(text, null);
  }
  public RoundButton(Action a) {
    this();
    setAction(a);
  }
  public RoundButton(String text, Icon icon) {
    setModel(new DefaultButtonModel());
    init(text, icon);
    if(icon==null) {
      return;
    }
    setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
    setBackground(Color.BLACK);
    setContentAreaFilled(false);
    setFocusPainted(false);
    //setVerticalAlignment(SwingConstants.TOP);
    setAlignmentY(Component.TOP_ALIGNMENT);
    initShape();
  }
  protected Shape shape, base;
  protected void initShape() {
    if(!getBounds().equals(base)) {
      Dimension s = getPreferredSize();
      base = getBounds();
      shape = new Ellipse2D.Float(0, 0, s.width-1, s.height-1);
    }
  }
  @Override public Dimension getPreferredSize() {
    Icon icon = getIcon();
    Insets i = getInsets();
    int iw = Math.max(icon.getIconWidth(), icon.getIconHeight());
    return new Dimension(iw+i.right+i.left, iw+i.top+i.bottom);
  }
  @Override protected void paintBorder(Graphics g) {
    initShape();
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setColor(getBackground());
    //g2.setStroke(new BasicStroke(1.0f));
    g2.draw(shape);
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_OFF);
  }
  @Override public boolean contains(int x, int y) {
    initShape();
    return shape.contains(x, y);
    //or return super.contains(x, y) && ((image.getRGB(x, y) >> 24) & 0xff) > 0;
  }
}
*/
