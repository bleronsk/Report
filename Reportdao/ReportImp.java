package sep.gruppea.Report.Reportdao;

import sep.gruppea.Report.ReportModel.Reports;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ReportImp implements Reportdao {
    @Override
    public List<Reports> findAll()  {
        Connection con = DBConnectionReport.getConnection();
        if( con == null){
            return null;
        }
        List<Reports> reportes = new LinkedList<>();
        String query =  "SELECT * FROM reports;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){

                Reports report = Reports.builder()
                        .report(resultSet.getString("report"))
                        .anliegen(resultSet.getNString("filmLeange"))
                        .build();

                reportes.add(report);

            }

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        } finally {
            try{
                con.close();
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return reportes;
    }

    @Override
    public void add(Reports reports)  {
        Connection con = DBConnectionReport.getConnection();
        if (con == null) {
            return;
        }
        if (findByName(reports.getReport()) != null) {
            String query = "UPDATE reports SET report=?,anliegen=? WHERE report=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, reports.getReport());
                preparedStatement.setString(2, reports.getAnliegen());


                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else {
            String query = "INSERT INTO reports(report,anliegen) VALUES(?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1, reports.getReport());
                preparedStatement.setString(2, reports.getAnliegen());


                preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Reports findByReport(String fehler) throws SQLException {
        return null;
    }


    @Override
    public Reports findByName(String name)  {
        Connection con = DBConnectionReport.getConnection();
        if(con == null){
            return null;
        }else{
            String query = "SELECT * FROM reports WHERE reports=?;";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {

                preparedStatement.setString(1,name);
                ResultSet resultSet= preparedStatement.executeQuery();
                if(resultSet.next()){
                    return  Reports.builder()
                            .report(resultSet.getString("report"))
                            .anliegen(resultSet.getNString("anliegen"))
                            .build();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                } catch (SQLException sqlException){
                    sqlException.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void delete(String name)  {

        Connection con = DBConnectionReport.getConnection();
        if(con == null){
            return;
        }
        String query = "DELETE FROM report WHERE report=?;";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1,name);
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }

    @Override
    public List<Reports> findFilmBySearchParamters(String report, String anliegen,){
        Connection conn = DBConnectionReport.getConnection();
        if( conn == null){
            return null;
        }

        List<Reports> reports = new LinkedList<>();
        String query =  "SELECT * FROM reports where " +whereClauselWriter(report,anliegen);
        System.out.println(query);
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet resultSet= ps.executeQuery();
            while (resultSet.next()){
                Reports rep = Reports.builder()
                        .report(resultSet.getString("report"))
                        .anliegen(resultSet.getNString("anliegen"))
                        .build();
                reports.add(rep);
            }

        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return reports;
    }

    private String whereClauselWriter(String report, String anliegen) {
        String res = "";

        if(report.trim() != "" ){
            res = res + " report like '%" +report +"%' and";
        }
        if(anliegen.trim() != ""){
            res = res + " anliegen like '%" +anliegen +"%' and";
        }
        return res.substring(0,res.length()-3);
    }

}

