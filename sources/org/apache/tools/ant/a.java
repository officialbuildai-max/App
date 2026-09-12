package org.apache.tools.ant;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.tools.ant.util.b;

/* loaded from: classes7.dex */
public class a extends ClassLoader implements c {

    /* renamed from: k, reason: collision with root package name */
    private static final org.apache.tools.ant.util.d f71348k = org.apache.tools.ant.util.d.k();

    /* renamed from: l, reason: collision with root package name */
    private static Map f71349l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    static /* synthetic */ Class f71350m;

    /* renamed from: n, reason: collision with root package name */
    static /* synthetic */ Class f71351n;

    /* renamed from: b, reason: collision with root package name */
    private Project f71353b;

    /* renamed from: a, reason: collision with root package name */
    private Vector f71352a = new Vector();

    /* renamed from: c, reason: collision with root package name */
    private boolean f71354c = true;

    /* renamed from: d, reason: collision with root package name */
    private Vector f71355d = new Vector();

    /* renamed from: e, reason: collision with root package name */
    private Vector f71356e = new Vector();

    /* renamed from: f, reason: collision with root package name */
    private boolean f71357f = false;

    /* renamed from: g, reason: collision with root package name */
    private ClassLoader f71358g = null;

    /* renamed from: h, reason: collision with root package name */
    private Hashtable f71359h = new Hashtable();

    /* renamed from: i, reason: collision with root package name */
    private ClassLoader f71360i = null;

    /* renamed from: j, reason: collision with root package name */
    private boolean f71361j = false;

    /* renamed from: org.apache.tools.ant.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0891a implements Enumeration {

        /* renamed from: a, reason: collision with root package name */
        private String f71362a;

        /* renamed from: b, reason: collision with root package name */
        private int f71363b = 0;

        /* renamed from: c, reason: collision with root package name */
        private URL f71364c;

        C0891a(String str) {
            this.f71362a = str;
            a();
        }

