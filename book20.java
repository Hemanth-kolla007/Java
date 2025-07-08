import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class book
{
    int isbn,cp;
    String tit,aut;
    public book(int isbn,int c,String t,String a)
    {
        this.isbn=isbn;
        cp=c;
        tit=t;
        aut=a;
    }
}
class InvalidCopiesException extends Exception
{
   public InvalidCopiesException(String s)
   {
        super(s);
   }
}
class SFrame extends JFrame implements ActionListener
{
    JLabel ilabel=new JLabel("ISBN number");
    JLabel tlabel=new JLabel("Title");
    JLabel alabel=new JLabel("Author");
    JLabel clabel=new JLabel("No of copies");
    JTextField itextfield=new JTextField();
    JTextField ttextfield=new JTextField();
    JTextField atextfield=new JTextField();
    JTextField ctextfield=new JTextField();
    JButton sbutton=new JButton("SUBMIT");
    JButton dbutton=new JButton("DETAILS");
    JTextArea textarea=new JTextArea();
    ArrayList<book> al=new ArrayList<book>();
    public void actionPerformed(ActionEvent e){}
    public SFrame()
    {
        ilabel.setBounds(50,50,80,20);
        tlabel.setBounds(50,80,80,20);
        alabel.setBounds(50,110,80,20);
        clabel.setBounds(50,140,80,20);
        itextfield.setBounds(200,50,100,20);
        ttextfield.setBounds(200,80,100,20);
        atextfield.setBounds(200,110,100,20);
        ctextfield.setBounds(200,140,100,20);
        textarea.setBounds(400,50,300,300);
        sbutton.setBounds(100,200,100,30);
        dbutton.setBounds(250,200,100,30);
        sbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int n,c;
                String a,t;
                try
                {
                     c=Integer.parseInt(ctextfield.getText());
                     if(c<0)
                     {
                        throw new InvalidCopiesException("invalid input");
                     }
                }
                catch(InvalidCopiesException ex)
                {
                    ctextfield.setText("");
                    System.out.println("enter valid no");
                    JOptionPane.showMessageDialog(null,"Invalid copies");
                }
                n=Integer.parseInt(itextfield.getText());
                 c=Integer.parseInt(ctextfield.getText());
                a=atextfield.getText();
                t=ttextfield.getText();
                book b=new book(n,c,t,a);
                al.add(b);
                itextfield.setText("");
                ttextfield.setText("");
                atextfield.setText("");
                ctextfield.setText("");
            }
        });
        dbutton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Iterator itr=al.iterator();
                while(itr.hasNext())
                {
                    book b=(book)itr.next();
                    String data=textarea.getText();
                    textarea.setText(data+"\nISBN number= "+b.isbn+"\ntitle=" +b.tit+"\nauthor="+b.aut+"\nno of copies= "+b.cp+"\n");

                }
            }
        });
        add(ilabel);
        add(tlabel);
        add(alabel);
        add(clabel);
        add(itextfield);
        add(ttextfield);
        add(atextfield);
        add(ctextfield);
        add(sbutton);
        add(dbutton);
        add(textarea);
        setLayout(null);
        setVisible(true);
        setSize(800,800);
    }
}
class book20
{
    public static void main(String[] args)
    {
        SFrame s=new SFrame();
    }
}