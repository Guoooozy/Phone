import java.util.Scanner;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:23
 */
public class Menu {
    Scanner input=new Scanner(System.in);
    String op="";
    TelNoteRegex t=new TelNoteRegex();
    public void mainMenu() {
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
                case "2":
                    findMenu();
                case "3":
                    modifyMenu();
                case "4":
                    deleteMenu();
                case "5":
                    System.exit(0);
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    mainMenu();
            }
        }

    }

    public void addMenu(){
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
                    ;
                case "2":
                    ;
                case "3":
                    mainMenu();
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    addMenu();
            }
        }
    }

    public void findMenu(){
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
                    ;
                case "2":
                    ;
                case "3":
                    ;
                case "4":
                    ;
                case "5":

                case "6":

                case "7":
                    mainMenu();
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    findMenu();
            }
        }
    }
    public void modifyMenu(){
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
                    ;
                case "2":
                    ;
                case "3":
                    mainMenu();
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    modifyMenu();
            }
        }
    }
    public void deleteMenu(){
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
                    ;
                case "2":
                    ;
                case "3":
                    ;
                case "4":
                    mainMenu();;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    deleteMenu();
            }
        }
    }
    public void sortMenu(){
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
                    ;
                case "2":
                    ;
                case "3":
                    ;
                case "4":
                    ;
                case "5":
                    mainMenu();;
                default:
                    System.out.println("您输入的数字不合法，请重新输入");
                    sortMenu();
            }
        }
    }
}