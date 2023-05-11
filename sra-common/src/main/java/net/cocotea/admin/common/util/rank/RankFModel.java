package net.cocotea.admin.common.util.rank;

public class RankFModel {
    private Integer ranking;
    private Float quantity;

    public Integer getRanking() {
        return ranking;
    }

    public RankFModel setRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public Float getQuantity() {
        return quantity;
    }

    public RankFModel setQuantity(Float quantity) {
        this.quantity = quantity;
        return this;
    }
}
