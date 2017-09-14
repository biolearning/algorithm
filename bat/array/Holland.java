package bat.array;

import java.util.Arrays;
import java.util.Random;

public class Holland {
	
	void solution(int[] nums) {
		int begin = 0, current = 0, end = nums.length - 1;
		
		while (current <= end) {
			System.out.println(begin + ", " + current + ", " + end);
			if (nums[current] == 1) {
				current++;
			}else if (nums[current] == 0) {
				if (current == begin) {
					current++;
					begin++;
				}else {
					int tmp = nums[begin];
					nums[begin] = nums[current];
					nums[current] = tmp;
					begin++;
				}
			}else {
				int tmp = nums[end];
				nums[end] = nums[current];
				nums[current] = tmp;
				end--;	
			}
			System.out.println(Arrays.toString(nums));
		}
	}
	
	/**
	 * @param nums
	 * 优化后的，当nums[current] == 0时， nums[begin] == 1 (? 为什么不会是0)
	 */
	void solution2(int[] nums) {
		int begin = 0, current = 0, end = nums.length - 1;
		while (current <= end) {
			if (nums[current] == 1) {
				current++;
			}else if (nums[current] == 0) {
				int tmp = nums[begin];
				nums[begin] = nums[current];
				nums[current] = tmp;
				begin++;
				current++;
			}else {
				int tmp = nums[end];
				nums[end] = nums[current];
				nums[current] = tmp;
				end--;	
			}			
		}
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int N = 10;
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = rand.nextInt(3);
		}
		System.out.println(Arrays.toString(nums));
		new Holland().solution(nums);
		System.out.println(Arrays.toString(nums));
	}

}
