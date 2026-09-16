package org.example.atm;

import org.example.atm.bank.MockBankService;
import org.example.atm.cash.*;
import org.example.atm.model.Card;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        MockBankService bank = new MockBankService();

        NoteHandler chain = new Note2000Handler(10);
        chain.setNext(new Note500Handler(20)).setNext(new Note100Handler(50));
        Atm atm = new Atm(bank, new CashDispenser(chain));

        Card card = new Card("CARD-1", "ACC-1", LocalDate.now().plusYears(2));
        atm.insertCard(card);
        atm.enterPin("1234");
        atm.withdraw(3500);
    }
}