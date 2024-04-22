public interface MarsRover {
    void move(String commands);
    Direction getCurrentDirection();
    Coordinates2D getCurrentLocation();
}
