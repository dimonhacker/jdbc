package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.Address;
import entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {
    Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Insert into EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID ) values (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<>();
        Statement statement = null;
        String sql = "Select * from EMPL_PROJ";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));
                emplProjList.add(emplProj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return emplProjList;
    }

    @Override
    public EmplProj getByEmplIdProjId(long emplId, long projId) throws SQLException {
        EmplProj emplProj = new EmplProj();
        PreparedStatement preparedStatement = null;
        String sql = "Select * from EMPL_PROJ where EMPLOYEE_ID = ? and PROJECT_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplId);
            preparedStatement.setLong(2, projId);
            ResultSet resultSet = preparedStatement.executeQuery();
            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj, long emplId, long projId) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Update EMPL_PROJ SET  EMPLOYEE_ID=?, PROJECT_ID=? where EMPLOYEE_ID=? and PROJECT_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());
            preparedStatement.setLong(3, emplId);
            preparedStatement.setLong(4, projId);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Delete from EMPL_PROJ where EMPLOYEE_ID = ? and PROJECT_ID=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
}
