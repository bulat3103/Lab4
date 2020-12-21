import characters.MainHero;
import characters.Rabbit;
import enums.*;
import exceptions.NotPutException;
import exceptions.NotTakeException;
import interfaces.IdentificationStrategy;
import materialObjects.*;
import placesPackage.Place;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws NotPutException, NotTakeException {
        Place nora = new Place(Places.BURROW, 10, PlaceOrientation.HORIZONTAL);
        Rabbit rabbit = new Rabbit(Colors.WHITE, "Тиша");
        rabbit.run(nora);
        IdentificationStrategy strategy = (dir, place, currentCoordinat) -> {
            ArrayList<Furniture> seen = new ArrayList<>();
            if (dir == Direction.UP) {
                System.out.println("Я вижу выход, но не тот :)");
                return seen;
            }
            if (dir == Direction.DOWN) {
                System.out.println("Я вижу волшебную дверь. Скорее бы долететь!!!");
                return seen;
            }
            for (Furniture e : place.getFurn()) {
                if (e.getDir().toString().equals(dir.toString()) && e.getDeepCoordinat() == (int) currentCoordinat) {
                    seen.add(e);
                }
            }
            return seen;
        };
        MainHero Alice = new MainHero("Алиса", 20, Sex.GIRL, 1.0, strategy);
        Alice.lookFor(rabbit);
        Alice.Move();
        while (Alice.getCurrentCoordinat() < nora.getDeep()) {
            Alice.Move();
            if (Alice.getCurrentCoordinat() >= nora.getDeep()) break;
        }
        Place pit = new Place(Places.PIT, 12, PlaceOrientation.VERTICAL);
        Alice.setPlace(pit);
        Alice.setCurrentCoordinat(0);
        for (int i = 1; i <= pit.getDeep(); i++) {
            for (Direction dir : Direction.values()) {
                Thing rnd = Thing.randomThing();
                if (rnd == null) continue;
                Furniture furn = new Furniture.Builder()
                        .type(rnd)
                        .dir(dir)
                        .deepCoordinat(i)
                        .subjects()
                        .build();

                try {
                    Subject sbj = new Subject.Builder()
                            .type(SubjectType.randomSubject())
                            .title("")
                            .build();
                    furn.addSubject(sbj);
                } catch (NotPutException exc){
                    System.out.println(exc.getMessage());
                }
                pit.addFurn(furn);
            }
        }
        while (Alice.getCurrentCoordinat() < pit.getDeep()) {
            Alice.Move();
            if (Alice.getCurrentCoordinat() >= pit.getDeep()) break;
            Direction rndDirection = Direction.randomDirection();
            Alice.Look(rndDirection);
            ArrayList<Furniture> seen = Alice.Identificate(rndDirection);
            if (rndDirection != Direction.UP && rndDirection != Direction.DOWN) {
                if (seen.size() == 0) System.out.println("Алиса ничего не увидела");
                else {
                    for (Furniture e : seen) {
                        if (Math.random () <= 0.3 && e.getSubjects().size() != 0) {
                            try {
                                int indexTake = (int) (Math.random() * e.getSubjects().size());
                                Alice.take(e.getSubjects().get(indexTake));
                            } catch (NotTakeException exc){
                                System.out.println(exc.getMessage());
                            }
                        }
                        if (Math.random () <= 0.3) {
                            try {
                                Alice.put(e);
                            } catch (NotPutException exc) {
                                System.out.println(exc.getMessage());
                            }
                        }
                        System.out.println("Алиса увидела " + e.getType().toString());
                    }
                }
            }
        }
        Alice.say("Я молодец. Теперь я не заплачу, когда упаду в следующий раз");
    }
}
