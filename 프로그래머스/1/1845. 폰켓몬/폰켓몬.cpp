#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int solution(vector<int> nums)
{
  set<int> s;
  for(int num : nums) s.insert(num);
    int answer = min(s.size(), nums.size()/2);
    return answer;
}