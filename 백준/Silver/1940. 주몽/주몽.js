let [n, m, input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

n = Number(n);
m = Number(m);
num = input.split(" ").map(Number);

num.sort((a, b) => a - b);

let start = 0,
  end = n - 1,
  cnt = 0;
while (start !== end) {
  if (num[start] + num[end] <= m) {
    cnt += num[start] + num[end] === m ? 1 : 0;
    start++;
    continue;
  }

  end--;
}

console.log(cnt);
