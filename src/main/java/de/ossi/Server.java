package de.ossi;

import de.ossi.data.AddressEntity;
import de.ossi.data.CustomerDTO;
import de.ossi.data.CustomerEntity;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor(onConstructor_ = @Inject)
public class Server {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final CustomerConverter customerConverter;

    public List<CustomerDTO> getAllCustomer() {
        return allCustomersDB.stream()
                             .map(e -> customerConverter.apply(e, "" + atomicInteger.incrementAndGet()))
                             .toList();
    }

    private final List<CustomerEntity> allCustomersDB = List.of(
            new CustomerEntity("1", 1, "password1", List.of(new AddressEntity(true, "street1", "city1"))),
            new CustomerEntity("2", 2, "password2", List.of(new AddressEntity(false, "street2", "city2"))),
            new CustomerEntity("3", 3, "password3", List.of(new AddressEntity(true, "street31", "city31"), new AddressEntity(true, "street32", "city32"))));
}
