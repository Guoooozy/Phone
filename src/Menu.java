import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 * Menu 对应  Menu （菜单类）：定义多个方法，显示各种操作对应的菜单，并调用Operate类中的方法实现菜单中的内容
 */
public class Menu {
    Scanner input=new Scanner(System.in);
    String op="";
    TelNoteRegex t=new TelNoteRegex();
    Operate operate=new Operate();
    //ArrayList arrayList=new ArrayList();
    boolean flag=true;
    public void mainMenu() throws Exception{
        System.out.println("        主菜单          ");
        System.out.println("************************");
        System.out.println("**    1.添加记录      **");
        System.out.println("**    2.查找记录      **");
        System.out.println("**    3.修改记录      **");
        System.out.println("**    4.删除记录      **");
        System.out.println("**    5.排序记录      **");
        System.out.println("**    6.退出系统      **");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        //ArrayList arrayList=new ArrayList();

        if(flag) {
            operate.readmessage();
            flag=false;
        }
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    addMenu();
                    break;
                case "2":
                    findMenu();
                    break;
                case "3":
                    modifyMenu();
                    break;
                case "4":
                    deleteMenu();
                    break;
                case "5":
                    sortMenu();
                    break;
                case "6":
                    operate.writemessage();
                    System.exit(0);
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    break;
            }
        }
        mainMenu();
    }

    public void addMenu()throws Exception{
        System.out.println("     添加记录子菜单     ");
        System.out.println("************************");
        System.out.println("      1.添加新记录      ");
        System.out.println("      2.查看全记录      ");
        System.out.println("      3.返回上一级      ");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    operate.addLogic();
                    break;
                case "2":
                    operate.searchLogic();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    break;
            }
        }
        addMenu();
    }

    public void findMenu()throws Exception{
        System.out.println("     查找记录子菜单     ");
        System.out.println("************************");
        System.out.println("      1.按姓名查找      ");
        System.out.println("      2.按年龄查找      ");
        System.out.println("      3.按性别查找      ");
        System.out.println("      4.按号码查找      ");
        System.out.println("      5.按住址查找      ");
        System.out.println("      6.查看全记录      ");
        System.out.println("      7.返回上一级      ");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    operate.searchLogic("name");
                    break;
                case "2":
                    operate.searchLogic("age");
                    break;
                case "3":
                    operate.searchLogic("sex");
                    break;
                case "4":
                    operate.searchLogic("telNum");
                    break;
                case "5":
                    operate.searchLogic("address");
                    break;
                case "6":
                    operate.searchLogic();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");

            }
        }
        findMenu();
    }
    public void modifyMenu()throws Exception{
        System.out.println("     修改记录子菜单     ");
        System.out.println("************************");
        System.out.println("      1.查看全记录      ");
        System.out.println("      2.修改指定记录    ");
        System.out.println("      3.返回上一级      ");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    operate.searchLogic();
                    break;
                case "2":
                    operate.modify();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");

            }
        }
        modifyMenu();
    }
    public void deleteMenu()throws Exception{
        System.out.println("     删除记录子菜单     ");
        System.out.println("************************");
        System.out.println("      1.查看全记录      ");
        System.out.println("      2.删除指定记录    ");
        System.out.println("      3.删除全部记录    ");
        System.out.println("      4.返回上一级      ");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    operate.searchLogic();
                    break;
                case "2":
                    operate.delone();
                    break;
                case "3":
                    operate.delall();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");

            }
        }
        deleteMenu();

    }
    public void sortMenu()throws Exception{
        System.out.println("     排序记录子菜单     ");
        System.out.println("************************");
        System.out.println("      1.按姓名排序      ");
        System.out.println("      2.按年龄排序      ");
        System.out.println("      3.按性别排序      ");
        System.out.println("      4.查看全记录      ");
        System.out.println("      5.返回上一级      ");
        System.out.println("************************");
        System.out.println("请输入您要执行的操作：");
        op=input.nextLine();
        boolean b=t.chicknum(op);
        while (!b){
            System.out.println("您输入的数字不合法，请重新输入(按0退出)：");
            op=input.nextLine();
            b=t.chicknum(op);
            if(op.equals("0"))
                System.exit(0);
        }
        if(b) {
            switch (op) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    return;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");

            }
        }
        sortMenu();
    }

}
