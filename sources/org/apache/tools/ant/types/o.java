package org.apache.tools.ant.types;

import java.net.SocketPermission;
import java.security.Permission;
import java.security.Permissions;
import java.security.UnresolvedPermission;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PropertyPermission;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ExitException;

/* loaded from: classes7.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    private static final Class[] f71624g;

    /* renamed from: h, reason: collision with root package name */
    static /* synthetic */ Class f71625h;

    /* renamed from: a, reason: collision with root package name */
    private List f71626a;

    /* renamed from: b, reason: collision with root package name */
    private List f71627b;

    /* renamed from: c, reason: collision with root package name */
    private Permissions f71628c;

    /* renamed from: d, reason: collision with root package name */
    private SecurityManager f71629d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71630e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71631f;

    /* loaded from: classes7.dex */
    private class a extends SecurityManager {
        private a() {
        }

        private void a(Permission permission) {
            ListIterator listIterator = o.this.f71627b.listIterator();
            while (listIterator.hasNext()) {
                if (((b) listIterator.next()).d(permission)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Permission ");
                    stringBuffer.append(permission);
                    stringBuffer.append(" was revoked.");
                    throw new SecurityException(stringBuffer.toString());
                }
            }
        }

        @Override // java.lang.SecurityManager
        public void checkExit(int i11) {
            try {
                checkPermission(new RuntimePermission("exitVM", null));
            } catch (SecurityException e11) {
                throw new ExitException(e11.getMessage(), i11);
            }
        }

        @Override // java.lang.SecurityManager
        public void checkPermission(Permission permission) {
            if (o.this.f71630e) {
                if (o.this.f71631f && !permission.getName().equals("exitVM")) {
                    boolean implies = o.this.f71628c.implies(permission);
                    a(permission);
                    if (implies || o.this.f71629d == null) {
                        return;
                    }
                    o.this.f71629d.checkPermission(permission);
                    return;
                }
                if (o.this.f71628c.implies(permission)) {
                    a(permission);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Permission ");
                stringBuffer.append(permission);
                stringBuffer.append(" was not granted.");
                throw new SecurityException(stringBuffer.toString());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f71633a;

        /* renamed from: b, reason: collision with root package name */
        private String f71634b;

        /* renamed from: c, reason: collision with root package name */
        private String f71635c;

        /* renamed from: d, reason: collision with root package name */
        private Set f71636d;

        private Set e(String str) {
            HashSet hashSet = new HashSet();
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if (!trim.equals("")) {
                    hashSet.add(trim);
                }
            }
            return hashSet;
        }

        public String a() {
            return this.f71635c;
        }

        public String b() {
            return this.f71633a;
        }

        public String c() {
            return this.f71634b;
        }

        boolean d(Permission permission) {
            if (!this.f71633a.equals(permission.getClass().getName())) {
                return false;
            }
            String str = this.f71634b;
            if (str != null) {
                if (str.endsWith("*")) {
                    String name = permission.getName();
                    String str2 = this.f71634b;
                    if (!name.startsWith(str2.substring(0, str2.length() - 1))) {
                        return false;
                    }
                } else if (!this.f71634b.equals(permission.getName())) {
                    return false;
                }
            }
            if (this.f71636d != null) {
                Set e11 = e(permission.getActions());
                int size = e11.size();
                e11.removeAll(this.f71636d);
                if (e11.size() == size) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Permission: ");
            stringBuffer.append(this.f71633a);
            stringBuffer.append(" (\"");
            stringBuffer.append(this.f71634b);
            stringBuffer.append("\", \"");
            stringBuffer.append(this.f71636d);
            stringBuffer.append("\")");
            return stringBuffer.toString();
        }
    }

    static {
        Class cls = f71625h;
        if (cls == null) {
            cls = f("java.lang.String");
            f71625h = cls;
        }
        Class cls2 = f71625h;
        if (cls2 == null) {
            cls2 = f("java.lang.String");
            f71625h = cls2;
        }
        f71624g = new Class[]{cls, cls2};
    }

    public o() {
        this(false);
    }

    public o(boolean z10) {
        this.f71626a = new LinkedList();
        this.f71627b = new LinkedList();
        this.f71628c = null;
        this.f71629d = null;
        this.f71630e = false;
        this.f71631f = z10;
    }

    static /* synthetic */ Class f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private Permission g(b bVar) {
        try {
            return (Permission) Class.forName(bVar.b()).getConstructor(f71624g).newInstance(bVar.c(), bVar.a());
        } catch (Exception unused) {
            return new UnresolvedPermission(bVar.b(), bVar.c(), bVar.a(), null);
        }
    }

    private void h() {
        this.f71628c = new Permissions();
        ListIterator listIterator = this.f71627b.listIterator();
        while (listIterator.hasNext()) {
            b bVar = (b) listIterator.next();
            if (bVar.b() == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Revoked permission ");
                stringBuffer.append(bVar);
                stringBuffer.append(" does not contain a class.");
                throw new BuildException(stringBuffer.toString());
            }
        }
        ListIterator listIterator2 = this.f71626a.listIterator();
        while (listIterator2.hasNext()) {
            b bVar2 = (b) listIterator2.next();
            if (bVar2.b() == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Granted permission ");
                stringBuffer2.append(bVar2);
                stringBuffer2.append(" does not contain a class.");
                throw new BuildException(stringBuffer2.toString());
            }
            this.f71628c.add(g(bVar2));
        }
        this.f71628c.add(new SocketPermission("localhost:1024-", "listen"));
        this.f71628c.add(new PropertyPermission("java.version", "read"));
        this.f71628c.add(new PropertyPermission("java.vendor", "read"));
        this.f71628c.add(new PropertyPermission("java.vendor.url", "read"));
        this.f71628c.add(new PropertyPermission("java.class.version", "read"));
        this.f71628c.add(new PropertyPermission("os.name", "read"));
        this.f71628c.add(new PropertyPermission("os.version", "read"));
        this.f71628c.add(new PropertyPermission("os.arch", "read"));
        this.f71628c.add(new PropertyPermission("file.encoding", "read"));
        this.f71628c.add(new PropertyPermission("file.separator", "read"));
        this.f71628c.add(new PropertyPermission("path.separator", "read"));
        this.f71628c.add(new PropertyPermission("line.separator", "read"));
        this.f71628c.add(new PropertyPermission("java.specification.version", "read"));
        this.f71628c.add(new PropertyPermission("java.specification.vendor", "read"));
        this.f71628c.add(new PropertyPermission("java.specification.name", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.specification.version", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.specification.vendor", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.specification.name", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.version", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.vendor", "read"));
        this.f71628c.add(new PropertyPermission("java.vm.name", "read"));
    }

    public synchronized void i() {
        this.f71630e = false;
        System.setSecurityManager(this.f71629d);
    }

    public synchronized void j() {
        this.f71629d = System.getSecurityManager();
        h();
        System.setSecurityManager(new a());
        this.f71630e = true;
    }
}
