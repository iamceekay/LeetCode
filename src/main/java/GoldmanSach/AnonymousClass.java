package GoldmanSach;

 class AnonymousClass {
     public void createMethod() {
         System.out.println("Creating one Method");
     }
     public void createMethod2() {
         System.out.println("Creating two Method");
     }
 }
 class anonymous2 extends AnonymousClass{
        @Override
        public void createMethod() {
            System.out.println("Creating one Method anonymous 2");
        }
    }
class  example{
    public static void main(String[] args) {
        AnonymousClass anno=new anonymous2(){
            @Override
            public void createMethod() {
                System.out.println("inside Anonymous");
            }

            @Override
            public void createMethod2() {
                System.out.println("inside Anonymous memthod 2");
            }
        };
        anno.createMethod();
        anno.createMethod2();
    }
}

