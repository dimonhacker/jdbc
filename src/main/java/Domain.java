import bl.Util;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {
        AddressService addressService;
        Address address = new Address();
        address.setId(3);
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Levicheva");
        address.setPostCode("160000");

        try {
            addressService = new AddressService();
            addressService.add(address);
            addressService = new AddressService();
            List<Address> addressList= addressService.getAll();
            System.out.println(addressList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
