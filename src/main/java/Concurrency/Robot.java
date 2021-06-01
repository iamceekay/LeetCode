package Concurrency;

public class Robot {
    //GL
        public boolean isRobotBounded(String instructions) {
            int i=0;
            int j=0;
            int dir=1;

            //1 north 2 East 3 South 4 west
            for(char c : instructions.toCharArray()){  // Loop through to follow every instruction

                if(c == 'G'){
                    if(dir == 1) j++;  //if direction is north, move forward
                    else if(dir == 2) i++;  //if direction is East, move right
                    else if(dir == 3) j--;  //if direction is South, move downward
                    else i--;  //if direction is west, move West
                }
                else if(c == 'L'){  // if asked to turn left
                    dir = dir == 1 ? 4 : dir-1; // subtract 1 from current direction to turn left, if  dir == 1 i.e. North, we need to turn towards west i.e. 4
                }
                else if(c == 'R'){ // if asked to turn right
                    dir = dir == 4 ? 1 : dir+1;  // add 1 from current direction to turn right, if  dir == 4 i.e. West, we need to turn towards North i.e. 1
                }

            }

            return i == 0 && j == 0 || dir>1;   // check the current position and direction and decide


        }

}
