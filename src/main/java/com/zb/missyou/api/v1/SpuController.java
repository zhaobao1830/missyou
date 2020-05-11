package com.zb.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.zb.missyou.bo.PageCounter;
import com.zb.missyou.exception.http.NotFoundException;
import com.zb.missyou.model.Banner;
import com.zb.missyou.model.Spu;
import com.zb.missyou.service.SpuService;
import com.zb.missyou.util.CommonUtil;
import com.zb.missyou.vo.PagingDozer;
import com.zb.missyou.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/spu")
@Validated
public class SpuController {

    @Autowired
    private SpuService spuService;

    @RequestMapping(value = "/id/{id}/detail", method = RequestMethod.GET)
    public Spu getDetail(@PathVariable @Positive Long id) {
        Spu spu = spuService.getSpu(id);
        if (spu == null) {
            throw new NotFoundException(30003);
        }
        return spu;
    }

    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    public PagingDozer<Spu, SpuSimplifyVO> getLatestSpuList(@RequestParam(defaultValue = "0") Integer start,
                                                            @RequestParam(defaultValue = "10") Integer count
    ) {
        PageCounter pageCounter = CommonUtil.converToPageParameter(start, count);
        // 从数据库查询出的数据
        Page<Spu> page = spuService.getLatestPagingSpu(pageCounter.getPage(), pageCounter.getCount());
        return new PagingDozer<>(page, SpuSimplifyVO.class);
    }

    @RequestMapping(value = "/by/category/{id}", method = RequestMethod.GET)
    public PagingDozer<Spu, SpuSimplifyVO> getByCategoryId(@PathVariable(name = "id") @Positive Long id,
                                                           @RequestParam(name = "is_root") Boolean isRoot,
                                                           @RequestParam(name = "start", defaultValue = "0") Integer start,
                                                           @RequestParam(name = "count", defaultValue = "10") Integer count) {
        return null;
    }
}
