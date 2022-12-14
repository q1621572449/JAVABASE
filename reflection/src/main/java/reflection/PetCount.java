package reflection;

import reflection.pets.*;
import java.util.*;

class PetCounter {
    static class Counter extends HashMap<String,Integer> {//重写hashmap
        public void count(String type) {//新增count方法。
            Integer quantity = get(type);
            if(quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }
    private Counter counter = new Counter();
    private void countPet(Pet pet) {
        System.out.print(
                pet.getClass().getSimpleName() + " ");
        if(pet instanceof Pet)
            counter.count("Pet");
        if(pet instanceof Dog)
            counter.count("Dog");
        if(pet instanceof Mutt)
            counter.count("Mutt");
        if(pet instanceof Pug)
            counter.count("Pug");
        if(pet instanceof Cat)
            counter.count("Cat");
        if(pet instanceof EgyptianMau)
            counter.count("EgyptianMau");
        if(pet instanceof Manx)
            counter.count("Manx");
        if(pet instanceof Cymric)
            counter.count("Cymric");
        if(pet instanceof Rodent)
            counter.count("Rodent");
        if(pet instanceof Rat)
            counter.count("Rat");
        if(pet instanceof Mouse)
            counter.count("Mouse");
        if(pet instanceof Hamster)
            counter.count("Hamster");
    }
    public void count(Creator creator) {
        creator.stream().limit(20)
                .forEach(pet -> countPet(pet));
        System.out.println();
        System.out.println(counter);
    }
    public static void main(String[] args) {
        new PetCounter().count(new ForNamePetCreator());
    }
}
/* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat
EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse
Pug Mouse Cymric
{EgyptianMau=2, Pug=3, Rat=2, Cymric=5, Mouse=2, Cat=9,
Manx=7, Rodent=5, Mutt=3, Dog=6, Pet=20, Hamster=1}
*/
