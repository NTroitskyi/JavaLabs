package org.fpm.di.Wonders;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WondersOfTheWorld extends Buildings{
    private Colosseum col;
    private GreatWallOfChina gw;
    private Petra pet;
    private TajMahal tm;
    //and the others...
    @Inject
    public WondersOfTheWorld(Colosseum col, GreatWallOfChina gw, Petra pet, TajMahal tm){
        this.col = col;
        this.gw = gw;
        this.pet = pet;
        this.tm = tm;
    }

    public Colosseum getColosseum(){
        return col;
    }
    public GreatWallOfChina getGreatWallOfChina(){
        return gw;
    }
    public Petra getPetra(){
        return pet;
    }
    public TajMahal getTajMahal(){
        return tm;
    }
}
