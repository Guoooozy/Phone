import javax.sound.midi.Soundbank;
import java.io.*;
import java.net.SocketTimeoutException;
import java.nio.file.FileAlreadyExistsException;
import java.security.MessageDigest;
import java.util.*;

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
        System.out.println("添加成功");

    }
    public void searchLogic()
    {
        boolean flag=true;
        Iterator<Person> it=arrayList.iterator();
        while (it.hasNext())
        {
            Person s=it.next();
            System.out.println(s);
            flag=false;
        }
        if(flag)
            System.out.println("未找到信息");
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
            boolean flag=false;
            if(s.getName().equals(who))
            {
                switch (what){
                    case "name":
                        flag=s.setName(value);
                        break;
                    case "age":
                        flag=s.setAge(value);
                        break;
                    case "sex":
                        flag=s.setSex(value);
                        break;
                    case "telNum":
                        flag=s.setTelNum(value);
                        break;
                    case "adress":
                        flag=s.setAddress(value);
                        break;
                }
                if(!flag) {
                    System.out.println("修改失败，请重新输入");
                    modify();
                }
            }
        }
    }
    public void delone()
    {
        System.out.println("请输入你要删除对象的名字：");
        String name=input.nextLine();
        Iterator<Person> iterator=arrayList.iterator();
        boolean flag=true;
        while (iterator.hasNext())
        {
            Person s=iterator.next();
            if(s.getName().equals(name))
                iterator.remove();
                flag=false;
        }
        if(flag)
            System.out.println("删除失败，请重新输入");
    }

    public void delall()
    {
        arrayList.clear();
    }

    public void compare(int op)
    {
        Comparator<Person> comparator1=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        Comparator<Person> comparator2=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        };
        Comparator<Person> comparator3=new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSex().compareTo(o2.getSex());
            }
        };

        switch (op)
        {
            case 1:
                Collections.sort(arrayList,comparator1);
            case 2:
                Collections.sort(arrayList,comparator2);
            case 3:
                Collections.sort(arrayList,comparator3);
        }
        System.out.println("排序成功");

    }

}

