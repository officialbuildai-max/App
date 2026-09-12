package org.apache.tools.ant.taskdefs;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.u;
import org.apache.tools.ant.v;
import org.apache.tools.ant.w;

/* loaded from: classes7.dex */
public class a extends u implements v {

    /* renamed from: j, reason: collision with root package name */
    static /* synthetic */ Class f71465j;

    /* renamed from: g, reason: collision with root package name */
    private ClassLoader f71466g;

    /* renamed from: h, reason: collision with root package name */
    private String f71467h = "";

    /* renamed from: i, reason: collision with root package name */
    private List f71468i = new ArrayList();

    static /* synthetic */ Class t(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static a u(Project project, URL url, String str) {
        try {
            ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).connect();
            ComponentHelper j11 = ComponentHelper.j(project);
            j11.g(str);
            try {
                w k11 = new u00.b().k(project, url);
                if (!k11.B().equals("antlib")) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Unexpected tag ");
                    stringBuffer.append(k11.B());
                    stringBuffer.append(" expecting ");
                    stringBuffer.append("antlib");
                    throw new BuildException(stringBuffer.toString(), k11.getLocation());
                }
                a aVar = new a();
                aVar.setProject(project);
                aVar.setLocation(k11.getLocation());
                aVar.r("antlib");
                aVar.l();
                k11.u(aVar);
                return aVar;
            } finally {
                j11.h();
            }
        } catch (IOException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unable to find ");
            stringBuffer2.append(url);
            throw new BuildException(stringBuffer2.toString(), e11);
        }
    }

    private ClassLoader v() {
        if (this.f71466g == null) {
            Class cls = f71465j;
            if (cls == null) {
                cls = t("org.apache.tools.ant.taskdefs.Antlib");
                f71465j = cls;
            }
            this.f71466g = cls.getClassLoader();
        }
        return this.f71466g;
    }

    @Override // org.apache.tools.ant.v
    public void b(u uVar) {
        this.f71468i.add(uVar);
    }

    @Override // org.apache.tools.ant.u
    public void e() {
        for (w wVar : this.f71468i) {
            setLocation(wVar.getLocation());
            wVar.m();
            Object A = wVar.A();
            if (A != null) {
                if (!(A instanceof b)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid task in antlib ");
                    stringBuffer.append(wVar.B());
                    stringBuffer.append(" ");
                    stringBuffer.append(A.getClass());
                    stringBuffer.append(" does not ");
                    stringBuffer.append("extend org.apache.tools.ant.taskdefs.AntlibDefinition");
                    throw new BuildException(stringBuffer.toString());
                }
                b bVar = (b) A;
                bVar.w(this.f71467h);
                bVar.v(v());
                bVar.l();
                bVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(ClassLoader classLoader) {
        this.f71466g = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(String str) {
        this.f71467h = str;
    }
}