        private void a() {
            URL url = null;
            while (this.f71363b < a.this.f71352a.size() && url == null) {
                try {
                    url = a.this.v((File) a.this.f71352a.elementAt(this.f71363b), this.f71362a);
                    this.f71363b++;
                } catch (BuildException unused) {
                }
            }
            this.f71364c = url;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f71364c != null;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            URL url = this.f71364c;
            a();
            return url;
        }
    }

    public a() {
        F(null);
    }

    public a(ClassLoader classLoader, Project project, org.apache.tools.ant.types.m mVar) {
        F(classLoader);
        D(mVar);
        H(project);
    }

    private InputStream A(String str) {
        Enumeration elements = this.f71352a.elements();
        InputStream inputStream = null;
        while (elements.hasMoreElements() && inputStream == null) {
            inputStream = u((File) elements.nextElement(), str);
        }
        return inputStream;
    }

    static /* synthetic */ Class i(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private Class n(String str) {
        ClassLoader classLoader = this.f71358g;
        return classLoader == null ? findSystemClass(str) : classLoader.loadClass(str);
    }

    private Class o(String str) {
        String q11 = q(str);
        InputStream inputStream = null;
        try {
            Enumeration elements = this.f71352a.elements();
            while (elements.hasMoreElements()) {
                File file = (File) elements.nextElement();
                try {
                    try {
                        inputStream = u(file, q11);
                    } catch (SecurityException e11) {
                        throw e11;
                    }
                } catch (IOException e12) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Exception reading component ");
                    stringBuffer.append(file);
                    stringBuffer.append(" (reason: ");
                    stringBuffer.append(e12.getMessage());
                    stringBuffer.append(")");
                    B(stringBuffer.toString(), 3);
                }
                if (inputStream != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Loaded from ");
                    stringBuffer2.append(file);
                    stringBuffer2.append(" ");
                    stringBuffer2.append(q11);
                    B(stringBuffer2.toString(), 4);
                    return r(inputStream, str, file);
                }
                continue;
            }
            throw new ClassNotFoundException(str);
        } finally {
            org.apache.tools.ant.util.d.b(inputStream);
        }
    }

    private String q(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append(".class");
        return stringBuffer.toString();
    }

    private Class r(InputStream inputStream, String str, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                return k(file, byteArrayOutputStream.toByteArray(), str);
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private Manifest t(File file) {
        JarFile jarFile = null;
        if (file.isDirectory()) {
            return null;
        }
        try {
            JarFile jarFile2 = new JarFile(file);
            try {
                Manifest manifest = jarFile2.getManifest();
                jarFile2.close();
                return manifest;
            } catch (Throwable th2) {
                th = th2;
                jarFile = jarFile2;
                if (jarFile != null) {
                    jarFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private InputStream u(File file, String str) {
        try {
            ZipFile zipFile = (ZipFile) this.f71359h.get(file);
            if (zipFile == null && file.isDirectory()) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    return new FileInputStream(file2);
                }
            } else {
                if (zipFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    this.f71359h.put(file, new ZipFile(file));
                    zipFile = (ZipFile) this.f71359h.get(file);
                }
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    return zipFile.getInputStream(entry);
                }
            }
        } catch (Exception e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Ignoring Exception ");
            stringBuffer.append(e11.getClass().getName());
            stringBuffer.append(": ");
            stringBuffer.append(e11.getMessage());
            stringBuffer.append(" reading resource ");
            stringBuffer.append(str);
            stringBuffer.append(" from ");
            stringBuffer.append(file);
            B(stringBuffer.toString(), 3);
        }
        return null;
    }

    private ClassLoader w() {
        ClassLoader classLoader = getClass().getClassLoader();
        while (classLoader != null && classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        return classLoader;
    }

    private boolean y(String str) {
        boolean z10 = this.f71354c;
        Enumeration elements = this.f71355d.elements();
        while (true) {
            if (!elements.hasMoreElements()) {
                break;
            }
            if (str.startsWith((String) elements.nextElement())) {
                z10 = true;
                break;
            }
        }
        Enumeration elements2 = this.f71356e.elements();
        while (elements2.hasMoreElements()) {
            if (str.startsWith((String) elements2.nextElement())) {
                return false;
            }
        }
        return z10;
    }

    private InputStream z(String str) {
        ClassLoader classLoader = this.f71358g;
        return classLoader == null ? ClassLoader.getSystemResourceAsStream(str) : classLoader.getResourceAsStream(str);
    }

    protected void B(String str, int i11) {
        Project project = this.f71353b;
        if (project != null) {
            project.x(str, i11);
        }
    }

    public void C() {
        if (org.apache.tools.ant.util.k.b() && this.f71361j) {
            org.apache.tools.ant.util.k.c(this.f71360i);
            this.f71360i = null;
            this.f71361j = false;
        }
    }

    public void D(org.apache.tools.ant.types.m mVar) {
        this.f71352a.removeAllElements();
        if (mVar != null) {
            for (String str : mVar.n("ignore").r()) {
                try {
                    f(str);
                } catch (BuildException unused) {
                }
            }
        }
    }

    public synchronized void E(boolean z10) {
        this.f71357f = z10;
    }

    public void F(ClassLoader classLoader) {
        if (classLoader != null) {
            this.f71358g = classLoader;
            return;
        }
        Class cls = f71350m;
        if (cls == null) {
            cls = i("org.apache.tools.ant.AntClassLoader");
            f71350m = cls;
        }
        this.f71358g = cls.getClassLoader();
    }

    public void G(boolean z10) {
        this.f71354c = z10;
    }

    public void H(Project project) {
        this.f71353b = project;
        if (project != null) {
            project.a(this);
        }
    }

    public void I() {
        if (this.f71361j) {
            throw new BuildException("Context loader has not been reset");
        }
        if (org.apache.tools.ant.util.k.b()) {
            this.f71360i = org.apache.tools.ant.util.k.a();
            Project project = this.f71353b;
            org.apache.tools.ant.util.k.c((project == null || !"only".equals(project.s("build.sysclasspath"))) ? this : getClass().getClassLoader());
            this.f71361j = true;
        }
    }

    @Override // org.apache.tools.ant.c
    public void a(BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.c
    public void b(BuildEvent buildEvent) {
    }

    @Override // org.apache.tools.ant.c
    public void c(BuildEvent buildEvent) {
    }

    public void e() {
        Enumeration elements = org.apache.tools.ant.util.f.h().elements();
        while (elements.hasMoreElements()) {
            h((String) elements.nextElement());
        }
    }

    public void f(String str) {
        Project project = this.f71353b;
        try {
            g(project != null ? project.D(str) : new File(str));
        } catch (IOException e11) {
            throw new BuildException(e11);
        }
    }

    @Override // java.lang.ClassLoader
    public Class findClass(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Finding class ");
        stringBuffer.append(str);
        B(stringBuffer.toString(), 4);
        return o(str);
    }

    @Override // java.lang.ClassLoader
    protected Enumeration findResources(String str) {
        C0891a c0891a = new C0891a(str);
        ClassLoader classLoader = this.f71358g;
        Enumeration<URL> c0894b = (classLoader == null || classLoader == getParent()) ? new b.C0894b() : this.f71358g.getResources(str);
        return y(str) ? org.apache.tools.ant.util.b.a(c0894b, c0891a) : this.f71357f ? w() == null ? c0891a : org.apache.tools.ant.util.b.a(c0891a, w().getResources(str)) : org.apache.tools.ant.util.b.a(c0891a, c0894b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        if (r4 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void g(java.io.File r8) {
        /*
            r7 = this;
            java.util.Vector r0 = r7.f71352a
            r0.addElement(r8)
            boolean r0 = r8.isDirectory()
            if (r0 == 0) goto Lc
            return
        Lc:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = r8.getAbsolutePath()
            r0.append(r1)
            long r1 = r8.lastModified()
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            long r1 = r8.length()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.Map r1 = org.apache.tools.ant.a.f71349l
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = ""
            if (r1 != 0) goto L90
            r3 = 0
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L74 org.apache.tools.ant.taskdefs.ManifestException -> L77
            r4.<init>(r8)     // Catch: java.lang.Throwable -> L74 org.apache.tools.ant.taskdefs.ManifestException -> L77
            java.util.zip.ZipEntry r5 = new java.util.zip.ZipEntry     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            java.lang.String r6 = "META-INF/MANIFEST.MF"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            java.io.InputStream r3 = r4.getInputStream(r5)     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            if (r3 != 0) goto L55
            org.apache.tools.ant.util.d.b(r3)
            r4.close()
            return
        L55:
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            java.lang.String r6 = "UTF-8"
            r5.<init>(r3, r6)     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            org.apache.tools.ant.taskdefs.k r6 = new org.apache.tools.ant.taskdefs.k     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            org.apache.tools.ant.taskdefs.k$b r5 = r6.b()     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            java.lang.String r6 = "Class-Path"
            java.lang.String r1 = r5.e(r6)     // Catch: java.lang.Throwable -> L72 org.apache.tools.ant.taskdefs.ManifestException -> L82
            org.apache.tools.ant.util.d.b(r3)
        L6e:
            r4.close()
            goto L88
        L72:
            r8 = move-exception
            goto L79
        L74:
            r8 = move-exception
            r4 = r3
            goto L79
        L77:
            r4 = r3
            goto L82
        L79:
            org.apache.tools.ant.util.d.b(r3)
            if (r4 == 0) goto L81
            r4.close()
        L81:
            throw r8
        L82:
            org.apache.tools.ant.util.d.b(r3)
            if (r4 == 0) goto L88
            goto L6e
        L88:
            if (r1 != 0) goto L8b
            r1 = r2
        L8b:
            java.util.Map r3 = org.apache.tools.ant.a.f71349l
            r3.put(r0, r1)
        L90:
            boolean r0 = r2.equals(r1)
            if (r0 != 0) goto Lf9
            org.apache.tools.ant.util.d r0 = org.apache.tools.ant.a.f71348k
            java.net.URL r8 = r0.j(r8)
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r0.<init>(r1)
        La1:
            boolean r1 = r0.hasMoreTokens()
            if (r1 == 0) goto Lf9
            java.lang.String r1 = r0.nextToken()
            java.net.URL r2 = new java.net.URL
            r2.<init>(r8, r1)
            java.lang.String r3 = r2.getProtocol()
            java.lang.String r4 = "file"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto Ldc
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Skipping jar library "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = " since only relative URLs are supported by this"
            r2.append(r1)
            java.lang.String r1 = " loader"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 3
            r7.B(r1, r2)
            goto La1
        Ldc:
            java.lang.String r1 = r2.getFile()
            java.lang.String r1 = w00.b.a(r1)
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 == 0) goto La1
            boolean r1 = r7.x(r2)
            if (r1 != 0) goto La1
            r7.g(r2)
            goto La1
        Lf9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.a.g(java.io.File):void");
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        URL url;
        if (y(str)) {
            ClassLoader classLoader = this.f71358g;
            url = classLoader == null ? super.getResource(str) : classLoader.getResource(str);
        } else {
            url = null;
        }
        if (url != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Resource ");
            stringBuffer.append(str);
            stringBuffer.append(" loaded from parent loader");
            B(stringBuffer.toString(), 4);
        } else {
            Enumeration elements = this.f71352a.elements();
            while (elements.hasMoreElements() && url == null) {
                url = v((File) elements.nextElement(), str);
                if (url != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Resource ");
                    stringBuffer2.append(str);
                    stringBuffer2.append(" loaded from ant loader");
                    B(stringBuffer2.toString(), 4);
                }
            }
        }
        if (url == null && !y(str)) {
            if (this.f71357f) {
                url = w() != null ? w().getResource(str) : null;
            } else {
                ClassLoader classLoader2 = this.f71358g;
                url = classLoader2 == null ? super.getResource(str) : classLoader2.getResource(str);
            }
            if (url != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Resource ");
                stringBuffer3.append(str);
                stringBuffer3.append(" loaded from parent loader");
                B(stringBuffer3.toString(), 4);
            }
        }
        if (url == null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Couldn't load Resource ");
            stringBuffer4.append(str);
            B(stringBuffer4.toString(), 4);
        }
        return url;
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String str) {
        InputStream A;
        if (y(str)) {
            A = z(str);
            if (A != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("ResourceStream for ");
                stringBuffer.append(str);
                stringBuffer.append(" loaded from parent loader");
                B(stringBuffer.toString(), 4);
            } else {
                A = A(str);
                if (A != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("ResourceStream for ");
                    stringBuffer2.append(str);
                    stringBuffer2.append(" loaded from ant loader");
                    B(stringBuffer2.toString(), 4);
                }
            }
        } else {
            A = A(str);
            if (A != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("ResourceStream for ");
                stringBuffer3.append(str);
                stringBuffer3.append(" loaded from ant loader");
                B(stringBuffer3.toString(), 4);
            } else {
                A = z(str);
                if (A != null) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("ResourceStream for ");
                    stringBuffer4.append(str);
                    stringBuffer4.append(" loaded from parent loader");
                    B(stringBuffer4.toString(), 4);
                }
            }
        }
        if (A == null) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Couldn't load ResourceStream for ");
            stringBuffer5.append(str);
            B(stringBuffer5.toString(), 4);
        }
        return A;
    }

    public void h(String str) {
        Vector vector = this.f71355d;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str.endsWith(".") ? "" : ".");
        vector.addElement(stringBuffer.toString());
    }

    public synchronized void j() {
        Enumeration elements = this.f71359h.elements();
        while (elements.hasMoreElements()) {
            try {
                ((ZipFile) elements.nextElement()).close();
            } catch (IOException unused) {
            }
        }
        this.f71359h = new Hashtable();
        Project project = this.f71353b;
        if (project != null) {
            project.B(this);
        }
        this.f71353b = null;
    }

    protected Class k(File file, byte[] bArr, String str) {
        l(file, str);
        int length = bArr.length;
        Class cls = f71351n;
        if (cls == null) {
            cls = i("org.apache.tools.ant.Project");
            f71351n = cls;
        }
        return defineClass(str, bArr, 0, length, cls.getProtectionDomain());
    }

    protected void l(File file, String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return;
        }
        String substring = str.substring(0, lastIndexOf);
        if (getPackage(substring) != null) {
            return;
        }
        Manifest t11 = t(file);
        if (t11 == null) {
            definePackage(substring, null, null, null, null, null, null, null);
        } else {
            m(file, substring, t11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:8:0x0009, B:24:0x0010, B:14:0x009a, B:12:0x0058, B:26:0x0035, B:19:0x0077, B:21:0x007b, B:22:0x009f), top: B:2:0x0001, inners: #0, #2 }] */
    @Override // java.lang.ClassLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected synchronized java.lang.Class loadClass(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.Class r0 = r4.findLoadedClass(r5)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L9
            monitor-exit(r4)
            return r0
        L9:
            boolean r0 = r4.y(r5)     // Catch: java.lang.Throwable -> L33
            r1 = 4
            if (r0 == 0) goto L58
            java.lang.Class r0 = r4.n(r5)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            r2.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            java.lang.String r3 = "Class "
            r2.append(r3)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            r2.append(r5)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            java.lang.String r3 = " loaded from parent loader "
            r2.append(r3)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            java.lang.String r3 = "(parentFirst)"
            r2.append(r3)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            r4.B(r2, r1)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L35
            goto L98
        L33:
            r5 = move-exception
            goto La0
        L35:
            java.lang.Class r0 = r4.findClass(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L33
            r2.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "Class "
            r2.append(r3)     // Catch: java.lang.Throwable -> L33
            r2.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = " loaded from ant loader "
            r2.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = "(parentFirst)"
            r2.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L33
            r4.B(r5, r1)     // Catch: java.lang.Throwable -> L33
            goto L98
        L58:
            java.lang.Class r0 = r4.findClass(r5)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            java.lang.String r3 = "Class "
            r2.append(r3)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            r2.append(r5)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            java.lang.String r3 = " loaded from ant loader"
            r2.append(r3)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            r4.B(r2, r1)     // Catch: java.lang.Throwable -> L33 java.lang.ClassNotFoundException -> L76
            goto L98
        L76:
            r0 = move-exception
            boolean r2 = r4.f71357f     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto L9f
            java.lang.Class r0 = r4.n(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuffer r2 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L33
            r2.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.String r3 = "Class "
            r2.append(r3)     // Catch: java.lang.Throwable -> L33
            r2.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = " loaded from parent loader"
            r2.append(r5)     // Catch: java.lang.Throwable -> L33
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L33
            r4.B(r5, r1)     // Catch: java.lang.Throwable -> L33
        L98:
            if (r6 == 0) goto L9d
            r4.resolveClass(r0)     // Catch: java.lang.Throwable -> L33
        L9d:
            monitor-exit(r4)
            return r0
        L9f:
            throw r0     // Catch: java.lang.Throwable -> L33
        La0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L33
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.a.loadClass(java.lang.String, boolean):java.lang.Class");
    }

    protected void m(File file, String str, Manifest manifest) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        URL url;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.replace('.', '/'));
        stringBuffer.append("/");
        Attributes attributes = manifest.getAttributes(stringBuffer.toString());
        if (attributes != null) {
            str3 = attributes.getValue(Attributes.Name.SPECIFICATION_TITLE);
            str4 = attributes.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            str5 = attributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            str6 = attributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            str7 = attributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            str8 = attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            str2 = attributes.getValue(Attributes.Name.SEALED);
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
        }
        Attributes mainAttributes = manifest.getMainAttributes();
        if (mainAttributes != null) {
            if (str3 == null) {
                str3 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_TITLE);
            }
            if (str4 == null) {
                str4 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            }
            if (str5 == null) {
                str5 = mainAttributes.getValue(Attributes.Name.SPECIFICATION_VERSION);
            }
            if (str6 == null) {
                str6 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            }
            if (str7 == null) {
                str7 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            }
            if (str8 == null) {
                str8 = mainAttributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            }
            if (str2 == null) {
                str2 = mainAttributes.getValue(Attributes.Name.SEALED);
            }
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str4;
        String str12 = str6;
        String str13 = str5;
        String str14 = str3;
        if (str2 != null && str2.toLowerCase(Locale.ENGLISH).equals("true")) {
            try {
                url = new URL(org.apache.tools.ant.util.d.k().r(file.getAbsolutePath()));
            } catch (MalformedURLException unused) {
            }
            definePackage(str, str14, str13, str11, str12, str10, str9, url);
        }
        url = null;
        definePackage(str, str14, str13, str11, str12, str10, str9, url);
    }

    public Class p(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("force loading ");
        stringBuffer.append(str);
        B(stringBuffer.toString(), 4);
        Class<?> findLoadedClass = findLoadedClass(str);
        return findLoadedClass == null ? findClass(str) : findLoadedClass;
    }

    public String s() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = this.f71352a.elements();
        boolean z10 = true;
        while (elements.hasMoreElements()) {
            if (z10) {
                z10 = false;
            } else {
                stringBuffer.append(System.getProperty("path.separator"));
            }
            stringBuffer.append(((File) elements.nextElement()).getAbsolutePath());
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AntClassLoader[");
        stringBuffer.append(s());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected URL v(File file, String str) {
        try {
            ZipFile zipFile = (ZipFile) this.f71359h.get(file);
            if (zipFile == null && file.isDirectory()) {
                File file2 = new File(file, str);
                if (file2.exists()) {
                    try {
                        return f71348k.j(file2);
                    } catch (MalformedURLException unused) {
                        return null;
                    }
                }
            } else {
                if (zipFile == null) {
                    if (!file.exists()) {
                        return null;
                    }
                    zipFile = new ZipFile(file);
                    this.f71359h.put(file, zipFile);
                }
                ZipEntry entry = zipFile.getEntry(str);
                if (entry != null) {
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("jar:");
                        stringBuffer.append(f71348k.j(file));
                        stringBuffer.append("!/");
                        stringBuffer.append(entry);
                        return new URL(stringBuffer.toString());
                    } catch (MalformedURLException unused2) {
                        return null;
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    protected boolean x(File file) {
        Enumeration elements = this.f71352a.elements();
        while (elements.hasMoreElements()) {
            if (((File) elements.nextElement()).equals(file)) {
                return true;
            }
        }
        return false;
    }
}
