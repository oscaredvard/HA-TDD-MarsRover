public interface MarsRover {
    void move(String commands);
    void rotate(String commands);
    void command(String commands);
    Direction getCurrentDirection();
    Coordinates2D getCurrentLocation();
}
