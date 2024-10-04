import java.util.Arrays;

public class CoinChangeDP {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int x = 1; x <= amount; x++) {
            for (int coin : coins) {
                if (coin <= x) {
                    // Calculate the number of coins needed if we use this coin
                    int withThisCoin = dp[x - coin] + 1;
                    
                    // Compare with the current best solution
                    if (withThisCoin < dp[x]) {
                        dp[x] = withThisCoin;
                        System.out.printf("For amount %d, using coin %d: %d coins (%d + 1)%n", 
                                          x, coin, withThisCoin, dp[x - coin]);
                    }
                }
            }
            System.out.println("Best for amount " + x + ": " + dp[x] + " coins");
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Coins: " + Arrays.toString(coins));
        System.out.println("Target amount: " + amount);
        System.out.println("Minimum coins needed: " + coinChange(coins, amount));
    }
}