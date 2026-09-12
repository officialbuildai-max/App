package org.apache.tools.ant;

/* loaded from: classes7.dex */
public class ExitStatusException extends BuildException {
    private static final long serialVersionUID = 7760846806886585968L;
    private int status;

    public ExitStatusException(int i11) {
        this.status = i11;
    }

    public ExitStatusException(String str, int i11) {
        super(str);
        this.status = i11;
    }

    public ExitStatusException(String str, int i11, Location location) {
        super(str, location);
        this.status = i11;
    }

    public int getStatus() {
        return this.status;
    }
}
