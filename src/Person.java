import java.lang.annotation.Target;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 * Person 对应  Person （实体类）：定义属性和方法
 */
public class Person {
    private String id;
    private String name;
    private String age;
    private String sex;
    private String telNum;
    private String address;
    TelNoteRegex tnr=new TelNoteRegex();
    public Person(){}
    public Person(String name,String age,String sex,String telNum,String address)
    {
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.telNum=telNum;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getId() {
        return id;
    }

    public boolean setName(String name) {
        if(tnr.nameRegex(name)){
            this.name = name;
            return true;
        }
        else
            System.out.println("输入名字不合法，请重新输入");
            return false;
    }

    public boolean setAge(String age) {
        if(tnr.chicknum(age)){
            this.age = age;
            return true;
        }
        else {
            System.out.println("输入年龄不合法，请重新输入");
            return false;
        }
    }

    public boolean setSex(String sex) {
        if(tnr.sexRegex(sex)){
            this.sex = sex;
            return true;
        }
        else {
            System.out.println("输入性别不合法，请重新输入");
            return false;
        }
    }

    public boolean setTelNum(String telNum) {
        if(tnr.telNumRegex(telNum))
        {
            this.telNum = telNum;
            return true;
        }
        else {
            System.out.println("输入手机号不合法，请重新输入");
            return false;
        }
    }

    public boolean setAddress(String address) {
        if(tnr.nameRegex(address)){
            this.address = address;
            return true;
        }
        else {
            System.out.println("输入地址不合法，请重新输入");
            return false;
        }
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+sex+" "+telNum+" "+address+"\n";
    }
}
