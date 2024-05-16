package org.codingdojo.yatzy1.categoryManagement.enums;

import org.codingdojo.yatzy1.categoryManagement.enums.AllowedCategory;

public class AllowedCategoryUtil {
    public static AllowedCategory getAllowedCategory(String categoryName){
        try{
            return AllowedCategory.valueOf(categoryName.toUpperCase());
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Unknown category " + categoryName);
        }
    }

}
