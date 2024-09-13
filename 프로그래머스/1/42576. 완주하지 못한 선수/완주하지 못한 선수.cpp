#include <string>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
  map<string, int> player;

  for(string p : participant){
    map<string, int>::iterator it = player.find(p);
    if(it == player.end())
      player[p] = 1;
    else
      player[p]++;
  }

  for(string c : completion){
    player[c]--;
  }

  string answer = "";
  map<string, int>::iterator it = player.begin();
  while(it != player.end()){
    if(it->second != 0){
      answer = it->first;
      break;
    }

    it++;
  }

    
    return answer;
}