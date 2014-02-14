package madvirus.spring.chap06.service;

public class ArticleService {

    public void writeArticle(NewArticleCommand command) {
        System.out.println("writing article: " + command);
    }
}
