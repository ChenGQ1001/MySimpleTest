package test.Gson;

import java.util.List;
import java.util.Map;

public class DefaultFwPolicyDto {
    private int id;
    private String name;
    private String protocol;
    private List<String> sourceIPList;
    private List<String> destIPList;
    private List<String> sourceZone;
    private List<String> destZone;
    private List<String> urlList;
    private String deviceGroup;
    private String permanent;
    private String logforward;
    private int fkgroupId;
    private String internalId;
    private List<String> serviceId;
    private String description;

    //    新增属性
    private String paAction;
    private List<String> paApplications;
    private String logStart;
    private String logEnd;
    private long startDate;
    private long endDate;
    private String serverResponse;
    private String profileGroup;

    private String scheduleInternalId;

    private String workOrderAction;

    public String getProfileGroup() {
        return profileGroup;
    }

    public void setProfileGroup(String profileGroup) {
        this.profileGroup = profileGroup;
    }

    public String getWorkOrderAction() {
        return workOrderAction;
    }

    public void setWorkOrderAction(String workOrderAction) {
        this.workOrderAction = workOrderAction;
    }

    public List<String> getPaApplications() {
        return paApplications;
    }

    public void setPaApplications(List<String> paApplications) {
        this.paApplications = paApplications;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getPermanent() {
        return permanent;
    }

    public void setPermanent(String permanent) {
        this.permanent = permanent;
    }

    public List<String> getSourceIPList() {
        return sourceIPList;
    }

    public void setSourceIPList(List<String> sourceIPList) {
        this.sourceIPList = sourceIPList;
    }

    public List<String> getDestIPList() {
        return destIPList;
    }

    public void setDestIPList(List<String> destIPList) {
        this.destIPList = destIPList;
    }

    public List<String> getSourceZone() {
        return sourceZone;
    }

    public void setSourceZone(List<String> sourceZone) {
        this.sourceZone = sourceZone;
    }

    public List<String> getDestZone() {
        return destZone;
    }

    public void setDestZone(List<String> destZone) {
        this.destZone = destZone;
    }

    public String getDeviceGroup() {
        return deviceGroup;
    }

    public void setDeviceGroup(String deviceGroup) {
        this.deviceGroup = deviceGroup;
    }

    public String getLogforward() {
        return logforward;
    }

    public void setLogforward(String logforward) {
        this.logforward = logforward;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public List<String> getServiceId() {
        return serviceId;
    }

    public void setServiceId(List<String> serviceId) {
        this.serviceId = serviceId;
    }

    public int getFkgroupId() {
        return fkgroupId;
    }

    public void setFkgroupId(int fkgroupId) {
        this.fkgroupId = fkgroupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaAction() {
        return paAction;
    }

    public void setPaAction(String paAction) {
        this.paAction = paAction;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getLogStart() {
        return logStart;
    }

    public void setLogStart(String logStart) {
        this.logStart = logStart;
    }

    public String getLogEnd() {
        return logEnd;
    }

    public void setLogEnd(String logEnd) {
        this.logEnd = logEnd;
    }

    public String getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }

    public String getScheduleInternalId() {
        return scheduleInternalId;
    }

    public void setScheduleInternalId(String scheduleInternalId) {
        this.scheduleInternalId = scheduleInternalId;
    }

	public List<String> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<String> urlList) {
		this.urlList = urlList;
	}

	
    
}
