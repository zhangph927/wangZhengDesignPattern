package edu.princeton.cs.myalg.u2.u2_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.awt.Color;

/**
 * Created by HuGuodong on 2018/7/18.
 */

public class Insertion {
  public  static void sort(Comparable[] a){
    int N = a.length;
    for(int i=0; i<N; i++){
      int j=i;
      for(; j>0 && less(a[j], a[j-1]); j--){
        exch(a, j, j-1);
      }
      // 显示排序的动态
      show(a,i,j);
    }
    assert isSorted(a);
  }

  private static boolean less(Comparable v, Comparable w){
    return v.compareTo(w)<0;
  }

  private static void exch(Object[] a, int i, int j){
    Object t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a){
    for(int i=0; i<a.length; i++){
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static void show(Comparable[] a, int sorted, int min) {
    StdDraw.enableDoubleBuffering();
    StdDraw.setYscale(0.0, 2);
    StdDraw.clear(Color.WHITE);
    int N = a.length;

    for (int i = 0; i < N; i++) {

      double x = 1.0 * i / N;
      double y = (double) a[i] / 2.0;
      double rw = 0.3 / N;
      double rh = (double) a[i] / 2.0;
      if (i <= sorted && i > min) {
        StdDraw.setPenColor(StdDraw.BLACK);
      } else if (i == min) {
        System.out.println(a[i]);
        StdDraw.setPenColor(Color.RED);
      } else {
        StdDraw.setPenColor(Color.GRAY);
      }
      StdDraw.filledRectangle(x, y, rw, rh);



      StdDraw.show();
      StdDraw.pause(50);
    }
//    StdDraw.clear();
  }

  public static boolean isSorted(Comparable[] a){
    for(int i=1; i<a.length; i++){
      if(less(a[i],a[i-1])){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String[] a = StdIn.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }

}
