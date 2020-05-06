package com.zb.missyou.api.v1;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.zb.missyou.exception.http.NotFoundException;
import com.zb.missyou.model.Banner;
import com.zb.missyou.model.Spu;
import com.zb.missyou.service.SpuService;
import com.zb.missyou.vo.SpuSimplifyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<SpuSimplifyVO> getLatestSpuList() {
//        使用DozerBeanMapper拷贝属性
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        List<Spu> spuList = spuService.getLatestPagingSpu();
        List<SpuSimplifyVO> vos = new ArrayList<>();
        spuList.forEach(s -> {
            // s是源文件，SpuSimplifyVO.class是目标文件的class
            SpuSimplifyVO vo = mapper.map(s, SpuSimplifyVO.class);
            vos.add(vo);
        });
        return vos;
    }
}
