package org.fpm.di.Wonders;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class WondersOfTheNature {
    private KomodoIsland komo; //and the others...

    @Inject
    public WondersOfTheNature(KomodoIsland komo){
        this.komo = komo;
    }

    public KomodoIsland getKomoIsland(){
        return komo;
    }
}
