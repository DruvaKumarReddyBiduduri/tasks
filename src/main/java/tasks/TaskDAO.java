package tasks;

import java.util.List;

public interface TaskDAO {
    Task findById(int id);
    List<Task> findByUserId(int userId);
    List<Task> findCompleted(int userId);
    boolean insert(Task task);
	void update(int id,String name,String description);
	void update(int id,boolean completed);
    void delete(int id);
}
