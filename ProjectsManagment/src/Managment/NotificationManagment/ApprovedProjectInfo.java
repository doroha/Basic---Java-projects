package Managment.NotificationManagment;

public class ApprovedProjectInfo {

    private String projectName;
    private String description;
    private String publisher;
    private String url;

    public ApprovedProjectInfo (String pn,String de,String p,String url){
        this.projectName=pn;
        this.description=de;
        this.publisher=p;
        this.url=url;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription() {
        return description;
    }

    public String getPublish() {
        return publisher;
    }

    public String getUrl() {
        return url;
    }
}
