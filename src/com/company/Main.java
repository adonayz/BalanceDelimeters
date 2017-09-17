package com.company;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        LinkedList<Character> openingDelimeters = new LinkedList<>();
        openingDelimeters.add('(');
        openingDelimeters.add('{');
        openingDelimeters.add('[');

        LinkedList<Character> closingDelimeters = new LinkedList<>();
        closingDelimeters.add(')');
        closingDelimeters.add('}');
        closingDelimeters.add(']');

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        char[] inputChars = input.toCharArray();

        for(char currentChar: inputChars){
            if(openingDelimeters.contains(currentChar)){
                stack.push(currentChar);
            }else if(closingDelimeters.contains(currentChar)){
                boolean valid = true;
                switch (stack.peek()){
                    case '(':
                        if(valid = currentChar == ')'){
                            stack.pop();
                        }
                        break;
                    case '{':
                        if(valid = currentChar == '}'){
                            stack.pop();
                        }
                        break;
                    case '[':
                        if(valid = currentChar == ']'){
                            stack.pop();
                        }
                        break;
                }
                if(!valid){
                    System.out.println("False");
                    System.exit(0);
                }
            }else{
                System.out.println("NOT ALLOWED");
            }
        }

        if(stack.empty()){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}
