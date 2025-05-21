
import java.util.LinkedList;
import java.util.Queue;

class SlidingWindowFixedSize {
    //first negative number in every window of size k
    public int[] firstNegativeInWindow(int[] list, int k){
        int i=0, j=0;
        int[] ans = new int[list.length-k+1];
        int count=0;
        Queue<Integer> queue = new LinkedList<>();
        if(list.length==0){
            return new int[]{0};
        }else{
            while(j<list.length){
                if(list[j]<0){
                    queue.add(list[j]);
                }
                if(j-i+1<k){
                    j++;
                }else if(j-i+1==k){
                    if(queue.isEmpty()){
                        ans[count++]=0;
                    }else{
                        ans[count++]=queue.peek();
                    }
                    if(list[i]==queue.peek()){
                        queue.poll();
                    }
                    i++;
                    j++;
                }
            }
        }
        return ans;
    }
    
}
    
