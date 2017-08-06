package ua.nure.shekhovtsov.Practice2;

import java.util.Iterator;

public class MyListImpl implements MyList, ListIterable{
	private Object[] listObjects;
	private int listSize;
	public void add(Object e) {
		if(listSize == 0)	{
			listObjects = new Object[1];
			listObjects[0] = e;			
		}
		else	{
			Object[] temp = new Object[listSize+1];
			System.arraycopy(listObjects, 0, temp, 0, listSize);
			temp[listSize] = e;
			listObjects = temp;
		}
		listSize = listObjects.length;
	}

	public void clear() {
		listObjects = null;
		listSize = 0;
	}

	public boolean remove(Object o) {
		Object[] temp = new Object[listSize-1];
		boolean isHere = false;
		for (int i = 0, j = 0; i < listSize; i++) {
			if(listObjects[i].equals(o)) {
				isHere = true;
				continue;
			}
			temp[j] = listObjects[i];
			j++;
		}
		listObjects = temp;
		listSize = listObjects.length;
		return isHere;
	}

	public Object[] toArray() {
		return listObjects;
	}

	public int size() {
		return listSize;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < listSize; i++) {
			if(listObjects[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(MyList c) {
		Object[] cArray = c.toArray();
		boolean isHere = false;
		for (int i = 0; i < c.size(); i++) {
			isHere = false;
			for (int j = 0; j < listSize; j++) {
				if(listObjects[j].equals(cArray[i])) {
					isHere = true;
					break;
				}
				else if(j == listSize-1 && !isHere) {
					return false;
				}
			}
			
		}
		return isHere;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("{");
		for (int i = 0; i < listSize - 1; i++) {
			sb.append(listObjects[i].toString());
			sb.append(", ");
		}
		sb.append(listObjects[listSize - 1].toString());
		sb.append("}");
		return sb.toString();		
	}

	private class IteratorImpl implements Iterator<Object> {
		protected int cursor;
		protected int index;
		protected boolean isRemove;
		public boolean hasNext() {
			return cursor!=listSize;
	    }
	 
	    public Object next() {
            isRemove = false;
            index = cursor++;
			return listObjects[index];            
	    }
	      
	    public void remove() {
	    	if(cursor == 0 || isRemove) {
	    		throw new IllegalStateException();
	    	}
	    	isRemove = true;
	    	index = --cursor;
	    	MyListImpl.this.remove(listObjects[index]);
	    }        
	}
	
	public Iterator<Object> iterator() {
	    return new IteratorImpl();
	}

	
	public ListIterator listIterator() {
		return new ListIteratorImpl();		
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator {

		ListIteratorImpl() {
            cursor = listSize-1;
        }

        public boolean hasPrevious() {
            return cursor != -1;
        }

		public Object previous() {
			if(cursor == -1) {
            	return null;
			}
            isRemove = false;
            index = cursor--;
			return listObjects[index];
		}

		public void set(Object e) {
			listObjects[index-1] = e;
		}
	    public void remove() {
	    	if(isRemove) {
	    		throw new IllegalStateException();
	    	}
	    	isRemove = true;
	    	index = cursor--;
	    	MyListImpl.this.remove(listObjects[index]);
	    } 
	}
}
