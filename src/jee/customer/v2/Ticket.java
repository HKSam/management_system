package jee.customer.v2;

public class Ticket
{
    int id;     //票据唯一标识
    private String customerName; //客户名
    private String subject;         //票据主题
    private String body;     // 票据说明
    double money;
    String ticketType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    //构造函数
    public Ticket() {

    }
    public Ticket(String customerName, String subject){
        this.customerName = customerName;
        this.subject = subject;
    }
    public Ticket(String customerName, String subject, String body, double money, String ticketType) {
        this.customerName = customerName;
        this.subject = subject;
        this.body = body;
        this.money = money;
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "customerName='" + customerName + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", money=" + money +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}
