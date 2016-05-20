package com.kevin.common.utils.json.model;

import java.util.List;

public class QualificationMsgModel {

    private long brandId;
    private long channelId;
    private List<Long> offerIds;
    private List<QualificationOperationItem> operations;
    
    public long getBrandId() {
        return brandId;
    }
    
    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }
    
    public long getChannelId() {
        return channelId;
    }
    
    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }
    
    public List<Long> getOfferIds() {
        return offerIds;
    }
    
    public void setOfferIds(List<Long> offerIds) {
        this.offerIds = offerIds;
    }
    
    public List<QualificationOperationItem> getOperations() {
        return operations;
    }
    
    public void setOperations(List<QualificationOperationItem> operations) {
        this.operations = operations;
    }
}
