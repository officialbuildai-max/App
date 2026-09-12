package u00;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.t;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Project f76652a;

    /* renamed from: b, reason: collision with root package name */
    private File f76653b;

    /* renamed from: d, reason: collision with root package name */
    private File f76655d;

    /* renamed from: e, reason: collision with root package name */
    private String f76656e;

    /* renamed from: f, reason: collision with root package name */
    private Locator f76657f;

    /* renamed from: c, reason: collision with root package name */
    private Vector f76654c = new Vector();

    /* renamed from: g, reason: collision with root package name */
    private t f76658g = new t();

    /* renamed from: h, reason: collision with root package name */
    private t f76659h = null;

    /* renamed from: i, reason: collision with root package name */
    private Vector f76660i = new Vector();

    /* renamed from: j, reason: collision with root package name */
    private boolean f76661j = false;

    /* renamed from: k, reason: collision with root package name */
    private Map f76662k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private Map f76663l = null;

    public a(Project project) {
        this.f76652a = project;
        this.f76658g.m(project);
        this.f76658g.l("");
        this.f76654c.addElement(this.f76658g);
    }

    public void a(t tVar) {
        this.f76654c.addElement(tVar);
        this.f76659h = tVar;
    }

    public void b(Object obj, Attributes attributes) {
        String value = attributes.getValue("id");
        if (value != null) {
            this.f76652a.b(value, obj);
        }
    }

    public RuntimeConfigurable c() {
        if (this.f76660i.size() < 1) {
            return null;
        }
        Vector vector = this.f76660i;
        return (RuntimeConfigurable) vector.elementAt(vector.size() - 1);
    }

    public void d(String str) {
        List list = (List) this.f76662k.get(str);
        if (list == null || list.size() == 0) {
            return;
        }
        list.remove(list.size() - 1);
    }

    public File e() {
        return this.f76653b;
    }

    public File f() {
        return this.f76655d;
    }

    public String g() {
        return this.f76656e;
    }

    public t h() {
        return this.f76659h;
    }

    public Map i() {
        return this.f76663l;
    }

    public t j() {
        return this.f76658g;
    }

    public Locator k() {
        return this.f76657f;
    }

    public String l(String str) {
        List list = (List) this.f76662k.get(str);
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) list.get(list.size() - 1);
    }

    public Project m() {
        return this.f76652a;
    }

    public boolean n() {
        return this.f76661j;
    }

    public void o() {
        if (this.f76660i.size() > 0) {
            this.f76660i.removeElementAt(r0.size() - 1);
        }
    }

    public void p(RuntimeConfigurable runtimeConfigurable) {
        this.f76660i.addElement(runtimeConfigurable);
    }

    public void q(File file) {
        this.f76653b = file;
        this.f76655d = new File(file.getParent());
        this.f76658g.k(new Location(file.getAbsolutePath()));
    }

    public void r(String str) {
        this.f76656e = str;
    }

    public void s(t tVar) {
        this.f76659h = tVar;
    }

    public void t(t tVar) {
        this.f76658g = tVar;
    }

    public void u(Locator locator) {
        this.f76657f = locator;
    }

    public void v(String str, String str2) {
        List list = (List) this.f76662k.get(str);
        if (list == null) {
            list = new ArrayList();
            this.f76662k.put(str, list);
        }
        list.add(str2);
    }
}
