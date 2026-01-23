package tools.other;

public class AAAA {
    public int marks=0;
    //by default access modifier is applied as 'default' i.e. package-private
    private String grade="A";
    public void display(){
        System.out.println("Marks: "+marks);
        System.out.println("Grade: "+grade);
    }
    public String getGrade(){
        return grade;
    }
    
}
