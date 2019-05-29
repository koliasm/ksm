package lab7;

import java.util.Arrays;
import java.util.Iterator;
import lab6.*;

public class Main {
    public static void main(String[] args) {
        TrainSet trainSet = new TrainSet();
        System.out.println(trainSet.isEmpty());
        System.out.println("-------------------------------");

        Train obj1 = new Train(10,70,"Huge comfort");
        Train obj2 = new Train(20,60,"Very NICE!");
        Train obj3 = new Train(30,50,"~Aaah");
        Train obj4 = new Train(40,40,"Nice!");
        Train obj5 = new Train(50,30,"Fine");
        Train obj6 = new Train(60,20,"Meh");
        Train obj7 = new Train(70,10,"Ew");

        trainSet.add(obj1);
        trainSet.add(obj2);
        trainSet.add(obj3);
        trainSet.add(obj4);
        trainSet.add(obj5);
        trainSet.add(obj6);
        trainSet.add(obj7);

        System.out.println("Содержит ли объект 1: "+trainSet.contains(obj1));
        System.out.println("Содержит ли объект, которого изначально не было: "+trainSet.contains(new Train(11,12,"Perevirka")));
        System.out.println("-------------------------------");

        TrainSet firstTrainSet = new TrainSet();
        TrainSet secondTrainSet = new TrainSet();
        TrainSet thirdTrainSet = new TrainSet();

        firstTrainSet.add(obj1);
        firstTrainSet.add(obj2);
        firstTrainSet.add(obj3);
        firstTrainSet.add(obj4);
        firstTrainSet.add(obj5);

        secondTrainSet.add(obj1);
        secondTrainSet.add(obj2);
        secondTrainSet.add(obj4);
        secondTrainSet.add(obj6);
        secondTrainSet.add(obj7);

        thirdTrainSet.add(obj1);
        thirdTrainSet.add(obj2);
        thirdTrainSet.add(obj3);
        thirdTrainSet.add(obj5);
        thirdTrainSet.add(obj6);

//        firstTrainSet.removeAll(secondTrainSet);
        System.out.print(Arrays.toString(firstTrainSet.toArray())+"\n");
        System.out.println("-------------------------------");
        System.out.print(Arrays.toString(thirdTrainSet.toArray())+"\n");
        System.out.println("-------------------------------");

        System.out.println("Содержит ли изначальная коллекция все элементы меньшей коллекции: "+trainSet.containsAll(secondTrainSet));
        System.out.println("-------------------------------");

        Train[] A = new Train[7];
        A[0]=obj7;A[1]=obj6;A[2]=obj5;A[3]=obj4;A[4]=obj3;A[5]=obj2;A[6]=obj1;
        firstTrainSet.toArray(A);
        System.out.println(Arrays.toString(A)+"\n");

        System.out.println("-------------------------------");

        secondTrainSet.remove(obj1);
        secondTrainSet.remove(obj2);
        System.out.println(Arrays.toString(secondTrainSet.toArray())+"\n");
        System.out.println("-------------------------------");
        secondTrainSet.addAll(firstTrainSet);
        System.out.println(Arrays.toString(secondTrainSet.toArray())+"\n");
        System.out.println("-------------------------------");
        secondTrainSet.clear();
        System.out.println("["+Arrays.toString(secondTrainSet.toArray())+"]");
        System.out.println("-------------------------------");

        Iterator<Train> trainIterator = trainSet.iterator();
        System.out.println(trainIterator.hasNext());
        System.out.println(trainIterator.next());
    }
}
