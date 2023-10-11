package dao.impl;

import dao.OfficeDAO;
import model.Office;
import util.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class OfficeDAOImpl implements OfficeDAO {
    @Override
    public boolean createOffice(Office office) {
        Connection connection = DBUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO offices (title, address, `phone 1`, `phone 2`, postal_code, created_ts) "
                    + "VALUES ('" + office.getTitle() + "', '" + office.getAddress()
                    + "', '" + office.getPhone1() + "', '" + office.getPhone2() + "', '"
                    + office.getPostalCode() + "', CURRENT_TIMESTAMP)";
            int count = statement.executeUpdate(sql);
            return count == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Office findById(int id) {
        Connection connection = DBUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM offices where id =" + id);
            if (rs.next()) {
                Office office = new Office();
                office.setId(id);
                office.setTitle(rs.getString("title"));
                office.setAddress(rs.getString("address"));
                office.setPhone1(rs.getString("phone 1"));
                office.setPhone2(rs.getString("phone 2"));
                office.setPostalCode(rs.getInt("postal_code"));
                office.setCreatedTS(rs.getTimestamp("created_ts"));
                office.setUpdatedTS(rs.getTimestamp("updated_ts"));
                return office;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean updateOffice(Office office) {
        return false;
    }

    @Override
    public Set<Office> all() {
        Set<Office> offices = new HashSet<>();
        Connection connection = DBUtils.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM offices");
            while (rs.next()) {
                Office office = new Office();
                office.setId(rs.getInt("id"));
                office.setTitle(rs.getString("title"));
                office.setAddress(rs.getString("address"));
                office.setPhone1(rs.getString("phone 1"));
                office.setPhone2(rs.getString("phone 2"));
                office.setPostalCode(rs.getInt("postal_code"));
                office.setCreatedTS(rs.getTimestamp("created_ts"));
                office.setUpdatedTS(rs.getTimestamp("updated_ts"));
                offices.add(office);
            }
            return offices;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
