class A{
    private int data;
    private String info;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }   
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }

}

public class Main{
    public static void main(String[] args) {
        A obj = new A();
        obj.setData(10);
        obj.setInfo("Hello World");

        System.out.println("Data: " + obj.getData());
        System.out.println("Info: " + obj.getInfo());
        
    }
}