package main;

import java.io.IOException;
import java.util.List;
import model.Histogram;
import model.Mail;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;

public class Kata6 {

    private List<Mail> mailList;
    Histogram<String> histogram;

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
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}