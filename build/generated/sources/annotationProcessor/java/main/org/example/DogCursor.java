package org.example;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.annotation.apihint.Internal;
import io.objectbox.internal.CursorFactory;

// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.

/**
 * ObjectBox generated Cursor implementation for "Dog".
 * Note that this is a low-level class: usually you should stick to the Box class.
 */
public final class DogCursor extends Cursor<Dog> {
    @Internal
    static final class Factory implements CursorFactory<Dog> {
        @Override
        public Cursor<Dog> createCursor(io.objectbox.Transaction tx, long cursorHandle, BoxStore boxStoreForEntities) {
            return new DogCursor(tx, cursorHandle, boxStoreForEntities);
        }
    }

    private static final Dog_.DogIdGetter ID_GETTER = Dog_.__ID_GETTER;


    private final static int __ID_age = Dog_.age.id;
    private final static int __ID_gender = Dog_.gender.id;
    private final static int __ID_noOfTeeth = Dog_.noOfTeeth.id;

    public DogCursor(io.objectbox.Transaction tx, long cursor, BoxStore boxStore) {
        super(tx, cursor, Dog_.__INSTANCE, boxStore);
    }

    @Override
    public long getId(Dog entity) {
        return ID_GETTER.getId(entity);
    }

    /**
     * Puts an object into its box.
     *
     * @return The ID of the object within its box.
     */
    @Override
    public long put(Dog entity) {
        Integer age = entity.getAge();
        int __id1 = age != null ? __ID_age : 0;

        long __assignedId = collect004000(cursor, entity.id, PUT_FLAG_FIRST | PUT_FLAG_COMPLETE,
                __id1, __id1 != 0 ? age : 0, __ID_noOfTeeth, entity.getNoOfTeeth(),
                __ID_gender, entity.getGender(), 0, 0);

        entity.id = __assignedId;

        return __assignedId;
    }

}
