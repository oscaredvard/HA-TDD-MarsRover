import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MarsRoverTests {

    @Test
    public void testConstructor() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        Assertions.assertEquals(new Coordinates2D(3, 3), rover.getCurrentLocation());

        Assertions.assertEquals(Direction.WEST, rover.getCurrentDirection());
    }

    @Test
    public void testMoveForwardNorth() {

        //Arrange (see README for reference to Arrange-Act-Assert Pattern)
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        //Act
        rover.move("f");

        //Assert
        Assertions.assertEquals(new Coordinates2D(3, 4), rover.getCurrentLocation());
    }
    @Test
    public void testMoveBackwardNorth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        rover.move("b");

        Assertions.assertEquals(new Coordinates2D(3, 2), rover.getCurrentLocation());
    }
    @Test
    public void testMoveForwardSouth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(3, 2), rover.getCurrentLocation());
    }
    @Test
    public void testMoveBackwardSouth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        rover.move("b");

        Assertions.assertEquals(new Coordinates2D(3, 4), rover.getCurrentLocation());
    }
    @Test
    public void testMoveForwardWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());
    }
    @Test
    public void testMoveBackwardWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.move("b");

        Assertions.assertEquals(new Coordinates2D(4, 3), rover.getCurrentLocation());
    }
    @Test
    public void testMoveForwardEast() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        rover.move("f");

        Assertions.assertEquals(new Coordinates2D(4, 3), rover.getCurrentLocation());
    }
    @Test
    public void testMoveBackwardEast() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        rover.move("b");

        Assertions.assertEquals(new Coordinates2D(2, 3), rover.getCurrentLocation());
    }
}
