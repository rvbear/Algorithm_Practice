const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

const [n, k] = input.shift().split(" ").map(Number);
let words = input.map((line) => {
  let mask = 0;
  for (const char of line.trim().slice(4, -4)) {
    mask |= 1 << (char.charCodeAt(0) - 97);
  }
  return mask;
});

let visit = 0;
[0, 2, 8, 13, 19].forEach((c) => (visit |= 1 << c));
let max = 0;

const countReadableWords = () =>
  words.reduce((cnt, word) => ((word & visit) === word ? cnt + 1 : cnt), 0);

const backtracking = (alphabet, len) => {
  if (len === k) {
    max = Math.max(max, countReadableWords());
    return;
  }

  for (let i = alphabet; i < 26; i++) {
    if (!(visit & (1 << i))) {
      visit |= 1 << i;
      backtracking(i + 1, len + 1);
      visit &= ~(1 << i);
    }
  }
};

backtracking(0, 5);

console.log(k < 5 ? 0 : k === 26 ? n : max);
