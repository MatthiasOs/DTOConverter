package de.ossi.data;

import java.util.List;

public record CustomerDTO(String name, String additionalString, List<AddressDTO> addressesDTO) {
}
