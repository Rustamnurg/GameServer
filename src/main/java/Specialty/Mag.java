package Specialty;


import Gameplay.Gameplay;

/**
 * Created by Rustam on 16.12.16.
 */
public class Mag {
    String abilities = "";
    String feedback = "";
    int healthFirst = Gameplay.getInstance().getHealthFirst();
    int healthSecond = Gameplay.getInstance().getHealthSecond();
    public String blow(String enemy){

     switch (enemy){
         case "Mag":
             enemyMag();
             break;
         case "Wars":
             enemyWars();
             break;
         case "Hunter":
             enemyHunter();
             break;
     }
        Gameplay.getInstance().setHealthFirst(healthFirst);
        Gameplay.getInstance().setHealthSecond(healthSecond);
        return feedback;
    }


    public void enemyMag(){

        double damage = 60  +  (Math.random() *20);
        if(Math.random() * 2 == 1){
            healthFirst -= damage;
            abilities = "урон отражен";
        }
        else {
            healthSecond -= damage;
            abilities = "урон нанесен";
        }
        feedback = "Маг -> Маг " + abilities + " нанесено " + damage;


    }

    public void enemyWars(){
        double damage = 30  +  (Math.random() *30);
        if(Math.random() * 2 == 1){
            damage = damage * 1.5;
            abilities += "урон увеличин ";
        }
        if(Math.random() * 2 == 1){
            healthFirst -= damage;
            abilities += "урон отражен ";
        }
        else {
            healthSecond -= damage;
            abilities += "урон нанесен ";
        }
        feedback = "Воин -> Маг " + abilities + " нанесено " + damage;

    }


    public void enemyHunter(){
        double damage = 30  +  (Math.random() *30);
        if(Math.random() * 2 == 1){
            abilities += "урон отражен ";
            if(Math.random() * 2 == 1){
                damage = 0;
                abilities += "урон укланен ";
            }
            healthSecond -= damage;
        }
        else {
            healthSecond -= damage;
            abilities += "урон нанесен ";
        }

        feedback = "Лучник -> Маг " + abilities + " нанесено " + damage;

    }
}
