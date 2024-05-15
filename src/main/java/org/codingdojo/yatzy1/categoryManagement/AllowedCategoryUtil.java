package org.codingdojo.yatzy1.categoryManagement;

public class AllowedCategoryUtil {
    public static AllowedCategory getAllowedCategory(String categoryName){
        try{
            return AllowedCategory.valueOf(categoryName);
        } catch (IllegalArgumentException ex){
            throw new IllegalArgumentException("Unknown category " + categoryName);
        }
    }

}
