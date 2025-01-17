import java.util.*;
import java.util.regex.*;


class Solution {
    class PageInfo {
        String name;
        int outerCnt;
        int basicScore;
        List<String> links;
        double score;
    }
    public int solution(String word, String[] pages) {
        int answer = 0;
        int n = pages.length;
        Matcher mt = null;
        word = word.toLowerCase();
        
        PageInfo[] pageInfos = new PageInfo[n];
        List<String>[] datas = new List[n];
        
        for(int i = 0; i < n; i++) {
            int score = 0;
            pages[i] = pages[i].toLowerCase();
            datas[i] = new ArrayList<>();
            pageInfos[i] = new PageInfo();
            
            mt = Pattern.compile("(<meta property=\"og:url\" content=\"https://(\\S*)\")").matcher(pages[i]);
            while(mt.find()) {
                String name = mt.group(2).trim();
                pageInfos[i].name = name;
            }
            
            mt = Pattern.compile("(?<=[^a-zA-Z])("+word+")[^a-zA-Z]").matcher(pages[i]);
            while(mt.find()) {
                score += 1;
            }
            pageInfos[i].basicScore = score;
            
            mt = Pattern.compile("<a href=\"(\\S*)//(\\S*)\"").matcher(pages[i]);
            while(mt.find()) {
                String url = mt.group(2).trim();
                datas[i].add(url);
            }
            
            pageInfos[i].links = datas[i];
            pageInfos[i].outerCnt = datas[i].size();
        }
        
        for(int i = 0; i < n; i++) {
            for(String url : pageInfos[i].links) {
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        continue;
                    }
                    
                    if(url.equals(pageInfos[j].name)) {
                        pageInfos[j].score += (double)pageInfos[i].basicScore / pageInfos[i].links.size();
                    }
                }
            }
        }
        
        double max = 0;
        for(int i = 0; i < n; i++) {
            if(max < pageInfos[i].basicScore + pageInfos[i].score) {
                max = pageInfos[i].basicScore + pageInfos[i].score;
                answer = i;
            }
        }
        
        return answer;
    }
}