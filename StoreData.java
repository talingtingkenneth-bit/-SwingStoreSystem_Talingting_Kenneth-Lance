package store;

public class StoreData {
    // Inventory Arrays [cite: 87-94]
    public static String[] products = {"Rice", "Sugar", "Coffee", "Milk"};
    public static double[] prices = {50.00, 65.00, 120.00, 85.00}; 
    public static int[] stock = {20, 20, 20, 20};

    // Transaction Log Arrays [cite: 52-56]
    public static final int MAX_TRANSACTIONS = 100; // Fixed size limit
    public static String[] logNames = new String[MAX_TRANSACTIONS];
    public static int[] logQuantities = new int[MAX_TRANSACTIONS];
    public static double[] logTotals = new double[MAX_TRANSACTIONS];
    
    // Index counter to track the number of transactions [cite: 56]
    public static int currentLogIndex = 0;
}