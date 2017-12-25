package controller;

import java.io.IOException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata6 {

    private List<Mail> mailList;
    MailHistogramBuilder<Mail> builder;
    Histogram<String> domains;
    Histogram<Character> letters;

    public static void main(String[] args) throws IOException {
        new Kata6().execute();
    }

    public void execute() throws IOException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        String filname = "emails.txt";
        mailList = MailListReader.read(filname);
    }

    private void process() {
        builder = new MailHistogramBuilder<>(mailList);
        domains = builder.build((Mail item) -> item.getMail().split("@")[1]);
        letters = builder.build((Mail item) -> item.getMail().charAt(0));
    }

    private void output() {
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer Caracter").execute();
    }
}
