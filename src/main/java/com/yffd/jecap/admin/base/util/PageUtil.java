package com.yffd.jecap.admin.base.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yffd.jecap.admin.base.web.model.PageModel;
import com.yffd.jecap.admin.base.page.PageData;

public class PageUtil {

    public static Page toPage(PageModel model) {
        return new Page(model.getPageNum(), model.getPageSize());
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
