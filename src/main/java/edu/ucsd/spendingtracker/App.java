package edu.ucsd.spendingtracker;

import edu.ucsd.spendingtracker.datasource.InMemoryDataSource;
import edu.ucsd.spendingtracker.model.Model;
import edu.ucsd.spendingtracker.repository.ExpenseRepository;
import edu.ucsd.spendingtracker.presenter.SpendingPresenter;
import edu.ucsd.spendingtracker.view.SpendingView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Data layer
        InMemoryDataSource dataSource = InMemoryDataSource.defaultDataSource();

        // Domain layer (repository)
        ExpenseRepository repo = new ExpenseRepository(dataSource);

        // Model (presentation state + app logic)
        Model model = new Model(repo);

        // View
        SpendingView view = new SpendingView();

        // Presenter
        SpendingPresenter presenter = new SpendingPresenter(model, view);

        Scene scene = new Scene(presenter.getView(), 500, 600);
        stage.setTitle(presenter.getViewTitle());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
