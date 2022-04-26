package model;

public class Test {

    private int id;
    private String name;
    private Integer status_id;
    private String method_name;
    private int project_id;
    private int session_id;
    private String start_time;
    private String end_time;
    private String env;
    private String browser;
    private Integer author_id;

    public Test() {
    }

    public Test(String name, Integer status_id, String method_name, int project_id, int session_id,
                String start_time, String end_time, String env, String browser, Integer author_id) {

        this.name = name;
        this.status_id = status_id;
        this.method_name = method_name;
        this.project_id = project_id;
        this.session_id = session_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.env = env;
        this.browser = browser;
        this.author_id = author_id;
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

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Test{" + "\n" +
                "id=" + id + "\n" +
                "name='" + name + '\'' + "\n" +
                "status_id=" + status_id + "\n" +
                "method_name='" + method_name + '\'' + "\n" +
                "project_id=" + project_id + "\n" +
                "session_id=" + session_id + "\n" +
                "start_time='" + start_time + '\'' + "\n" +
                "end_time='" + end_time + '\'' + "\n" +
                "env='" + env + '\'' + "\n" +
                "browser='" + browser + '\'' + "\n" +
                "author_id=" + author_id + "\n" +
                '}';
    }
}
