package edu.ucsd.spendingtracker.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.ucsd.spendingtracker.model.Category;
import edu.ucsd.spendingtracker.model.Expense;

public class InMemoryDataSource {
    private List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public static InMemoryDataSource defaultDataSource() {
        InMemoryDataSource ds = new InMemoryDataSource();
        ds.addExpense(new Expense("Coffee", Category.FOOD, 4.5));
        ds.addExpense(new Expense("Bus Ticket", Category.TRANSPORT, 2.75));
        return ds;
    }
}

