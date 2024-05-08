//Dallin Lyman
//cards with blackjack scoring
//you can't actually "bust" because there is no user input, but it is in the code
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class card {
    static int sus = 0;//int for drawing cards
    int type;
    int value;
    public card(int it, int iv){//value is the face value of the card, and type is the suite of the card
        type=it;
        value=iv;
    }
    public static void print(List<card> p, int pnum){//prints the cards the players had
        System.out.println("player "+pnum +":");
        for(card ii:p){
            if(ii.type==4){
                if(ii.value==1){
                    System.out.println("Spade "+ "Ace");
                }if(ii.value==11){
                    System.out.println("Spade "+ "Jack");
                }if(ii.value==12){
                    System.out.println("Spade "+ "Queen");
                }if(ii.value==13){
                    System.out.println("Spade "+ "King");
                }if(ii.value<=10)
                    System.out.println("Spade "+ ii.value);
                }
            if (ii.type==3) {
                if(ii.value==1){
                    System.out.println("Club "+ "Ace");
                }if(ii.value==11){
                    System.out.println("Club "+ "Jack");
                }if(ii.value==12){
                    System.out.println("Club "+ "Queen");
                }if(ii.value==13){
                    System.out.println("Club "+ "King");
                }if(ii.value<=10)
                    System.out.println("Club "+ ii.value);
            } if(ii.type==2) {
                if(ii.value==1){
                    System.out.println("Diamond "+ "Ace");
                }if(ii.value==11){
                    System.out.println("Diamond "+ "Jack");
                }if(ii.value==12){
                    System.out.println("Diamond "+ "Queen");
                }if(ii.value==13){
                    System.out.println("Diamond "+ "King");
                }if(ii.value<=10)
                    System.out.println("Diamond "+ ii.value);
            } if(ii.type==1){
                if(ii.value==1){
                    System.out.println("Heart "+ "Ace");
                }if(ii.value==11){
                    System.out.println("Heart "+ "Jack");
                }if(ii.value==12){
                    System.out.println("Heart "+ "Queen");
                }if(ii.value==13){
                    System.out.println("Heart "+ "King");
                }if(ii.value<=10)
                    System.out.println("Heart "+ ii.value);
            }
        }
    }
    public static void winner(List<card> p1,List<card> p2,List<card> p3){//determines who wins
        int p11=0;//p11,p21,and p31 are variables to determine how many aces a player has
        int p21=0;
        int p31=0;
        int p1i=0;//overall score
        int p2i=0;
        int p3i=0;
        for(card ii:p1){//for every card, it tests for if it is an ace or a face card
            if(ii.value==1){
                p11=11+p11;
                p1i=ii.value+p1i;
            }if(ii.value>=10){
                p1i=10+p1i;
            } else{
                p1i=ii.value+p1i;
            }
        }
        if(p1i>=22){//uses the number of aces to determine the score
            if(p11==1){
                p1i=p1i-10;
            }
            if(p11==2){
                p1i=1-p1i;
            }
            if(p1i>=22){
                p1i=0;
            }
        }
        for(card ii:p2){
            if(ii.value==1){
                p21=11+p21;
                p2i=ii.value+p2i;
            }if(ii.value>=10){
                p2i=10+p2i;
            } else{
                p2i=ii.value+p2i;
            }
        }
        if(p2i>=22){
            if(p21==1){
                p2i=p2i-10;
            }
            if(p21==2){
                p2i=1-p2i;
            }
            if(p2i>=22){
                p2i=0;
            }
        }
        for(card ii:p3){
            if(ii.value==1){
                p31=11+p31;
                p3i=ii.value+p3i;
            }if(ii.value>=10){
                p3i=10+p3i;
            } else{
                p3i=ii.value+p3i;
            }
        }
        if(p3i>=22){
            if(p31==1){
                p3i=p3i-10;
            }
            if(p31==2){
                p3i=1-p3i;
            }
            if(p3i>=22){
                p3i=0;
            }
        }
        if(p1i<=p2i){
            if(p2i<=p3i){
                System.out.println("Player 3 wins!");
            }else{
                System.out.println("Player 2 wins!");
            }
        } else{ if(p1i<=p3i){
            System.out.println("Player 3 wins!");
            } else{
                System.out.println("Player 1 wins!");
            }
        }
    }
    public static void main(String[] args){
        ArrayList<card> deck = new ArrayList<card>();//makes deck with all of the cards
        for(int e=1;e<5;e++){
        for(int n=1;n<14;n++){
            deck.add(new card(e, n));
            }}
        ArrayList<card> p1 = new ArrayList<card>();//makes players
        ArrayList<card> p2 = new ArrayList<card>();
        ArrayList<card> p3 = new ArrayList<card>();
        DealCard(deck,p1);//deals the cards
        DealCard(deck,p1);
        DealCard(deck,p2);
        DealCard(deck,p2);
        DealCard(deck,p3);
        DealCard(deck,p3);
        print(p1,1);//prints the cards the players had
        print(p2,2);
        print(p3,3);
        winner(p1, p2, p3);//determines the winner
    }
    public static void DealCard(List<card> source,List<card> destination){//this deals the card by a random number generator
    Random rand = new Random();
    destination.add(source.remove(rand.nextInt(52-sus)));
    sus++;//counts how many cards are taken
    }
    public class joker1 extends card{//I wrote joker 1 and 2 to extend off of card
        int type=5;
        public joker1(int type){//note: I wrote these because I did the project with one class and had to fill in requirements to show that I could use inheritance
            super(type, type);//these are not used but could be if wanted
        }
        public static void print(List<card> p){
            for(card ii:p){
                if(ii.type==5){
                    System.err.println("Joker");
                }
            }
        }
    }
    public class joker2 extends card{
        int type=5;
        public joker2(int type){
            super(type, type);
        }
        public static void print(List<card> p){
            for(card ii:p){
                if(ii.type==5){
                    System.err.println("Joker");
                }
            }
        }
    }
}