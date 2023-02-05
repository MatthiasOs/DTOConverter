package de.ossi;

import de.ossi.data.AddressDTO;
import de.ossi.data.AddressEntity;

public class AddressConverter implements TriFunction<AddressEntity, String, Integer, AddressDTO> {

    @Override
    public AddressDTO apply(AddressEntity addressEntity, String s, Integer integer) {
        return new AddressDTO(addressEntity.street(), addressEntity.city(), "address" + s, integer);
    }

    //TODO extra public Method! -> doesnt conform Single Responsibility Principle
    public String exe() {
        return "";
    }
}
