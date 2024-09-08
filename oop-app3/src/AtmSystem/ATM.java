package AtmSystem;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    ArrayList<Account> accounts = new ArrayList<>();
    private Scanner in = new Scanner(System.in);
    private Account loginAcc;
    /** 启动ATM系统 展示欢迎界面*/
    public void start(){
        while (true) {
            System.out.println("===欢迎您进入到ATM系统===");
            System.out.println("1、用户登录");
            System.out.println("2、用户开户");
            System.out.println("请选择：");
            int command = in.nextInt();
            switch (command){
                case 1:
                    //用户登录
                    login();
                    break;
                case 2:
                    createAccoount();
                    //用户开户
                    break;
                default:
                    System.out.println("没有该操作~~");
            }
        }
    }

    private void login(){
        System.out.println("==系统登录==");
        if(accounts.size()==0){
            System.out.println("当前系统中无任何系统，请先开户再登录~~");
            return;
        }

        while (true) {
            System.out.println("请您输入您的登录卡号：");
            String cardId = in.next();

            Account acc = getAccountByCardId(cardId);
            if(acc == null){
                System.out.println("您输入的登录卡号不存在，请确认~~");
            }else {
                System.out.println("请您输入登录密码");
                String passWord = in.next();
                if (acc.getPassWord().equals(passWord)){
                    System.out.println("恭喜您，" + acc.getName() + "成功登录了系统，您的卡号是：" + acc.getCardId());
                    //......
                    loginAcc = acc;
                    showUserCommand();
                    return;
                }else{
                    System.out.println("您输入的密码不正确，请确认~~");
                }
            }
        }
    }

    private void showUserCommand(){
        while (true) {
            System.out.println(loginAcc.getName() + "您可以选择如下功能进行账户的处理===");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、密码修改");
            System.out.println("6、退出");
            System.out.println("7、注销当前账户");
            int command = in.nextInt();
            switch (command){
                case 1:
                    showLoginAccount();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println(loginAcc.getName() + "您退出系统成功！");
                    return;
                case 7:
                    break;
                default:
                    System.out.println("您当前选择的操作是不存在的，请确认~~");
            }
        }
    }

    /**
       展示当前登录的账户信息
     */
    private void showLoginAccount(){

    }

    /** 完成用户开户操作 */
    private void createAccoount(){
        //1、创建一个账户对象，用于封装用户的开户信息
        Account acc = new Account();

        //2、需要用户输入自己的开户信息，赋值给账户对象
        System.out.println("请输入您的账户名称：");
        String name = in.next();
        acc.setName(name);

        while (true) {
            System.out.println("请您输入您的性别：");
            char sex = in.next().charAt(0);
            if(sex=='男'||sex=='女'){
                acc.setSex(sex);
                break;
            }else{
                System.out.println("您输入的性别有误~只能是男或者女~");
            }
        }

        while (true) {
            System.out.println("请您输入您的账户密码：");
            String passWord = in.next();
            System.out.println("请您输入您的确认密码：");
            String okPassWord = in.next();
            if(passWord.equals(okPassWord)){
                acc.setPassWord(okPassWord);
                break;
            }else {
                System.out.println("您输入的2次密码不一致，请您确认~~");
            }
        }

        System.out.println("请您输入您的取现额度：");
        double limit = in.nextDouble();
        acc.setLimit(limit);

        //为这个账户生成一个卡号（由系统自动生成，8位数字表示，不能与其他账户的卡号重复）
        String newCardId = createCardId();
        acc.setCardId(newCardId);

        //3、把这个账户对象，存入到账户的集合中去
        accounts.add(acc);
        System.out.println("恭喜您，" + acc.getName() + "开户成功，您的卡号是：" + acc.getCardId());

    }

    /** 返回一个8位 数字的卡号，而且这个卡号不能与其他账户的卡号重复 */
    private String createCardId(){
        while (true) {
            String cardId = "";

            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId += data;
            }
            Account acc = getAccountByCardId(cardId);
            if (acc == null){
                return cardId;
            }
        }
    }

    private Account getAccountByCardId(String cardId){
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if(acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null; //查无此账户，这个卡号不存在
    }


}
