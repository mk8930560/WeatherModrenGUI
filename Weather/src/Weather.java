
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Weather extends JDialog {
	
	static JLabel daytwo;
	static JPanel p1;
	static JLabel l1;
	static JPanel temp;
	static JLabel num;
	static JLabel digre;
	static JLabel type;
	static JLabel today;
	static JLabel todaytemp;
	static JLabel todaymin;
	static JLabel todaymax;
	static JLabel cityname;
	static JPanel Info;
	static JPanel Info1;
	static JPanel Info2;
	static JPanel Info3;
	static JLabel humidity;
	static JLabel humidityvalue;
	static JLabel Windspeed;
	static JLabel Windspeedvalue;
	static JLabel pressure;
	static JLabel pressurevalue;
	static JLabel visibility;
	static JLabel visibilityvalue;
	static JTextField search;
	static JButton searchbutton;
	static JButton b1;
	static JPanel p2;
	static JLabel daytwoico;
	static JLabel daytwominmax;
	static JPanel p3;
	static JLabel daythree;
	static JLabel daythreeico;
	static JLabel daythreeminmax;
	static JPanel p4;
	static JLabel dayfour;
	static JLabel dayfourico;
	static JLabel dayfourminmax;
	static JPanel p5;
	static JLabel dayfive;
	static JLabel dayfiveico;
	static JLabel dayfiveminmax;
	static JPanel p6;
	static JLabel daySix;
	static JLabel daysixico;
	static JLabel daysixminmax;
	static JPanel p7;
	static JLabel daySeven;
	static JLabel daysevenico;
	static JLabel daysevenminmax;
	static JTextPane daytwoweather;
	static JTextPane daythreeweather;
	static JTextPane dayfourweather;
	static JTextPane dayfiveweather;
	static JTextPane daysixweather;
	static JTextPane daysevenweather;
	private JLabel Drag;
	int mousepx,mousepy;
	public static int RoundOf(Object object) //This is for RoundOff the temperature values
	{
		int value=0;
		Class c = object.getClass(); 
        if(c.getName().equals("java.lang.Double"))
        {
        	double letroundOff=Math.round((double) object);
    		value=(int)letroundOff;
    		
        }
        if(c.getName().equals("java.lang.Long"))
        {
    		value=(int) (long) object;
        }
        if(c.getName().equals("java.lang.Integer"))
        {
        	value=(int)object;
        }
        return value;
	}
	
	public static String Dayname(Object object) //This id for finding Dayname like:Mon,Tue
	{
		java.util.Date time=new java.util.Date((long)object*1000);
		DateFormat df = new SimpleDateFormat("EE");
    	String dayname = df.format(time);
    	return dayname;
	}
	
	public static String Info(Object object) //This is for print info of like pressure,windspeed,humidity,etc
	{
		String value="";
		Class c = object.getClass();
		if(c.getName().equals("java.lang.Double"))
		{
			double value1=(double)object;
			value=Double.toString(value1);
		}
		if(c.getName().equals("java.lang.Float"))
		{
			float value1=(float)object;
			value=Float.toString(value1);
		}
		if(c.getName().equals("java.lang.Long"))
		{
			int value1=(int) (long) object;
			value=Integer.toString(value1);
		}
		if(c.getName().equals("java.lang.Integer"))
		{
			int value1=(int)object;
			value=Integer.toString(value1);
		}
		return value;
	}
	
	public static String Image(Object object) //This is for Main panel images change according weather
	{
		String value="";
		String value1=(String) object;
		if(value1.equals("Rain"))
		{
			value="Rain.jpg";
		}
		else if(value1.equals("Thunderstorm"))
		{
			value="Thunderstorm.jpg";
		}
		else if(value1.equals("Drizzle"))
		{
			value="Drizzle.jpg";
		}
		else if(value1.equals("Snow"))
		{
			value="Snow.jpg";
		}
		else if(value1.equals("Clear"))
		{
			value="Clear.jpg";
		}
		else if(value1.equals("Clouds"))
		{
			value="Clouds.png";
		}
		else if(value1.equals("Mist")||value1.equals("Smoke")||value1.equals("Haze")||value1.equals("Dust")||value1.equals("Fog")||value1.equals("Sand")||value1.equals("Dust")||value1.equals("Ash")||value1.equals("Squall")||value1.equals("Tornado"))
		{
			value="Haze.jpg";
		}
		return value;
	}
	public static String Weatherico(Object object) //This is for showing nextSix dya weather ico 
	{
		String value="";
		String value1=(String) object;
		if(value1.equals("sky is clear"))
		{
			value="clear.png";
		}
		else if(value1.equals("few clouds"))
		{
			value="02d.png";
		}
		else if(value1.equals("broken clouds")||value1.equals("overcast clouds"))
		{
			value="04d.png";
		}
		else if(value1.equals("scattered clouds"))
		{
			value="03d.png";
		}
		else if(value1.equals("light intensity drizzle")||value1.equals("drizzle")||value1.equals("heavy intensity drizzle")||value1.equals("light intensity drizzle rain")||value1.equals("drizzle rain")||value1.equals("heavy intensity drizzle rain")||value1.equals("shower rain and drizzle")||value1.equals("heavy shower rain and drizzle")||value1.equals("shower drizzle")||value1.equals("light intensity shower rain")||value1.equals("shower rain")||value1.equals("heavy intensity shower rain")||value1.equals("ragged shower rain"))
		{
			value="09d.png";
		}
		else if(value1.equals("mist")||value1.equals("Smoke")||value1.equals("Haze")||value1.equals("fog")||value1.equals("sand")||value1.equals("dust")||value1.equals("volcanic ash")||value1.equals("squalls")||value1.equals("tornado")||value1.equals("sand/ dust whirls"))
		{
			value="50d.png";
		}
		else if(value1.equals("light snow")||value1.equals("freezing rain")||value1.equals("Snow")||value1.equals("Heavy snow")||value1.equals("Sleet")||value1.equals("Light shower sleet")||value1.equals("Shower sleet")||value1.equals("Light rain and snow")||value1.equals("Rain and snow")||value1.equals("Light shower snow")||value1.equals("Shower snow")||value1.equals("Heavy shower snow"))
		{
			value="13d.png";
		}
		else if(value1.equals("thunderstorm with light rain")||value1.equals("thunderstorm with rain")||value1.equals("thunderstorm with heavy rain")||value1.equals("light thunderstorm")||value1.equals("thunderstorm")||value1.equals("heavy thunderstorm")||value1.equals("ragged thunderstorm")||value1.equals("thunderstorm with light drizzle")||value1.equals("thunderstorm with drizzle")||value1.equals("thunderstorm with heavy drizzle"))
		{
			value="11d.png";
		}
		else if(value1.equals("light rain")||value1.equals("moderate rain")||value1.equals("heavy intensity rain")||value1.equals("very heavy rain")||value1.equals("extreme rain"))
		{
			value="10d.png";
		}
		
		return value;
	}
	
	private AttributeSet SimpleAttributeSet() //This is for printing nextSix day weather type
	{
		SimpleAttributeSet atr=new SimpleAttributeSet();
		StyleConstants.setAlignment(atr, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontSize(atr,17);
		StyleConstants.setForeground(atr, Color.white);
		StyleConstants.setFontFamily(atr,"SANS_SERIF");
		return atr;
	}
	
	public Weather() {
		setUndecorated(true);
		setBounds(100, 100, 1000, 500);
		getContentPane().setLayout(null);
		
		p1 = new JPanel();
		p1.setBounds(0, 0, 1000, 500);
		getContentPane().add(p1);
		p1.setLayout(null);
		
		l1 = new JLabel("");
		l1.setBounds(0, 0, 1000, 500);
		l1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Main_panel/Clear.jpg")).getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH)));
		p1.add(l1);
		
		temp = new JPanel();
		temp.setOpaque(false);
		temp.setBounds(70, 70, 200, 170);
		temp.setBackground(new Color(0,0,0,0));
		l1.add(temp);
		temp.setLayout(null);
		
		num=new JLabel("30");
		num.setForeground(Color.white);
		num.setFont(new Font("SANS_SERIF",Font.PLAIN,79));
		num.setBounds(0, 0, 100, 80);
		temp.add(num);
		
		digre=new JLabel("\u00B0");
		digre.setForeground(Color.white);
		digre.setFont(new Font("SANS_SERIF",Font.PLAIN,40));
		digre.setBounds(100, 0, 30, 40);
		temp.add(digre);
		
		type=new JLabel("C");
		type.setForeground(Color.white);
		type.setFont(new Font("SANS_SERIF",Font.PLAIN,79));
		type.setBounds(130, 0, 70, 80);
		temp.add(type);
		
		today=new JLabel("Monday 16TH");
		today.setForeground(Color.white);
		today.setFont(new Font("SANS_SERIF",Font.PLAIN,18));
		today.setBounds(0, 80, 200, 30);
		temp.add(today);
		
		todaytemp=new JLabel("Mist");
		todaytemp.setForeground(Color.white);
		todaytemp.setFont(new Font("SANS_SERIF",Font.PLAIN,18));
		todaytemp.setBounds(0, 110, 200, 30);
		temp.add(todaytemp);
		
		todaymin=new JLabel("16\u00B0");
		todaymin.setForeground(Color.white);
		todaymin.setFont(new Font("SANS_SERIF",Font.PLAIN,18));
		todaymin.setBounds(0, 140, 70, 30);
		temp.add(todaymin);
		
		todaymax=new JLabel("32\u00B0");
		todaymax.setForeground(Color.white);
		todaymax.setFont(new Font("SANS_SERIF",Font.PLAIN,18));
		todaymax.setBounds(70, 140, 130, 30);
		temp.add(todaymax);
		
		cityname=new JLabel("Palwal,In");
		cityname.setForeground(Color.white);
		cityname.setFont(new Font("SANS_SERIF",Font.PLAIN,22));
		cityname.setBounds(400, 20, 200, 30);
		cityname.setHorizontalAlignment(SwingConstants.CENTER);
		l1.add(cityname);
		
		Info = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Info.setOpaque(false);
		Info.setBounds(750, 70, 160, 50);
		Info.setBackground(new Color(0,0,0,80));
		l1.add(Info);
		Info.setLayout(null);
		
		humidity=new JLabel("Humidity");
		humidity.setForeground(Color.white);
		humidity.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		humidity.setBounds(0, 0, 160, 22);
		humidity.setHorizontalAlignment(SwingConstants.CENTER);
		Info.add(humidity);
		
		humidityvalue=new JLabel("99%");
		humidityvalue.setForeground(Color.white);
		humidityvalue.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		humidityvalue.setBounds(0, 22, 160, 28);
		humidityvalue.setHorizontalAlignment(SwingConstants.CENTER);
		Info.add(humidityvalue);
		
		Info1 = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Info1.setOpaque(false);
		Info1.setBounds(800, 123, 160, 50);
		Info1.setBackground(new Color(0,0,0,80));
		l1.add(Info1);
		Info1.setLayout(null);
		
		Windspeed=new JLabel("Wind Speed");
		Windspeed.setForeground(Color.white);
		Windspeed.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		Windspeed.setBounds(0, 0, 160, 22);
		Windspeed.setHorizontalAlignment(SwingConstants.CENTER);
		Info1.add(Windspeed);
		
		Windspeedvalue=new JLabel("1.5km/h");
		Windspeedvalue.setForeground(Color.white);
		Windspeedvalue.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		Windspeedvalue.setBounds(0, 22, 160, 28);
		Windspeedvalue.setHorizontalAlignment(SwingConstants.CENTER);
		Info1.add(Windspeedvalue);
		
		Info2 = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Info2.setOpaque(false);
		Info2.setBounds(750, 176, 160, 50);
		Info2.setBackground(new Color(0,0,0,80));
		l1.add(Info2);
		Info2.setLayout(null);
		
		pressure=new JLabel("Air Pressure");
		pressure.setForeground(Color.white);
		pressure.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		pressure.setBounds(0, 0, 160, 22);
		pressure.setHorizontalAlignment(SwingConstants.CENTER);
		Info2.add(pressure);
		
		pressurevalue=new JLabel("2200 PS");
		pressurevalue.setForeground(Color.white);
		pressurevalue.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		pressurevalue.setBounds(0, 22, 160, 28);
		pressurevalue.setHorizontalAlignment(SwingConstants.CENTER);
		Info2.add(pressurevalue);
		
		Info3 = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		Info3.setOpaque(false);
		Info3.setBounds(800, 229, 160, 50);
		Info3.setBackground(new Color(0,0,0,80));
		l1.add(Info3);
		Info3.setLayout(null);
		
		visibility=new JLabel("Visibility");
		visibility.setForeground(Color.white);
		visibility.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		visibility.setBounds(0, 0, 160, 22);
		visibility.setHorizontalAlignment(SwingConstants.CENTER);
		Info3.add(visibility);
		
		visibilityvalue=new JLabel("1200");
		visibilityvalue.setForeground(Color.white);
		visibilityvalue.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		visibilityvalue.setBounds(0, 22, 160, 28);
		visibilityvalue.setHorizontalAlignment(SwingConstants.CENTER);
		Info3.add(visibilityvalue);
		
		//main panel
		search=new JTextField();
		search.setForeground(Color.WHITE);
		search.setBounds(800, 20, 150, 28);
		search.setHorizontalAlignment(JTextField.CENTER);
		Font font =new Font("SANS_SERIF",Font.PLAIN,20);
		search.setBorder(new LineBorder(Color.black, 1));
		search.setFont(font);
		search.setOpaque(false);
		l1.add(search);
		
		
		searchbutton = new JButton();
		searchbutton.setBounds(950,20,30,30);
		searchbutton.setOpaque(false);
		searchbutton.setContentAreaFilled(false);
		searchbutton.setBorderPainted(false);
		searchbutton.setMargin(new Insets(0,0,0,0));
		l1.add(searchbutton);
		  try {
		    Image img = ImageIO.read(getClass().getResource("/Main_panel/search-png-white-search-icon.png"));
		    searchbutton.setIcon(new ImageIcon(img));
		  } catch (Exception ex) {
		    System.out.println(ex);
		  }
		
		
		b1 = new JButton("x");
		b1.setForeground(Color.WHITE);
		b1.setBounds(980, 5, 15, 15);
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setMargin(new Insets(0,0,0,0));
		l1.add(b1);
		
		//second panel
		p2=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p2.setOpaque(false);
		p2.setBounds(2, 320, 164,180);
		p2.setBackground(new Color(0,0,0,80));
		l1.add(p2);
		p2.setLayout(null);
		
		daytwo=new JLabel("Tue");
		daytwo.setBounds(0, 5, 162, 30);
		daytwo.setForeground(Color.white);
		daytwo.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		daytwo.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(daytwo);
		
		daytwoico=new JLabel("");
		daytwoico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH)));
		daytwoico.setBounds(0, 35, 162, 60);
		daytwoico.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(daytwoico);
		
		daytwoweather = new JTextPane();
		daytwoweather.setBounds(0, 95, 162, 55);
		daytwoweather.setText("Rain");
		daytwoweather.setBackground(new Color(0,0,0,0));
		daytwoweather.setParagraphAttributes(SimpleAttributeSet(), true);
		daytwoweather.setOpaque(false);
		daytwoweather.setEditable(false);
		p2.add(daytwoweather);
		
		
		daytwominmax=new JLabel("32\u00B0C / 32\u00B0C");
		daytwominmax.setBounds(0, 150, 162, 30);
		daytwominmax.setForeground(Color.white);
		daytwominmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		daytwominmax.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(daytwominmax);
		
				
		//Third panel
		p3=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p3.setOpaque(false);
		p3.setBounds(168, 320, 164,180);
		p3.setBackground(new Color(0,0,0,80));
		l1.add(p3);
		p3.setLayout(null);
		
		daythree=new JLabel("Wed");
		daythree.setBounds(0, 5, 162, 30);
		daythree.setForeground(Color.white);
		daythree.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		daythree.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(daythree);
		
		daythreeico=new JLabel("");
		daythreeico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		daythreeico.setBounds(0,35,162,60);
		daythreeico.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(daythreeico);

		daythreeweather = new JTextPane();
		daythreeweather.setBounds(0, 95, 162, 55);
		daythreeweather.setText("Rain");
		daythreeweather.setBackground(new Color(0,0,0,0));
		daythreeweather.setParagraphAttributes(SimpleAttributeSet(), true);
		daythreeweather.setOpaque(false);
		daythreeweather.setEditable(false);
		p3.add(daythreeweather);
		
		
		daythreeminmax=new JLabel("32\u00B0C / 32\u00B0C");
		daythreeminmax.setBounds(0, 150, 162, 30);
		daythreeminmax.setForeground(Color.white);
		daythreeminmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		daythreeminmax.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(daythreeminmax);
		
		//Forth panel
		p4=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p4.setOpaque(false);
		p4.setBounds(334, 320, 164,180);
		p4.setBackground(new Color(0,0,0,80));
		l1.add(p4);
		p4.setLayout(null);
		
		dayfour=new JLabel("Thr");
		dayfour.setBounds(0, 5, 162, 30);
		dayfour.setForeground(Color.white);
		dayfour.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		dayfour.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(dayfour);
		
		dayfourico = new JLabel("");
		dayfourico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		dayfourico.setBounds(0, 35, 162, 60);
		dayfourico.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(dayfourico);
		
		dayfourweather = new JTextPane();
		dayfourweather.setBounds(0, 95, 162, 55);
		dayfourweather.setText("Rain");
		dayfourweather.setBackground(new Color(0,0,0,0));
		dayfourweather.setParagraphAttributes(SimpleAttributeSet(), true);
		dayfourweather.setOpaque(false);
		dayfourweather.setEditable(false);
		p4.add(dayfourweather);
		
		
		dayfourminmax=new JLabel("32\u00B0C / 32\u00B0C");
		dayfourminmax.setBounds(0, 150, 162, 30);
		dayfourminmax.setForeground(Color.white);
		dayfourminmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		dayfourminmax.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(dayfourminmax);
		
		//fifth panel
		p5=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p5.setOpaque(false);
		p5.setBounds(500, 320, 164,180);
		p5.setBackground(new Color(0,0,0,80));
		l1.add(p5);
		p5.setLayout(null);
		
		dayfive=new JLabel("Fri");
		dayfive.setBounds(0, 5, 162, 30);
		dayfive.setForeground(Color.white);
		dayfive.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		dayfive.setHorizontalAlignment(SwingConstants.CENTER);
		p5.add(dayfive);
		
		dayfiveico = new JLabel("");
		dayfiveico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		dayfiveico.setBounds(0,35,162,60);
		dayfiveico.setHorizontalAlignment(SwingConstants.CENTER);
		p5.add(dayfiveico);
		
		dayfiveweather = new JTextPane();
		dayfiveweather.setBounds(0, 95, 162, 55);
		dayfiveweather.setText("Rain");
		dayfiveweather.setBackground(new Color(0,0,0,0));
		dayfiveweather.setParagraphAttributes(SimpleAttributeSet(), true);
		dayfiveweather.setOpaque(false);
		dayfiveweather.setEditable(false);
		p5.add(dayfiveweather);
		
		
		dayfiveminmax=new JLabel("32\u00B0C / 32\u00B0C");
		dayfiveminmax.setBounds(0, 150, 162, 30);
		dayfiveminmax.setForeground(Color.white);
		dayfiveminmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		dayfiveminmax.setHorizontalAlignment(SwingConstants.CENTER);
		p5.add(dayfiveminmax);
		
		//sixth panel
		p6=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p6.setOpaque(false);
		p6.setBounds(666, 320, 164,180);
		p6.setBackground(new Color(0,0,0,80));
		l1.add(p6);
		p6.setLayout(null);
		
		daySix=new JLabel("Sat");
		daySix.setBounds(0, 5, 162, 30);
		daySix.setForeground(Color.white);
		daySix.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		daySix.setHorizontalAlignment(SwingConstants.CENTER);
		p6.add(daySix);
		
		daysixico=new JLabel("");
		daysixico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		daysixico.setBounds(0, 35, 162, 60);
		daysixico.setHorizontalAlignment(SwingConstants.CENTER);
		p6.add(daysixico);
		
		daysixweather = new JTextPane();
		daysixweather.setBounds(0, 95, 162, 55);
		daysixweather.setText("Rain");
		daysixweather.setBackground(new Color(0,0,0,0));
		daysixweather.setParagraphAttributes(SimpleAttributeSet(), true);
		daysixweather.setOpaque(false);
		daysixweather.setEditable(false);
		p6.add(daysixweather);
		
		
		daysixminmax=new JLabel("32\u00B0C / 32\u00B0C");
		daysixminmax.setBounds(0, 150, 162, 30);
		daysixminmax.setForeground(Color.white);
		daysixminmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		daysixminmax.setHorizontalAlignment(SwingConstants.CENTER);
		p6.add(daysixminmax);
		
		//seventh panel
		p7=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				g.setColor(getBackground());
				g.fillRect(0, 0, getWidth(), getHeight());
				super.paintComponent(g);
			}
		};
		p7.setOpaque(false);
		p7.setBounds(832, 320, 164,180);
		p7.setBackground(new Color(0,0,0,80));
		l1.add(p7);
		p7.setLayout(null);
		
		daySeven=new JLabel("Sun");
		daySeven.setBounds(0, 5, 162, 30);
		daySeven.setForeground(Color.white);
		daySeven.setFont(new Font("SANS_SERIF",Font.PLAIN,20));
		daySeven.setHorizontalAlignment(SwingConstants.CENTER);
		p7.add(daySeven);
		
		daysevenico = new JLabel("");
		daysevenico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/clear.png")).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
		daysevenico.setBounds(0, 35, 162, 60);
		daysevenico.setHorizontalAlignment(SwingConstants.CENTER);
		p7.add(daysevenico);
		
		daysevenweather = new JTextPane();
		daysevenweather.setBounds(0, 95, 162, 55);
		daysevenweather.setText("Rain");
		daysevenweather.setBackground(new Color(0,0,0,0));
		daysevenweather.setParagraphAttributes(SimpleAttributeSet(), true);
		daysevenweather.setOpaque(false);
		daysevenweather.setEditable(false);
		p7.add(daysevenweather);
		
		daysevenminmax=new JLabel("32\u00B0C / 32\u00B0C");
		daysevenminmax.setBounds(0, 150, 162, 30);
		daysevenminmax.setForeground(Color.white);
		daysevenminmax.setFont(new Font("SANS_SERIF",Font.PLAIN,17));
		daysevenminmax.setHorizontalAlignment(SwingConstants.CENTER);
		p7.add(daysevenminmax);
		
		Drag = new JLabel("");
		Drag.setBounds(0, 0, 1000, 15);
		l1.add(Drag);
		
		//These drag are for providing the moveable facility to jdialog 
		Drag.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent ekl)
			{
				int coordx=ekl.getXOnScreen();
				int coordy=ekl.getYOnScreen();
				setLocation(coordx-mousepx,coordy-mousepy);
			}
		});
		
		Drag.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent ekl)
			{
				mousepx=ekl.getX();
				mousepy=ekl.getY();
			}
		});
		
		//For close the window
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//For Search Button
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String addres=search.getText();
				search.setText("");
				try 
				{
					
					//for six day report
					URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+addres+"&units=metric&cnt=7&lang=en&APPID=0e948b3ecd877b785634d8ebdd15621e");
				    Scanner scan = new Scanner(url.openStream());
				    String str = new String();
				    while (scan.hasNext())
				        str += scan.nextLine();
				    scan.close();
				    
				    Object obj = new JSONParser().parse(str);
				    JSONObject jo = (JSONObject) obj;
				    JSONArray ja = (JSONArray) jo.get("list");
				    
				    for(int i=1;i<=6;i++)
				    {
				    	JSONObject j1 = (JSONObject)ja.get(i);
				    	if(ja.get(i)==ja.get(1))
				    	{
				    		daytwo.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		daytwominmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		daytwoweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    		
				    		daytwoico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));

				    	}
				    	if(ja.get(i)==ja.get(2))
				    	{
				    		daythree.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		daythreeminmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		daythreeweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    		
				    		daythreeico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
				    	}
				    	if(ja.get(i)==ja.get(3))
				    	{
				    		dayfour.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		dayfourminmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		dayfourweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    	
				    		dayfourico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
				    	}
				    	if(ja.get(i)==ja.get(4))
				    	{
				    		dayfive.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		dayfiveminmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		dayfiveweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    		
				    		dayfiveico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
				    	}
				    	if(ja.get(i)==ja.get(5))
				    	{
				    		daySix.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		daysixminmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		daysixweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    		
				    		daysixico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
				    	}
				    	if(ja.get(i)==ja.get(6))
				    	{
				    		daySeven.setText(Dayname(j1.get("dt")));
				    		
				    		JSONObject temp = (JSONObject)j1.get("temp");
				    		int min=RoundOf(temp.get("min"));
				    		int max=RoundOf(temp.get("max"));
				    		daysevenminmax.setText(Integer.toString(min)+"\u00B0C / "+Integer.toString(max)+"\u00B0C");
				    		JSONArray weather = (JSONArray)j1.get("weather");
				    		JSONObject weather1 = (JSONObject)weather.get(0);
				    		daysevenweather.setText((String)weather1.get("description")+System.getProperty("line.separator"));
				    		
				    		daysevenico.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/weather_images/"+Weatherico(weather1.get("description")))).getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH)));
				    	}   
				    }
				    
				  //This is Current weather
					URL url0 = new URL("http://api.openweathermap.org/data/2.5/weather?q="+addres+"&units=metric&APPID=0e948b3ecd877b785634d8ebdd15621e");
					Scanner scan0 = new Scanner(url0.openStream());
				    String str0 = new String();
				    while (scan0.hasNext())
				        str0 += scan0.nextLine();
				    scan0.close();
				    
				    Object obj0 = new JSONParser().parse(str0);
				    JSONObject jo0 = (JSONObject) obj0;
				    JSONObject jo1 = (JSONObject)(jo0.get("main"));
				    
				    //This is for current temp of today
				    int currenttemp=RoundOf(jo1.get("temp"));
				    num.setText(Integer.toString(currenttemp));
				    
				    //This is for air pressure value
				    if(jo1.get("pressure")==null)
				    {
				    	pressurevalue.setText("null");
				    }
				    else
				    {
				    	pressurevalue.setText(Info(jo1.get("pressure"))+" hPa");
				    } 
				    
				    //this is for visibility value
				    if(jo0.get("visibility")==null)
				    {
				    	visibilityvalue.setText("null");
				    }
				    else
				    {
				    	visibilityvalue.setText(Info(jo0.get("visibility")));
				    }
				    //This is for humidity value
				    if(jo1.get("humidity")==null)
				    {
				    	humidityvalue.setText("null");
				    }
				    else
				    {
				    	humidityvalue.setText(Info(jo1.get("humidity"))+"%");
				    }
				    
				    
				    //this is for today min and max temp
				    int max=RoundOf(jo1.get("temp_max"));
				    int min=RoundOf(jo1.get("temp_min"));
				    todaymin.setText(Integer.toString(min)+"\u00B0");
				    todaymax.setText(Integer.toString(max)+"\u00B0");
				    
				    //This is for Today weather
				    JSONArray ja0 = (JSONArray) jo0.get("weather");
				    JSONObject jaobject0 = (JSONObject)ja0.get(0);
				    todaytemp.setText((String)jaobject0.get("description"));
				    
				    //This is for Changing backgroundpic
				    l1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Main_panel/"+Image(jaobject0.get("main")))).getImage().getScaledInstance(1000,500,Image.SCALE_SMOOTH)));
				    
				    //This is for printing th Wind speed
				    JSONObject jo2 = (JSONObject)(jo0.get("wind"));
				    Windspeedvalue.setText(Info(jo2.get("speed"))+"m/s");
				    
				    //This is for printing Today date and day 
				    java.util.Date time1=new java.util.Date((long)jo0.get("dt")*1000);
					DateFormat df1 = new SimpleDateFormat("EEEE dd");
			    	String First = df1.format(time1);
					today.setText(First+"TH");
				    
					//This for printing Place and Country name
					JSONObject jo3 = (JSONObject)(jo0.get("sys"));
					cityname.setText(jo0.get("name")+","+jo3.get("country"));
				    
				}catch(Exception em)
				{
					JOptionPane.showMessageDialog(null,"Some Error Try Again");
				}
			}
		});
		
	}
	public static void main(String[] args) {
			Weather dialog = new Weather();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}
}
