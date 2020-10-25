package dto;

public class AdminDTO {
    private String id;
    private String name;
    private String user_name;
    private String password;

    public AdminDTO() {
    }

    public AdminDTO(String id, String name, String user_name, String password) {
        this.id = id;
        this.name = name;
        this.user_name = user_name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
