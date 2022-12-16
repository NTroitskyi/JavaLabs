package org.fpm.di.Wonders;
import javax.inject.Inject;


public class Wonders {
    private WondersOfTheNature nat;
    private WondersOfTheWorld wor;

    @Inject
    public Wonders(WondersOfTheWorld wor, WondersOfTheNature nat){
        this.nat = nat;
        this.wor = wor;
    }

    public WondersOfTheNature getNature(){
        return nat;
    }

    public WondersOfTheWorld getWorld(){
        return wor;
    }
}
