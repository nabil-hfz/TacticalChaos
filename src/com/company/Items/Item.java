package com.company.Items;


import com.company.champion.Champion;

public abstract class Item  {

    public int x ;
    public int y ;
    public abstract void equip(Champion champion);
    public abstract void unquip(Champion champion);

}
