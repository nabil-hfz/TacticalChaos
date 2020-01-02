package com.company.utilities;

import com.company.arena.Square;

import java.util.Comparator;

public class SortBySquare implements Comparator<Square> {
    @Override
    public int compare(Square square, Square t1) {
        return square.getX() - t1.getX();
    }
}
