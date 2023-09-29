package models;

public class Roles {
    private String role_id;
    private String roles_name;
    private String decription;
    private long status;

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getRoles_name() {
        return roles_name;
    }

    public void setRoles_name(String roles_name) {
        this.roles_name = roles_name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Roles() {
    }

    public Roles(String role_id, String roles_name, String decription, long status) {
        this.role_id = role_id;
        this.roles_name = roles_name;
        this.decription = decription;
        this.status = status;
    }
}
