let [n, ...glass] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

glass = [0, ...glass];
let dp = Array(n + 1).fill(0);
dp[1] = glass[1];

if (n > 1) {
  dp[2] = glass[1] + glass[2];
}

for (let i = 3; i <= n; i++) {
  dp[i] = Math.max(
    dp[i - 1],
    dp[i - 2] + glass[i],
    dp[i - 3] + glass[i - 1] + glass[i]
  );
}

console.log(dp[n]);
