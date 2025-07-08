import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.SocketPermission;
class student
{
    String name1,dob1,branch1,gen1;
    int rno1;
    student(String name1,String dob1,String branch1,String gen1,int rno1)
    {
        this.name1=name1;
        this.dob1=dob1;
        this.branch1=branch1;
        this.gen1=gen1;
        this.rno1=rno1;
    }
}
class studentdemo extends Frame
{
    ArrayList<student> al=new ArrayList<student>();
    public studentdemo()
    {
    Label title=new Label("STUDENT FORM");
    add(title);
    title.setBounds(500,10,50,20);
    Label namel=new Label("name:");
    Label rnol=new Label("r.no:");
    Label dobl=new Label("DOB:");
    Label branchl=new Label("branch:");
    Label genl=new Label("Gender:");
    TextField name=new TextField();
    TextField  rno=new TextField();
    TextField dob=new TextField();
    Choice branch= new Choice();
    branch.add("B.Tech");
    branch.add("B.Sc");
    branch.add("B.Com");
    CheckboxGroup gen=new CheckboxGroup();
    Checkbox male=new Checkbox("MALE",gen,false);
    Checkbox female=new Checkbox("FEMALE",gen,false);
    add(namel);
    add(rnol);
    add(dobl);
    add(branchl);
    add(genl);
    add(name);
    add(rno);
    add(dob);
    add(branch);
    add(male);
    add(female);
    namel.setBounds(100,100,50,20);
    name.setBounds(150,100,50,20);
    rnol.setBounds(250,100,50,20);
    rno.setBounds(300,100,50,20);
    dobl.setBounds(100,150,50,20);
    dob.setBounds(150,150,100,20);
    branchl.setBounds(100,200,50,20);
    branch.setBounds(150,200,80,20);
    genl.setBounds(100,250,50,20);
    male.setBounds(150,250,50,20);
    female.setBounds(150,280,50,20);
    Button Add=new Button("ADD");
    add(Add);
    Add.setBounds(200,400,50,20);
    Add.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a)
        {
            
            String name2=name.getText();
            String dob2=dob.getText();
            String branch2=branch.getSelectedItem();
           String gen2=(male.getState()?"MALE":"FEMALE");
            int rno2=Integer.parseInt(rno.getText());
            al.add(new student(name2,dob2,branch2,gen2,rno2));
            name.setText("");
            rno.setText("");
            dob.setText("");
            male.setState(false);
            female.setState(false);
        }
    });
    TextArea ta=new TextArea();
    ta.setBounds(500,100,250,500);
    add(ta);
    Button display=new Button("DISPLAY");
    display.setBounds(275,400,50,20);
    Button nxt=new Button("CLEAR");
    nxt.setBounds(350,400,50,20);
    display.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {

            StringBuilder text = new StringBuilder();
            for (student s1 : al) {
                text.append("NAME is: ").append(s1.name1)
                    .append("\nR.NO is: ").append(s1.rno1)
                    .append("\nDOB is: ").append(s1.dob1)
                    .append("\nBRANCH is: ").append(s1.branch1)
                    .append("\nGENDER is: ").append(s1.gen1)
                    .append("\n\n");
            }
            ta.setText(text.toString());
        }
    });
    nxt.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent a)
        {
            ta.setText(" ");
        }
    });
    add(nxt);
    add(display);
    setSize(1000,1000);
    setTitle("STUDENT FORM");
    setLayout(null);
    setVisible(true);
    }
    public static void main(String[] args) 
    {
        studentdemo st=new studentdemo();
    }
}