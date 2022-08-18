
package org.example;

import io.objectbox.BoxStore;
import io.objectbox.BoxStoreBuilder;
import io.objectbox.ModelBuilder;
import io.objectbox.ModelBuilder.EntityBuilder;
import io.objectbox.model.PropertyFlags;
import io.objectbox.model.PropertyType;

// THIS CODE IS GENERATED BY ObjectBox, DO NOT EDIT.
/**
 * Starting point for working with your ObjectBox. All boxes are set up for your objects here.
 * <p>
 * First steps (Android): get a builder using {@link #builder()}, call {@link BoxStoreBuilder#androidContext(Object)},
 * and {@link BoxStoreBuilder#build()} to get a {@link BoxStore} to work with.
 */
public class MyObjectBox {

    public static BoxStoreBuilder builder() {
        BoxStoreBuilder builder = new BoxStoreBuilder(getModel());
        builder.entity(Animal_.__INSTANCE);
        builder.entity(Dog_.__INSTANCE);
        builder.entity(LameDog_.__INSTANCE);
        return builder;
    }

    private static byte[] getModel() {
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.lastEntityId(3, 6999963512808324211L);
        modelBuilder.lastIndexId(0, 0L);
        modelBuilder.lastRelationId(0, 0L);

        buildEntityAnimal(modelBuilder);
        buildEntityDog(modelBuilder);
        buildEntityLameDog(modelBuilder);

        return modelBuilder.build();
    }

    private static void buildEntityAnimal(ModelBuilder modelBuilder) {
        EntityBuilder entityBuilder = modelBuilder.entity("Animal");
        entityBuilder.id(1, 2005637749772739563L).lastPropertyId(3, 1672369363295964998L);

        entityBuilder.property("id", PropertyType.Long).id(1, 1056689899923680231L)
                .flags(PropertyFlags.ID | PropertyFlags.ID_SELF_ASSIGNABLE);
        entityBuilder.property("age", PropertyType.Int).id(2, 1156670538878602834L)
                .flags(PropertyFlags.NON_PRIMITIVE_TYPE);
        entityBuilder.property("gender", PropertyType.Char).id(3, 1672369363295964998L);


        entityBuilder.entityDone();
    }

    private static void buildEntityDog(ModelBuilder modelBuilder) {
        EntityBuilder entityBuilder = modelBuilder.entity("Dog");
        entityBuilder.id(2, 8658722619858073457L).lastPropertyId(4, 6405125806048295383L);
        entityBuilder.flags(io.objectbox.model.EntityFlags.USE_NO_ARG_CONSTRUCTOR);

        entityBuilder.property("id", PropertyType.Long).id(1, 4962583415842172854L)
                .flags(PropertyFlags.ID | PropertyFlags.ID_SELF_ASSIGNABLE);
        entityBuilder.property("age", PropertyType.Int).id(2, 5168088255912766233L)
                .flags(PropertyFlags.NON_PRIMITIVE_TYPE);
        entityBuilder.property("gender", PropertyType.Char).id(3, 585871991091991538L);
        entityBuilder.property("noOfTeeth", PropertyType.Int).id(4, 6405125806048295383L);


        entityBuilder.entityDone();
    }

    private static void buildEntityLameDog(ModelBuilder modelBuilder) {
        EntityBuilder entityBuilder = modelBuilder.entity("LameDog");
        entityBuilder.id(3, 6999963512808324211L).lastPropertyId(4, 8151094282998827260L);
        entityBuilder.flags(io.objectbox.model.EntityFlags.USE_NO_ARG_CONSTRUCTOR);

        entityBuilder.property("id", PropertyType.Long).id(1, 8450147586450920021L)
                .flags(PropertyFlags.ID | PropertyFlags.ID_SELF_ASSIGNABLE);
        entityBuilder.property("age", PropertyType.Int).id(2, 5383190571862716645L)
                .flags(PropertyFlags.NON_PRIMITIVE_TYPE);
        entityBuilder.property("gender", PropertyType.Char).id(3, 6811390144953371060L);
        entityBuilder.property("noOfLegs", PropertyType.Int).id(4, 8151094282998827260L);


        entityBuilder.entityDone();
    }


}
