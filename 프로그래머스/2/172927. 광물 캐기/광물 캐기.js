function solution(picks, minerals) {
    let answer = 0;
    let sum = 0;
    for (let i = 0; i < picks.length; i++) sum += picks[i];
    
    let m = [];
    for (let i = 0; i < sum; i++) m.push(minerals.splice(0, 5));
    
    m.sort((a, b) => {
        let diamondCountA = a.filter(mineral => mineral === 'diamond').length;
        let diamondCountB = b.filter(mineral => mineral === 'diamond').length;
        let ironCountA = a.filter(mineral => mineral === 'iron').length;
        let ironCountB = b.filter(mineral => mineral === 'iron').length;
        let stoneCountA = a.filter(mineral => mineral === 'stone').length;
        let stoneCountB = b.filter(mineral => mineral === 'stone').length;

        if (diamondCountA === diamondCountB) {
            if (ironCountA === ironCountB) {
                return stoneCountB - stoneCountA;
            }
            return ironCountB - ironCountA;
        }
        return diamondCountB - diamondCountA;
    });
    
    for (let i = 0; i < picks.length; i++) {
        let count = picks[i];
        let n1, n2, n3;
        
        if (i === 0) {
            n1 = 1;
            n2 = 1;
            n3 = 1;
        } else if (i === 1) {
            n1 = 5;
            n2 = 1;
            n3 = 1;
        } else {
            n1 = 25;
            n2 = 5;
            n3 = 1;
        }
        
        while (count !== 0) {
            if (m.length === 0) return answer;
            
            let diamondCount = 0,
                ironCount = 0,
                stoneCount = 0;
            
            for (let j = 0; j < m[0].length; j++) {
                if (m[0][j] === 'diamond') diamondCount++;
                else if (m[0][j] === 'iron') ironCount++;
                else if (m[0][j] === 'stone') stoneCount++;
            }
            
            answer += diamondCount * n1 + ironCount * n2 + stoneCount * n3;
            count--;
            
            m.shift();
        }
    }
    return answer;
}