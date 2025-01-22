package Polynomial_Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ANIL
 */
public class Proj_1_comp_2112 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the coefficient and power of the first polynomial. Type 0 at the end:");
        MyLinkedList firstList = new MyLinkedList();
        MyLinkedList secondList = new MyLinkedList();
        int input1 = 1;

        while (input1 != 0) {
              try{
                  input1 = scn.nextInt();
                  if (input1 == 0) {
                   break;
                  }
                  int input2 = scn.nextInt();
                   Node newnode = new Node(input1, input2);

                    addInOrder(firstList, newnode);
                }
             catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                 scn.next();
             }
            
        }

        int menu = 0;
        System.out.println("Enter the coefficient and power of the second polynomial. Type 0 at the end:");
        int input3 = 1;
         while (input3 != 0) {
                try{
                    input3 = scn.nextInt();
                    if (input3 == 0) {
                         break;
                    }
                    int input4 = scn.nextInt();
                    Node newnode2 = new Node(input3, input4);

                   addInOrder(secondList, newnode2);
                 }
             catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scn.next();
             }
            

        }
        System.out.println("The entered polynomials are: ");
        printPolinomial(firstList);
        printPolinomial(secondList);
        
        System.out.println("Which task you want to do?");
        System.out.println("1- Add");
        System.out.println("2- Multiply");
        System.out.println("3- Print");
        System.out.println("4- Delete");
        System.out.println("5- exit");
        while (menu != 5) {
            System.out.println("Please enter a digit (1-5):");
            try{
              menu = scn.nextInt();
            }
             catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer between 1 and 5.");
                 scn.next();
                  continue;
             }
            

            switch (menu) {
                case 1:
                    System.out.println("Adding two polynomials:");
                    printPolinomial(addPolinomials(firstList, secondList));

                    break;
                case 2:
                    System.out.println("Multiplying two polynomials:");
                    printPolinomial(multiplyPolinomal(firstList, secondList));
                    break;
                case 3:
                    System.out.println("The polynomials are:");
                    printPolinomial(firstList);
                    printPolinomial(secondList);

                    break;
                case 4:
                     try{
                       System.out.println("Which power you want to be delated from both polynomials?");
                         int delete = scn.nextInt();
                        deletePolinomials(firstList, secondList, delete);
                       System.out.println("The elements having this power has been delated.");
                    }
                      catch (InputMismatchException e) {
                         System.out.println("Invalid input for the delete power. Please enter an integer.");
                           scn.next();
                        }
                    catch (NullPointerException e){
                       System.out.println("There are no elements with the entered degree");
                        
                    }
                    

                    break;
                case 5:
                    System.out.println("Exiting the program …");
                    System.exit(0);
                    break;
                 default:
                      System.out.println("Invalid input. Please enter a number between 1 and 5.");
                     break;
            }
        }

    }

    public static void printPolinomial(MyLinkedList list) {
         if(list.first == null){
             System.out.println("There is nothing to print");
         } else {
        
        Node temp = list.first;
        while (temp != null) {

            System.out.print(temp.coef + "x^" + temp.power);
            if (temp.next != null) {
                System.out.print(" + ");
            }

            temp = temp.next;
        }
        System.out.println(" ");
      }

    }

    
    

    

    public static void addInOrder(MyLinkedList enteredList, Node newnode) {

        if (enteredList.first == null) {
            enteredList.first = newnode;
            enteredList.last = newnode;
        } else {
            if (enteredList.first.power < newnode.power) {
                newnode.next = enteredList.first;
                enteredList.first = newnode;
            } else if (enteredList.first.power == newnode.power) {
                enteredList.first.coef = enteredList.first.coef + newnode.coef;
            } else if (enteredList.last.power > newnode.power) {
                enteredList.last.next = newnode;
                enteredList.last = newnode;
            } else {
                
                Node prev = enteredList.first;
                while (prev.next != null && prev.next.power > newnode.power){
                    prev = prev.next;
                } 
                if (prev.next.power == newnode.power) {
                    prev.next.coef = prev.next.coef + newnode.coef;
                } else {
                   newnode.next=prev.next;
                   prev.next=newnode;
                }
            }
        }
    }

    public static MyLinkedList addPolinomials(MyLinkedList list1, MyLinkedList list2) {
        MyLinkedList newList = new MyLinkedList();
        Node temp = list1.first;
        int coef1;
        int power1;
        Node newNode1;
        int coef2;
        int power2;
        Node newNode2;

        while (temp != null) {
            coef1=temp.coef;
            power1=temp.power;
            newNode1=new Node(coef1, power1);

            addInOrder(newList, newNode1);
            temp = temp.next;

        }
        Node temp2 = list2.first;

        while (temp2!= null) {
           coef2=temp2.coef;
           power2=temp2.power;
           newNode2=new Node(coef2, power2);
            addInOrder(newList, newNode2);
           temp2=temp2.next;
        }
        return newList;
    }

    public static void deletePolinomials(MyLinkedList list1, MyLinkedList list2, int deleted) {
          if(list1.first==null|| list2.first==null){
                throw new NullPointerException("There are no nodes in one of the list");
            }
        Node prev1 = list1.first;
        Node temp1 = list1.first;
        if(deleted==list1.first.power){
            list1.first=list1.first.next;
        }else{
        
        while (temp1 != null) {

            if (temp1.power == deleted) {
                prev1.next = temp1.next;
                break;
            }
            prev1 = temp1;
            temp1 = temp1.next;
        }
        }
        if(deleted==list2.first.power){
            list2.first=list2.first.next;
        }else{

        Node prev2 = list2.first;
        Node temp2 = list2.first;
        while (temp2 != null) {
            if (temp2.power == deleted) {
                prev2.next = temp2.next;
                break;
            }
            prev2 = temp2;
            temp2 = temp2.next;
        }
    }
    }

    public static MyLinkedList multiplyPolinomal(MyLinkedList list1, MyLinkedList list2) {
        Node temp1 = list1.first;
        Node temp2 = list2.first;
        int finalcoef;
        int finalpower;
        Node newNode;
        MyLinkedList finalList = new MyLinkedList();
        while (temp1 != null) {

            while (temp2 != null) {
                finalcoef = temp1.coef * temp2.coef;
                finalpower = temp1.power + temp2.power;
                newNode = new Node(finalcoef, finalpower);
                addInOrder(finalList, newNode);

                temp2 = temp2.next;

            }
            temp2 = list2.first;

            temp1 = temp1.next;

        }
        return finalList;
    }

}