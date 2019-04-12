package jee.customer.v2;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供用户对象的基本存储操作
public class UserService {
    private volatile int TICKET_ID = 0;
    // username-Object 形式
    // 使用静态对象
    private static Map<Integer, User> userMap = new HashMap<>();

    public UserService(){
        User user1 = new User("admin", "123456");
        user1.setRole(WebCts.ROLE_ADMIN);
        User user2 = new User("test", "123456");
        User user3 = new User("user1", "000");
        user2.setRole(WebCts.ROLE_USER);
        user3.setRole(WebCts.ROLE_USER);
        //初始化用户数据
        addUser(user1);
        addUser(user2);
        addUser(user3);
    }
    //获取某个用户
    public  User getUser(int  userId){
        return userMap.get(userId);
    }
    public User delUser(int userId){
        return userMap.remove(userId);
    }

    //添加用户
    public synchronized void addUser(User user){
        TICKET_ID++;
        user.setId(TICKET_ID);
        userMap.put(user.getId(),user);
    }
    //根据用户名查找用户
    public  User findByUsername(String  username){
        User user =null;
        for(int id : userMap.keySet()){
            user = userMap.get(id);
            if (user.getUsername().equals(username))
                return  user;
        }

        return  user;
    }
    //获取所有用户对象
    public List<User> findAllUsers(){
        return  new ArrayList<>(userMap.values());
    }
    //更新用户数据
    public void updateUser(User user){
        //更新用户
        userMap.put(user.getId(),user);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserService userService1 = new UserService();
        User user =userService.getUser(2);
        User user1 = new User("test", "test");
        userService.addUser(user1);

        //在另一个对象中查找user1的数据
        System.out.println(userService1.getUser(2));
        user1.setEmail("test@ddd");
        userService.updateUser(user1);
        System.out.println(userService1.getUser(3));
    }
}
