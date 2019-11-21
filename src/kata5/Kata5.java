package kata5;

public class Kata5 {


    public static void main(String[] args) {
        String url ="jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5\\DB_SQLite\\miercoles.db";
        DataBase db = new DataBase(url);
        db.open();
        
        db.select_PERSONAS();
        
        People people = new People("Santi","Abas","Marketing");
        
        db.insert_PERSONAS(people);
        
        System.out.println("* * * * *");
        
        db.select_PERSONAS();
        
        db.close();
    }
    
}
