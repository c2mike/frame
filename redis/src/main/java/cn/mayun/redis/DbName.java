package cn.mayun.redis;
public enum DbName{
    MAIN(0,"main"),
    REDIS(1,"redis");

    private int index;
    private String name;

    private DbName(int index, String name)
    {
        this.index = index;
        this.name = name;
    }

    public int getIndex()
    {
        return index;
    }

    public String getName()
    {
        return name;
    }
}