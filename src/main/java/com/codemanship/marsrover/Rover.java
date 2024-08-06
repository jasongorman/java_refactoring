package com.codemanship.marsrover;

import java.util.Arrays;

public class Rover {
    private int[] position;
    private String facing;

    public Rover(String facing, int x, int y) {
        this.facing = facing;
        this.position = new int[]{x, y};
    }

    public String getFacing() {
        return facing;
    }

    public int[] getPosition() {
        return position;
    }

    public void go(String instructions) {
        instructions.chars().forEach((instruction) -> {
            if(instruction == 'R'){

                if (turnRight()) return;
            }

            if(instruction == 'L') {
                if (facing == "N") {
                    facing = "W";
                    return;
                }

                if (facing == "W") {
                    facing = "S";
                    return;
                }

                if (facing == "S") {
                    facing = "E";
                    return;
                }

                facing = "N";
            }

            if(instruction == 'F'){
                if(facing == "N") {
                    position[1] = position[1] + 1;
                }

                if(facing == "E"){
                    position[0] = position[0] + 1;
                }

                if(facing == "S"){
                    position[1] = position[1] - 1;
                }

                if(facing == "W"){
                    position[0] = position[0] - 1;
                }
            }

            if(instruction == 'B'){
                if(facing == "N") {
                    position[1] = position[1] - 1;
                }

                if(facing == "E"){
                    position[0] = position[0] - 1;
                }

                if(facing == "S"){
                    position[1] = position[1] + 1;
                }

                if(facing == "W"){
                    position[0] = position[0] + 1;
                }
            }
        });
    }

    private boolean turnRight() {
        if(facing == "N") {
            facing = "E";
            return true;
        }

        if(facing == "E") {
            facing = "S";
            return true;
        }

        if(facing == "S") {
            facing = "W";
            return true;
        }

        facing = "N";
        return false;
    }
}
