package de.ossi;

import de.ossi.annotation.SingleResponsibility;
import de.ossi.data.AddressDTO;
import de.ossi.data.AddressEntity;

@SingleResponsibility
public class AddressConverter implements TriFunction<AddressEntity, String, Integer, AddressDTO> {

    @Override
    public AddressDTO apply(AddressEntity addressEntity, String s, Integer integer) {
        return new AddressDTO(addressEntity.street(), addressEntity.city(), "address" + s, integer);
    }

    private void test() {
        
    }
}
