package edu.ucsd.spendingtracker.model;

import java.util.List;

import edu.ucsd.spendingtracker.repository.ExpenseRepository;

public class Model {
    private final ExpenseRepository repo;

    public Model(ExpenseRepository repo) {
        this.repo = repo;
    }

    public void addExpense(String name, Category category, double amount) {
        repo.addExpense(new Expense(name, category, amount));
    }

    public List<Expense> getExpenses() {
        return repo.getExpenses();
    }
}

