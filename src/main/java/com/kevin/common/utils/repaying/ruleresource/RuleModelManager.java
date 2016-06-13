package com.kevin.common.utils.repaying.ruleresource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kevin.common.utils.repaying.enums.RuleTypeEnum;
import com.kevin.common.utils.repaying.model.RuleGroup;
import com.kevin.common.utils.repaying.model.RuleModel;

public class RuleModelManager {

    private volatile List<RuleGroup>                    rightsContainer = new ArrayList<RuleGroup>();
    private final static TypeReference<List<RuleGroup>> typeReference   = new TypeReference<List<RuleGroup>>(){};
    
    public static void main(String[] args) {
        RuleModelManager manager = new RuleModelManager();
        String config = manager.readFromFile();
        manager.rightsContainer = manager.parseRightsDefine(config);
        
        System.out.println(manager.rightsContainer);
//        RuleGroup group1 = new RuleGroup();
//        group1.setName("group1");
//        group1.setDescription("分组一");
//        group1.setPriority(1);
//        RuleModel rule1 = new RuleModel();
//        rule1.setName("rule1");
//        rule1.setDescription("规则一");
//        rule1.setRuleType(RuleTypeEnum.OFFER_SHIELD.name());
//        rule1.setRuleHandler(null);
//        RuleModel rule2 = new RuleModel();
//        rule2.setName("rule2");
//        rule2.setDescription("规则一");
//        rule2.setRuleType(RuleTypeEnum.OFFER_SHIELD.name());
//        rule2.setRuleHandler(null);
//        group1.setRuleModels(Arrays.asList(rule1, rule2));
//        
//        RuleGroup group2 = new RuleGroup();
//        group2.setName("group2");
//        group2.setDescription("分组一");
//        group2.setPriority(1);
//        RuleModel rule3 = new RuleModel();
//        rule3.setName("rule3");
//        rule3.setDescription("规则一");
//        rule3.setRuleType(RuleTypeEnum.OFFER_SHIELD.name());
//        rule3.setRuleHandler(null);
//        RuleModel rule4 = new RuleModel();
//        rule4.setName("rule4");
//        rule4.setDescription("规则一");
//        rule4.setRuleType(RuleTypeEnum.OFFER_SHIELD.name());
//        rule4.setRuleHandler(null);
//        group2.setRuleModels(Arrays.asList(rule3, rule4));
//        
//        System.out.println(JSON.toJSONString(Arrays.asList(group1, group2)));
    }
    
    private List<RuleGroup> parseRightsDefine(String config) {

        List<RuleGroup> result = JSON.parseObject(config, typeReference);

        return result;
//        rightsContainer = result;
    }
    
    private String readFromFile() {
        String data = null;
        InputStream is = null;
        try {
            File file = new File("D:/lunaworkspace/common.utils/src/main/resources/rule.json");
            is = new FileInputStream(file);
            StringWriter result = new StringWriter();
            PrintWriter out = new PrintWriter(result);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
            data = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) { // do nothing
                }
            }
        }
        return data;
    }
}


