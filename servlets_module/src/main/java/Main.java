import org.example.model.*;

import java.util.List;

public class Main {
    private static ConnectionDB connectionDB = new Driver.getConnection();
    private static List<Class> tablesClasses = List.of(Client.class, Account.class, Deposit.class, Credit.class, Deposit.class, TransactionHistory.class, BankCard.class);
    private static QuaeryHelper quaeryHelper = new QuaeryHelperImpl(tablesClasses);
    private static Quaery quaery = new QuaeryGenerator(quaeryHelper);

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.fillServletContainer(
                connectionDB,
                quaery,
                tablesClasses
        );
    }
}