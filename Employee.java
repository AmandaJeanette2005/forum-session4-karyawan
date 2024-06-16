public class Employee {
    String id;
    String name;

    public Employee(String id, String name){
        this.id = id;
        this.name = name;
    }

    //#region getter and setter
    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    //#endregion
    
    @Override
    public String toString() {
        return "ID: " + id + "\nNama: " + name;
    }
}
