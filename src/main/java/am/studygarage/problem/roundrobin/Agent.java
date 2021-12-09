package am.studygarage.problem.roundrobin;

import java.util.ArrayList;
import java.util.List;

class Agent implements Consumer {

    private final List<Task<?>> values;

    public Agent() {
        this.values = new ArrayList<>();
    }

    @Override
    public List<Task<?>> getValues() {
        return values;
    }

    @Override
    public void addValue(Task<?> value) {
        this.values.add(value);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "values=" + getValues() +
                '}';
    }
}