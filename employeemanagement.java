import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
class exception extends Exception
{
    String str;
    exception(String str)
    {
      super(str);
      this.str=str;
    }
}
abstract class employee 
{
 String  Employeename;
 int EmployeeID;
 abstract void calcNetSalalry();
}
class permanentemployee extends employee
{
  double BasicPay,HRAPercentage,DAPercentage,PFPercentage,netsalary;
  permanentemployee(JTextField EmployeeName$t,JTextField EmployeeId$t,JTextField BasicPay$t,JTextField HRAPrecentage$t,JTextField DAPercentage$t,JTextField PFPercentage$t)
  {
    Employeename=EmployeeName$t.getText();
    EmployeeID=Integer.parseInt(EmployeeId$t.getText());
    BasicPay=Double.parseDouble(BasicPay$t.getText());
    HRAPercentage=Double.parseDouble(HRAPrecentage$t.getText());
    DAPercentage=Double.parseDouble(DAPercentage$t.getText());
    PFPercentage=Double.parseDouble(PFPercentage$t.getText());
    calcNetSalalry();
  }
void calcNetSalalry() {
    netsalary = BasicPay + (BasicPay * HRAPercentage / 100) + (BasicPay * DAPercentage / 100) - (BasicPay * PFPercentage / 100);
}
}
class temporaryemployee extends employee
{
  double HourlyWages,HoursWorked,netsalary;
  temporaryemployee(JTextField EmployeeName$t,JTextField EmployeeId$t,JTextField HourlyWages$t,JTextField HoursWorked$t)
  {
    Employeename=EmployeeName$t.getText();
    EmployeeID=Integer.parseInt(EmployeeId$t.getText());
    HourlyWages=Double.parseDouble(HourlyWages$t.getText());
    HoursWorked=Double.parseDouble(HoursWorked$t.getText());
    calcNetSalalry();
  }
  void calcNetSalalry()
  {
     netsalary=HoursWorked*HourlyWages;
  }
}
class employeemanagement extends JFrame 
{
  ArrayList<permanentemployee> arrayList$Permanentemployees=new ArrayList<permanentemployee>();
  ArrayList<temporaryemployee> arrayList$Temporaryemployees=new ArrayList<temporaryemployee>();
  void Add_Permanent_Employee(permanentemployee p)
  {
    arrayList$Permanentemployees.add(p);
  }
  void Add_Temporary_Employee(temporaryemployee t)
  {
    arrayList$Temporaryemployees.add(t);
  }
  String search(int target)
  {
    for(int i=0;i<arrayList$Permanentemployees.size();i++)
    {
      if(arrayList$Permanentemployees.get(i).EmployeeID==target)
      {
        return display(i, "permanent");
      }
    }
    for(int i=0;i<arrayList$Temporaryemployees.size();i++)
    {
     if(arrayList$Temporaryemployees.get(i).EmployeeID==target)
      return display(i, "temporary");
    }
    return "EmployeeID not found";
  }
  String display(int pos,String type)
  {
    String str="";
    if(type.equals("permanent"))
    {
     permanentemployee s=arrayList$Permanentemployees.get(pos);
        str+=("\nEmployeeName: "+s.Employeename+"\n");
        str+=("EmployeeId: "+s.EmployeeID+"\n");
        str+=("netsalary: "+s.netsalary+"\n");
    }
     else
    {
     temporaryemployee s=arrayList$Temporaryemployees.get(pos); 
        str+=("\nEmployeeName: "+s.Employeename+"\n");
        str+=("EmployeeId: "+s.EmployeeID+"\n");
        str+=("netsalary: "+s.netsalary+"\n");
    }
    return str;
  }
  int i=0,j=0;
  String type="";
   employeemanagement()
   {
    JLabel EmployeeName$l,EmployeeId$l,BasicPay$l,HRAPrecentage$l,DAPercentage$l,PFPercentage$l,HoursWorked$l,HourlyWages$l;
    JTextField EmployeeName$t,EmployeeId$t,BasicPay$t,HRAPrecentage$t,DAPercentage$t,PFPercentage$t,HoursWorked$t,HourlyWages$t;
    JRadioButton permanent$b,temparory$b;
    JButton add$b,search$b,display$b,movefirst$b,moveprevoius$b,movenext$b,movelast$b;  
    JTextArea textArea;

    this.setSize(700, 600);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    EmployeeName$l=new JLabel("NAME");
    EmployeeName$l.setBounds(50,50,150,30);
    EmployeeName$t=new JTextField();
    EmployeeName$t.setBounds(220,50,150,30);

    EmployeeId$l=new JLabel("EMPLOYEEID");
    EmployeeId$l.setBounds(50,100,150,30);
    EmployeeId$t=new JTextField();
    EmployeeId$t.setBounds(220,100,150,30);

    BasicPay$l=new JLabel("BASICPAY");
    BasicPay$l.setBounds(50,150,150,30);
    BasicPay$t=new JTextField();
    BasicPay$t.setBounds(220,150,150,30);

    HRAPrecentage$l=new JLabel("HRA");
    HRAPrecentage$l.setBounds(50,200,150,30);
    HRAPrecentage$t=new JTextField();
    HRAPrecentage$t.setBounds(220,200,150,30);

    DAPercentage$l=new JLabel("DA");
    DAPercentage$l.setBounds(50,250,150,30);
    DAPercentage$t=new JTextField();
    DAPercentage$t.setBounds(220,250,150,30);

    PFPercentage$l=new JLabel("PR");
    PFPercentage$l.setBounds(50,300,150,30);
    PFPercentage$t=new JTextField();
    PFPercentage$t.setBounds(220,300,150,30);

    HoursWorked$l=new JLabel("hoursWorked");
    HoursWorked$l.setBounds(50,350,150,30);
    HoursWorked$t=new JTextField();
    HoursWorked$t.setBounds(220,350,150,30);
    
    HourlyWages$l=new JLabel("HourlyWages");
    HourlyWages$l.setBounds(50,400,150,30);
    HourlyWages$t=new JTextField();
    HourlyWages$t.setBounds(220,400,150,30);
    
    add$b=new JButton("ADD");
    add$b.setBounds(40,450,80,30);

    display$b=new JButton("DIS");
    display$b.setBounds(180,450,80,30);

    search$b=new JButton("SEARCH");
    search$b.setBounds(300,450,80,30);

    movefirst$b=new JButton("mf");
    movefirst$b.setBounds(30,500,80,30);

    movenext$b=new JButton(">>");
    movenext$b.setBounds(140,500,80,30);

    moveprevoius$b=new JButton("<<");
    moveprevoius$b.setBounds(220,500,80,30);

    movelast$b=new JButton("ml");
    movelast$b.setBounds(330,500,80,30);

    permanent$b=new JRadioButton("permanent");
    permanent$b.setBounds(420,50,120,30);
    temparory$b=new JRadioButton("temporary");
    temparory$b.setBounds(570,50,120,30);
    ButtonGroup bg=new ButtonGroup();
    bg.add(permanent$b);bg.add(temparory$b);

    textArea = new JTextArea(20,20);
    JScrollPane scrollableTextArea = new JScrollPane(textArea);
    scrollableTextArea.setBounds(420, 100, 260, 400);
    scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
    scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    add(EmployeeName$l);add(EmployeeId$l); add(BasicPay$l);add(HRAPrecentage$l);add(DAPercentage$l);add(PFPercentage$l);add(HoursWorked$l);add (HourlyWages$l);
    add(EmployeeName$t);add(EmployeeId$t); add(BasicPay$t);add(HRAPrecentage$t);add(DAPercentage$t);add(PFPercentage$t);add(HoursWorked$t);add (HourlyWages$t);
    add(add$b);add(search$b);add(display$b);add(movefirst$b);add(moveprevoius$b);add(movenext$b);add(movelast$b);
    add(permanent$b);add(temparory$b);
    add(scrollableTextArea);
    this.setVisible(true);
    add$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          type= permanent$b.isSelected()?"permanent":temparory$b.isSelected()?"temporary":"null";
          try{
            if(EmployeeName$t.getText().isEmpty()||EmployeeId$t.getText().isEmpty()||BasicPay$t.getText().isEmpty()||HRAPrecentage$t.getText().isEmpty()||DAPercentage$t.getText().isEmpty()||PFPercentage$t.getText().isEmpty()||HoursWorked$t.getText().isEmpty()||HourlyWages$t.getText().isEmpty()||type.equals("null"))
            {
              throw new exception("NULL FILED EXCEPTION");          
          }
          if(Integer.parseInt(HourlyWages$t.getText())>200)
            {
              throw new exception("HUMAN RIGHTS VIOLATIONS EXCEPTION");
            }
          }
          catch(exception E)
          {
            JOptionPane.showMessageDialog(null,E.str);
          }
          if(type.equals("permanent"))
          {
            permanentemployee p=new permanentemployee(EmployeeName$t,EmployeeId$t,BasicPay$t,HRAPrecentage$t,DAPercentage$t,PFPercentage$t);
            Add_Permanent_Employee(p);
            JOptionPane.showMessageDialog(null,"added successfully");
            bg.clearSelection();
            EmployeeName$t.setText("");
            EmployeeId$t.setText("");
            BasicPay$t.setText("");
            HRAPrecentage$t.setText("");
            DAPercentage$t.setText("");
            PFPercentage$t.setText("");
            HoursWorked$t.setText("");
            HourlyWages$t.setText("");
            type="null";
          }
          if(type.equals("temporary"))
          {
            temporaryemployee t=new temporaryemployee(EmployeeName$t,EmployeeId$t,HourlyWages$t,HoursWorked$t);
            Add_Temporary_Employee(t);
            JOptionPane.showMessageDialog(null,"added successfully");
            bg.clearSelection();
            EmployeeName$t.setText("");
            EmployeeId$t.setText("");
            BasicPay$t.setText("");
            HRAPrecentage$t.setText("");
            DAPercentage$t.setText("");
            PFPercentage$t.setText("");
            HoursWorked$t.setText("");
            HourlyWages$t.setText("");
            type="null";
          }
        }
      });
      search$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          String str=EmployeeId$t.getText();
          textArea.setText("");
          str=search(Integer.parseInt(str));
          if(!str.equals("EmployeeID not found"))
          {
            textArea.setText(str);
          }
          else
          {
            JOptionPane.showMessageDialog(null,"EmployeeID not found");
          }
        }
      });
      display$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
          String temp="";
          textArea.setText("");
          String type= permanent$b.isSelected()?"permanent":"temporary";
          if(type.equals("permanent"))
          {
            for(int i=0;i<arrayList$Permanentemployees.size();i++)
            temp+=display(i, type);
          }
          if(type.equals("temporary"))
          {
            for(int i=0;i<arrayList$Temporaryemployees.size();i++)
            temp+=display(i, type);
          }
          textArea.setText(temp);
          type="";
        }
      });
      movefirst$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String temp="";
          type= permanent$b.isSelected()?"permanent":temparory$b.isSelected()?"temporary":"";
          if(type.equals("permanent"))
          {
            textArea.setText("");
            if(!arrayList$Permanentemployees.isEmpty())
            temp+=display(0, type);
          }
          if(type.equals("temporary"))
          {
            textArea.setText("");
            if(!arrayList$Temporaryemployees.isEmpty())
            temp+=display(0, type);
          }
          textArea.setText(temp);
          type="";
        }
    });
    movelast$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String temp="";
          type= permanent$b.isSelected()?"permanent":temparory$b.isSelected()?"temporary":"";
          if(type.equals("permanent"))
          {
            textArea.setText("");
            if(!arrayList$Permanentemployees.isEmpty())
            temp+=display(arrayList$Permanentemployees.size()-1, type);
            
          }
          if(type.equals("temporary"))
          {
            textArea.setText("");
            if(!arrayList$Temporaryemployees.isEmpty())
            temp+=display(arrayList$Temporaryemployees.size()-1, type);
          }
          textArea.setText(temp);
          type="";
        }
    });
  movenext$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String temp="";
          String type1= permanent$b.isSelected()?"permanent":temparory$b.isSelected()?"temporary":"";
          if(type1.equals("permanent"))
          {
            i++;
            textArea.setText("");
            if(i >= 0 &&i<arrayList$Permanentemployees.size()-1&&!arrayList$Permanentemployees.isEmpty())
            temp+=display(i, type1);
          }
          else
          {
            i--;
          }
          if(type1.equals("temporary"))
          {
            j++;
            textArea.setText("");
            if(i >= 0 &&i<arrayList$Temporaryemployees.size()-1&&!arrayList$Temporaryemployees.isEmpty())
            temp+=display(i, type1);
          }
          else
          {
            j--;
          }
          textArea.setText(temp);
        }
    });
    moveprevoius$b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String temp="";
          String type2= permanent$b.isSelected()?"permanent":temparory$b.isSelected()?"temporary":"";
          if(type2.equals("permanent"))
          {
            i--;
            textArea.setText("");
            if(i >= 0 &&i<arrayList$Permanentemployees.size()&&!arrayList$Permanentemployees.isEmpty())
            temp+=display(i, type2);
          }
          else
          {
            i++;
          }
          if(type2.equals("temporary"))
          {
            j++;
            textArea.setText("");
            if(i >= 0 &&i<arrayList$Temporaryemployees.size()&&!arrayList$Temporaryemployees.isEmpty())
            temp+=display(i, type2);
          }
          else
          {
            j++;
          }
          textArea.setText(temp);
        }
    });
}
   public static void main(String[] args) {
    new employeemanagement();
   }

}