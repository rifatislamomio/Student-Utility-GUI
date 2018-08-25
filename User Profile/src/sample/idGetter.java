package sample;

public class idGetter {
    public static String id;

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

}
