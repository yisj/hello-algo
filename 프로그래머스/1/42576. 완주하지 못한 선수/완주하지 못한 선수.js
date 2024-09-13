function solution(participant, completion) {

  const map = {};
  participant.forEach(p => {
    if(!map[p])
      map[p] = 1;
     else
      map[p]++;
  })

  completion.forEach(c => {
    map[c]--;
  })

  var answer = '';

  for(let key in map){
    if(map[key] != 0) {
      answer = key;
      break;
    }
  }

  
  return answer;
}