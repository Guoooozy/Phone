import javax.sound.midi.Soundbank;
import java.io.*;
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
        }
        bufferedReader.close();

    }
    public void writemessage()throws Exception
    {
        FileOutputStream fileOutputStream=new FileOutputStream("message.txt",true);
        BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        for(int i=0;i<arrayList.size();i++)
            bufferedWriter.write(arrayList.get(i).toString());
        bufferedWriter.close();
    }
    public void addLogic()
    {
        Person person=new Person();
        System.out.println("请输入你要添加的人名");
        String name =input.nextLine();
        person.setName(name);
        System.out.println("请输入"+name+"的age：");
        person.setAge(input.nextLine());
        System.out.println("请输入"+name+"的sex：");
        person.setSex(input.nextLine());
        System.out.println("请输入"+name+"的tellnumber：");
        person.setTelNum(input.nextLine());
        System.out.println("请输入"+name+ "的address：");
        person.setAddress(input.nextLine());
        arrayList.add(person);



    }
}
