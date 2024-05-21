package sit707_week6;

import java.util.ArrayList;

public class TaskView {
    private TaskInbox taskInbox;

    public TaskView(TaskInbox taskInbox) {
        this.taskInbox = taskInbox;
    }

    public TaskDetail viewTask(int taskId) {
        Task task = findTaskById(taskId);
        if (task != null) {
            return new TaskDetail(task.getId(), "Sample feedback", new ArrayList<>()); 
        } else {
            return null;
        }
    }

    private Task findTaskById(int taskId) {
        for (Task task : taskInbox.getTasksForStudent(0)) { 
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}
