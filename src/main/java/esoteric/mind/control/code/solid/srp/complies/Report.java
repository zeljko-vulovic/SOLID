package esoteric.mind.control.code.solid.srp.complies;

import com.google.gson.Gson;

//!SRP conformed
public class Report {

    //!SRP, 1 reason for change: print reports
    public static String asJson(int sum) {
        String area = "{\"area\": " + sum + "}";
        return new Gson().toJson(area);
    }

    public static String asXML(int sum) {
        return "<area>%d<\\area>".formatted(sum);
    }
}
