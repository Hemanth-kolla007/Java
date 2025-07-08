import java.util.*;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
class ProductNotAvailableException extends Exception
{
    public ProductNotAvailableException(String s)
    {
        super(s);
    }
}
class multithreading0 implements Runnable
{
  Thread t;
  Label moving;
  multithreading0(Label moving)
  {
    this.moving=moving;
    t=new Thread(this);
    t.start();
  }
  public void run()
  {
    try
    {
      while (true) {
    moving.setBounds(40,50,90,20);
    Thread.sleep(700);
    moving.setBounds(120,50,90,20);
    Thread.sleep(700);
    moving.setBounds(240,50,90,20);
    Thread.sleep(700);
    moving.setBounds(340,50,90,20);
    Thread.sleep(700);
    moving.setBounds(440,50,90,20);
    Thread.sleep(700);
    moving.setBounds(540,50,90,20);
    Thread.sleep(700);
      }
    }
     catch(InterruptedException e) {
					return;
			}
  }
}
class MOBILE_PURCHASE extends Frame
{
    String name,year,mvalue;
    int mprice;
    Label blabel=new Label("BRAND");
    Label ylabel=new Label("YEAR");
    Choice brand=new Choice();
    CheckboxGroup yor=new CheckboxGroup();
    Checkbox y1=new Checkbox("2018",yor,false);
    Checkbox y2=new Checkbox("2019",yor,false);
    Checkbox y3=new Checkbox("2020",yor,false);
    Label mvlabel=new Label("M-VALUE");
    TextField mvtextfield=new TextField();
    Label plabel=new Label("PRICE");
    TextField ptextfield=new TextField();
    static Label ta1;
    TextArea ta2=new TextArea();
    Button sbutton=new Button("SUBMIT");
    public MOBILE_PURCHASE()
    {
        blabel.setBounds(100,100,80,20);
        brand.setBounds(200,100,80,20);
        ylabel.setBounds(100,150,80,20);
        y1.setBounds(200,150,50,20);
        y2.setBounds(200,180,50,20);
        y3.setBounds(200,210,50,20);
        mvlabel.setBounds(100,240,80,20);
        mvtextfield.setBounds(200,240,80,20);
        plabel.setBounds(100,270,80,20);
        ptextfield.setBounds(200,270,80,20);
        ta1=new Label("Online shopping");
        ta2.setBounds(300,100,250,250);
        ta1.setBounds(50,50,700,40);
        sbutton.setBounds(150,350,50,20);
        brand.add("SAMSUNG");
        brand.add("MOTOROLA");
        brand.add("SONY");
        name=brand.getSelectedItem();
     sbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)  
            {
                 if(y1.getState())
                year=String.valueOf(2018);
            if(y2.getState())
                year=String.valueOf(2019);
            if(y3.getState())
                year=String.valueOf(2020);
            mprice=Integer.parseInt(ptextfield.getText());
        try
        {
            if(mprice<10000||mprice>50000)
            {
                throw new ProductNotAvailableException("product not available");
            }
        }
        catch(ProductNotAvailableException a)
        {
            System.out.println("enter valid amount");
        }
        mvalue=mvtextfield.getText();
        mprice=Integer.parseInt(ptextfield.getText());
                ta2.setText("\nMODEL = "+name+"\nYEAR OF RELEASE = "+year+"\nPRICE = "+mprice+"\nMODEL VALUE = "+mvalue);
            }  
        });
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                dispose();
            }    
        });
        add(blabel);
        add(brand);
        add(ylabel);
        add(y1);
        add(y2);
        add(y3);
        add(mvlabel);
        add(mvtextfield);
        add(plabel);
        add(ptextfield);
        add(ta2);
        add(ta1);
        add(sbutton);
        setSize(800,800);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[])
    {
            new MOBILE_PURCHASE();
            new multithreading0(ta1);
    }   
}