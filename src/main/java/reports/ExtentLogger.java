package reports;

public final class ExtentLogger {
    private ExtentLogger() {}
    private static ExtentLogger extenLogger;

    public static void pass(String message){
        ExtentManager.getTest().pass(message);
    }
    public static void fail(String message){
        ExtentManager.getTest().fail(message);
    }
    public static void skip(String message){
        ExtentManager.getTest().skip(message);
    }
}
