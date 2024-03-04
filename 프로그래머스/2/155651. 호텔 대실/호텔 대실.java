import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);
			}
		});
        
        int[][] time = new int[book_time.length][2];
        
		for (int i = 0; i < book_time.length; i++) {
				int startTime = Integer.parseInt(book_time[i][0].replace(":", ""));
				int endTime = Integer.parseInt(book_time[i][1].replace(":", ""));
				
				endTime += 10;
	            if(endTime % 100 >= 60) {
	                endTime += 40;
	            }
	            
	            time[i][0] = startTime;
	            time[i][1] = endTime;
		}
        
        ArrayList<Integer> rooms = new ArrayList<>();
		for (int i = 0; i < time.length; i++) {
			Collections.sort(rooms);

			boolean isAdd = false;

			for (int j = 0; j < rooms.size(); j++) {
				if (time[i][0] >= rooms.get(j)) {
					rooms.set(j, time[i][1]);
					isAdd = true;
					break;
				}
			}

			if (!isAdd) { 
                rooms.add(time[i][1]);
			}
		}
        
        return rooms.size();
    }
}