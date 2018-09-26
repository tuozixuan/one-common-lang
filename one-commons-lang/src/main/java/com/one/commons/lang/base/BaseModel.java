/*
 * 描述： Base Model
 * 修改人： tuozixuan
 * 修改时间： Sep 26, 2018
 * 项目： one-commons-lang
 */
package com.one.commons.lang.base;

import java.io.Serializable;

import com.one.commons.lang.utils.ObjectsUtils;


/**
 * Base Model<br>
 * 
 * @author tuozixuan
 * @version [版本号, Sep 26, 2018]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public abstract class BaseModel implements Serializable {
    
    @Override
    public String toString() {
        return ObjectsUtils.toString(this);
    }
}
