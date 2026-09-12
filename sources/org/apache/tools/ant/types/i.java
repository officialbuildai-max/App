package org.apache.tools.ant.types;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class i extends e implements Cloneable {

    /* renamed from: k, reason: collision with root package name */
    static /* synthetic */ Class f71595k;

    /* renamed from: a, reason: collision with root package name */
    private String f71596a = "@";

    /* renamed from: b, reason: collision with root package name */
    private String f71597b = "@";

    /* renamed from: c, reason: collision with root package name */
    private boolean f71598c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f71599d = true;

    /* renamed from: e, reason: collision with root package name */
    private Hashtable f71600e = null;

    /* renamed from: f, reason: collision with root package name */
    private Vector f71601f = new Vector();

    /* renamed from: g, reason: collision with root package name */
    private b f71602g = b.f71609d;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71603h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f71604i = 0;

    /* renamed from: j, reason: collision with root package name */
    private Vector f71605j = new Vector();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f71606a;

        /* renamed from: b, reason: collision with root package name */
        String f71607b;

        public a() {
        }

        public a(String str, String str2) {
            a(str);
            b(str2);
        }

        public void a(String str) {
            this.f71606a = str;
        }

        public void b(String str) {
            this.f71607b = str;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends f {

        /* renamed from: c, reason: collision with root package name */
        private static final String[] f71608c = {"fail", "warn", "ignore"};

        /* renamed from: d, reason: collision with root package name */
        public static final b f71609d = new b("fail");

        /* renamed from: e, reason: collision with root package name */
        public static final b f71610e = new b("warn");

        /* renamed from: f, reason: collision with root package name */
        public static final b f71611f = new b("ignore");

        public b() {
        }

        public b(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return f71608c;
        }
    }

    static /* synthetic */ Class d(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private void g(String str) {
        int a11 = this.f71602g.a();
        if (a11 == 0) {
            throw new BuildException(str);
        }
        if (a11 == 1) {
            log(str, 1);
        } else if (a11 != 2) {
            throw new BuildException("Invalid value for onMissingFiltersFile");
        }
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public synchronized Object clone() {
        if (isReference()) {
            return f().clone();
        }
        try {
            i iVar = (i) super.clone();
            iVar.f71605j = (Vector) e().clone();
            iVar.setProject(getProject());
            return iVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    protected synchronized Vector e() {
        if (isReference()) {
            return f().e();
        }
        if (!this.f71603h) {
            this.f71603h = true;
            int size = this.f71601f.size();
            for (int i11 = 0; i11 < size; i11++) {
                i((File) this.f71601f.get(i11));
            }
            this.f71601f.clear();
            this.f71603h = false;
        }
        return this.f71605j;
    }

    protected i f() {
        Class cls = f71595k;
        if (cls == null) {
            cls = d("org.apache.tools.ant.types.FilterSet");
            f71595k = cls;
        }
        return (i) getCheckedRef(cls, "filterset");
    }

    public synchronized void i(File file) {
        Properties properties;
        FileInputStream fileInputStream;
        try {
            if (isReference()) {
                throw tooManyAttributes();
            }
            if (!file.exists()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not read filters from file ");
                stringBuffer.append(file);
                stringBuffer.append(" as it doesn't exist.");
                g(stringBuffer.toString());
            }
            FileInputStream fileInputStream2 = null;
            if (file.isFile()) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Reading filters from ");
                stringBuffer2.append(file);
                log(stringBuffer2.toString(), 3);
                try {
                    try {
                        properties = new Properties();
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception e11) {
                        e = e11;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    properties.load(fileInputStream);
                    Enumeration<?> propertyNames = properties.propertyNames();
                    Vector e12 = e();
                    while (propertyNames.hasMoreElements()) {
                        String str = (String) propertyNames.nextElement();
                        e12.addElement(new a(str, properties.getProperty(str)));
                    }
                    org.apache.tools.ant.util.d.b(fileInputStream);
                } catch (Exception e13) {
                    e = e13;
                    fileInputStream2 = fileInputStream;
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Could not read filters from file: ");
                    stringBuffer3.append(file);
                    throw new BuildException(stringBuffer3.toString(), e);
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    org.apache.tools.ant.util.d.b(fileInputStream2);
                    throw th;
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Must specify a file rather than a directory in the filtersfile attribute:");
                stringBuffer4.append(file);
                g(stringBuffer4.toString());
            }
            this.f71600e = null;
        } catch (Throwable th4) {
            throw th4;
        }
    }
}
