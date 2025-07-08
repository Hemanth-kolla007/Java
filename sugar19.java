import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class sugfactory
{
    int sal;
    double hra,da,gp;
    String name,des;
    public sugfactory(int s,String n,String d)
    {
        sal=s;
        name=n;
        des=d;
        if(d.equals("manager"))
        {
            hra=0.2*sal;
            da=0.25*sal;
            gp=sal+hra+da;
        }
        else if(d.equals("accountant"))
        {
            hra=0.1*sal;
            da=0.15*sal;
            gp=sal+hra+da;
        }
        else
        {
            hra=0.1*sal;
            da=0.1*sal;
            gp=sal+hra+da;
        }
    }
}
class InvalidSalaryException extends Exception
{
   public InvalidSalaryException(String s)
   {
        super(s);
   }
}
class SFrame extends JFrame implements ActionListener
{
    JLabel nlabel=new JLabel("NAME");
    JLabel slabel=new JLabel("SALARY");
    JLabel dlabel=new JLabel("DESIGNATION");
    JTextField ntextfield=new JTextField();
    JTextField stextfield=new JTextField();
    JTextField dtextfield=new JTextField();
    JButton sbutton=new JButton("SUBMIT");
    JButton dbutton=new JButton("DETAILS");
    JTextArea textarea=new JTextArea();
    ArrayList<sugfactory> al=new ArrayList<sugfactory>();
    public void actionPerformed(ActionEvent e){}
    public SFrame()
    {
        nlabel.setBounds(50,50,80,20);
        slabel.setBounds(50,80,80,20);
        dlabel.setBounds(50,110,80,20);
        ntextfield.setBounds(200,50,100,20);
        stextfield.setBounds(200,80,100,20);
        dtextfield.setBounds(200,110,100,20);
        textarea.setBounds(400,50,300,300);
        sbutton.setBounds(100,200,100,30);
        dbutton.setBounds(250,200,100,30);
        sbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int sa;
                String n,d;
                try
                {
                     sa=Integer.parseInt(stextfield.getText());
                     if(sa<0)
                     {
                        throw new InvalidSalaryException("invalid salary");
                     }
                }
                catch(InvalidSalaryException ex)
                {
                    stextfield.setText("");
                    System.out.println("enter valid no");
                    JOptionPane.showMessageDialog(null,"Invalid basic salary");
                }
                sa=Integer.parseInt(stextfield.getText());
                n=ntextfield.getText();
                d=dtextfield.getText();
                sugfactory s=new sugfactory(sa,n,d);
                al.add(s);
                stextfield.setText("");
                ntextfield.setText("");
                dtextfield.setText("");
            }
        });
        dbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Iterator itr=al.iterator();
                while(itr.hasNext())
                {
                    sugfactory s=(sugfactory)itr.next();
                    String data=textarea.getText();
                    textarea.setText(data+"\nName= "+s.name+"\nBasic salary=" +s.sal+"\nDesignation ="+s.des+"\nhra="+s.hra+"\nda="+s.da+"\ngross pay+"+s.gp+"\n");

                }
            }
        });
        add(nlabel);
        add(slabel);
        add(dlabel);
        add(ntextfield);
        add(dtextfield);
        add(stextfield);
        add(sbutton);
        add(dbutton);
        add(textarea);
        setLayout(null);
        setVisible(true);
        setSize(800,800);
    }
}
class sugar19
{
    public static void main(String[] args)
    {
        SFrame s=new SFrame();
    }
}