package catalog.view;


import catalog.dao.impl.connectionpool.ConnectionPoolException;
import catalog.controller.Controller;



public class View {

    public static void main(String[] args) throws ConnectionPoolException {
        Controller controller = new Controller();
        controller.executeCommand("add_news_item/book/The Old Man and the Sea/written by Ernest Hemingway/1995");
        controller.executeCommand("search_by_year/1991");
        controller.executeCommand("search_by_title/Pride_and_Prejudice");

    }
}
