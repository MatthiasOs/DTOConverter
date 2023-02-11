package de.ossi;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.ossi.data.AddressDTO;
import de.ossi.data.CustomerDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ServerIntegrationTest {

    @Test
    void converterShouldConvertToDTOs() {
        //given
        Injector injector = Guice.createInjector();
        Server uut = injector.getInstance(Server.class);
        //when
        List<CustomerDTO> allCustomers = uut.getAllCustomer();
        //then
        assertThat(allCustomers).usingRecursiveFieldByFieldElementComparator()
                                .isEqualTo(expectedDTOs);

    }

    private final List<CustomerDTO> expectedDTOs = List.of(
            new CustomerDTO("1", "customer1", List.of(new AddressDTO("street1", "city1", "address1", 1))),
            new CustomerDTO("2", "customer2", List.of(new AddressDTO("street2", "city2", "address2", 2))),
            new CustomerDTO("3", "customer3", List.of(new AddressDTO("street31", "city31", "address3", 3),
                    new AddressDTO("street32", "city32", "address3", 3)))

    );
}