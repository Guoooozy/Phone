/**
 * @author Guoooozy
 * @date 2019/12/24 - 10:24
 */
public class TelNoteRegex {
    public boolean chicknum(String num)
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
}
