import com.fasterxml.jackson.annotation.JsonProperty

class Employee {
    @JsonProperty
    var firstName: String = ""

    @JsonProperty
    var lastName: String = ""

    @JsonProperty
    var salary: String = ""
}