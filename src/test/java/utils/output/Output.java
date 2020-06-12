
package utils.output;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "per_page",
        "total",
        "total_pages",
        "data",
        "ad"
})
public class Output {

    @JsonProperty("page")
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    @JsonProperty("data")
    private List<Datum> data = new ArrayList<Datum>();
    @JsonProperty("ad")
    private Ad ad;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonProperty("ad")
    public Ad getAd() {
        return ad;
    }

    @JsonProperty("ad")
    public void setAd(Ad ad) {
        this.ad = ad;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Output.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("page");
        sb.append('=');
        sb.append(((this.page == null) ? "<null>" : this.page));
        sb.append(',');
        sb.append("perPage");
        sb.append('=');
        sb.append(((this.perPage == null) ? "<null>" : this.perPage));
        sb.append(',');
        sb.append("total");
        sb.append('=');
        sb.append(((this.total == null) ? "<null>" : this.total));
        sb.append(',');
        sb.append("totalPages");
        sb.append('=');
        sb.append(((this.totalPages == null) ? "<null>" : this.totalPages));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null) ? "<null>" : this.data));
        sb.append(',');
        sb.append("ad");
        sb.append('=');
        sb.append(((this.ad == null) ? "<null>" : this.ad));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.total == null) ? 0 : this.total.hashCode()));
        result = ((result * 31) + ((this.perPage == null) ? 0 : this.perPage.hashCode()));
        result = ((result * 31) + ((this.ad == null) ? 0 : this.ad.hashCode()));
        result = ((result * 31) + ((this.data == null) ? 0 : this.data.hashCode()));
        result = ((result * 31) + ((this.totalPages == null) ? 0 : this.totalPages.hashCode()));
        result = ((result * 31) + ((this.page == null) ? 0 : this.page.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Output) == false) {
            return false;
        }
        Output rhs = ((Output) other);
        return ((((((((this.total == rhs.total) || ((this.total != null) && this.total.equals(rhs.total))) && ((this.perPage == rhs.perPage) || ((this.perPage != null) && this.perPage.equals(rhs.perPage)))) && ((this.ad == rhs.ad) || ((this.ad != null) && this.ad.equals(rhs.ad)))) && ((this.data == rhs.data) || ((this.data != null) && this.data.equals(rhs.data)))) && ((this.totalPages == rhs.totalPages) || ((this.totalPages != null) && this.totalPages.equals(rhs.totalPages)))) && ((this.page == rhs.page) || ((this.page != null) && this.page.equals(rhs.page)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
