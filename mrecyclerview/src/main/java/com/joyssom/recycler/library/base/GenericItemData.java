package com.joyssom.recycler.library.base;
import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * @author Mr.Zang
 * @data 2018/07/16
 * description : 多条目适配 组装数据
 */
public class GenericItemData<T> {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({genericItemType.TYPE_ZERO, genericItemType.TYPE_ONE,
            genericItemType.TYPE_TWO, genericItemType.TYPE_THREE,
            genericItemType.TYPE_FOUR, genericItemType.TYPE_FIVE,
            genericItemType.TYPE_SIX, genericItemType.TYPE_SEVEN,
            genericItemType.TYPE_EIGHT, genericItemType.TYPE_NINE})
    public @interface genericItemType {
        int TYPE_ZERO = 0;
        int TYPE_ONE = 1;
        int TYPE_TWO = 2;
        int TYPE_THREE = 3;
        int TYPE_FOUR = 4;
        int TYPE_FIVE = 5;
        int TYPE_SIX = 6;
        int TYPE_SEVEN = 7;
        int TYPE_EIGHT = 8;
        int TYPE_NINE = 9;
    }

    private List<T> mTS;
    @genericItemType
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public GenericItemData(List<T> TS, @genericItemType int type) {
        mTS = TS;
        this.type = type;
    }

    public List<T> getTS() {
        return mTS;
    }

    public void setTS(List<T> TS) {
        mTS = TS;
    }
}
