package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.ArticleService;
import madvirus.spring.chap06.service.NewArticleCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        return "article/newArticleForm";
    }

    /*
      - HTML 폼에 입력한 데이터를 자바빈 객체로 전달 받는 방법:
        ㅁ. 단지 @RequestMapping 어노테이션이 적용된 메서드의 파라미터로 자바빈 타입을 추가해주면 된다.
        ex. submit(NewArticleCommand command)
      - 뷰에서 @RequestMapping 오노테이션 메서드에서 전달 받은 객체는 자동으로 모델에 추가되어 적근 가능하다
        ㅁ.
      - 뷰에서 사용할 모델의 이름을 변경하고 싶다면 ModelAttribute()를 사용하면 된다.
        ㅁ. ${newArticleCommand.title} -> ${command.title}
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") NewArticleCommand command) {
        articleService.writeArticle(command);
        return "article/newArticleSubmitted";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String submit(NewArticleCommand command) {
//        System.out.println(command.getTitle());
//        return "article/newArticleSubmitted";
//    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

}