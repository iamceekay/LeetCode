package Concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        int course=4;
       int[][] prerequisite ={{1,0},{2,0},{3,1},{3,2}};
       findOrder(course,prerequisite);
    }
    static int N=0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(courses[i], result)) {
                return new int[0];
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    private static boolean isCyclic(Course cur, int[] result) {
        if (cur.tested == true) return false;
        if (cur.visited == true) return true;
        cur.visited = true;
        for (Course c : cur.pre) {
            if (isCyclic(c, result)) {
                return true;
            }
        }
        cur.tested = true;
        result[N++] = cur.number;
        return false;
    }

   static class Course {
        boolean visited = false;
        boolean tested = false;
        int number;
        List<Course> pre = new ArrayList<Course>();
        public Course(int i) {
            number = i;
        }
        public void add(Course c) {
            pre.add(c);
        }
    }
}
