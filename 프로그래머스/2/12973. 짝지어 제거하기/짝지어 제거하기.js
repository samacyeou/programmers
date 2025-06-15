function solution(s) {
  sArr = s.split("");
  const heap = [sArr.pop()];

  while (sArr.length > 0) {
      temp = sArr.pop()
      if(heap[heap.length-1] === temp) heap.pop()
      else heap.push(temp)
    //heap.push(sArr.pop());
    //const len = heap.length;
    //if (heap[len - 1] === heap[len - 2]) heap.splice(-2, 2);
  }

  return heap.length > 0 ? 0 : 1;
}