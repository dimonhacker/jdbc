package service;

import bl.Util;
import dao.AddressDAO;
import entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Util implements AddressDAO {

    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql ="Insert into Address (ID, COUNTRY, CITY, STREET, POST_CODE values (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2,address.getCountry());
            preparedStatement.setString(3,address.getCity());
            preparedStatement.setString(4,address.getStreet());
            preparedStatement.setString(5,address.getPostCode());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(preparedStatement!=null)preparedStatement.close();
            if (connection!=null)connection.close();
        }
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addressList = new ArrayList<>();
        Statement statement = null;
        String sql = "Select * from Address";
        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));
                addressList.add(address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(statement!=null)statement.close();
            if(connection!=null)connection.close();
        }
        return addressList;
    }

    @Override
    public Address getById(long id) throws SQLException {
        Address address = new Address();
        PreparedStatement preparedStatement = null;
        String sql ="Select * from Address where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            address.setId(resultSet.getLong("ID"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setPostCode(resultSet.getString("POST_CODE"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(preparedStatement!=null)preparedStatement.close();
            if (connection!=null)connection.close();
        }
        return address;
    }

    @Override
    public void update(Address address) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql ="Update ADDRESS SET  COUNTRY=?, CITY=?, STREET=?, POST_CODE=? where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,address.getCountry());
            preparedStatement.setString(2,address.getCity());
            preparedStatement.setString(3,address.getStreet());
            preparedStatement.setString(4,address.getPostCode());
            preparedStatement.setLong(5,address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if(preparedStatement!=null)preparedStatement.close();
            if (connection!=null)connection.close();
        }

    }

    @Override
    public void remove(Address address) throws SQLException {
        PreparedStatement preparedStatement =null;
        String sql = "Delete from Address where ID = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(preparedStatement!=null)preparedStatement.close();
            if (connection!=null)connection.close();
        }
    }
}
