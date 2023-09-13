const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

var result = [];

for(var i = 0; i < input.length; i++) {
    if(input[i] == ".") {
        break;
    }
    var arr = [];
    var flag = false;
    for(var j = 0; j < input[i].length; j++) {
        var c = input[i].charAt(j);
        if(c == '(' || c == '[') {
            arr.push(c);
        } else if(c == ')' || c == ']') {
            if(c == ')' && arr[arr.length - 1] == '(' && arr.length != 0) {
                arr.pop();
            } else if(c == ']' && arr[arr.length - 1] == '[' && arr.length != 0) {
                arr.pop();
            } else {
                flag = true;
            }
        }
        if(flag) {
            break;
        }
    }
    if(arr.length == 0 && !flag) {
        result.push("yes");
    } else {
        result.push("no");
    }
}

console.log(result.join("\n"));