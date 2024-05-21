package sit707_week6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TaskInboxTest {

    private TaskInbox taskInbox;
    private TaskView taskView;

    @Before
    public void setUp() {
        taskInbox = new TaskInbox();
        taskView = new TaskView(taskInbox);
        taskInbox.addTask(new Task(1, "Task 1", "Description 1"));
        taskInbox.addTask(new Task(2, "Task 2", "Description 2"));
    }

    @Test
    public void testGetTasksForStudent_NonEmptyInbox() {
        List<Task> tasks = taskInbox.getTasksForStudent(1);
        Assert.assertFalse(tasks.isEmpty());
    }

    @Test
    public void testViewTask() {
        TaskDetail taskDetail = taskView.viewTask(1);
        Assert.assertNotNull(taskDetail);
        Assert.assertEquals(1, taskDetail.getTaskId());
        Assert.assertEquals("Sample feedback", taskDetail.getFeedback());
        Assert.assertTrue(taskDetail.getChatMessages().isEmpty());
    }

    @Test
    public void testViewTask_NonExistentTaskId() {
        TaskDetail taskDetail = taskView.viewTask(999);
        Assert.assertNull(taskDetail);
    }
}
