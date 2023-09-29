package repositories;

import connection.Connect;

import models.GrantAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrantAccessRepository {
    public List<GrantAccess> getAll() {
        String sql = "select * from grant_access";
        List<GrantAccess> grantAccesses = new ArrayList<>();
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GrantAccess grantAccess = new GrantAccess();
                grantAccess.setRoles_id(rs.getString(1));
                grantAccess.setAccount_id(rs.getString(2));
                grantAccess.setIs_grant(rs.getBoolean(3));
                grantAccess.setNote(rs.getString(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grantAccesses;
    }

    public boolean insert(GrantAccess grantAccess){
        String sql = "insert into grant_access(role_id, account_id, is_grant, note)values(?,?,?,?) ";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,grantAccess.getRoles_id());
            ps.setString(2, grantAccess.getAccount_id());
            ps.setBoolean(3, grantAccess.isIs_grant());
            ps.setString(4, grantAccess.getNote());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(GrantAccess grantAccess){
        String sql = "update grant_access set account_id=?, is_grant=?, note=? where role_id=?";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, grantAccess.getAccount_id());
            ps.setBoolean(2, grantAccess.isIs_grant());
            ps.setString(3, grantAccess.getNote());
            ps.setString(4, grantAccess.getRoles_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean delete (Long id){
        String sql = "delete from grant_access where  role_id = ?";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public GrantAccess findById(String id) {
        String sql = "select * from grant_access where role_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GrantAccess grantAccess = new GrantAccess();
                grantAccess.setRoles_id(rs.getString(1));
                grantAccess.setAccount_id(rs.getString(2));
                grantAccess.setIs_grant(rs.getBoolean(3));
                grantAccess.setNote(rs.getString(4));
                return grantAccess;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
