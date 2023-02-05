package de.ossi.data;

import java.util.List;

public record CustomerEntity(String name, int id, String password, List<AddressEntity> addresses) {
}
