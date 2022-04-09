package service;

import bl.Util;
import dao.ProjectDAO;
import entity.Address;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Util implements ProjectDAO {
    Connection connection = getConnection();
    @Override
    public void add(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Insert into PROJECT (ID, TITLE) values (?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public List<Project> getAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        Statement statement = null;
        String sql = "Select * from Project";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));
                projectList.add(project);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return projectList;
    }

    @Override
    public Project getById(long id) throws SQLException {
        Project project = new Project();
        PreparedStatement preparedStatement = null;
        String sql = "Select * from PROJECT where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return project;
    }

    @Override
    public void update(Project project) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "Update PROJECT SET  TITLE=? where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void remove(Project project) {
        PreparedStatement preparedStatement = null;
        String sql = "Delete from PROJECT where ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,project.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
