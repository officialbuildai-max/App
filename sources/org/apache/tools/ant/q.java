package org.apache.tools.ant;

/* loaded from: classes7.dex */
public abstract class q implements Cloneable {
    protected String description;
    protected Location location = Location.UNKNOWN_LOCATION;
    protected Project project;

    public Object clone() {
        q qVar = (q) super.clone();
        qVar.setLocation(getLocation());
        qVar.setProject(getProject());
        return qVar;
    }

    public String getDescription() {
        return this.description;
    }

    public Location getLocation() {
        return this.location;
    }

    public Project getProject() {
        return this.project;
    }

    public void log(String str) {
        log(str, 2);
    }

    public void log(String str, int i11) {
        if (getProject() != null) {
            getProject().x(str, i11);
        } else if (i11 <= 2) {
            System.err.println(str);
        }
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
