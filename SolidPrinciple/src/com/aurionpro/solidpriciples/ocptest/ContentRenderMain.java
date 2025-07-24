package com.aurionpro.solidpriciples.ocptest;


import com.aurionpro.solidpriciples.ocpmodel.Article;
import com.aurionpro.solidpriciples.ocpmodel.ContentRender;
import com.aurionpro.solidpriciples.ocpmodel.IContentType;
import com.aurionpro.solidpriciples.ocpmodel.Podcast;
import com.aurionpro.solidpriciples.ocpmodel.QuizContent;
public class ContentRenderMain {
    public static void main(String[] args) {
        ContentRender renderer = new ContentRender();

        
        IContentType article = new Article();
        IContentType quiz = new QuizContent();
        IContentType podcast = new Podcast();

     
        renderer.render(article);
        renderer.render(quiz);
        renderer.render(podcast);
    }
}