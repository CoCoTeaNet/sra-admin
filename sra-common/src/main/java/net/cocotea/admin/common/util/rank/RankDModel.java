package net.cocotea.admin.common.util.rank;

public class RankDModel {
    private Integer ranking;
    private Double quantity;

    public Integer getRanking() {
        return ranking;
    }

    public RankDModel setRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public Double getQuantity() {
        return quantity;
    }

    public RankDModel setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }
}
