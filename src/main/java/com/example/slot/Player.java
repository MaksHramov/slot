package com.example.slot;

public class Player {

    private String name;

    private Integer count;

    private Integer number;

    public Player(String name, Integer number){

        this.name = name;

        this.number = number;

        count = 0;

    }

    public boolean pay(Integer number){

        if(number <= this.number){

            this.number -= number;

            count++;

            return true;

        }

        return false;

    }

    public void addNumber(Integer number){

        this.number += number;

    }

    public Integer getCount(){

        return count;

    }

    public Integer getNumber(){

        return number;

    }

}