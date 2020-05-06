package com.zb.missyou.api.v1;

import com.zb.missyou.exception.http.NotFoundException;
import com.zb.missyou.model.Banner;
import com.zb.missyou.model.Spu;
import com.zb.missyou.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
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
    public List<Spu> getLatestSpuList() {
        return spuService.getLatestPagingSpu();
    }
}
