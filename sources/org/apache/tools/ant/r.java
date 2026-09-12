package org.apache.tools.ant;

import java.util.Vector;

/* loaded from: classes7.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private Vector f71438a = new Vector();

    public static BuildException a(BuildException buildException, Location location) {
        if (buildException.getLocation() == null || buildException.getMessage() == null) {
            return buildException;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The following error occurred while executing this line:");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append(buildException.getLocation().toString());
        stringBuffer.append(buildException.getMessage());
        String stringBuffer2 = stringBuffer.toString();
        return location == null ? new BuildException(stringBuffer2, buildException) : new BuildException(stringBuffer2, buildException, location);
    }

    public static void b(Project project, Object obj, String str) {
        if (str == null) {
            return;
        }
        o.k(project, obj.getClass()).b(project, obj, str);
    }

    public static String c(String str) {
        int lastIndexOf = str.lastIndexOf(58);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String d(String str) {
        int lastIndexOf;
        return (str == null || (lastIndexOf = str.lastIndexOf(58)) == -1) ? "" : str.substring(0, lastIndexOf);
    }

    public static String e(String str, String str2) {
        if (str == null || str.equals("") || str.equals("antlib:org.apache.tools.ant")) {
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(":");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }
}
