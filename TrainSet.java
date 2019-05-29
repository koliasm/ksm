package lab7;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import lab6.*;

public class TrainSet implements Set<Train>, Serializable {
    private static final int MAX_CAPACITY = 15;
    private Train train[] = new Train[MAX_CAPACITY];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<Train> trainIterator = iterator();
        while (trainIterator.hasNext()){
            if(o.equals(trainIterator.next())){
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<Train> iterator() {
        return new Iterator<Train>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Train next() {
                return train[index++];
            }

            /*@Override
            public void remove() {

            }*/
        };
    }

    @Override
    public Object[] toArray() {
        Iterator<Train> trainIterator = iterator();
        Object[] o = new Object[size];
        int index = 0;
        while (trainIterator.hasNext()){
            o[index++] = trainIterator.next();
        }
        return o;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length >= size && a instanceof  Train[]){
            for(int i = 0; i < a.length; i++){
                try {
                    a[i] = (T) train[i];
                }catch (IndexOutOfBoundsException e){
                    a[i]=null;
                }
            }
        }else{
            a = (T[]) toArray();
        }
    return a;
    }
    @Override
    public boolean add(Train addedTrain){
        if (addedTrain.getComfort().equals("")){
            throw new WrongComfortExeption();
        }
        if(addedTrain.getLuggage()<0){
            throw new WrongLuggageExeption();
        }
        if(addedTrain.getUsedSeats()<0){
            throw new WrongUsedSeatsExeption();
        }
        train[size++] = addedTrain;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Iterator<Train> trainIterator = iterator();
        int index = 0;
            while (trainIterator.hasNext()){
                if (trainIterator.next() == o){
                    for (int _index = index; _index < size; _index++){
                        try {
                            train[_index] = train[_index + 1];
                        }catch (IndexOutOfBoundsException e){
                            train[_index] = null;
                        }
                    }
                    size--;
                    return true;
                }
                index++;
            }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<Train> trainIterator = iterator();
        Iterator<?> cIterator = c.iterator();
        while (cIterator.hasNext()){
            while (trainIterator.hasNext()){
                if(cIterator.next() == trainIterator.next()){
                    break;
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Train> c) {
        boolean tf = false;
        try {
            for (Train addingTrain : c) {
                if (add(addingTrain)) {
                    tf = true;
                }
                add(addingTrain);
            }
        }catch (IndexOutOfBoundsException e){
            return false;
        }
        return tf;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean tf = false;
        Iterator<Train> trainIterator = iterator();
        Iterator<?> cIterator = c.iterator();
        while (cIterator.hasNext()){
            while (trainIterator.hasNext()){
                if (cIterator.next() == trainIterator.next()){break;}
                remove(trainIterator.next());
                size--;
                tf = true;
            }
        }
        return tf;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean tf = false;
        Iterator<Train> trainIterator = iterator();
        Iterator<?> cIterator = c.iterator();
        while (cIterator.hasNext()){
            while (trainIterator.hasNext()){
                if (cIterator.next().equals(trainIterator.next())){
                    remove(trainIterator.next());
                    size--;
                    tf = true;
                }
            }
        }
        return tf;
    }

    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            train[i]=null;
        }
    }
}