package repositories;

import connection.Connect;
import models.GrantAccess;
import models.Roles;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public List<Roles> getAll() {
        String sql = "select * from role";
        List<Roles> role = new ArrayList<>();
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            Roles roles = new Roles();
            roles.setRole_id(rs.getString(1));
            roles.setRoles_name(rs.getString(2));
            roles.setDecription(rs.getString(3));
            roles.setStatus(rs.getLong(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    public boolean insert(Roles roles){
        String sql = "insert into role(role_id, role_name, description, status)values(?,?,?,?) ";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, roles.getRole_id());
            ps.setString(2, roles.getRoles_name());
            ps.setString(3, roles.getDecription());
            ps.setLong(4, roles.getStatus());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Roles roles){
        String sql = "update role set role_name=?, description=?, status=? where role_id=?";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, roles.getRoles_name());
            ps.setString(2, roles.getDecription());
            ps.setLong(3, roles.getStatus());
            ps.setString(4, roles.getRole_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean delete (Long id){
        String sql = "delete from role where  role_id = ?";
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

    public Roles findById(String id) {
        String sql = "select * from role where role_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Roles roles = new Roles();
                roles.setRole_id(rs.getString(1));
                roles.setRoles_name(rs.getString(2));
                roles.setDecription(rs.getString(3));
                roles.setStatus(rs.getLong(4));
                return roles;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
