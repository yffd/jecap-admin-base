package com.yffd.jecap.admin.base.helper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yffd.jecap.admin.base.page.PageData;
import com.yffd.jecap.admin.base.query.BaseQryParam;

public class PageHelper {

    public static Page toPage(BaseQryParam param) {
        return new Page(param.getPageNum(), param.getPageSize());
    }

    public static PageData fromPage(Page page) {
        return new PageData(
                Long.valueOf(page.getCurrent()).intValue(),
                Long.valueOf(page.getSize()).intValue(),
                Long.valueOf(page.getTotal()).intValue(),
                page.getRecords()
        );
    }

}
