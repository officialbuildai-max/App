package y00;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.types.r;
import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class c extends t {

    /* renamed from: j, reason: collision with root package name */
    private static final org.apache.tools.ant.util.d f78681j = org.apache.tools.ant.util.d.k();

    /* renamed from: k, reason: collision with root package name */
    private static final int f78682k = t.g("null file".getBytes());

    /* renamed from: h, reason: collision with root package name */
    private File f78683h;

    /* renamed from: i, reason: collision with root package name */
    private File f78684i;

    public c() {
    }

    public c(File file, String str) {
        u(f78681j.q(file, str));
        t(file);
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.u
    public boolean a() {
        return !isReference() || ((c) getCheckedRef()).a();
    }

    @Override // org.apache.tools.ant.types.t, java.lang.Comparable
    public int compareTo(Object obj) {
        if (isReference()) {
            return ((Comparable) getCheckedRef()).compareTo(obj);
        }
        if (equals(obj)) {
            return 0;
        }
        if (!obj.getClass().equals(getClass())) {
            return super.compareTo(obj);
        }
        c cVar = (c) obj;
        File r11 = r();
        if (r11 == null) {
            return -1;
        }
        File r12 = cVar.r();
        if (r12 == null) {
            return 1;
        }
        return r11.compareTo(r12);
    }

    @Override // org.apache.tools.ant.types.t
    public InputStream e() {
        return isReference() ? ((t) getCheckedRef()).e() : new FileInputStream(s());
    }

    @Override // org.apache.tools.ant.types.t
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        c cVar = (c) obj;
        return r() == null ? cVar.r() == null : r().equals(cVar.r());
    }

    @Override // org.apache.tools.ant.types.t
    public long f() {
        return isReference() ? ((t) getCheckedRef()).f() : s().lastModified();
    }

    @Override // org.apache.tools.ant.types.t
    public String getName() {
        if (isReference()) {
            return ((t) getCheckedRef()).getName();
        }
        File q11 = q();
        return q11 == null ? s().getName() : f78681j.p(q11, s());
    }

    @Override // org.apache.tools.ant.types.t
    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return t.f71656f * (r() == null ? f78682k : r().hashCode());
    }

    @Override // org.apache.tools.ant.types.t
    public long i() {
        return isReference() ? ((t) getCheckedRef()).i() : s().length();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean j() {
        return isReference() ? ((t) getCheckedRef()).j() : s().isDirectory();
    }

    @Override // org.apache.tools.ant.types.t
    public boolean k() {
        return isReference() ? ((t) getCheckedRef()).k() : s().exists();
    }

    public File q() {
        return isReference() ? ((c) getCheckedRef()).q() : this.f78684i;
    }

    public File r() {
        return isReference() ? ((c) getCheckedRef()).r() : this.f78683h;
    }

    protected File s() {
        if (r() != null) {
            return r();
        }
        throw new BuildException("file attribute is null!");
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f78683h != null || this.f78684i != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    public void t(File file) {
        checkAttributesAllowed();
        this.f78684i = file;
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        File file = this.f78683h;
        if (file == null) {
            return "(unbound file resource)";
        }
        return f78681j.o(file.getAbsolutePath()).getAbsolutePath();
    }

    public void u(File file) {
        checkAttributesAllowed();
        this.f78683h = file;
    }
}
