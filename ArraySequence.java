import java.util.NoSuchElementException;
public class ArraySequence implements IntegerSequence{
  int currentIndex;
  int[] data;

  /*Construct the sequence by copying values from the other array into the data array*/
  public ArraySequence(int [] other){
    data = other;
    currentIndex = 0;
  }
  public ArraySequence(IntegerSequence otherseq){ 
    //make new array length of sequence
    int size = 0;
    int[] temp = new int[otherseq.length()];
    for (int i = 0; otherseq.hasNext(); i++) {
        temp[i] = otherseq.next();
        size++;
    }
    data = new int[size];
    for (int i = 0; i < data.length; i++) {
        data[i] = temp[i];
    }
    otherseq.reset();
  } 
  
  public void reset() {
    currentIndex = 0;
  }
  public int length() {
    return data.length;
  }


  public boolean hasNext() {
    return currentIndex < data.length;
  }
  public int next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No more elements!");
    }
    int curr = data[currentIndex];
    currentIndex++;
    return curr;
  }
  
  

}
