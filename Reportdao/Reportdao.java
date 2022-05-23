package sep.gruppea.Report.Reportdao;



import sep.gruppea.Report.ReportModel.Report;

import java.sql.SQLException;
import java.util.List;


public interface Reportdao {

    List<Report> findAll() throws SQLException;
    void add(Report report throws SQLException;
    Report findByReport(String fehler) throws SQLException;
    void delete(String fehler) throws SQLException;

}
