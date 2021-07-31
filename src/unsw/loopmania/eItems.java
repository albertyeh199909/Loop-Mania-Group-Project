package unsw.loopmania;

public enum eItems {
    Sword,
    Staff,
    Stake,
    Armour,
    Helmet,
    Shield,
    Potion,
    TheRing,
    Anduril,
    TreeStump
}

/*
        BasicItem item = null;
        int value = new Random().nextInt(7);
        if(value == 0)
            item = new Sword(20, "Sword",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 1)
            item = new Staff(20, "Staff",150, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 2)
            item = new Stake(20, "Stake",250, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 3)
            item = new Armour(20, "Armour",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if (value ==4)
            item = new Helmet(20, "Helmet",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 5)
            item = new Shield(20, "Shield",300, firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else if(value == 6)
            item = new Potion(20, "Potion",200,firstAvailableSlot.getValue0(),firstAvailableSlot.getValue1());
        else
            System.out.println("EXCEPTION erros at line around 550 filename: World");

        //check if inventory is full, then remove the first item
        */