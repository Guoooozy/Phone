import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 * Operate 对应  Operate（业务处理类）：定义每一个具体操作的方法
 */
public class Operate {
        PreparedStatement pstmt;
        Connection conn=getConn();
        Scanner input=new Scanner(System.in);
        ArrayList arrayList=new ArrayList();
        String message[]=new String[10];
        public Connection getConn() {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://49.234.72.114:3306/gzy?&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "gzy112480..";
            Connection conn = null;
            try {
                Class.forName(driver); //classLoader,加载对应驱动
                conn = (Connection) DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

    public void insert(String[] message)//增加用户
    {
        //Connection conn = getConn();
        int i = 0;
        String sql = "insert into phone (name,age,sex,telNum,address) values(?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            String s1, s2, s3, s4, s5;
            s1 = message[0];
            s2 = message[1];
            s3 = message[2];
            s4 = message[3];
            s5 = message[4];
            pstmt.setString(1, s1);
            pstmt.setString(2, s2);
            pstmt.setString(3, s3);
            pstmt.setString(4, s4);
            pstmt.setString(5, s5);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(String money,String acc) //更新用户信息
    {
        Connection conn = getConn();
        int i = 0;
        String sql = "update phone set money=? where acc=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,money);
            pstmt.setString(2,acc);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String[] select(String where, String value)//查询某个参数的某个值
    {
        String sql = "SELECT * from phone WHERE ?=?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //String[] message = new String[8];
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,where);
            pstmt.setString(2,value);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                message[0] = rs.getString(1);
                message[1] = rs.getString(2);
                message[2] = rs.getString(3);
                message[3] = rs.getString(4);
                message[4] = rs.getString(5);
                return message;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return message;
    }
    public void addLogic()
    {
        System.out.println("请依次输入姓名，年龄，性别，电话号码，住址：");
        Person person=new Person(input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine(),input.nextLine());
        boolean flag=true;
        TelNoteRegex telNoteRegex=new TelNoteRegex();
        if(!telNoteRegex.nameRegex(person.getName())){
            flag=false;
            System.out.println("姓名输入不合法，请重新输入");
        }
        if(!telNoteRegex.chicknum(person.getAge())){
            flag= false;
            System.out.println("年龄输入不合法，请重新输入");
        }
        if(!telNoteRegex.sexRegex(person.getSex())) {
            flag = false;
            System.out.println("性别输入不合法，请重新输入");
        }
        if(!telNoteRegex.chicknum(person.getTelNum())) {
            flag = false;
            System.out.println("电话号码输入不合法，请重新输入");
        }
        if(!telNoteRegex.nameRegex(person.getAddress())) {
            flag = false;
            System.out.println("住址输入不合法，请重新输入");
        }
        if(flag)
        {
            arrayList.add(person);
            message[0]=person.getName();
            message[1]=person.getAge();
            message[2]=person.getSex();
            message[3]=person.getTelNum();
            message[4]=person.getAddress();
            insert(message);
            System.out.println("成功添加用户");
            new Menu().addMenu();
        }
        else
        {
            addLogic();
        }
    }
    public void searchLogic(String where)
    {
        System.out.println("请输入您要查询的值：");
        String value=input.nextLine();
            String temp[] = new String[10];
            temp = select(where, value);
            for(int i=0;i<5;i++)
                System.out.println(temp[i]);
    }
    public void searchLogic()
    {
        String sql = "SELECT * from phone";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String[] message = new String[8];
        int i=1;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = (ResultSet) pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("序号"+i+" "+rs.getString("name")+" "
                        +rs.getString("age")+" "
                        +rs.getString("sex")+" "
                        +rs.getString("telNum") +" "
                        +rs.getString("address"));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ;
    }
}
