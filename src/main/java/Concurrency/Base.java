package Concurrency;

 class Base<T> {
   void set(T t)
   {
       /***/
   }

     public static void main(String[] args) {
         Base<String> b=new Base<>();
         Base c=b;
     }
}

class Child extends Base {
    Child(String s) {
        System.out.println("sub-"+s);
    }

    public static void main(String[] args) {
        Base<String> b=new Base<>();
        Base c=b;
    }
}
