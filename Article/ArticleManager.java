package me.pepe.ExamenCarrera.Ejercicio10.Article;

import java.util.Collection;
import java.util.HashMap;

public class ArticleManager {
	private HashMap<Integer, Article> articles = new HashMap<Integer, Article>();
	public ArticleManager() {}
	public Collection<Article> getArticles() {
		return articles.values();
	}
	public boolean hasArticle(String name) {
		for (Article art : getArticles()) {
			if (art.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	public boolean hasArticle(int id) {
		return articles.containsKey(id);
	}
	public Article getArticle(int id) {
		if (hasArticle(id)) {
			return articles.get(id);
		} else {
			return null;
		}
	}
	public Article getArticle(String name) {
		for (Article art : getArticles()) {
			if (art.getName().equalsIgnoreCase(name)) {
				return art;
			}
		}
		return null;
	}
	public int registerArticle(Article article) {
		int id = articles.values().size() + 1;
		articles.put(id, article);
		return id;
	}
}
