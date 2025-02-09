package mars.task;

public class Todo extends Task {
    public Todo(String description){
        super(description);
    }

    @Override
    public String toString(){
        String str = super.getStatusIcon();
        return str.equals("X") ? "[T][X] " + this.description : "[T][ ] " + this.description;
    }


}
