class Solution {
    private int indexOf(int[] arr, int element) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == element) {
                return i;
            }
        }

        return -1;
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int minSwaps(int[] arr, int n) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);

        for(int i = 0; i < n; i++) {
            if(arr[i] != temp[i]) {
                ans++;
                swap(arr, i, indexOf(arr, temp[i]));
            }
        }

        return ans;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int cnt = 0;

        while(!q.isEmpty()) {
            TreeNode cur = q.peek();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                cur = q.remove();

                if(cur.left != null) {
                    q.add(cur.left);
                }

                if(cur.right != null) {
                    q.add(cur.right);
                }
            }

            int[] arr = new int[q.size()];
            int k = 0;
            for(TreeNode node : q) {
                arr[k++] = node.val;
            }

            cnt += minSwaps(arr, k);
        }

        return cnt;
    }
}