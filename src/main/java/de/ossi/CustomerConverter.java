package de.ossi;

import de.ossi.annotation.SingleResponsibility;
import de.ossi.data.AddressDTO;
import de.ossi.data.CustomerDTO;
import de.ossi.data.CustomerEntity;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;
import java.util.function.BiFunction;

@SingleResponsibility
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CustomerConverter implements BiFunction<CustomerEntity, String, CustomerDTO> {

    private final AddressConverter addressConverter;


    @Override
    public CustomerDTO apply(CustomerEntity customerEntity, String s) {
        List<AddressDTO> addressDTOS = customerEntity.addresses()
                                                     .stream()
                                                     .map(a -> addressConverter.apply(a, s, Integer.valueOf(s)))
                                                     .toList();
        return new CustomerDTO(customerEntity.name(), "customer" + s, addressDTOS);
    }
}
