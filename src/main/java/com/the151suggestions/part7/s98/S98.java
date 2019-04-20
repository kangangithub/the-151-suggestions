package com.the151suggestions.part7.s98;

/**
 * 建议98:建议采用的顺序是list<T>,List<?>,List<Object>
 * <p>
 * Created by Akang on 2017/8/22.
 */
public class S98 {
    /**
     * 1.List<T>是确定的一个类型
     *      list<T>表示List集合中的元素都是T类型,具体类型运行期决定.
     *      List<?>表示List集合中的元素可以是任意类型
     *      List<Object>表示List集合中的元素为Object类型,即任意类型
     *
     * 2.List<T>可以进行读写操作
     *      List<T>可以进行add remove等操作,因为泛型是固定的T类型,在编码期不需要进行任何转型操作
     *      List<?>是只读类型,不能增加,修改,但可以删除,remove, clear,因为删除动作与泛型类型无关
     *      List<Object>可以读写,但写入时需向上转型,读取时需向下转型,泛型已失去存在意义
     */
}
