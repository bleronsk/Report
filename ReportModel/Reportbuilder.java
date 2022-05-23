package sep.gruppea.Report.ReportModel;

import java.util.Date;

public class Reportbuilder {

    private String report;
    private String anliegen;


    public sep.gruppea.Report.ReportModel.Reportbuilder report(String report){
        this.report=report;
        return this;
    }
    public sep.gruppea.Report.ReportModel.Reportbuilder anliegen(String anliegen){
        this.anliegen=anliegen;
        return this;
    }


    public Report build(){
        return new Report(report,anliegen);
    }
