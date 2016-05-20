package com.kevin.common.utils.json;

import java.util.Arrays;

import com.kevin.common.utils.json.model.QualificationMsgModel;
import com.kevin.common.utils.json.model.QualificationOperationItem;

public class MultiClassToJson {

    public static void main(String[] args) {
        QualificationOperationItem item1 = new QualificationOperationItem();
        item1.setName("item1");
        item1.setOperation("add");
        item1.setValues(Arrays.asList("itemTest1"));
        
        QualificationOperationItem item2 = new QualificationOperationItem();
        item2.setName("item2");
        item2.setOperation("add");
        item2.setValues(Arrays.asList("itemTest2"));
        
        QualificationMsgModel msgModel = new QualificationMsgModel();
        msgModel.setBrandId(1111111L);
        msgModel.setChannelId(2222222L);
        msgModel.setOfferIds(Arrays.asList(333333L, 444444L));
        msgModel.setOperations(Arrays.asList(item1, item2));
        
        
    }
}
