package org.apache.tools.ant.types;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class c implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f71572c = x00.a.a("win9x");

    /* renamed from: d, reason: collision with root package name */
    protected static final String f71573d;

    /* renamed from: a, reason: collision with root package name */
    private Vector f71574a = new Vector();

    /* renamed from: b, reason: collision with root package name */
    private String f71575b = null;

    /* loaded from: classes7.dex */
    public static class a extends org.apache.tools.ant.q {

        /* renamed from: a, reason: collision with root package name */
        private String[] f71576a;

        public String[] e() {
            return this.f71576a;
        }

        public void f(String str) {
            this.f71576a = new String[]{str};
        }
    }

    static {
        StringBuffer stringBuffer = new StringBuffer();
        String str = org.apache.tools.ant.util.p.f71726a;
        stringBuffer.append(str);
        stringBuffer.append("The ' characters around the executable and arguments are");
        stringBuffer.append(str);
        stringBuffer.append("not part of the command.");
        stringBuffer.append(str);
        f71573d = stringBuffer.toString();
    }

    protected static String e(String[] strArr, int i11) {
        if (strArr == null || strArr.length <= i11) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("argument");
        if (strArr.length > i11) {
            stringBuffer.append("s");
        }
        stringBuffer.append(":");
        stringBuffer.append(org.apache.tools.ant.util.p.f71726a);
        while (i11 < strArr.length) {
            stringBuffer.append("'");
            stringBuffer.append(strArr[i11]);
            stringBuffer.append("'");
            stringBuffer.append(org.apache.tools.ant.util.p.f71726a);
            i11++;
        }
        stringBuffer.append(f71573d);
        return stringBuffer.toString();
    }

    public static String f(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("Executing '");
        stringBuffer.append(strArr[0]);
        stringBuffer.append("'");
        if (strArr.length > 1) {
            stringBuffer.append(" with ");
            stringBuffer.append(e(strArr, 1));
        } else {
            stringBuffer.append(f71573d);
        }
        return stringBuffer.toString();
    }

    public static String k(String str) {
        if (str.indexOf("\"") > -1) {
            if (str.indexOf("'") > -1) {
                throw new BuildException("Can't handle single and double quotes in same argument");
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('\'');
            stringBuffer.append(str);
            stringBuffer.append('\'');
            return stringBuffer.toString();
        }
        if (str.indexOf("'") <= -1 && str.indexOf(" ") <= -1 && (!f71572c || str.indexOf(59) == -1)) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    public static String m(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < strArr.length; i11++) {
            if (i11 > 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append(k(strArr[i11]));
        }
        return stringBuffer.toString();
    }

    public void a(ListIterator listIterator) {
        for (int i11 = 0; i11 < this.f71574a.size(); i11++) {
            String[] e11 = ((a) this.f71574a.elementAt(i11)).e();
            if (e11 != null) {
                for (String str : e11) {
                    listIterator.add(str);
                }
            }
        }
    }

    public void b(ListIterator listIterator) {
        String str = this.f71575b;
        if (str != null) {
            listIterator.add(str);
        }
        a(listIterator);
    }

    public a c() {
        return d(false);
    }

    public Object clone() {
        try {
            c cVar = (c) super.clone();
            cVar.f71574a = (Vector) this.f71574a.clone();
            return cVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public a d(boolean z10) {
        a aVar = new a();
        if (z10) {
            this.f71574a.insertElementAt(aVar, 0);
        } else {
            this.f71574a.addElement(aVar);
        }
        return aVar;
    }

    public String[] g() {
        ArrayList arrayList = new ArrayList(this.f71574a.size() * 2);
        a(arrayList.listIterator());
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String[] i() {
        LinkedList linkedList = new LinkedList();
        b(linkedList.listIterator());
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public String j() {
        return this.f71575b;
    }

    public void l(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char c11 = File.separatorChar;
        this.f71575b = str.replace('/', c11).replace('\\', c11);
    }

    public String toString() {
        return m(i());
    }
}
