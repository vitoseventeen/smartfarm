package cz.cvut.fel.omo.smartfarm.factory;

public interface Factory<T> {

    T create(String type);

}
