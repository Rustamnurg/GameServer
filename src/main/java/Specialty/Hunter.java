package Specialty;

import Gameplay.Gameplay;

/**
 * Created by Rustam on 16.12.16.
 */
public class Hunter {
    String abilities = "";
    String feedback = "";
    int healthFirst = Gameplay.getInstance().getHealthFirst();
    int healthSecond = Gameplay.getInstance().getHealthSecond();

    public String blow(String enemy) {

        switch (enemy) {
            case "Hunter":
                enemyHunter();
                break;
            case "Mag":
                enemyMag();
                break;
            case "Wars":
                enemyWars();
                break;
        }
        Gameplay.getInstance().setHealthFirst(healthFirst);
        Gameplay.getInstance().setHealthSecond(healthSecond);
        return feedback;
    }


    public void enemyMag() {
        double damage = 60 + (Math.random() * 20);
        if (Math.random() * 2 == 1) {
            damage = 0;
            abilities = "урон укланен";
        } else {
            healthSecond -= damage;
            abilities = "урон нанесен";
        }
        feedback = "Маг -> Лучник " + abilities + " нанесено " + damage;


    }

    public void enemyWars() {
        double damage = 30 + (Math.random() * 30);
        if (Math.random() * 2 == 1) {
            damage = damage * 1.5;
            abilities += "урон увеличин ";
        }
        if (Math.random() * 2 == 1) {
            damage = 0;
            abilities = "урон укланен";
        } else {
            healthSecond -= damage;
            abilities += "урон нанесен ";
        }
        feedback = "Воин -> Лучник " + abilities + " нанесено " + damage;

    }


    public void enemyHunter() {
        double damage = 30 + (Math.random() * 30);
        if (Math.random() * 2 == 1) {
            damage = 0;
            abilities = "урон укланен";
        } else {
            healthSecond -= damage;
            abilities = "урон нанесен";
        }
        feedback = "Лучник -> Лучник " + abilities + " нанесено " + damage;


    }
}