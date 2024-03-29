package com.udbac.versionpublish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udbac.versionpublish.entity.Branch;
import com.udbac.versionpublish.service.BranchService;
import com.udbac.versionpublish.util.ResponseData;

@RestController
@RequestMapping("/branch")
public class BranchController {
    @Autowired
    BranchService branchService;

    /**
     * 添加渠道
     * 
     * @param branch
     * @return {@link ResponseData}
     */
    @RequestMapping("/insert")
    public ResponseData insert(@RequestBody Branch branch) {
        return branchService.insert(branch);
    }

    /**
     * 更新渠道
     * 
     * @param branch
     * @return {@link ResponseData}
     */
    @RequestMapping("/update")
    public ResponseData update(@RequestBody Branch branch) {
        return branchService.update(branch);
    }

    /**
     * 分页查找
     * 
     * @param branch
     * @param page
     * @return {@link ResponseData}
     */
    @RequestMapping("/findPage")
    public ResponseData findPage(@PageableDefault(page = 0, size = 10, sort = { "dcsid" })Pageable page) {
        return branchService.findPagination(page);
    }

    /**
     * 根据id删除
     * 
     * @param branch
     * @return {@link ResponseData}
     */
    @RequestMapping("/delete")
    public ResponseData delete(@RequestBody Branch branch) {
        return branchService.deleteById(branch);
    }
    /**
     * 根据省份渠道
     * @param province
     * @return {@link ResponseData}
     */
    @RequestMapping("/findByProvince")
    public ResponseData findByProvince(@RequestHeader String token) {
        return branchService.findByProvince(token);
    }
}
