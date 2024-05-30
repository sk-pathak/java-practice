public class guess {
    public void start(int n){
        int num=(int)(Math.random()*100);
        System.out.println("Number to guess: "+num);
        while(true){
            for(int i=1;i<=n;i++){
                int x=(int)(Math.random()*100);
                System.out.println("player "+i+" Guessed: "+x);
                if(x==num){
                    System.out.println("player "+i+" won!!!");
                    return;
                }
            }
            System.out.println();
        }
    }
}