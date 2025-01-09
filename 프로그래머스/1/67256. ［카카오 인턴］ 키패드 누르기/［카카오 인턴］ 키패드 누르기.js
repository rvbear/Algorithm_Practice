function checkDist(x1, y1, x2, y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
}

function solution(numbers, hand) {
    var point = [[3, 1], [0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2], [3, 0], [3, 2]];
    
    var answer = '';
    var left = 10, right = 11;
    
    numbers.forEach(function(item, index) {
        if(item === 1 || item === 4 || item === 7) {
            answer += "L";
            left = item;
        } else if(item === 3 || item === 6 || item === 9) {
            answer += "R";
            right = item;
        } else {
            var cal = checkDist(point[item][0], point[item][1], point[left][0], point[left][1]) - checkDist(point[item][0], point[item][1], point[right][0], point[right][1]);
            
            if(cal === 0) {
                if(hand == "right") {
                    answer += "R";
                    right = item;
                } else {
                    answer += "L";
                    left = item;
                }
            } else if(cal > 0) {
                answer += "R";
                right = item;
            } else {
                answer += "L";
                left = item;
            }
        }
    })
    
    return answer;
}