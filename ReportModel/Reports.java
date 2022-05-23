package sep.gruppea.Report.ReportModel;

import java.time.Year;
import java.util.Date;

public class Reports {

    private int id;
    private String report;
    private String anliegen;




    public Reports(String report,  String anliegen) {
        this.id=id;
        this.report = report;
        this.anliegen = anliegen;

    }


    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getAnliegen() {
        return anliegen;
    }

    public void setAnliegen(String anliegen) {
        this.anliegen = anliegen;
    }


    public static Reportbuilder builder(){
        return new Reportbuilder();
    }

    @Override
    public String toString() {
        return "Reports{" +
                "report='" + report + '\'' +
                ", anliegen='" + anliegen + '\'' +
                ' }';
    }
}
