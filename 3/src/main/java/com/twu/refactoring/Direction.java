package com.twu.refactoring;

public class Direction {
    private final char direction;
    private char[] DIRECTION = {'N', 'E', 'S' , 'W'};

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turn(boolean left){
        switch (direction) {
            case 'N':
                return new Direction(left? DIRECTION[3]:DIRECTION[1]);
            case 'S':
                return new Direction(left? DIRECTION[1]:DIRECTION[3]);
            case 'E':
                return new Direction(DIRECTION[0]);
            case 'W':
                return new Direction(DIRECTION[2]);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
