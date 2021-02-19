package pers.yjw.platform.design.model.created;

/**
 * 抽象工厂模式
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
//        IDatabaseUtils databaseUtils = new MysqlDatabaseUtils();
        IDatabaseUtils databaseUtils = new OracleDatabaseUtils();
        IConnection connection = databaseUtils.getConnection();
        connection.connect();
        ICommand command = databaseUtils.getCommand();
        command.command();


    }
}

//变化:mysql,oracle....
// connection,command,
interface IConnection {
    void connect();
}

interface ICommand {
    void command();
}

interface IDatabaseUtils {
    IConnection getConnection();
    ICommand getCommand();
}

class MysqlConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("Mysql build connection...");
    }
}

class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("Mysql send command...");
    }
}

class MysqlDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

class OracleConnection implements IConnection {

    @Override
    public void connect() {
        System.out.println("Oracle build connection...");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("Oracle send command...");
    }
}

class OracleDatabaseUtils implements IDatabaseUtils {

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}
