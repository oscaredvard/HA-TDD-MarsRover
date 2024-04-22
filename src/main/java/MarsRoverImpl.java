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

       if (this.y != 0 && this.y != 6) {
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
       } else if (this.y == 0) {
           if (this.x < 4) {
               if (this.direction == Direction.NORTH) {
                   if (commands.equals("f")) {
                       this.y += 1;
                   } else if (commands.equals("b")) {
                       this.x += 4;
                   }
               } else if (this.direction == Direction.SOUTH) {
                   if (commands.equals("f")) {
                       this.x += 4;
                   } else if (commands.equals("b")) {
                       this.y += 1;
                   }
               }
           } else if (this.x <= 7) {
               if (this.direction == Direction.NORTH) {
                   if (commands.equals("f")) {
                       this.y += 1 ;
                   } else if (commands.equals("b")) {
                       this.x -= 4;
                   }
               } else if (this.direction == Direction.SOUTH) {
                   if (commands.equals("f")) {
                       this.x -= 4 ;
                   } else if (commands.equals("b")) {
                       this.y += 1;
                   }
               }
           }
       } else if (this.y == 6) {
           if (this.x < 4) {
               if (this.direction == Direction.NORTH) {
                   if (commands.equals("f")) {
                       this.x += 4 ;
                   } else if (commands.equals("b")) {
                       this.y -= 1;
                   }
               } else if (this.direction == Direction.SOUTH) {
                   if (commands.equals("f")) {
                       this.y -= 1 ;
                   } else if (commands.equals("b")) {
                       this.x += 4;
                   }
               }
           } else if (this.x <= 7) {
               if (this.direction == Direction.NORTH) {
                   if (commands.equals("f")) {
                       this.x -= 4 ;
                   } else if (commands.equals("b")) {
                       this.y -= 1;
                   }
               } else if (this.direction == Direction.SOUTH) {
                   if (commands.equals("f")) {
                       this.y -= 1 ;
                   } else if (commands.equals("b")) {
                       this.x -= 4;
                   }
               }
           }
       }


       if (this.x != 0 && this.x != 7) {
            if (this.direction == Direction.WEST) {
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
       } else {
          if (this.x == 0)  {
              if (this.direction == Direction.WEST) {
                  if (commands.equals("f")) {
                      this.x = 7;
                  } else if (commands.equals("b")){
                      this.x += 1;
                  }
              }
              else if (this.direction == Direction.EAST) {
                  if (commands.equals("f")) {
                      this.x += 1;
                  } else if (commands.equals("b")){
                      this.x = 7;
                  }
              }
          } else if (this.x == 7) {
              if (this.direction == Direction.WEST) {
                  if (commands.equals("f")) {
                      this.x -= 1;
                  } else if (commands.equals("b")){
                      this.x = 0;
                  }
              }
              else if (this.direction == Direction.EAST) {
                  if (commands.equals("f")) {
                      this.x = 0;
                  } else if (commands.equals("b")){
                      this.x -= 1;
                  }
              }
          }
       }
    }

    @Override
    public void rotate(String commands){
        if (this.direction == Direction.NORTH) {
            if (commands.equals("l")) {
               this.direction = Direction.WEST;
            } else if (commands.equals("r")){
                this.direction = Direction.EAST;
            }
        }
        else if (this.direction == Direction.SOUTH) {
            if (commands.equals("l")) {
                this.direction = Direction.EAST;
            } else if (commands.equals("r")){
                this.direction = Direction.WEST;
            }
        }
        else if (this.direction == Direction.WEST) {
            if (commands.equals("l")) {
                this.direction = Direction.SOUTH;
            } else if (commands.equals("r")){
                this.direction = Direction.NORTH;
            }
        }
        else if (this.direction == Direction.EAST) {
            if (commands.equals("l")) {
                this.direction = Direction.NORTH;
            } else if (commands.equals("r")){
                this.direction = Direction.SOUTH;
            }
        }
    }

    @Override
    public void command(String commands) {
        for (int i = 0; i < commands.length(); i++)
            if (commands.charAt(i) == 'f' || commands.charAt(i) == 'b') {
                this.move(Character.toString(commands.charAt(i)));
            } else if (commands.charAt(i) == 'l' || commands.charAt(i) == 'r') {
                this.rotate(Character.toString(commands.charAt(i)));
            }
    }

    @Override
    public Coordinates2D getCurrentLocation() {
        return new Coordinates2D(x, y);
    }

    @Override
    public Direction getCurrentDirection() { return direction; }
}
