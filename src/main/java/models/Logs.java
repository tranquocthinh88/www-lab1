package models;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Logs {
    private long id;
    private String account_id;
    private Timestamp login_time;
    private Timestamp logout_time;
    private String notes;

    public Logs(long id, String account_id, Timestamp login_time, Timestamp logout_time, String notes) {
        this.id = id;
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public Logs() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
    }

    public Timestamp getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Timestamp logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
