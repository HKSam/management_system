package jee.customer.v2;

import java.util.Date;
//用户类
// 2019-3-31
public class User{
    int id;
    String username;
    String password;
    String email;
    Date registerDate;
    String registerIp;
    int status;   //表示用户状态、status=0表示用户停用，status=1表示用户激活
    int role;    //用户角色、role=0表示管理员、role=1表示普通用户

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User(){

    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String email, Date registerDate, String registerIp, int status, int role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registerDate = registerDate;
        this.registerIp = registerIp;
        this.status = status;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", registerIp='" + registerIp + '\'' +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}

