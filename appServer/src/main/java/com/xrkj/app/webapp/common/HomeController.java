package com.xrkj.app.webapp.common;

import static com.xrkj.app.Constants.REQUEST_MAPPING_HOME;
import static com.xrkj.app.Constants.WELCOME_PAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xrkj.app.webapp.base.controller.BaseController;
import com.xrkj.app.webapp.common.viewObj.CommonVo;

/**
 * <pre>
 * 用了显示json格式的首页
 * </pre>
 *
 * @author wwh
 * @date 2015年7月4日 下午12:17:54
 *
 */
@RestController
@RequestMapping
public class HomeController extends BaseController {

    @RequestMapping(WELCOME_PAGE)
    public ModelAndView showIndexPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
        mv.addObject("hometitle", getText("home.title"));
        mv.addObject("textappname", getText("text.app.name"));
        mv.addObject("appname", getText("app.name"));
        mv.addObject("textappversion", getText("text.app.version"));
        mv.addObject("appversion", getText("app.version"));
        mv.addObject("textcompanyname", getText("text.company.name"));
        mv.addObject("companyname", getText("company.name"));
        mv.addObject("textcompanyurl", getText("text.company.url"));
        mv.addObject("companyurl", getText("company.url"));
        return mv;
    }

    @RequestMapping(REQUEST_MAPPING_HOME)
    public List<CommonVo> showHomePage(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {

        List<CommonVo> list = new ArrayList<CommonVo>();
        final String name = "app.name";
        CommonVo hvo = new CommonVo();
        hvo.setKey(name);
        hvo.setValue(getText(name));
        list.add(hvo);

        final String version = "app.version";
        CommonVo hvo1 = new CommonVo();
        hvo1.setKey(version);
        hvo1.setValue(getText(version));
        list.add(hvo1);

        final String companyName = "company.name";
        CommonVo hvo2 = new CommonVo();
        hvo2.setKey(companyName);
        hvo2.setValue(getText(companyName));
        list.add(hvo2);

        final String companyURL = "company.url";
        CommonVo hvo3 = new CommonVo();
        hvo3.setKey(companyURL);
        hvo3.setValue(getText(companyURL));
        list.add(hvo3);

        return list;
    }

}
