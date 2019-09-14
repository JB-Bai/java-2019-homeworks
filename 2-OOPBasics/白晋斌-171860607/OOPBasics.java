//This is my second java program.
//function: application of object-oriented programming
//written by Bai Jinbin


class Queue{
    public int[] queu;
    Queue(){
        this.queu=new int[7];
    }
    public void setq(int i,int j){
        queu[i]=j;
    }
}


class CalabashBrothers {
    private int nameOrder;
    private String name;
    private int colorOrder;
    private String color;
    private int curPosition;
    CalabashBrothers(int nO,String n,int cO,String c){
        this.nameOrder=nO;
        this.name=n;
        this.colorOrder=cO;
        this.color=c;
    }
    public void setPosition(int pos){
        this.curPosition=pos;
    }
    public void showName(){
        System.out.println("我叫"+name);
    }
    public void showColor(){
        System.out.println(color);
    }
    public int getNameOrder(){
        return nameOrder;
    }
    public int getColorOrder(){
        return colorOrder;
    }
    public int getPos(){
        return curPosition;
    }
    public void move(int dstPosition){
        System.out.println(name+":"+curPosition+"->"+dstPosition);
        this.curPosition=dstPosition;
    }
}
    
public class SortAlgorithm {
    static CalabashBrothers  calabro[]= new CalabashBrothers[7];
    static Queue Q= new Queue();
    public static void init(){
        
        calabro[0]=new CalabashBrothers(1, "老大", 1,"红色");
        calabro[1]=new CalabashBrothers(2, "老二", 2,"橙色");
        calabro[2]=new CalabashBrothers(3, "老三", 3,"黄色");
        calabro[3]=new CalabashBrothers(4, "老四", 4,"绿色");
        calabro[4]=new CalabashBrothers(5, "老五", 5,"青色");
        calabro[5]=new CalabashBrothers(6, "老六", 6,"蓝色");
        calabro[6]=new CalabashBrothers(7, "老七", 7,"紫色");
        Q=new  Queue();
        
    }
    public static void randStand(int time){
        if(time==1){
            for(int i=0;i<7;i++){
                int bias=0;
                switch(calabro[i].getNameOrder()%2){
                    case 0:bias=1;break;
                    case 1:bias=-1;break;
                }
                if(calabro[i].getNameOrder()==7){
                    bias=0;
                }
                int pos=(calabro.length+1-calabro[i].getNameOrder()+bias)%8;
                calabro[i].setPosition(pos);
                //System.out.println(pos-1);
                //System.out.println(i);
                Q.setq(pos-1,i);
                //range from 1 to 7
                //System.out.println(pos);
            }
        }
        else{
            for(int i=0;i<7;i++){
                int bias=0;
                switch(calabro[i].getNameOrder()%2){
                    case 0:bias=-1;break;
                    case 1:bias=1;break;
                }
                if(calabro[i].getNameOrder()==1){
                    bias=0;
                }
                int pos=(calabro.length+1-calabro[i].getNameOrder()+bias)%8;
                calabro[i].setPosition(pos);
                Q.setq(pos-1,i);
                //System.out.println(pos);
            }
        }
    }
    
    public static void bubbleSort(){
        for(int p=0;p<7;p++){
           for(int q=0;q<6-p;q++){
               int i=Q.queu[q];
               int j=Q.queu[q+1];
                if(calabro[i].getNameOrder()> calabro[j].getNameOrder()){
                    calabro[i].move(q+1+1); //queu:[0,6]     move pos:[1,7]
                    calabro[j].move(q+1);
                    Q.setq(q, j);
                    Q.setq(q+1, i);
                }          
            }
        }
    }
    public static void binarySort(){
        for(int p=1;p<7;p++){
            int tmp=Q.queu[p];
            int low=0;
            int high=p-1;
            int mid=-1;
            while(low<=high){
                mid = low + (high - low) / 2;
                if (calabro[Q.queu[mid]].getColorOrder() > calabro[Q.queu[p]].getColorOrder()) {
                    high = mid - 1;
                } else { 
                    low = mid + 1;
                }
            }
            //System.out.println("low:"+low+" high:"+high+" p:"+p);
            for(int j = p - 1; j >= low; j--) {
                //System.out.println("j:"+j);
                Q.queu[j+1]=Q.queu[j];
                calabro[Q.queu[j+1]].move(j+2);
            }
            Q.queu[low]=tmp;
            calabro[Q.queu[low]].move(low+1);
            //System.out.println(p);
            //report(2);
        }
    }
    public static void report(int num){
        if(num==1){
            for(int cur=0;cur<calabro.length;cur++){
                calabro[Q.queu[cur]].showName();
            }
        }
        else{
            for(int cur=0;cur<calabro.length;cur++){
                calabro[Q.queu[cur]].showColor();
            }
        }
    }
        
    public static void main(String args[]) {
        
        init();
        randStand(1);
        report(1);
        bubbleSort();
        report(1);
        randStand(2);
        report(2);
        binarySort();
        report(2);
    }    
}
//ISO 25010 软件质量模型
//功能适用性
//效率
//兼容性
//易用性
//可靠性
//安全性
//可维护性
//可移植性