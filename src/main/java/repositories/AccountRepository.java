package repositories;

import connection.Connect;
import models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public boolean insert(Account account){
        String sql = "insert into account(account_id, full_name, password, email, phone)values(?,?,?,?,?)";
        Connection connection = Connect.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getAccount_id());
            ps.setString(2, account.getFull_name());
            ps.setString(3, account.getPassword());
            ps.setString(4, account.getEmail());
            ps.setString(5, account.getPhone());
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Account> getAll() {
        String sql = "select * from account";
        List<Account> accounts = new ArrayList<>();
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccount_id(rs.getString(1));
                account.setFull_name(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setStatus(rs.getInt(6));
                accounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public boolean update(Account account){
        String sql = "update account set full_name=?, password=?, email=?, phone=?" +
                "where account_id = ?";
        Connection connection = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, account.getFull_name());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getEmail());
            ps.setString(4, account.getPhone());
            ps.setString(5,account.getAccount_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean delete (Long id){
        String sql = "delete from account where account_id = ?";
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
    public Account findById(String id) {
        String sql = "select * from account where account_id = ?";
        Connection conn = Connect.getInstance().getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setAccount_id(rs.getString(1));
                account.setFull_name(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setStatus(rs.getInt(6));
                return account;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
