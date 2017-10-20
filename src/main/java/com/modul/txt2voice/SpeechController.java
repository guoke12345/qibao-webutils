package com.modul.txt2voice;

import com.core.util.txt2voice.BaiDuApiUtil;
import jodd.util.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 张伟超
 * @create 2017/10/20 0020
 **/
@Controller
@RequestMapping(value = "SpeechController")
public class SpeechController implements ServletContextAware {
    private ServletContext servletContext;

    @RequestMapping(value = "/speech")
    public String speech(ModelMap modelMap){
        return "speech";
    }

    @ResponseBody
    @RequestMapping(value = "getVoice",method = RequestMethod.POST)
    public String getVoice(HttpServletRequest request){
        BaiDuApiUtil.text2mp3("直到现在，仍然不存在一项旨在网页上播放音频的标准。\n" +
                "今天，大多数音频是通过插件（比如 Flash）来播放的。然而，并非所有浏览器都拥有同样的插件。\n" +
                "HTML5 规定了一种通过 audio 元素来包含音频的标准方法。\n" +
                "audio 元素能够播放声音文件或者音频流。",getServletContext()+"textVoice","test.mp3");
        return "/textVoice/test.mp3";
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext=servletContext;
    }

    public String getServletContext() {
        return servletContext.getRealPath("/");
    }
}
