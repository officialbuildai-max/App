package org.apache.tools.ant;

/* loaded from: classes7.dex */
public class ExitException extends SecurityException {
    private static final long serialVersionUID = 2772487854280543363L;
    private int status;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ExitException(int r3) {
        /*
            r2 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "ExitException: status "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            r2.status = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.ExitException.<init>(int):void");
    }

    public ExitException(String str, int i11) {
        super(str);
        this.status = i11;
    }

    public int getStatus() {
        return this.status;
    }
}
