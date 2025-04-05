package commonLLDQuestions.parkingLot.dao;

public class Floor {

    private int floorNo;
    private int totalSpotCount;

    private int freeSpotCountForLV;

    private int freeSpotCountForHV;

    public Floor(int floorNo, int totalSpotCount){
        this.floorNo = floorNo;
        this.totalSpotCount = totalSpotCount;
        this.freeSpotCountForLV = this.totalSpotCount/2;
        this.freeSpotCountForHV = this.totalSpotCount - this.freeSpotCountForLV;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getTotalSpotCount() {
        return totalSpotCount;
    }

    public void setTotalSpotCount(int totalSpotCount) {
        this.totalSpotCount = totalSpotCount;
    }

    public int getFreeSpotCountForLV() {
        return freeSpotCountForLV;
    }

    public void setFreeSpotCountForLV(int freeSpotCountForLV) {
        this.freeSpotCountForLV = freeSpotCountForLV;
    }

    public int getFreeSpotCountForHV() {
        return freeSpotCountForHV;
    }

    public void setFreeSpotCountForHV(int freeSpotCountForHV) {
        this.freeSpotCountForHV = freeSpotCountForHV;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorNo=" + floorNo +
                ", totalSpotCount=" + totalSpotCount +
                ", freeSpotCountForLV=" + freeSpotCountForLV +
                ", freeSpotCountForHV=" + freeSpotCountForHV +
                '}';
    }
}
