package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

/**
 * - @Controller 어노테이션은 해당 클래스가 스프링 MVC의 컨트롤러를 구현한 클래스라는 것을 지정함
 */
@Controller
public class HelloController {


    /**
     * @return the model and view
     * @RequestMapping 어노테이션은 값으로 지정한 요청 경로를 처리할 메서드를 설정함
     * - ModelAndView는 컨트롤러의 처리 결과를 보여줄 뷰와 뷰에서 출력할 모델을 지정할 때 사용함
     */
    @RequestMapping("/hello.do")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();

        // DispatcherServlet은 이 뷰이름과 매칭되는 뷰 구현체를 찾기 위해 ViewResolver를 사용한다.
        mav.setViewName("hello"); // ex. hello.jsp
        mav.addObject("greeting", getGreeting());
        return mav;
    }

    private String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 10) {
            return "좋은 아침입니다.";
        } else if (hour >= 12 && hour <= 15) {
            return "점심 식사는 하셨나요?";
        } else if (hour >= 18 && hour <= 22) {
            return "좋은 밤되세요";
        }
        return "안녕하세요";
    }

}
