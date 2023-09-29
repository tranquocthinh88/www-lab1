package repositories;

import connection.Connect;
import models.Logs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogRepository {
    public List<Logs> getAll() {
        String sql = "select * from log";
        List<Logs> log = new ArrayList<>();
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logs logs = new Logs();
                logs.setId(rs.getLong(1));
                logs.setAccount_id(rs.getString(2));
                logs.setLogin_time(rs.getTimestamp(3));
                logs.setLogout_time(rs.getTimestamp(4));
                logs.setNotes(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return log;
    }

    public boolean insert(Logs logs){
        String sql = "insert into log(id, account_id, login_time, logout_time, notes)values(?,?,?,?,?) ";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, logs.getId());
            ps.setString(2, logs.getAccount_id());
            ps.setTimestamp(3, logs.getLogin_time());
            ps.setTimestamp(4, logs.getLogin_time());
            ps.setString(5, logs.getNotes());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(Logs logs){
        String sql = "update log set account_id=?, login_time=?, logout_time=?, notes=? where id=?";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, logs.getAccount_id());
            ps.setTimestamp(2, logs.getLogin_time());
            ps.setTimestamp(3, logs.getLogin_time());
            ps.setString(4, logs.getNotes());
            ps.setLong(5, logs.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean delete (Long id){
        String sql = "delete from log where  id = ?";
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

    public Logs findById(String id) {
        String sql = "select * from log where id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logs logs = new Logs();
                logs.setId(rs.getLong(1));
                logs.setAccount_id(rs.getString(2));
                logs.setLogin_time(rs.getTimestamp(3));
                logs.setLogout_time(rs.getTimestamp(4));
                logs.setNotes(rs.getString(5));
                return logs;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
