import java.util.Iterator;
public class Deque<Item> implements Iterable<Item> {
    Node first,last;
    int nSize;
    
   public Deque()                           // construct an empty deque
   {
       first = last = null;
       nSize = 0;
   }
   public boolean isEmpty()                 // is the deque empty?
   {
       if( first== null || last ==null)
           return true;
       return false;
   }
   public int size()                        // return the number of items on the deque
   {
       return nSize;
   }
   public void addFirst(Item item)          // add the item to the front
   {
      if(first == null)
      {
          Node fnode = new Node(null,null,item);
          last = fnode;
          first = fnode;
          return;
      }
      
      Node fnode = new Node(first,null,item);
      first.next = fnode;
      first = fnode;   
      
      
          
          
   }
   public void addLast(Item item)           // add the item to the end
   {
   }
   public Item removeFirst()                // remove and return the item from the front
   {
       return null;
   }
   public Item removeLast()                 // remove and return the item from the end
   {
       return null;
   }
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   {
       return null;
   }
   
   private class Node<Item>
   {
      public Node prev;
      public Node next;
      public Item val;   
      
      public Node(Node prev, Node next, Item val )
      {
          this.prev = prev;
          this.next = next;
          this.val = val;
      }
   }
   
       private class RangeIterator implements
                    Iterator<Item> {
        private int cursor;

        public RangeIterator() {
            //this.cursor = Range.this.start;
        }

        public boolean hasNext() {
            //return this.cursor < Range.this.end;
            return false;
        }

        public Item next() {
            return null;
            //throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
   public static void main(String[] args)   // unit testing
   {
   }
}