import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 * Operate 对应  Operate（业务处理类）：定义每一个具体操作的方法
 */
public class Operate {
    ArrayList arrayList=new ArrayList();
    Scanner input=new Scanner(System.in);
    public Operate(){}
    public void readmessage() throws Exception
    {
        FileInputStream fileInputStream = new FileInputStream("message.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line=null;
        String []temp=new String[10];
        while ((line=bufferedReader.readLine())!=null)
        {
            Person person=new Person();
            temp=line.split("\\s+");
            person.setName(temp[0]);
            person.setAge(temp[1]);
            person.setSex(temp[2]);
            person.setTelNum(temp[3]);
            person.setAddress(temp[4]);
            arrayList.add(person);
            //System.out.println(person.toString());
        }
        bufferedReader.close();
    }
    public void writemessage()throws Exception
    {
        FileWriter writer=new FileWriter("message.txt");
        BufferedWriter bufferedWriter=new BufferedWriter(writer);
        //Iterator it=arrayList.iterator();
        for(int i=0;i<arrayList.size();i++) {
            bufferedWriter.write(arrayList.get(i).toString());
        }
        bufferedWriter.close();
    }
    public void addLogic()throws Exception
    {
        boolean tem=false;
        Person person=new Person();
        while (!tem) {
            System.out.println("请输入你要添加的人名");
            String name = input.nextLine();
            tem = person.setName(name);
            if(!tem)
                continue;
            System.out.println("请输入" + name + "的age：");
            tem = person.setAge(input.nextLine());
            if(!tem)
                continue;
            System.out.println("请输入" + name + "的sex：");
            tem = person.setSex(input.nextLine());
            if(!tem)
                continue;
            System.out.println("请输入" + name + "的tellnumber：");
            tem = person.setTelNum(input.nextLine());
            if(!tem)
                continue;
            System.out.println("请输入" + name + "的address：");
            tem = person.setAddress(input.nextLine());
            if(!tem)
                continue;
        }
        if(tem)
        arrayList.add(person);

    }
    public void searchLogic()
    {
        Iterator<Person> it=arrayList.iterator();
        while (it.hasNext())
        {
            Person s=it.next();
            System.out.println(s);
        }
    }
    public void searchLogic(String where)
    {
        System.out.println("请输入你要查找的值");
        String value=input.nextLine();
        Iterator<Person> it= arrayList.iterator();
        boolean flag=true;
        switch (where)
        {
            case "name":
                while (it.hasNext())
                {
                    Person p=it.next();
                    if(p.getName().equals(value)){
                    System.out.println(p);
                    flag=false;}
                }
                break;
            case "age":
                while (it.hasNext())
                {
                    Person p=it.next();
                    if(p.getAge().equals(value)){
                    System.out.println(p.toString());
                    flag=false;}
                }
                break;
            case "sex":
                while (it.hasNext())
                {
                    Person p=it.next();
                    if(p.getSex().equals(value)){
                    System.out.println(p.toString());
                    flag=false;}
                }
                break;
            case "telNum":
                while (it.hasNext())
                {
                    Person p=it.next();
                    if(p.getTelNum().equals(value)){
                    System.out.println(p.toString());
                    flag=false;}
                }
                break;
            case "address":
                while (it.hasNext())
                {
                    Person p=it.next();
                    if(p.getAddress().equals(value)){
                    System.out.println(p.toString());
                    flag=false;}
                }
                break;
        }
        if(flag)
        System.out.println("未找到信息");
    }
    public void modify()
    {
        System.out.println("请输入你要修改的人的姓名");
        String who=input.nextLine();
        System.out.println("请输入你要修改的选项");
        String what=input.nextLine();
        System.out.println("请输入你要修改的值");
        String value=input.nextLine();
        Iterator<Person> it=arrayList.iterator();
        while (it.hasNext())
        {
            Person s=it.next();
            if(s.getName().equals(who))
            {
                switch (what){
                    case "name":
                        s.setName(value);
                    case "age":
                        s.setAge(value);
                    case "sex":
                        s.setSex(value);
                    case "telNum":
                        s.setTelNum(value);
                    case "adress":
                        s.setAddress(value);
                }
            }
        }
    }
    public void delone()
    {
        System.out.println("请输入你要删除对象的名字：");
        String name=input.nextLine();
        Iterator<Person> iterator=arrayList.iterator();
        while (iterator.hasNext())
        {
            Person s=iterator.next();
            if(s.getName().equals(name))
                iterator.remove();
        }
    }

    public void delall()
    {
        arrayList.clear();
    }


}

