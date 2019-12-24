import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import javax.swing.text.StyledEditorKit;

/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:24
 * TelNoteRegex 对应  TelNoteRegex（用户输入验证类）用于对用户输入的姓名，年龄等属性进行验证。
 */
public class TelNoteRegex {
    public boolean chicknum(String num)//验证是否为数字
    {
        for(int i=0;i<num.length();i++)
        {
            if(!(num.charAt(i)>='0'&&num.charAt(i)<='9'))
            {
                return false;
            }
        }
        return true;
    }
    public boolean nameRegex(String name)//验证输入是否为中文
    {
        for(int i=0;i<name.length();i++)
        {
            if(!(name.charAt(i)>=19968&&name.charAt(i)<=171941))
            {
                return false;
            }
        }
        return true;
    }
    public boolean sexRegex(String sex)//验证性别
    {
        if(sex.equals("male")||sex.equals("female"))
            return true;
        else
            return false;
    }
    public boolean telNumRegex(String tel)//验证电话号码
    {
        if(tel.length()!=11)
            return false;
        else
        {
            return chicknum(tel);
        }
    }
}
