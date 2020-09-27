import com.fasterxml.jackson.databind.ObjectMapper
import net.sf.jasperreports.engine.JRDataSource
import net.sf.jasperreports.engine.JasperCompileManager
import net.sf.jasperreports.engine.JasperExportManager
import net.sf.jasperreports.engine.JasperFillManager
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource
import net.sf.jasperreports.engine.data.JsonDataSource
import java.io.File


fun main() {

    val jasperReport = JasperCompileManager
            .compileReport("src/main/resources/employee.jrxml")

    val parameters = mutableMapOf<String, Any>()
    val dataBeanList = mutableListOf<Employee>()
    val employee = Employee().apply {
        firstName = "User_Name"
        lastName = "User_Last_Name"
        salary = "107000$"
    }
    parameters["title"] = "TEST"

    val json = ObjectMapper().writeValue(File("src/main/resources/employee.json"),employee)

    val dataSource: JRDataSource = JsonDataSource(File("src/main/resources/employee.json"))
    val beanColDataSource = JRBeanCollectionDataSource(dataBeanList)

    val jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource)

    val outDir = File("C:/jasperoutput")
    outDir.mkdirs()

    JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/jasperoutput/employee.pdf")

    println("Done!")

}

