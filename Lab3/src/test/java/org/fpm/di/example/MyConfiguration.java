package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.Wonders.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

///////////////////////////////////////////////////////////////

        binder.bind(Buildings.class);
        binder.bind(Colosseum.class);
        binder.bind(WondersOfTheWorld.class);

        binder.bind(Island.class, KomodoIsland.class);
        binder.bind(KomodoIsland.class, new KomodoIsland());

    }
}
