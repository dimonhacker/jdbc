import bl.Util;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class Domain {
    public static void main(String[] args) {
        AddressService addressService;
        Address address = new Address();
        address.setId(2);
        address.setCountry("Russia");
        address.setCity("Vologda");
        address.setStreet("Leningradskaya");
        address.setPostCode("160000");
        addressService = new AddressService();
        try {
            //addressService.add(address);
            List<Address> addressList= addressService.getAll();
            System.out.println(addressList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
