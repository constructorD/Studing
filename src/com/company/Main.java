package com.company;

public class Main {
    public static void main(String[] args) {


        Worker workerTwo = new Worker("workerTwo", 50, 3,5);

        Solder solderOne = new Solder("solderOne", 100, 50,15);

        Wizard wizardOne = new Wizard("wizardOne", 60, 10,5);

        workerTwo.speach();
        wizardOne.speach();
        solderOne.speach();

        wizardOne.throwFireBall(solderOne);
        solderOne.speach();

        solderOne.attack(wizardOne);
        wizardOne.speach();

        wizardOne.throwFireBall(solderOne);
        solderOne.speach();

        workerTwo.buildHouse();
    }
    static abstract class Personage{
        String name;
        int health;
        int armor;
        int attack;
        String text;
        Personage(String name, int health, int armor, int attack){
            this.name = name;
            this.health = health;
            this.armor = armor;
            this.attack = attack;
        }
        void speach(){
            if(health > 0) {
                System.out.println(text + name + ". My health, armor, attack: " + health + ", " + armor + ", " + attack);
            }
            else {
                System.out.println(name + " is dead.");
            }
        }
        void attack(Personage personage){

            if(personage.armor > 0) {
                personage.armor = personage.armor - attack;
                if (personage.armor < 0){
                    personage.health = personage.health + personage.armor;
                    personage.armor = 0;
                }
            }
            else {
                personage.health = personage.health - attack;
            }
            System.out.println(name + " hit " + personage.name + " -" + attack + " points");
        }
    }
    static class Worker extends Personage implements Constructor{
        Worker(String name, int health, int armor, int attack){
            super(name, health, armor, attack);
            text = "Hello I'm ";
        }

        public void buildHouse() {
            System.out.println("Construction complete!!!...");
            System.out.println("___##___");
            System.out.println("__####__");
            System.out.println("_##  ##_");
            System.out.println("_#    #_");
            System.out.println("_# 88 #_");
            System.out.println("_# 88 #_");
            System.out.println("_#____#_");
        }
    }
    static class Solder extends Personage{
        Solder(String name, int health, int armor, int attack){
            super(name, health, armor, attack);
            text = "Sir!Report by ";
        }

        @Override
        void attack(Personage personage) {
            super.attack(personage);
            super.attack(personage);
        }
    }
    static class Wizard extends Personage implements FireBall{
        Wizard(String name, int health, int armor, int attack){
            super(name, health, armor, attack);
            text = "Greetings Lord, I'm ";
        }

        @Override
        void attack(Personage personage) {
            //super.attack(personage);
            throwFireBall(personage);
        }

        public void throwFireBall(Personage personage) {
            personage.health = personage.health - 50;
            System.out.println(name + " throw fireball in " + personage.name + " -50 points");
            super.attack(personage);
        }
    }
    interface Constructor{
         void buildHouse();
    }
    interface FireBall{
         void throwFireBall(Personage personage);
    }
    public interface Interface1 {

        void method1(String str);

        default void log(String str){
            System.out.println("Метод по умолчанию. Логгируем: " + str);
        }
    }
}
