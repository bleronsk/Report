package sep.gruppea.Report.Reportdao;



import sep.gruppea.Report.ReportModel.Reports;

import java.sql.SQLException;
import java.util.List;


public interface Reportdao {

    List<Reports> findAll() throws SQLException;
    void add(Reports reports)throws SQLException;
    Reports findByReport(String fehler) throws SQLException;
    void delete(String fehler) throws SQLException;

}
