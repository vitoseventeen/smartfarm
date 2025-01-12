package cz.cvut.fel.omo.smartfarm.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BaseFactory<T> implements Factory<T> {
    protected final Map<String, Supplier<T>> registry = new HashMap<>();

    public void register(String type, Supplier<T> supplier) {
        registry.put(type.toLowerCase(), supplier);
    }


    @Override
    public T create(String type) {
        Supplier<T> supplier = registry.get(type.toLowerCase());
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown type: " + type);
        }
        return supplier.get();
    }

}
