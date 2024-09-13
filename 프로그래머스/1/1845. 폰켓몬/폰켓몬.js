function solution(nums) {
  var answer = Math.min(new Set(nums).size, nums.length/2);
  return answer;
}