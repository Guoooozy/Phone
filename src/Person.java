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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+sex+" "+telNum+" "+address+"\n";
    }
}
