package com.gyamin.pjmonitor.web.request;
import javax.validation.constraints.NotNull;

public class ProjectDataRequest {
    @NotNull(message = "プロジェクトIDは必須です。")
    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
