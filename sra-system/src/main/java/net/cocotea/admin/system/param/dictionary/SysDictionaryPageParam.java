package net.cocotea.admin.system.param.dictionary;

import net.cocotea.admin.system.vo.SysDictionaryVO;
import org.sagacity.sqltoy.model.Page;

import java.io.Serializable;

/**
 * 字典分页参数
 * @author jwss
 * @date 2022-3-22
 */
public class SysDictionaryPageParam extends Page<SysDictionaryVO> implements Serializable {
    private static final long serialVersionUID = 8818887425379309640L;

    private SysDictionaryVO dictionary;

    public SysDictionaryVO getDictionary() {
        return dictionary;
    }

    public SysDictionaryPageParam setDictionary(SysDictionaryVO dictionary) {
        this.dictionary = dictionary;
        return this;
    }
}
