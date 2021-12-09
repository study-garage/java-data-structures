package am.studygarage.problem.roundrobin;

import java.util.List;

public interface Consumer {

    void addValue(Task<?> value);

    List<Task<?>> getValues();

}
