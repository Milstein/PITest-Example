package resources;

import com.github.toastshaman.pitest.persistence.TodoStore;
import com.github.toastshaman.pitest.resources.TodoResource;
import org.junit.Test;

public class TodoResourceTest {

    @Test
    public void shouldCreateANewTodoItem() {
        TodoResource resource = new TodoResource(new TodoStore());
    }
}
