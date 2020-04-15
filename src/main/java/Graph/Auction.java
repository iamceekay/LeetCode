package Graph;

import java.util.*;

class InvalidProductException extends Exception
{
    public InvalidProductException(String s)
    {
        super(s);
    }
}

public class Auction {
    private boolean auctionLive = true;
    private List<Buyer> bidderList;
    private Seller seller;

    public Auction(List<Buyer> bidderList,  Seller seller) {
        this.bidderList = bidderList;
        this.seller=seller;
    }

    public boolean isAuctionLive() {
        return auctionLive;
    }

    public void setAuctionLive(boolean auctionLive) {
        this.auctionLive = auctionLive;
    }

    public List<Buyer> getBidderList() {
        return bidderList;
    }

    public void setBidderList(List<Buyer> bidderList) {
        this.bidderList = bidderList;
    }


    public Buyer findWinner() {
        setAuctionLive(false);
        return processBids();

    }

    private Buyer processBids() {

        HashMap<Double, Buyer> bidsMap = new HashMap<Double, Buyer>();
        TreeMap<Double, Integer> uniqueMap = new TreeMap<Double, Integer>(Collections.reverseOrder());
        for (Buyer eachParticipant : bidderList) {
            uniqueMap.put(eachParticipant.getAmount(), uniqueMap.getOrDefault(eachParticipant.getAmount(), 0) + 1);
            bidsMap.put(eachParticipant.getAmount(), eachParticipant);
        }
        for (Double key : uniqueMap.keySet()) {
            if (uniqueMap.get(key) == 1) {
                profitLoss(key);
                return bidsMap.get(key);
            }

        }
        return null;
    }
    public void profitLoss(double winningBid) {
        bidderList.sort((o1, o2) -> Double.compare(o2.getAmount(), o1.getAmount()));
        double pnl = winningBid + ((0.20) * ((bidderList.get(0).getAmount() + bidderList.get(bidderList.size() - 1).getAmount())) / bidderList.size());
        seller.setPnl(pnl);


    }


}

    class Buyer {
        private double max;
        private double min;
        private String name;
        private double amount;
        private Buyer WithdrawBid;

        public Buyer getWithdrawBid() {
            return WithdrawBid;
        }

        public Buyer setWithdrawBid(Buyer withdrawBid) {
            WithdrawBid = withdrawBid;
            return withdrawBid;
        }

        public Buyer(double max, double min, String name, double amount) {
            this.max = max;
            this.min = min;
            this.name = name;
            this.amount = amount;
        }

        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
        public void WithdrawBid() {
            this.max = 0.00;
            this.min = 0.00;
            this.name = null;
            this.amount = 0.00;
        }
        public boolean  updateBid (double updatedAmount) throws InvalidProductException
        {
            if(updatedAmount > getMax() || updatedAmount < getMin()) {
                throw new InvalidProductException("Invalid amount");
            }
            else
                this.setAmount(updatedAmount);
            return true;
        }

    }
    class Seller
    {
        private double max;
        private double min;
        private String Item;
        private String name;

        public double getPnl() {
            System.out.println("Profit and Loss of"+this.getName()+" "+pnl);
            return pnl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Seller(double max, double min, String item, String name) {
            this.max = max;
            this.min = min;
            Item = item;
            this.name = name;

        }

        public void setPnl(double pnl) {
            this.pnl = pnl;
        }

        private double pnl;


        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public String getItem() {
            return Item;
        }

        public void setItem(String item) {
            Item = item;
        }
    }
class AuctionBuilder {

    public Auction buildAuction(List<Buyer> bidders, Seller seller) {

        return new Auction(bidders, seller);

    }

}

class AuctionProcessor {

    private Auction auction;

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }


    public AuctionProcessor(Auction auction) {
        this.auction = auction;
    }

    public AuctionResult execute() {

        Buyer winningBidder = auction.findWinner();

        return new AuctionResult(winningBidder);

    }



}
 final class AuctionResult {

    private Buyer winningBidder;

    public AuctionResult(Buyer winningBidder) {
        this.winningBidder = winningBidder;
    }
    public void closeAuction() {

        System.out.println("The auction won by " + winningBidder.getName()  + " for the amount of $ " + winningBidder.getAmount());

    }

    public double getWinningAmount() {
        return winningBidder.getAmount();
    }

}
class AuctionCoordinator {

    public static void main(String[] args) throws InvalidProductException {

        AuctionBuilder auctionBuilder = new AuctionBuilder();
        Seller seller1=new Seller(100.00,10.00,"TV","seller1");
        Seller seller2=new Seller(100.00,10.00,"Radio","seller2");
        Buyer buyer1 = new Buyer(seller1.getMax(), seller1.getMin(), "CK", 35.00);
        Buyer buyer2 = new Buyer(seller1.getMax(), seller1.getMin(), "Rajiv", 14.00);
        Buyer buyer3 = new Buyer(seller1.getMax(), seller1.getMin(), "rahul", 35.00);
        Buyer buyerA = new Buyer(seller1.getMax(), seller1.getMin(), "CK", 35.00);
        Buyer buyerB = new Buyer(seller1.getMax(), seller1.getMin(), "Rajiv", 14.00);
        Buyer buyerC = new Buyer(seller1.getMax(), seller1.getMin(), "rahul", 15.00);
        buyer1.updateBid(95.00);// Update bid
        buyer1.WithdrawBid();
        List<Buyer> bidders = new ArrayList<Buyer>();
        bidders.add(buyer1);
        bidders.add(buyer2);
        bidders.add(buyer3);
        List<Buyer> bidders2 = new ArrayList<Buyer>();
        bidders2.add(buyerC);
        bidders2.add(buyerB);
        bidders2.add(buyerA);
        Auction auction1 = auctionBuilder.buildAuction(bidders,seller1);
        Auction auction2 = auctionBuilder.buildAuction(bidders2,seller2);
        new AuctionProcessor(auction1).execute().closeAuction();
        new AuctionProcessor(auction2).execute().closeAuction();
        seller1.getPnl();
        seller2.getPnl();
    }
}

