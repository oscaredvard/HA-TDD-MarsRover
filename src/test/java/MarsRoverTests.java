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

    @Test
    public void testRotateLeftFromNorth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        rover.rotate("l");

        Assertions.assertEquals(Direction.WEST, rover.getCurrentDirection());
    }

    @Test
    public void testRotateRightFromNorth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        rover.rotate("r");

        Assertions.assertEquals(Direction.EAST, rover.getCurrentDirection());
    }
    @Test
    public void testRotateLeftFromSouth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        rover.rotate("l");

        Assertions.assertEquals(Direction.EAST, rover.getCurrentDirection());
    }
    @Test
    public void testRotateRightFromSouth() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.SOUTH);

        rover.rotate("r");

        Assertions.assertEquals(Direction.WEST, rover.getCurrentDirection());
    }
    @Test
    public void testRotateLeftFromWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.rotate("l");

        Assertions.assertEquals(Direction.SOUTH, rover.getCurrentDirection());
    }
    @Test
    public void testRotateRightFromWest() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.WEST);

        rover.rotate("r");

        Assertions.assertEquals(Direction.NORTH, rover.getCurrentDirection());
    }
    @Test
    public void testRotateLeftFromEast() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        rover.rotate("l");

        Assertions.assertEquals(Direction.NORTH, rover.getCurrentDirection());
    }
    @Test
    public void testRotateRightFromEast() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.EAST);

        rover.rotate("r");

        Assertions.assertEquals(Direction.SOUTH, rover.getCurrentDirection());
    }

    @Test
    public void testArbitraryCommandoString() {

        MarsRover rover = new MarsRoverImpl(new Coordinates2D(3, 3), Direction.NORTH);

        rover.command("ffrblb");

        Assertions.assertEquals(new Coordinates2D(2, 4), rover.getCurrentLocation());

        Assertions.assertEquals(Direction.NORTH, rover.getCurrentDirection());

    }

    @Test
    public void testWrappingOverNorthPoleXEqualZeroForwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 6), Direction.NORTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(4, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualTwoForwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(2, 6), Direction.NORTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(6, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualFourForwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(4, 6), Direction.NORTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(0, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualSixForwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 6), Direction.NORTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(2, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualSevenForwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(7, 6), Direction.NORTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(3, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualZeroBackwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 6), Direction.SOUTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(4, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualTwoBackwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(2, 6), Direction.SOUTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(6, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualFourBackwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(4, 6), Direction.SOUTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(0, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverNorthPoleXEqualSixBackwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 6), Direction.SOUTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(2, 6), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualZeroForwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 0), Direction.SOUTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(4, 0), rover.getCurrentLocation());
    }


    @Test
    public void testWrappingOverSouthPoleXEqualTwoForwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(2, 0), Direction.SOUTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(6, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualFourForwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(4, 0), Direction.SOUTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(0, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualSixForwardsFacingSouth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 0), Direction.SOUTH);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(2, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualZeroBackwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 0), Direction.NORTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(4, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualTwoBackwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 0), Direction.NORTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(2, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualFourBackwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 0), Direction.NORTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(2, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverSouthPoleXEqualSixBackwardsFacingNorth() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(6, 0), Direction.NORTH);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(2, 0), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverMeridianForwardsFacingWest() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 3), Direction.WEST);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(7, 3), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverMeridianBackwardsFacingWest() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(7, 3), Direction.WEST);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(0, 3), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverMeridianForwardsFacingEast() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(7, 3), Direction.EAST);

        rover.command("f");

        Assertions.assertEquals(new Coordinates2D(0, 3), rover.getCurrentLocation());
    }

    @Test
    public void testWrappingOverMeridianBackwardsFacingEast() {
        MarsRover rover = new MarsRoverImpl(new Coordinates2D(0, 3), Direction.EAST);

        rover.command("b");

        Assertions.assertEquals(new Coordinates2D(7, 3), rover.getCurrentLocation());
    }
}