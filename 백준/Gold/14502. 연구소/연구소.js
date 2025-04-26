let input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
  .toString()
  .trim()
  .split("\n");

let [n, m] = input[0].split(" ").map(Number);
let map = input.slice(1).map((line) => line.split(" ").map(Number));
let max = 0;

let dir = [[-1, 0], [1, 0], [0, -1], [0, 1]];

const spread = (temp) => {
  let q = [];

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (temp[i][j] === 2) {
        q.push([i, j]);
      }
    }
  }

  while (q.length) {
    let [x, y] = q.pop();
    for (let [dx, dy] of dir) {
      let nx = x + dx;
      let ny = y + dy;

      if (nx >= 0 && nx < n && ny >= 0 && ny < m && temp[nx][ny] === 0) {
        temp[nx][ny] = 2;
        q.push([nx, ny]);
      }
    }
  }
};

const getCount = (temp) => temp.flat().filter((cell) => cell === 0).length;

const dfs = (depth) => {
  if (depth === 3) {
    let temp = map.map((row) => row.slice());
    spread(temp);
    max = Math.max(max, getCount(temp));
    return;
  }

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (map[i][j] === 0) {
        map[i][j] = 1;
        dfs(depth + 1);
        map[i][j] = 0;
      }
    }
  }
};

dfs(0);

console.log(max);
