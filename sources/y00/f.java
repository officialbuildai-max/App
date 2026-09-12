package y00;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class f extends t {

    /* renamed from: h, reason: collision with root package name */
    private static final int f78688h = t.g("PropertyResource".getBytes());

    /* renamed from: i, reason: collision with root package name */
    private static final InputStream f78689i = new e();

    public f() {
    }

    public f(Project project, String str) {
        super(str);
        setProject(project);
    }

    @Override // org.apache.tools.ant.types.t
    public InputStream e() {
        return isReference() ? ((t) getCheckedRef()).e() : k() ? new ByteArrayInputStream(q().getBytes()) : f78689i;
    }

    @Override // org.apache.tools.ant.types.t
    public int hashCode() {
        return isReference() ? getCheckedRef().hashCode() : super.hashCode() * f78688h;
    }

    @Override // org.apache.tools.ant.types.t
    public long i() {
        if (isReference()) {
            return ((t) getCheckedRef()).i();
        }
        if (k()) {
            return q().length();
        }
        return 0L;
    }

    @Override // org.apache.tools.ant.types.t
    public boolean k() {
        return q() != null;
    }

    public String q() {
        Project project = getProject();
        if (project == null) {
            return null;
        }
        return project.s(getName());
    }

    @Override // org.apache.tools.ant.types.t, org.apache.tools.ant.types.e
    public String toString() {
        return isReference() ? getCheckedRef().toString() : String.valueOf(q());
    }
}
