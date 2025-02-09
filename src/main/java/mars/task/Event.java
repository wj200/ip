package mars.task;

public class Event extends Task {
   public Event(String description){
       super(description);
   }

    @Override
    public String toString(){
        String str = super.getStatusIcon();
        return str.equals("X") ? "[E][X] " + this.description : "[E][ ] " + this.description;
    }
}
