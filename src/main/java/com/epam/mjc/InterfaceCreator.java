package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase(){
        return x->{
            for(String elem: x)
            {
                if(!elem.equals(elem.toUpperCase()))
                {
                    return  false;
                }
            }
            return true;
        };
        }


    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x->{
            int endOfList = x.size();
            for(int i = 0; i<endOfList;i++ )
            {
                int currentValue = x.get(i);
                if( currentValue%2== 0)
                {
                    x.add(currentValue);
                }
            }

        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> newList = new LinkedList<>(values);
            for(String currentValue: values)
            {
                String[] words = currentValue.split(" ");
                if(!Character.isUpperCase(currentValue.charAt(0))
                        || currentValue.charAt(currentValue.length()-1) != '.'
                        || words.length <= 3) {
                    newList.remove(currentValue);
                }

                }
            return newList;
            };

    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return  x->{
            Map<String,Integer> map = new LinkedHashMap<>();
            for (String elem: x)
            {
                map.put(elem,elem.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1,list2)->{
            List<Integer> list3 = new ArrayList<>(list1);
            list3.addAll(list2);
            return  list3;
        };
    }
}
