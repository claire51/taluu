package com.Question.dao.Impl;

import com.Question.dao.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Kelvin on 21/06/2018.
 */
public class CommonImpl implements Common{
    @Override
    public String reverse(String inputString) {
        char[] inputStringArray = inputString.toCharArray();
        int k = 0;
        int m = inputStringArray.length - 1;
//        While k is smaller than m, do following
        while (k < m) {
//            checks if character is of type special character
//            If character at[k] is not an alphabetic character, do k++
            if (!Character.isAlphabetic(inputStringArray[k])) {
                k++;
            }
//            Else If character at [m] is not an alphabetic character, do m--
            else if (!Character.isAlphabetic(inputStringArray[m])) {
                m--;
            } else {
//                Else swap str[k] and str[m]
                char tempChar = inputStringArray[k];
                inputStringArray[k] = inputStringArray[m];
                inputStringArray[m] = tempChar;
                k++;
                m--;
            }
        }
        return new String(inputStringArray);

    }

    @Override
    public int countTriplets(int n, int sum ,int [] arr) {
        // Initialize result
        int ans = 0;

        // Fix the first element as A[i]
        for (int i = 0; i < n-2; i++)
        {
            // Fix the second element as A[j]
            for (int j = i+1; j < n-1; j++)
            {
                // Now look for the third number
                for (int k = j+1; k < n; k++)
                    if (arr[i] + arr[j] + arr[k] < sum)
                        ans++;
            }
        }

        return ans;

    }

    @Override
    public boolean isTriplet(int[] arr, int n) {
        // Square array elements
        for (int i=0; i<n; i++)
            arr[i] = arr[i]*arr[i];

        // Sort array elements
        Arrays.sort(arr);

        // Now fix one element one by one and find the other two
        // elements
        for (int i = n-1; i >= 2; i--)
        {
            // To find the other two elements, start two index
            // variables from two corners of the array and move
            // them toward each other
            int l = 0; // index of the first element in arr[0..i-1]
            int r = i-1; // index of the last element in arr[0..i-1]
            while (l < r)
            {
                // A triplet found
                if (arr[l] + arr[r] == arr[i])
                    return true;

                // Else either move 'l' or 'r'
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }

    @Override
    public boolean isValid(String s) {
        int length=s.length();
        char [] array=s.toCharArray();
        if(length==0) return true;
        Stack<Character> stack=new Stack<Character>();
        for(int i=0; i<length; i++)
        {
            if(array[i]=='(' || array[i]=='{' || array[i]=='[' )
            {
                stack.push(array[i]);
            }
            if(array[i]==')' ||array[i]=='}' ||array[i]==']')
            {
                if(stack.isEmpty()) return false;
                char temp=stack.pop();
                if((temp=='(' && array[i]==')' ) || (temp=='{' && array[i]=='}' ) ||(temp=='[' && array[i]==']' )  )
                {
                    continue;
                }else
                {
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    @Override
    public  void genParenthesis(ArrayList<String> result, String s, int left, int right){
        if(left > right)
            return;

        if(left==0&&right==0){
            result.add(s);
            return;
        }

        if(left>0){
            genParenthesis(result, s+"(", left-1, right);
        }

        if(right>0){
            genParenthesis(result, s+")", left, right-1);
        }

    }

    @Override
    public  ArrayList<Integer> findRow(int rowIndex) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if(rowIndex<0)
            return results;
        results.add(1);
        for(int i=1;i<=rowIndex;i++)
        {
            for(int j=results.size()-2;j>=0;j--)
            {
                results.set(j+1,results.get(j)+results.get(j+1));
            }
            results.add(1);
        }
        return results;
    }

    }


