function solution(s) {
  sArr = s.split("");
  const heap = [sArr.pop()];

  while (sArr.length > 0) {
      temp = sArr.pop()
      if(heap[heap.length-1] === temp) heap.pop()
      else heap.push(temp)
  }

  return heap.length > 0 ? 0 : 1;
}