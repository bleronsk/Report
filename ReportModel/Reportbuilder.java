package sep.gruppea.Report.ReportModel;

public class Reportbuilder {

    private String report;
    private String anliegen;


    public Reportbuilder report(String report) {
        this.report = report;
        return this;
    }

    public Reportbuilder anliegen(String anliegen) {
        this.anliegen = anliegen;
        return this;
    }


    public Reports build() {
        return new Reports(report, anliegen);
    }
}