package mars.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void mark(){
        this.isDone = true;
    }

    public void unmark(){
        this.isDone = false;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return isDone ? "[X] " + this.description : "[ ] " + this.description;
    }

}
