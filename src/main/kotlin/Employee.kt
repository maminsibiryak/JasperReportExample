import com.fasterxml.jackson.annotation.JsonProperty

class Employee {
    @JsonProperty("FIRST_NAME")
    var firstName: String = ""
    @JsonProperty("LAST_NAME")
    var lastName: String = ""
    @JsonProperty("SALARY")
    var salaty: String = ""
}