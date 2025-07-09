package com.tcg.backend.repositories;

import com.tcg.backend.entities.UbicacionEntity;
import java.util.List;

public interface UbicacionRepository {

    // CREATE

    UbicacionEntity CreateLocation(UbicacionEntity ubicacion);

    // READ

    List<UbicacionEntity> AllLocations();

    UbicacionEntity Location_for_id(int id_ubicacion);

    // UPDATE

    UbicacionEntity UpdateLocation(UbicacionEntity ubicacion, int id_ubicacion);

    // DELETE

    void DeleteLocation(int id_ubicacion);

}

