package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.Wonders.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void T1(){
        WondersOfTheNature nature = container.getComponent(WondersOfTheNature.class);
        Wonders wonders = container.getComponent(Wonders.class);
        assertSame(wonders.getNature().getKomoIsland(), nature.getKomoIsland());
    }

    @Test
    public void T2(){
        Buildings building1 = container.getComponent(Buildings.class);
        Buildings building2 = container.getComponent(Buildings.class);
        assertNotSame(building1, building2);
    }

    @Test
    public void T3(){
        WondersOfTheWorld world1 = container.getComponent(WondersOfTheWorld.class);
        WondersOfTheWorld world2 = container.getComponent(WondersOfTheWorld.class);
        assertSame(world1.getColosseum(), world2.getColosseum());
        assertSame(world1, world2);
    }

    @Test
    public void T4(){
        Wonders wonders = container.getComponent(Wonders.class);
        assertSame(wonders.getWorld().getColosseum(), container.getComponent(Colosseum.class));
        assertSame(wonders.getWorld().getPetra(), container.getComponent(Petra.class));
        assertSame(wonders.getWorld().getGreatWallOfChina(), container.getComponent(GreatWallOfChina.class));
        assertSame(wonders.getWorld().getTajMahal(), container.getComponent(TajMahal.class));
    }

    @Test
    public void T5(){
        KomodoIsland komodoIsland = container.getComponent(KomodoIsland.class);
        assertSame(container.getComponent(KomodoIsland.class), komodoIsland);
        assertSame(container.getComponent(Island.class), komodoIsland);
    }
}
