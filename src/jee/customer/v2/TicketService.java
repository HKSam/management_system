package jee.customer.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//提供用户对象的基本存储操作
public class TicketService {
    // 票据ID号，全局唯一
    private volatile int TICKET_ID = 0;
    // username-Object 形式
    // 使用静态对象
    private static Map<Integer, Ticket> ticketMap = new HashMap<>();

    public TicketService(){
        Ticket ticket1 = new Ticket("电子科技大学中山学院", "办公桌");
        Ticket ticket2 = new Ticket("阿里巴巴", "服务器");
        Ticket ticket3 = new Ticket("计算机学院", "硬件开发板");
        //初始化票据数据
        addTicket(ticket1);
        addTicket(ticket2);
        addTicket(ticket3);
    }

    //获取某个票据
    public  Ticket getTicket(int id){
        return ticketMap.get(id);
    }
    //使用同步操作，防止多人同时添加票据，id出现重复
    public synchronized void  addTicket(Ticket ticket){
            TICKET_ID++;
            ticket.setId(TICKET_ID);
            ticketMap.put(TICKET_ID,ticket);
    }

    //获取所有票据对象
    public List<Ticket> findAllTickets(){
        return  new ArrayList<>(ticketMap.values());
    }
    //更新票据数据
    public void updateTicket(Ticket ticket){
        ticketMap.put(ticket.getId(),ticket );
    }

    public static void main(String[] args) {
        TicketService userService = new TicketService();
        TicketService userService1 = new TicketService();
        Ticket user =userService.getTicket(1);
        Ticket user1 = new Ticket("test", "test");
        userService.addTicket(user1);

        //在另一个对象中查找user1的数据
        System.out.println(userService1.getTicket(2));
//        System.out.println(user);
    }
}
