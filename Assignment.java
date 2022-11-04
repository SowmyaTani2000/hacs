package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 */

import java.util.*;
import java.text.DateFormat;

public class Assignment {

  public String AssName;
  public Date DueDate =new Date();
  public String AssSpec;
  public SolutionList theSolutionList=new SolutionList();
  public Solution SuggestSolution=new Solution();

  public Assignment() {

    System.out.println("Assignment is implemented");
  }

  public void setDueDate(Date theDueDate) { this.DueDate = theDueDate; }
  public void setAssSpec(String theSpec){ this.AssSpec = theSpec; }
  public String getAssSpec(){
    return this.AssSpec;
  }
  public boolean IsOverDue(){
    Date today;
    today = new Date();
    if (today.after(this.DueDate)) {
      return true;
    }
    else {
      return false;
    }
  }

  public Solution addSolution() {
    Solution mySolution = new Solution();
    return mySolution;
  }

  ////add the theSolution to the Solutionlist
  public void addSolution(Solution theSolution) {
    theSolutionList.add(theSolution);
  }
  public Solution getSuggestedSolution() { return SuggestSolution; }
  public void submitSolution(){

    System.out.println("submit the solution implemented");
  }

  public List<Integer> getSolutionList(){
    List<Integer> list = new ArrayList<Integer>();
    list.add(0);
    System.out.println("get the solution implemented");
    return list;
  }

  /* return the solution of the given name
  */
  public Solution getSolution(String studentname) {
    SolutionIterator Iterator=getSolutionIterator();
    return (Solution)Iterator.next(studentname);
  }

  public Solution getSuggestSolution(){

    return SuggestSolution;
  }

  public SolutionIterator getSolutionIterator() { return new SolutionIterator(theSolutionList);}


  public String toString() {
    return AssName;
  }

  public String getDueDateString() {
    DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
    return  dateFormat.format(DueDate);
  }

  public void accept(NodeVisitor visitor) {
    visitor.visitAssignment(this);
    accepted=true;
  }
}