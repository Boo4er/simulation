package com.boo4er;



public class Coordinates {
    public final File file;
    public final Integer rank;
    public Coordinates(File file, Integer rank){
        this.file=file;
        this.rank=rank;
    }
    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(File.values()[this.file.ordinal() + shift.fileShift],this.rank + shift.rankShift);
    }
}
