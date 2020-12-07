package _01_AnimalFarm;

import java.util.ArrayList;

public class Farm {
	
public static void main(String[] args) {
	Dog dog = new Dog();
	Sheep sheep = new Sheep();
	Cow cow = new Cow();
	Pig pig = new Pig();
	ArrayList<Animal> farm = new ArrayList<Animal>();
	farm.add(dog);
	farm.add(sheep);
	farm.add(cow);
	farm.add(pig);
	for (int i = 0; i < farm.size(); i++) {
		System.out.println(farm.get(i).makeNoise());
		System.out.println(farm.get(i).favoriteFood());
	}
}
}
