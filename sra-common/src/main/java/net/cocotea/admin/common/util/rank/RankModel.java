package net.cocotea.admin.common.util.rank;

public class RankModel {
    private Integer ranking;
    private Long quantity;

    public Integer getRanking() {
        return ranking;
    }

    public RankModel setRanking(Integer ranking) {
        this.ranking = ranking;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public RankModel setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }
}
