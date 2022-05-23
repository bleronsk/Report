package sep.gruppea.Report.ReportController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import sep.gruppea.Report.Reportdao.ReportImp;
import sep.gruppea.Report.ReportModel.Reports;


import javax.mail.internet.MimeBodyPart;
import java.sql.SQLException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class Reportanlegen {

    private Reports reports;
    private ReportImp reportImp = new ReportImp();


    @GetMapping("/ReportUser")
    public String addReport() {
        return "addReport";
    }

    @PostMapping("/ReportUser")
    public String addReport(@RequestParam("report") String report,
                            @RequestParam("anliegen") String anliegen
    ) throws SQLException {

        reportImp.add(reports.builder()
                .report(report)
                .anliegen(anliegen)
                .build());

        return "redirect:";
    }
}
