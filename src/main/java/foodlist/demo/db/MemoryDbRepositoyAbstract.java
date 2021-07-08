package foodlist.demo.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDbRepositoyAbstract<T> implements MemoryDbRepositoryIfs<T> {

    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index) {
        return Optional.empty();
    }

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public void deleteById(int index) {

    }

    @Override
    public List listAll() {
        return null;
    }
}
