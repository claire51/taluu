package com.Question.dao;


import javax.ejb.Local;
import java.util.ArrayList;

/**
 * Created by Kelvin on 21/06/2018.
 */
//a common inteface
@Local
public interface Common {
   String  reverse(String inputString);
   int countTriplets(int n, int sum, int [] arr);
   boolean isTriplet(int arr[], int n);
   boolean isValid(String s) ;
   void genParenthesis(ArrayList<String> result, String s, int left, int right);
   ArrayList<Integer> findRow(int rowIndex) ;
}
