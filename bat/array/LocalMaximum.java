package bat.array;

import java.util.Arrays;
import java.util.Random;

public class LocalMaximum {
	
	int solution(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right)/2;
			if (nums[mid] > nums[mid+1]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(left);
		return nums[left];
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int N = 10;
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = rand.nextInt(1);
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(new LocalMaximum().solution(nums));
	}

}
