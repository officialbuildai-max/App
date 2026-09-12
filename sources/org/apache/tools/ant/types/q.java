package org.apache.tools.ant.types;

import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* loaded from: classes7.dex */
public class q extends e implements u {

    /* renamed from: g, reason: collision with root package name */
    static /* synthetic */ Class f71639g;

    /* renamed from: c, reason: collision with root package name */
    private Set f71642c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f71640a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f71641b = false;

    /* renamed from: d, reason: collision with root package name */
    private Vector f71643d = new Vector();

    /* renamed from: e, reason: collision with root package name */
    private Vector f71644e = new Vector();

    /* renamed from: f, reason: collision with root package name */
    private boolean f71645f = true;

    /* loaded from: classes7.dex */
    public static class a extends f {
        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return new String[]{IntegrationConstants.NAVIGATION_BAR_ALL_ACTION, "system", "commandline"};
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f71646a;

        /* renamed from: b, reason: collision with root package name */
        private String f71647b;

        /* renamed from: c, reason: collision with root package name */
        private String f71648c;

        /* renamed from: d, reason: collision with root package name */
        private String f71649d;

        /* renamed from: e, reason: collision with root package name */
        private String f71650e;

        private void e(String str, String str2) {
            if (str2 == null || str2.length() < 1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Invalid attribute: ");
                stringBuffer.append(str);
                throw new BuildException(stringBuffer.toString());
            }
            int i11 = this.f71646a + 1;
            this.f71646a = i11;
            if (i11 != 1) {
                throw new BuildException("Attributes name, regex, and prefix are mutually exclusive");
            }
        }

        public void f(a aVar) {
            String b11 = aVar.b();
            e("builtin", b11);
            this.f71650e = b11;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("name=");
            stringBuffer.append(this.f71647b);
            stringBuffer.append(", regex=");
            stringBuffer.append(this.f71648c);
            stringBuffer.append(", prefix=");
            stringBuffer.append(this.f71649d);
            stringBuffer.append(", builtin=");
            stringBuffer.append(this.f71650e);
            return stringBuffer.toString();
        }
    }

    private void d(Set set, Hashtable hashtable) {
        Enumeration elements = this.f71643d.elements();
        while (elements.hasMoreElements()) {
            b bVar = (b) elements.nextElement();
            if (bVar.f71647b != null) {
                if (hashtable.get(bVar.f71647b) != null) {
                    set.add(bVar.f71647b);
                }
            } else if (bVar.f71649d != null) {
                Enumeration keys = hashtable.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    if (str.startsWith(bVar.f71649d)) {
                        set.add(str);
                    }
                }
            } else {
                if (bVar.f71648c != null) {
                    new a10.b().c();
                    String unused = bVar.f71648c;
                    throw null;
                }
                if (bVar.f71650e == null) {
                    throw new BuildException("Impossible: Invalid PropertyRef!");
                }
                if (bVar.f71650e.equals(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION)) {
                    set.addAll(hashtable.keySet());
                } else if (bVar.f71650e.equals("system")) {
                    set.addAll(System.getProperties().keySet());
                } else {
                    if (!bVar.f71650e.equals("commandline")) {
                        throw new BuildException("Impossible: Invalid builtin attribute!");
                    }
                    set.addAll(getProject().w().keySet());
                }
            }
        }
    }

    static /* synthetic */ Class i(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private Hashtable j() {
        Hashtable hashtable = new Hashtable();
        Enumeration<?> propertyNames = System.getProperties().propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashtable.put(str, System.getProperties().getProperty(str));
        }
        return hashtable;
    }

    @Override // org.apache.tools.ant.types.u
    public boolean a() {
        return isReference() && n().a();
    }

    public void e(b bVar) {
        g();
        this.f71643d.addElement(bVar);
    }

    public void f(a aVar) {
        b bVar = new b();
        bVar.f(aVar);
        e(bVar);
    }

    protected final void g() {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.f71645f = false;
    }

    @Override // org.apache.tools.ant.types.u
    public Iterator iterator() {
        return new p(this, m().propertyNames());
    }

    public boolean k() {
        return isReference() ? n().f71640a : this.f71640a;
    }

    public k l() {
        if (!isReference()) {
            return null;
        }
        n().getClass();
        return null;
    }

    public Properties m() {
        Set<String> hashSet;
        if (isReference()) {
            return n().m();
        }
        Project project = getProject();
        Hashtable j11 = project == null ? j() : project.r();
        Enumeration elements = this.f71644e.elements();
        while (elements.hasMoreElements()) {
            j11.putAll(((q) elements.nextElement()).m());
        }
        if (k() || (hashSet = this.f71642c) == null) {
            hashSet = new HashSet();
            d(hashSet, j11);
            Enumeration elements2 = this.f71644e.elements();
            while (elements2.hasMoreElements()) {
                hashSet.addAll(((q) elements2.nextElement()).m().keySet());
            }
            if (this.f71641b) {
                HashSet hashSet2 = new HashSet(j11.keySet());
                hashSet2.removeAll(hashSet);
                hashSet = hashSet2;
            }
            if (!k()) {
                this.f71642c = hashSet;
            }
        }
        l();
        Properties properties = new Properties();
        for (String str : hashSet) {
            String str2 = (String) j11.get(str);
            if (str2 != null) {
                properties.setProperty(str, str2);
            }
        }
        return properties;
    }

    protected q n() {
        Class cls = f71639g;
        if (cls == null) {
            cls = i("org.apache.tools.ant.types.PropertySet");
            f71639g = cls;
        }
        return (q) getCheckedRef(cls, "propertyset");
    }

    @Override // org.apache.tools.ant.types.e
    public final void setRefid(r rVar) {
        if (!this.f71645f) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public int size() {
        return isReference() ? n().size() : m().size();
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry entry : new TreeMap(m()).entrySet()) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(entry.getKey().toString());
            stringBuffer.append(UrlUtils.EQUAL_MARK);
            stringBuffer.append(entry.getValue().toString());
        }
        return stringBuffer.toString();
    }
}
