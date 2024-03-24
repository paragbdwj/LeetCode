package core_java;

public class SingletonClass {
//    Check whether why below code runs fine without making it static and in the below class it is mandatory to make it static
//    private static SingletonClass singletonClass = new SingletonClass();
//
//    private SingletonClass() {
//
//    }
//    public SingletonClass getDbConnection() {
//        if(singletonClass == null) {
//            singletonClass = new SingletonClass();
//        }
//        return singletonClass;
//    }

    static class DBConnectionEager {
        private static DBConnectionEager dbConnection = new DBConnectionEager();

        private DBConnectionEager() {

        }
        public static DBConnectionEager getDbConnection() {
            return dbConnection;
        }

    }

    public static class DBConnectionLazy {
        private static DBConnectionLazy dbConnectionLazy;
        private DBConnectionLazy() {

        }

        public static DBConnectionLazy getDbConnectionLazy() {
            if(dbConnectionLazy == null) {
                dbConnectionLazy = new DBConnectionLazy();
            }
            return dbConnectionLazy;
        }
    }

    static class DBConnectionSynchronized {
        private static DBConnectionSynchronized dbConnectionSynchronized;

        private DBConnectionSynchronized() {

        }

        public synchronized static DBConnectionSynchronized getDbConnectionSynchronized() {
            if(dbConnectionSynchronized == null) {
                dbConnectionSynchronized = new DBConnectionSynchronized();
            }
            return dbConnectionSynchronized;
        }

    }

    static class DBConnectionSynchronizedDoubleLock {
        private static volatile DBConnectionSynchronizedDoubleLock dbConnectionSynchronizedDoubleLock;  // Because of the caching problem update the
        // object value in RAM only


        private DBConnectionSynchronizedDoubleLock() {

        }

        public static DBConnectionSynchronizedDoubleLock getDbConnectionSynchronizedDoubleLock() {
            if(dbConnectionSynchronizedDoubleLock == null) {
                synchronized (DBConnectionSynchronizedDoubleLock.class) {
                    if(dbConnectionSynchronizedDoubleLock == null) {
                        dbConnectionSynchronizedDoubleLock = new DBConnectionSynchronizedDoubleLock();
                    }
                }
            }
            return dbConnectionSynchronizedDoubleLock;
        }

    }

    static class DBConnectionBillPugh {
        private DBConnectionBillPugh() {

        }
        private static class DbConnectionHelper {
            private static final DBConnectionBillPugh dbConnectionBillPugh = new DBConnectionBillPugh();
        }

        public static DBConnectionBillPugh getDBConnectionBillPugh() {
            return DbConnectionHelper.dbConnectionBillPugh;
        }
    }




}
