import java.util.*;
import java.awt.*;
import java.awt.event.*;
class NullFieldException extends Exception
{
    public NullFieldException(String s)
    {
        super(s);
    }
}
class student
{
    String name;
    int rno,tot,nq;
    double avg;
    public student(String name,int rno,int t,int n)
    {
        this.name=name;
        this.rno=rno;
        tot=t;
        nq=n;
        avg=(tot/nq);
    }
}
class QuizManagement extends Frame
{
    int x;
    Label nlabel=new Label("NAME");
    Label rlabel=new Label("RNO");
    Label tlabel=new Label("TOTAL");
    Label nqlabel=new Label("QUIZES");
    TextField ntextfield=new TextField();
    TextField rtextfield=new TextField();
    TextField ttextfield=new TextField();
    TextField nqtextfield=new TextField();
    Button Add=new Button("ADD");
    Button search=new Button("SEARCH");
    Button dis=new Button("DISPLAY");
    Button mp=new Button("LEFT");
    Button mn=new Button("RIGHT");
    Button mf=new Button("FIRST");
    Button ml=new Button("LAST");
    TextArea textarea=new TextArea();
    ArrayList<student> al=new ArrayList<student>(5);
    public QuizManagement()
    {
        nlabel.setBounds(100,50,80,20);
        rlabel.setBounds(100,80,80,20);
        tlabel.setBounds(100,110,80,20);
        nqlabel.setBounds(100,140,80,20);
        ntextfield.setBounds(200,50,80,20);
        rtextfield.setBounds(200,80,80,20);
        ttextfield.setBounds(200,110,80,20);
        nqtextfield.setBounds(200,140,80,20);
        Add.setBounds(50,250,50,20);
        search.setBounds(120,250,80,20);
        dis.setBounds(220,250,80,20);
        mf.setBounds(50,300,50,20);
        mp.setBounds(120,300,50,20);
        mn.setBounds(190,300,50,20);
        ml.setBounds(260,300,50,20);
        textarea.setBounds(400,50,250,250);
        add(nlabel);
        add(rlabel);
        add(tlabel);
        add(nqlabel);
        add(ntextfield);
        add(rtextfield);
        add(ttextfield);
        add(nqtextfield);
        add(Add);
        add(search);
        add(dis);
        add(mf);
        add(mp);
        add(mn);
        add(ml);
        add(textarea);  
        x=0;
         Add.addActionListener(new ActionListener()
        {
             public void actionPerformed(ActionEvent e)
             {
                String name;
                int rno,t,n;
                name=ntextfield.getText();
                rno=Integer.parseInt(rtextfield.getText());
                t=Integer.parseInt(ttextfield.getText());
                n=Integer.parseInt(nqtextfield.getText());
                try 
                {
                    if(name.isEmpty()||(String.valueOf(rno)).isEmpty()||(String.valueOf(t)).isEmpty()||(String.valueOf(n)).isEmpty())
                    {
                        throw new NullFieldException("fill all fields");
                    }
                }
                catch(NullFieldException ne)
                {
                    System.out.println("fill all fields");
                    //OptionPane.showMessageDialogue(this,"fill all fields");
                }
                name=ntextfield.getText();
                rno=Integer.parseInt(rtextfield.getText());
                t=Integer.parseInt(ttextfield.getText());
                n=Integer.parseInt(nqtextfield.getText());
                student s=new student(name,rno,t,n);
                ADD(s);
                ntextfield.setText("");
                rtextfield.setText("");
                ttextfield.setText("");
                nqtextfield.setText("");
            }
        });
        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int no=Integer.parseInt(rtextfield.getText());
                SEARCH(no);
                rtextfield.setText("");
            }
        });
        setLayout(null);
        setVisible(true);
        setSize(800,800);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
              dispose();
            }
        });
        dis.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Iterator itr=al.iterator();
                while(itr.hasNext())
                {
                    student s=(student)itr.next();
                    String data=textarea.getText();
                    textarea.setText(data+"\nname is "+s.name+"\nrno is "+s.rno+"\ntotal is ="+s.tot+"\nno of quizes = "+s.nq+"\naverage = "+s.avg);
                }
            }
        });
        mf.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                student s=(student)al.get(0);
                textarea.setText("\nname is "+s.name+"\nrno is "+s.rno+"\ntotal is ="+s.tot+"\nno of quizes = "+s.nq+"\naverage = "+s.avg);
            }   
        });
        ml.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                student s=(student)al.get(4);
                textarea.setText("\nname is "+s.name+"\nrno is "+s.rno+"\ntotal is ="+s.tot+"\nno of quizes = "+s.nq+"\naverage = "+s.avg);
            }   
        });
        mp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                student s=(student)al.get(x);
                textarea.setText("\nname is "+s.name+"\nrno is "+s.rno+"\ntotal is ="+s.tot+"\nno of quizes = "+s.nq+"\naverage = "+s.avg);
                if(x>0)
                    x--;
            }   
        });
        mn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                student s=(student)al.get(x);
                textarea.setText("\nname is "+s.name+"\nrno is "+s.rno+"\ntotal is ="+s.tot+"\nno of quizes = "+s.nq+"\naverage = "+s.avg);
                if(x<4)
                    x++;
            }   
        });
    }
    public void ADD(student s)
    {
        al.add(s);
    }
    public void SEARCH(int r)
    {
        for(int i=0;i<5;i++)
        {
            student s1=al.get(i);
            if(s1.rno==r)
            {
                textarea.setText("found at index "+(i+1)+"\naverage = "+s1.avg);
                
            }
        }
    }
}
class sastra17
{
    public static void main(String[] args)
    {
        QuizManagement q=new QuizManagement();
    }
}