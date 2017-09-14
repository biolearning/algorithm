package bat.array;

import java.util.Arrays;
import java.util.Random;

public class FirstMissNumber {
	
	int solution(int[] nums) {
		int size = nums.length - 1;
		for (int i = 1; i < nums.length && size > i; ) {
			if (nums[i] == i) i++;
			else if (nums[i] < i || nums[i] < 1 || nums[i] > size || nums[i] == nums[nums[i]]) {
				nums[i] = nums[size];
				size--;
			}else {
				int tmp = nums[i];
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
			System.out.println(Arrays.toString(nums) + ", size = " + size);
		}
		return size;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		int N = 10;
		int[] nums = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			nums[i] = rand.nextInt(8);
		}
		System.out.println(Arrays.toString(nums));
		System.out.println(new FirstMissNumber().solution(nums));
	}

}
