package sample;

public class idGetter {
    public static String id;
    public static String usrName;
    public static String usrMail;
    public static String usrPass;
    public static String usrname;




    public idGetter(String id)
    {
        this.id = id;
    }

    public static void setID(String aid)
    {
        id =aid;
    }

    public static String getID()
    {
        return id;
    }

    public static String getUserName() {
        return usrName;
    }

    public static void setUserName(String usrName) {
        idGetter.usrName = usrName;
    }

    public static String getUserMail() {
        return usrMail;
    }

    public static void setUserMail(String usrMail) {
        idGetter.usrMail = usrMail;
    }

    public static String getUserPass() {
        return usrPass;
    }

    public static void setUserPass(String usrPass) {
        idGetter.usrPass = usrPass;
    }

    public static String getUsername() {
        return usrname;
    }

    public static void setUsername(String usrFname) {
        idGetter.usrname = usrFname;
    }

    public static String getDept(String id)
    {
        //String id = n +"";
        if(id.charAt(id.length()-2)=='4' && id.charAt(id.length()-1)=='2')
        {
            return "CSE";
        }

        else if(id.charAt(id.length()-2)=='3' && id.charAt(id.length()-1)=='0')
        {
            return "BBA";
        }

        else if(id.charAt(id.length()-2)=='4' && id.charAt(id.length()-1)=='3')
        {
            return "EEE";
        }

        return "Not Specefied";
    }

}
