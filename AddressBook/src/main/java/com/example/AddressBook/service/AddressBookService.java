package com.example.AddressBook.service;

import com.example.AddressBook.dto.AddressBookDTO;
import com.example.AddressBook.model.AddressBookModel;
import org.springframework.stereotype.Service;



@Service
public class AddressBookService {

    private final List<AddressBookModel> addressList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public AddressBookModel saveAddress(AddressBookDTO dto) {
        AddressBookModel address = new AddressBookModel();
        address.setId(idCounter.getAndIncrement()); // Assign a unique ID
        address.setName(dto.getName());
        address.setPhone(dto.getPhone());
        address.setEmail(dto.getEmail());
        addressList.add(address);
        return address;
    }

    }
    // Get address by ID
    public Optional<AddressBookModel> getAddressById(Long id) {
        return addressList.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    // Update address by ID
    public Optional<AddressBookModel> updateAddress(Long id, AddressBookDTO dto) {
        return getAddressById(id).map(existingAddress -> {
            existingAddress.setName(dto.getName());
            existingAddress.setPhone(dto.getPhone());
            existingAddress.setEmail(dto.getEmail());
            return existingAddress;
        });
    }

    // Delete address by ID
    public boolean deleteAddress(Long id) {
        return addressList.removeIf(address -> address.getId().equals(id));
    }

}
