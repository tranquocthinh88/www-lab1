package models;

public class GrantAccess {
    private String roles_id;
    private String account_id;
    private boolean is_grant;
    private String note;

    public String getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(String roles_id) {
        this.roles_id = roles_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public boolean isIs_grant() {
        return is_grant;
    }

    public void setIs_grant(boolean is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public GrantAccess() {
    }

    public GrantAccess(String roles_id, String account_id, boolean is_grant, String note) {
        this.roles_id = roles_id;
        this.account_id = account_id;
        this.is_grant = is_grant;
        this.note = note;
    }
}
