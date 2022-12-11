package com.d4rkr34lm.extendedUtil;

public class Matrix{
    private int[][] values;

    public Matrix(int[][] values){
        if(values.length < 1 || values[0].length < 0) throw new ArithmeticException();
        this.values = values;
    }

    public Matrix(int width, int height){
        if(width < 1 || height < 1) throw new ArithmeticException();
        values = new int[width][height];
    }

    public Matrix add(Matrix matrix){
        if(matrix.getValues().length != values.length || matrix.getValues()[0].length != values[0].length) throw new ArithmeticException();
        int[][] newValues = new int[values.length][values[0].length];

        for(int x = 0; x < newValues.length; x++)
            for(int y = 0; y < newValues[0].length; y++)
                newValues[x][y] = values[x][y] + matrix.getValues()[x][y];
        return new Matrix(newValues);
    }

    public Matrix subtract(Matrix matrix){
        if(matrix.getValues().length != values.length || matrix.getValues()[0].length != values[0].length) throw new ArithmeticException();
        int[][] newValues = new int[values.length][values[0].length];

        for(int x = 0; x < newValues.length; x++)
            for(int y = 0; y < newValues[0].length; y++)
                newValues[x][y] = values[x][y] - matrix.getValues()[x][y];
        return new Matrix(newValues);
    }

    public Matrix multiply(Matrix matrix){
        if(values.length != matrix.getValues()[0].length) throw new ArithmeticException();

        int[][] newValues = new int[matrix.getValues().length][values[0].length];

        for(int x = 0; x < newValues.length; x++){
            for(int y = 0; y < newValues[0].length; y++){
                int newValue = 0;
                for(int n = 0; n < values.length; n++)
                    newValue += values[n][y] * values[x][y];
                newValues[x][y] = newValue;
            } 
        }  
        return new Matrix(newValues);
    }

    public Matrix multiply(int c){
        int [][] newValues = new int[values.length][values[0].length];
        for(int x = 0; x < values.length; x++)
            for(int y = 0; y < values[0].length; y++)
                newValues[x][y] = values[x][y] * c;
        return new Matrix(newValues);
    }

    public Matrix pow(int e){
        Matrix newMatrix = this;
        for(int n = 1; n < e; n++){
            newMatrix = newMatrix.multiply(this);
        }
        return newMatrix;
    }

    public int[][] getValues(){
        return values;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int[] row : values){
            for(int value : row)
                ret += value + ", ";
            ret += "\n";
        }
        return ret;
    }
}