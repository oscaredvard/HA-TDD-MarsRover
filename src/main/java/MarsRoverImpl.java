public class MarsRoverImpl implements MarsRover {

    private int x;
    private int y;
    private Direction direction;

    public MarsRoverImpl(Coordinates2D startingPosition, Direction startingDirection){
        x = startingPosition.x();
        y = startingPosition.y();
        direction = startingDirection;
    }

    @Override
    public void move(String commands){
        if (this.direction == Direction.NORTH) {
            if (commands.equals("f")) {
                this.y += 1;
            } else if (commands.equals("b")){
                this.y -= 1;
            }
        }
        else if (this.direction == Direction.SOUTH) {
            if (commands.equals("f")) {
                this.y -= 1;
            } else if (commands.equals("b")){
                this.y += 1;
            }
        }
        else if (this.direction == Direction.WEST) {
            if (commands.equals("f")) {
                this.x -= 1;
            } else if (commands.equals("b")){
                this.x += 1;
            }
        }
        else if (this.direction == Direction.EAST) {
            if (commands.equals("f")) {
                this.x += 1;
            } else if (commands.equals("b")){
                this.x -= 1;
            }
        }
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }

    @Override
    public Direction getCurrentDirection() { return direction; }
}
