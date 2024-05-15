package Constant;
import java.util.HashMap;
import java.util.Map;

import Model.Classification;

public class ClassificationConst {

    public static final Map<Double, Classification> CLASSIFICATION_CONST_MAP = new HashMap<>();

    static {
        CLASSIFICATION_CONST_MAP.put(0.0, Classification.POOR);
        CLASSIFICATION_CONST_MAP.put(3.0, Classification.WEAK);
        CLASSIFICATION_CONST_MAP.put(5.0, Classification.AVERAGE);
        CLASSIFICATION_CONST_MAP.put(6.5, Classification.GOOD);
        CLASSIFICATION_CONST_MAP.put(7.5, Classification.VERY_GOOD);
        CLASSIFICATION_CONST_MAP.put(9.0, Classification.EXCELLENT);
    }

}
