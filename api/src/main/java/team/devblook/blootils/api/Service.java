package team.devblook.blootils.api;

public interface Service {

    void start();
    default void stop() {}

}
