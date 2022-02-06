package com.greatlearning.gradedassignment3;

import java.util.Scanner;

class Floor {
    private int floorIndex;
    private int floorSize;

    public Floor(int floorIndex, int floorSize) {
        this.floorIndex = floorIndex;
        this.floorSize = floorSize;
    }

    public int getFloorIndex() {
        return floorIndex;
    }

    public int getFloorSize() {
        return floorSize;
    }
}

class BuildingFloors {
    private int size;
    private Floor skyscraperFloors[];

    public BuildingFloors(int size) {
        this.size = size;
        skyscraperFloors = new Floor[size];
    }

    public void setFloors(int index, int value) {
        skyscraperFloors[index] = new Floor(index, value);
    }

    public void bubbleSortFloors() {
        Floor temp;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size - 1; j++)
                if (skyscraperFloors[j].getFloorSize() <= skyscraperFloors[j + 1].getFloorSize()) {
                    temp = skyscraperFloors[j];
                    skyscraperFloors[j] = skyscraperFloors[j + 1];
                    skyscraperFloors[j + 1] = temp;
                }

    }

    public void getBuildingFloorAssembly() {
        System.out.println("The order of construction is as follows");
        int j = 0;
        for (int i = 0; i < size; i++) {
            System.out.println("\nDay: " + (i + 1));
            while (j < size && i >= skyscraperFloors[j].getFloorIndex())
                System.out.print(skyscraperFloors[j++].getFloorSize() + " ");
        }
        System.out.println();
    }
}

public class Skyscraper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no of floors in the building:");
        int floorCount = sc.nextInt();
        BuildingFloors bFloors = new BuildingFloors(floorCount);

        for (int i = 0; i < floorCount; i++) {
            System.out.println("Enter the floor size given on day : " + (i + 1));
            bFloors.setFloors(i, sc.nextInt());
        }

        bFloors.bubbleSortFloors();
        bFloors.getBuildingFloorAssembly();

        sc.close();
    }
}
