package am.studygarage.problem.roundrobin;

public final class Task<T> {

    private final T value;

    public Task(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }
}
